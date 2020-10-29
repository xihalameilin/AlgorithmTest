package summer2019;

import java.util.*;

public class LeetCodePraticeIII {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    //214 前面补齐字符 使成为最短的回文
    public String shortestPalindrome(String s) {
       String reverse = new StringBuilder(s).reverse().toString();
       for(int i=0;i<s.length();i++){
           if(s.startsWith(reverse.substring(i)))
               return reverse.substring(0,i)+s;
       }
       return "";
    }

    public String shortestPalindromeII(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        int begin = 0;
        int length = s.length();
        while(true) {
            if (reverse.substring(begin).equals(s.substring(0, length - begin))) {
                break;
            }
            begin++;
        }
        return reverse.substring(0,begin)+s;
    }


    //215
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        return nums[k-1];
    }

    private void quickSort(int[] nums,int l,int r){
        if(l>=r)
            return;
        int pivot = nums[r];
        int left = l;
        int right = r-1;
        while(left<=right){
            while(left<=right && nums[left]<pivot)
                left++;
            while(left<=right && nums[right]>=pivot)
                right--;
            if(left<right)
                swap(nums,left,right);
        }
        nums[r] = nums[left];
        nums[left] = pivot;

        quickSort(nums,l,left-1);
        quickSort(nums,left+1, r);
    }

    private void swap(int[] nums,int l,int r){
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }


    //216
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        help216(k,n,res,temp,1);
        return res;
    }

    private void help216(int times,int left,List<List<Integer>> res,List<Integer> temp,int start){
        if(times == 0 && left == 0)
            res.add(new ArrayList<>(temp));
        if(times ==0 || left == 0)
            return;
        for(int i=start;i<=9;i++){
            if(!temp.contains(i)){
                temp.add(i);
                help216(times-1,left-i,res,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }


    //217
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            if(!set.add(n))
                return false;
        }
        return true;
    }

    //219
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length&&j<=i+k;j++){
                if(nums[i]==nums[j])
                    return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateI(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(Math.abs(i-map.get(nums[i]))<=k)
                    return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }


    //滑动窗口
    public boolean containsNearbyDuplicateII(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if(set.size()>k)
                set.remove(nums[i-k]);
        }
        return false;
    }



    //220
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Long successor = set.ceiling((long)nums[i]);
            if(successor!=null&&(long)nums[i]+t>=successor)
                return true;
            Long predecessor = set.floor((long)nums[i]);
            if(predecessor!=null&&(long)nums[i]-t<=predecessor)
                return true;
            set.add((long)nums[i]);
            if(set.size()>k)
                set.remove((long)nums[i-k]);
        }
        return false;
    }

    //223
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(A);
        list1.add(C);
        list1.add(E);
        list1.add(G);

        List<Integer> list2 = new ArrayList<>();
        list2.add(B);
        list2.add(D);
        list2.add(F);
        list2.add(H);
        List<Integer> res1 = getMedia(list1);
        List<Integer> res2 = getMedia(list2);
        int off = 0;
        if(E>=C||G<=A||F>=D||H<=B){
        }
        else{
            off = Math.abs(res1.get(0)-res1.get(1)) * Math.abs(res2.get(0)-res2.get(1));
        }
        return (C-A)*(D-B) + (G-E)*(H-F) - off;

    }

    private List<Integer> getMedia(List<Integer> list){
        int max = list.get(0);
        int min = list.get(0);
        for(int i : list){
            if( i > max)
                max = i;
            if( i < min)
                min = i;
        }
        list.remove(list.indexOf(max));
        list.remove(list.indexOf(min));
        List<Integer> res = new ArrayList<>();
        res.add(list.get(0));
        res.add(list.get(1));
        return res;
    }

    //224
    public int calculate(String s) {
        String[] items = s.split(" ");
        return 0;
    }

    //226
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        else{
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;

            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }


    //228
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while( index < nums.length){
            int begin = nums[index];
            int end = nums[index];
            index ++;
            for (int i=index;i<nums.length;i++){
                if(end + 1 == nums[i]){
                    index ++;
                    end ++;
                }
                else{
                    index --;
                    break;
                }
            }
            index ++ ;
            if(begin == end)
                res.add(String.valueOf(begin));
            else
                res.add(String.valueOf(begin)+"->"+String.valueOf(end));
        }
        return res;
    }


    public List<String> summaryRangesII(int[] nums) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++){
            int index = i;
            while(index + 1<nums.length && nums[index]+1 == nums[index+1]){
                index++;
            }
            if(index == i)
                res.add(String.valueOf(nums[i]));
            else {
                res.add((nums[i])+"->"+(nums[index]));
                i = index;
            }
        }
        return res;
    }

    //229 摩尔投票算法 计算出现次数较多的数
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        int vote1 = 0;
        int vote2 = 0;
        for (int num:nums){
            if(num == candidate1){
                vote1 ++;
                continue;
            }
            if(num == candidate2){
                vote2 ++;
                continue;
            }
            if(vote1 == 0 && candidate2 != num){
                vote1 ++;
                candidate1 = num;
                continue;
            }
            if(vote2 == 0 && candidate1 != num){
                vote2 ++;
                candidate2 = num;
                continue;
            }
            vote1 --;
            vote2 --;
        }

        int count1 = 0, count2 = 0;
        for(int num:nums){
            if(num == candidate1)
                count1 ++;
            if(num == candidate2)
                count2 ++;
        }
        if(count1 > nums.length/3)
            res.add(candidate1);
        if(candidate1 != candidate2 && count2 > nums.length/3)
            res.add(candidate2);
        return res;
    }


    //230  找到二叉搜索树第K小的元素
    List<TreeNode> list0f230 = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        help230(root);
        return list0f230.get(k-1).val;
    }

    private void help230(TreeNode treeNode){
        if(treeNode == null)
            return;
        help230(treeNode.left);
        list0f230.add(treeNode);
        help230(treeNode.right);
    }

    // 二叉搜索树的非递归遍历
    public int kthSmallestII(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            k--;
            if(k == 0)
                return temp.val;
            root = temp.right;
        }
    }


    //231
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        else
            return (n & (n - 1)) == 0;
    }


    //232
    public int countDigitOne(int n) {
        int res = 0;
        for(int i=1;i<n;i++)
            res += help232(i);
        return res;
    }

    private int help232(int n){
        String s = String.valueOf(n);
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1')
                res++;
        }
        return res;
    }

  public static void main(String[] args) {
    System.out.println(
    new LeetCodePraticeIII().countDigitOneII(13));
  }

    public int countDigitOneII(int n) {
        String s = String.valueOf(n);
        int k = 1;
        int res = 0;
        for(int i=s.length()-1;i>=0;i--){
            StringBuilder sb = new StringBuilder(s);
            int time = String.valueOf(k).length()-1;
            int index = i + 1;
            while(time > 0){
                sb.setCharAt(index,'0');
                time--;
                index ++;
            }
            sb.setCharAt(i,'1');
            System.out.println(sb.toString());
            int begin = Integer.valueOf(sb.toString());
            res += n/10 + Math.min(n-begin+1,k);
            k = k * 10;
        }
        return res;
    }
}

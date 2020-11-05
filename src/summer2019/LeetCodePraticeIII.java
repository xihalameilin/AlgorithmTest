package summer2019;

import sun.applet.AppletResourceLoader;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class LeetCodePraticeIII {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
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

    public int countDigitOneII(int n) {
        if(n<=0)
            return 0;
        String s = String.valueOf(n);
        long k = 1;
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

            int begin = Integer.valueOf(sb.toString());
            res += (n/(k*10))*k + Math.min(Math.max(n-begin+1,0),k);
            k = k * 10;
        }
        return res;
    }


    public int countDigitOneIII(int n) {
        if(n<=0)
            return 0;
        String s = String.valueOf(n);
        long k = 1;
        int res = 0;
        for(int i=s.length()-1;i>=0;i--){
            int begin = (int)(n/(k*10)*k*10 + k);
            res += (n/(k*10))*k + Math.min(Math.max(n-begin+1,0),k);
            k = k * 10;
        }
        return res;
    }



    public void test(){
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(0);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        isPalindrome(listNode);
    }

    //234
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverse = reverseListNode(slow);
        while(head != null && reverse!= null){
            if(head.val != reverse.val)
                return false;
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }

    private ListNode reverseListNode(ListNode head){
        if(head == null)
            return null;
        ListNode pre = null;
        ListNode mid = head;
        while(mid != null){
            ListNode temp = mid.next;
            mid.next = pre;
            pre = mid;
            mid = temp;
        }
        return pre;
    }

    private void showListNode(ListNode head){
        while(head!=null){
            System.out.print(head.val);
            head = head.next;
        }
    }


    //235
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = help235(root,p);
        List<TreeNode> path2 = help235(root,q);
        int max = Math.min(path1.size(),path2.size());
        for(int i=max-1;i>=0;i--){
            if(path1.get(i).val == path2.get(i).val)
                return path1.get(i);
        }
        return null;
    }

    private List<TreeNode> help235(TreeNode root,TreeNode p){
        List<TreeNode> res = new ArrayList<>();
        while(true){
            res.add(root);
            if(root.val > p.val){
                root = root.left;
            }
            else if(root.val < p.val){
                root = root.right;
            }
            else{
                break;
            }
        }
        return res;
    }

    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left,p,q);
        else if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right,p,q);
        return root;
    }


    //236
    private Set<Integer> visited = new HashSet<>();
    public TreeNode lowestCommonAncestorIII(TreeNode root, TreeNode p, TreeNode q) {
        help236(root);
        while(p != null){
            visited.add(p.val);
            p = map236.get(p.val);
        }
        while(q != null){
            if(visited.contains(q.val)){
                return q;
            }
            else{
                q = map236.get(q.val);
            }
        }
        return null;
    }

    private Map<Integer,TreeNode> map236 = new HashMap<>();
    private void help236(TreeNode root){
        if(root.left != null){
            map236.put(root.left.val, root);
            help236(root.left);
        }
        if(root.right != null){
            map236.put(root.right.val, root);
            help236(root.right);
        }
    }

    public TreeNode lowestCommonAncestorIIII(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestorIIII(root.left, p , q);
        TreeNode right = lowestCommonAncestorIIII(root.right, p, q);
        if(left != null && right !=null)
            return root;
        else if(left != null)
            return left;
        else if(right != null)
            return right;
        else
            return null;
    }



    //238
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, 1);
        int left = 1;
        int right = 1;
        for(int i = 0 ; i < len ; i ++){
            res[i] = res[i] * left;
            res[len - 1 - i] = res[len - 1 - i] * right;
            left = left * nums[i];
            right = right * nums[len - 1 - i];
        }
        return res;
    }

    public int[] productExceptSelfII(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for(int i = 1 ; i < len ; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }
        int R = 1;
        for(int i = len - 1 ; i >= 0 ; --i ){
            res[i] = res[i] * R;
            R = R * nums[i];
        }
        return res;
    }
    //239
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return nums;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0 ; i < nums.length ; i++){
            int temp = nums[i];
            while(!arrayDeque.isEmpty() && arrayDeque.peekLast() < temp){
                arrayDeque.pollLast();
            }
            arrayDeque.offerLast(temp);
            arrayDeque.forEach(System.out::print);
            System.out.println();
           if(i >= k && nums[i - k] == arrayDeque.peekFirst())
                arrayDeque.pollFirst();
            if(i >= k - 1)
                res[i - k + 1] = arrayDeque.peekFirst();
        }
        return res;
    }

    //240
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int r = 0;
        int c = col;
        while(true){
            if(matrix[r][c] == target)
                return true;
            if(matrix[r][c] > target){
                c -- ;
                if(c<0)
                    return false;
            }
            else {
                r ++ ;
                if(r > row)
                    return false;
            }
        }
    }


    public static void main(String[] args) {

        new LeetCodePraticeIII().diffWaysToCompute(new String("2*3-4*5"));
    }
    //241
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        int times = 0;
        List<String> in = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for(int i = 0 ; i < input.length() ; i ++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                times ++ ;
                in.add(temp.toString());
                in.add(input.substring(i,i+1));
                temp = new StringBuilder();
            }
            else {
                temp.append(input.charAt(i));
            }
        }
        in.add(temp.toString());
        //in.forEach(System.out::println);
        help241(in,res,times);
        res.forEach(System.out::println);
        return res;
    }

    private void help241(List<String> input,List<Integer> res,int times){
//        input.forEach(System.out::print);
//        System.out.println(times);
//        System.out.println();
        if(times == 0){
            System.out.println("trigger");
            res.add(Integer.valueOf(input.get(0)));
        }
        for(int i = 0 ; i < input.size() ; i ++){
            String item = input.get(i);
            List<String> copy = new ArrayList<>(input);
            if(item.equals("+")){
                List<String> copy2 = new ArrayList<>(input);
                Integer pre = Integer.valueOf(input.get(i - 1));
                Integer next = Integer.valueOf(input.get(i + 1));
                copy.remove(i-1);
                copy.remove(i-1);
                copy.set(i-1, String.valueOf(pre + next));
                help241(copy,res,--times);
                input = copy2;
            }
            else if(item.equals("-")){
                List<String> copy2 = new ArrayList<>(input);
                Integer pre = Integer.valueOf(input.get(i - 1));
                Integer next = Integer.valueOf(input.get(i + 1));
                copy.remove(i-1);
                copy.remove(i-1);
                copy.set(i-1, String.valueOf(pre - next));
                help241(copy,res,--times);
                input = copy2;
            }
            else if(item.equals("*")){
                List<String> copy2 = new ArrayList<>(input);
                Integer pre = Integer.valueOf(input.get(i - 1));
                Integer next = Integer.valueOf(input.get(i + 1));
                copy.remove(i-1);
                copy.remove(i-1);
                copy.set(i-1, String.valueOf(pre * next));
                help241(copy,res,--times);
                input = copy2;
            }
        }
    }

    public List<Integer> diffWaysToComputeII(String input) {
        List<Integer> res = new LinkedList<>();
        for(int i = 0 ; i < input.length() ; i ++){
            char cmd = input.charAt(i);
            if(cmd == '+' || cmd == '-' || cmd == '*'){
                List<Integer> left = diffWaysToCompute(input.substring(0 , i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for(int l : left){
                    for(int r : right){
                        if(cmd == '+')
                            res.add(l + r);
                        else if(cmd == '-')
                            res.add(l - r);
                        else if(cmd == '*')
                            res.add(l * r);
                    }
                }

            }
        }
        if(res.size() == 0)
            res.add(Integer.valueOf(input));
        return res;
    }

}

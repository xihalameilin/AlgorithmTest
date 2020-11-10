package summer2019;

import sun.applet.AppletResourceLoader;
import sun.reflect.generics.tree.Tree;

import javax.print.attribute.HashPrintServiceAttributeSet;
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


    //242
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < t.length() ; i ++){
            if(!map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), 0);
            }
            map.put(t.charAt(i),map.get(t.charAt(i))+1);
        }
        for(int i = 0 ; i < s.length() ; i ++){
            if(!map.containsKey(s.charAt(i)))
                return false;
            if(map.get(s.charAt(i)) == 0)
                return false;
            map.put(s.charAt(i),map.get(s.charAt(i))-1);
        }
        return true;
    }

    //257
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        help257(res,root,new StringBuilder());
        return res;
    }

    private void help257(List<String> res,TreeNode root,StringBuilder path){
        if(root == null)
            return;
        path.append(root.val);
        if(root.left == null && root.right == null)
            res.add(path.toString());
        else{
            help257(res,root.left,new StringBuilder(path).append("->"));
            help257(res,root.right,new StringBuilder(path).append("->"));
        }
    }


    //257
    public List<String> binaryTreePathsII(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        nodeQueue.add(root);
        pathQueue.add(String.valueOf(root.val));
        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();
              if (node.left == null && node.right == null)
                  res.add(path);
              else {
                    if(node.left != null) {
                      nodeQueue.offer(node.left);
                      pathQueue.offer(new StringBuilder(path).append("->").append(node.left.val).toString());
                    }
                    if(node.right != null) {
                      nodeQueue.offer(node.right);
                      pathQueue.offer(new StringBuilder(path).append("->").append(node.right.val).toString());
                    }
                    }
        }
        return res;
    }

    //258
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    //260
    public int[] singleNumber(int[] nums) {
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        for(int i : nums)
            res ^= i;
        int bit = 1;
        while((res & bit) == 0){
            bit <<= 1;
        }
        for(int i : nums){
            if((i & bit) == 0)
                num1 ^= i;
            else
                num2 ^= i;
        }
        return new int[]{num1,num2};
    }


    //263
    public boolean isUgly(int num) {
        if(num <= 0)
            return false;
        while(num%2 == 0)
            num /= 2;
        while(num%3 == 0)
            num /= 3;
        while(num%5 == 0)
            num /= 5;
        return num == 1;
    }


    //264
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1 ; i < n ;i ++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0 ; j < i ; j ++){
                if(dp[j] * 2 > dp[i-1]){
                    dp[i] = Math.min(dp[i] , dp[j] * 2);
                }
                if(dp[j] * 3 > dp[i-1]){
                    dp[i] = Math.min(dp[i] , dp[j] * 3);
                }
                if(dp[j] * 5 > dp[i-1]){
                    dp[i] = Math.min(dp[i] , dp[j] * 5);
                }
            }
        }
        return dp[n-1];
    }


    public int nthUglyNumberII(int n) {
        int[] idx = new int[]{0,0,0};
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 1 ; i < n ; i ++){
            int a = dp[idx[0]] * 2;
            int b = dp[idx[1]] * 3;
            int c = dp[idx[2]] * 5;
            dp[i] = Math.min(Math.min(a,b),c);
            if(dp[i] == a)
                idx[0] ++;
            if(dp[i] == b)
                idx[1] ++;
            if(dp[i] == c)
                idx[2] ++;
         }
        return dp[n-1];
    }


    //268
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 1 ; i <= nums.length ; i ++){
            sum += i;
            sum -= nums[i-1];
        }
        return sum;
    }

    public int missingNumberII(int[] nums) {
        int missing = nums.length;
        for(int i = 0 ; i < nums.length ; i ++){
            missing ^= i^nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {

        new LeetCodePraticeIII().numberToWords(1234567891);

    }
    //273
    public String numberToWords(int num) {
        String s = String.valueOf(num);
        String[] level = new String[]{""," Thousand "," Million "," Billion "};
        String res = new String();
        int times = 0;
        for(int i = s.length() ; i >0 ; i -= 3){
            int left = i - 3 < 0 ? 0 : i - 3 ;
            String sub = s.substring(left,i);
            System.out.println(sub);
            String temp = dealThreeBit(sub)+level[times];
            times ++;
            res = temp + res;
        }
        System.out.println(res);
        return res.trim();
    }

    private String dealThreeBit(String s){
        if(s.length() == 1)
            return singleNum(s);
        //两位
        else if(s.length() == 2){
            if(Integer.valueOf(s) < 20){
                return string2num3(s);
            }
            else {
                String shi = s.substring(0,1);
                String ge = s.substring(1,2);
                if(ge.equals("0")){
                    return string2num2(shi).trim();
                }
                return string2num2(shi) + singleNum(ge);
            }
        }
        //三位
        else{
            String bai = s.substring(0,1);

            String res = string2num1(bai);
            String temp = new String();
            if(Integer.valueOf(s.substring(1)) < 20){
                temp = string2num3(s.substring(1));
            }
            else if(Integer.valueOf(s.substring(2)) == 0){
                return string2num2(s.substring(1,2));
            }
            else {
                String shi = s.substring(1,2);
                String ge = s.substring(2,3);
                temp = string2num2(shi) + singleNum(ge);
            }
            return res +" " +temp;
        }
    }

    //百位
    private String string2num1(String s){
        return singleNum(s)+" Hundred";
    }

    //十位
    private String string2num2(String s){
        String res = new String();
        switch (s){
            case "2":
                res = "Twenty ";
                break;
            case "3":
                res = "Thirty ";
                break;
            case "4":
                res = "Forty ";
                break;
            case "5":
                res = "Fifty ";
                break;
            case "6":
                res = "Sixty ";
                break;
            case "7":
                res = "Seventy ";
                break;
            case "8":
                res = "Eighty ";
                break;
            case "9":
                res = "Ninety ";
                break;
        }
        return res;
    }
    private String string2num3(String s){
        String res = new String();
        if(0<Integer.valueOf(s)&&Integer.valueOf(s)<10)
            return singleNum(s);
        switch (s){
            case "1":
                res = "One";
                break;
            case "2":
                res = "Two";
                break;
            case "3":
                res = "Three";
                break;
            case "4":
                res = "Four";
                break;
            case "5":
                res = "Five";
                break;
            case "6":
                res = "Six";
                break;
            case "7":
                res = "Seven";
                break;
            case "8":
                res = "Eight";
                break;
            case "9":
                res = "Nine";
                break;
            case "10":
                res = "Ten";
                break;
            case "11":
                res = "Eleven";
                break;
            case "12":
                res = "Twelve";
                break;
            case "13":
                res = "Thirteen";
                break;
            case "14":
                res = "Fourteen";
                break;
            case "15":
                res = "Fifteen";
                break;
            case "16":
                res = "Sixteen";
                break;
            case "17":
                res = "Seventeen";
                break;
            case "18":
                res = "Eighteen";
                break;
            case "19":
                res = "nineteen";
                break;
        }
        return res;
    }


    private String singleNum(String s){
        String res = new String();
        switch (s){
            case "0":
                res = "Zero";
                break;
            case "1":
                res = "One";
                break;
            case "2":
                res = "Two";
                break;
            case "3":
                res = "Three";
                break;
            case "4":
                res = "Four";
                break;
            case "5":
                res = "Five";
                break;
            case "6":
                res = "Six";
                break;
            case "7":
                res = "Seven";
                break;
            case "8":
                res = "Eight";
                break;
            case "9":
                res = "Nine";
                break;
        }
        return res;
    }

    public String numberToWordsII(int num) {
        if(num==0){
            return "Zero";
        }
        int part1 = num%1000;
        num = num/1000;
        int part2 = num%1000;
        num = num/1000;
        int part3 = num%1000;
        num = num/1000;
        int part4 = num;
        String ans = "";
        if(part4!=0){
            ans = dealThreeBits(part4) + "Billion ";
        }
        if(part3!=0){
            ans = ans + dealThreeBits(part3) + "Million ";
        }
        if(part2!=0){
            ans = ans + dealThreeBits(part2) + "Thousand ";
        }
        if(part1!=0){
            ans = ans + dealThreeBits(part1);
        }
        return ans.trim();
    }

    private String dealThreeBits(int num){
        String[] low = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] mid = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] high = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        int ge = num%10;
        num /= 10;
        int shi = num%10;
        num /= 10;
        int bai = num%10;

        String res = new String();
        if(bai != 0)
            res += low[bai] + " Hundred ";
        if(shi == 0)
            res += low[ge];
        else if(shi == 1)
            res += mid[ge];
        else
            res += high[shi] + " " + low[ge];
        return res.trim() + " ";

    }

    //274
    public int hIndex(int[] citations) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < citations.length ; i ++){
            for(int j = 0 ; j <= citations[i] ; j ++){
                map.put(j,map.getOrDefault(j,0)+1);
            }
        }
        int res = 0;
        for(int i = citations.length ; i >= 0 ; i ++){
            if(map.get(i) != null && map.get(i) >= i){
                res = i;
                break;
            }

        }
        return res;
    }

      public int hIndexII(int[] citations) {
        Arrays.sort(citations);
        int h = citations.length;
        for (int i = 0; i < citations.length; i++) {
          // 比较小于则 h-1
          if (citations[i] < h) {
            h--;
          }
        }
        return h;
    }

    //275
    public int hIndexIII(int[] citations) {
        int left = 0;
        int right = citations.length-1;
        int res = 0 ;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(citations[mid] > citations.length - mid ){
                right = mid;
                res = citations.length - mid;
            }
            else{
                left = mid + 1;
            }
        }
        return res;
    }

    boolean isBadVersion(int version){
        return false;
    }

    //278
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n ;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if(!isBadVersion(mid)){
                left = mid;
            }
            else{
                right = mid - 1;
            }

        }
        return left;
    }

    //279
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1 ; i * i <= n ; i ++)
            dp[i] = 1;
        for(int i = 1 ; i <= n ; i ++){
            for(int j = 1 ; 2 * j <= i ; j++){
                dp[i] = Math.min(dp[j] + dp[i-j],dp[i]);
            }
        }
        return dp[n];
    }


    //283
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0)
                count ++;
            else
                nums[i-count] = nums[i];
        }
        for(int i = nums.length - count; i < nums.length ; i++)
            nums[i] = 0;
    }
}

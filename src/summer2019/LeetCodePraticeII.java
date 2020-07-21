package summer2019;

import java.lang.reflect.Array;
import java.util.*;

public class LeetCodePraticeII {
    public class ListNode {
     int val;
    ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  //21
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;

        while(l1 !=null && l2 != null){
            if(l1.val<=l2.val){
                cur.next = new ListNode(l1.val);
                cur = cur.next;
                l1 = l1.next;
            }
            else{
                cur.next = new ListNode(l2.val);
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if(l1==null){
            cur.next = l2;
        }
        else{
            cur.next = l1;
        }

        return result.next;
    }



    //22
    public List<String> generateParenthesis(int n) {
        if(n==0){
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        else if(n==1){
            List<String> result = new ArrayList<>();
            result.add("()");
            return result;
        }

        List<String> result = new ArrayList<>();
        dfs(n,n,"",result);
        return result;

    }

    private void dfs(int left,int right,String cur,List<String> result){
        if(left==0&&right==0){
            result.add(cur);
            return;
        }
        if(left>right){
            return;
        }
        if(left>0){
            dfs(left-1,right,cur+"(",result);
        }
        if(right>0){
            dfs(left,right-1,cur+")",result);
        }
    }

    //22动态规划 a[n] = "("+a[m]+")"+a[k] m+k=n-1
    public List<String> generateParenthesisII(int n) {
        if(n==0){
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        else if(n==1){
            List<String> result = new ArrayList<>();
            result.add("()");
            return result;
        }

        List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("");
        res.add(a1);
        ArrayList<String> a2 = new ArrayList<>();
        a2.add("()");
        res.add(a2);

        for(int i=2;i<=n;i++){
            ArrayList<String> cur = new ArrayList<>();
            for(int j=0;j<i;j++){
                ArrayList<String> list1 = res.get(j);
                ArrayList<String> list2 = res.get(i-1-j);
                int count1 = list1.size();
                int count2 = list2.size();
                for(int k=0;k<count1;k++){
                    for(int m=0;m<count2;m++){
                        cur.add("("+list1.get(k)+")"+list2.get(m));
                    }
                }
            }
            res.add(cur);
        }
        return res.get(n);
    }


    //23 优先堆合并多个有序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val>o2.val)
                    return 1;
                else if(o1.val<o2.val)
                    return -1;
                return 0;
            }
        });


         for(int i=0;i<lists.length;i++){
             if(lists[i]==null)
                 continue;
            queue.add(lists[i]);
         }
         ListNode res = new ListNode(0);
         ListNode cur = res;
         while(!queue.isEmpty()){
             ListNode l = queue.poll();
             cur.next = l;
             cur = cur.next;
             if(l.next!=null)
                 queue.add(l.next);
         }
         return res.next;
    }

    //24
    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        ListNode f = new ListNode(0);
        f.next = head;
        ListNode cur = f;
        head = f;
        while(cur!=null&&cur.next!=null&&cur.next.next!=null){
            ListNode x = cur.next;
            ListNode y = x.next;
            y.next = x;
            x.next = y.next;
            cur.next = y;

            cur = cur.next.next;
        }

        return head.next;
    }

    //26
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        for(int i=0;i<length-1;){
            if(nums[i]==nums[i+1]){
                for(int j=i+1;j<length-1;j++){
                    nums[j]=nums[j+1];
                }

                length--;
            }

            else{
                i++;
            }
        }
        return length;
    }

    //27
    public int removeElement(int[] nums, int val) {
        int i=-1;
        int j=0;
        while(j<nums.length){
            if(nums[j]!=val){
                i++;
                nums[i]=nums[j];
            }
            j++;
        }
        return i+1;
    }

    //28
    public int strStr(String haystack, String needle) {
        if(needle==null)
            return 0;
        if(needle.length()>haystack.length())
            return -1;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(haystack.substring(i,i+needle.length()).equals(needle))
                return i;
        }
        return -1;

    }

    //31
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while (i>0&&nums[i-1]>=nums[i]){
            i--;
        }
        if(i==0){
            int start = 0;
            int end = nums.length-1;
            while(start<end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
            return;
        }

        int start = i;
        int end = nums.length-1;
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        int j = i-1;
        while(i<nums.length&&nums[j]>=nums[i]){
            i++;
        }

        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;

    }


    //32
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> flags = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            flags.add(0);
        }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            else{
                if (stack.isEmpty()){
                    flags.set(i,1);
                }
                else {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            int index = stack.pop();
            flags.set(index,1);
        }

        int ans = 0;
        int curlength = 0;
        for(int i=0;i<flags.size();i++){
            if(flags.get(i)==1){
                curlength = 0;
                continue;
            }
            curlength++;
            ans = Math.max(curlength,ans);
        }
        return ans;

    }

    //33
    public int search(int[] nums, int target) {
        int left = 0;
        int rirght = nums.length-1;
        while(left<rirght){
            int mid = (left+rirght)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<nums[rirght]){
                if(nums[mid]<target&&target<=nums[rirght]){
                    left = mid+1;
                }
                else{
                    rirght = mid-1;
                }
            }
            else {
                if(nums[left]<=target&&target<=nums[mid]){
                    rirght = mid-1;
                }
                else{
                    left = mid +1;
                }
            }
        }
        return -1;
    }



    //34
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return new int[]{-1,-1};
        }
        int[] res =  new int[2];
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>=target){
                right = mid;
            }
            else {
                left = mid+1;
            }
        }

        if(nums[left]!=target){
            return new int[]{-1,-1};
        }
        res[0] = left;

        System.out.println(1);

        right = nums.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]<=target){
                left = mid+1;
            }
            else {
                right = mid;
            }
            System.out.println(left+" "+right);
        }

        System.out.println(2);

        res[1] = right-1;
        return res;

    }

    //35
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(target<nums[mid]){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        if(target<=nums[left]){
            return left;
        }
        else {
            return left+1;
        }
    }


    //36
    public boolean isValidSudoku(char[][] board) {
        int[] nums = new int[10];

        for(int i=0;i<9;i++){
            setZeros(nums);
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(nums[board[i][j]-'0']==1){
                        return false;
                    }
                    else {
                        nums[board[i][j]-'0']=1;
                    }
                }
            }
        }

        for(int i=0;i<9;i++){
            setZeros(nums);
            for(int j=0;j<9;j++){
                if(board[j][i]!='.'){
                    if(nums[board[j][i]-'0']==1){
                        return false;
                    }
                    else {
                        nums[board[j][i]-'0']=1;
                    }
                }
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                setZeros(nums);
                for(int x=0;x<3;x++){
                    for(int y=0;y<3;y++){
                        if(board[3*i+x][3*j+y]!='.'){
                            if(nums[board[3*i+x][3*j+y]-'0']==1){
                                return false;
                            }
                            else {
                                nums[board[3*i+x][3*j+y]-'0']=1;
                            }
                        }
                    }
                }

            }
        }

        return true;

    }

    private void setZeros(int[] nums){
        for(int i=0;i< nums.length;i++){
            nums[i] = 0;
        }
    }


    //38
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        String res = new String("1");
        for(int i=1;i<n;i++){
            res = help(res);
        }
        return res;
    }

    private String help(String s){
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int count = 0;
        while(index<s.length()){
            count=0;
            char c = s.charAt(index);
            for(;index<s.length()&&s.charAt(index)==c;index++){
                count++;
            }
            sb.append(count);
            sb.append(c);
        }
        return sb.toString();
    }

    public List<List<Integer>> combinationSumiiiii(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        //System.out.println(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            if (target < 0) break;
            //System.out.println(start);
            tmp_list.add(candidates[start]);
            //System.out.println(tmp_list);
            backtrack(candidates, target - candidates[start], res, start, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }

    //39
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,res,temp);
        return res;
    }

    private void backtrack(int[] candiates,int target,int start,List<List<Integer>> res,List<Integer> temp){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target < candiates[0]){
            return;
        }

        for(int i=start;i<candiates.length;i++){
            temp.add(candiates[i]);
            backtrack(candiates,target-candiates[i],i,res,temp);
            temp.remove(temp.size()-1);
        }
    }

    //40
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,res,temp);
        return new ArrayList<>(new HashSet<List<Integer>>(res));
    }


    //41
    public int firstMissingPositive(int[] nums) {
      int n = nums.length;
      for(int i=0;i<n;i++){
          if(nums[i]<=0){
              nums[i] = n+1;
          }
      }

      for(int i=0;i<n;i++){
          int val = Math.abs(nums[i]);
          if(val<=n){
              nums[val-1] = -Math.abs(nums[val-1]);
          }
      }

      for(int i=0;i<n;i++){
          if(nums[i]>0)
              return i+1;
      }
      return n+1;
    }

    //43
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        int [] res = new int[length1+length2];
        for(int i=length1-1;i>=0;i--){
            for(int j=length2-1;j>=0;j--){
                res[i+j+1] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }

        int jinwei = 0;
        for(int i=res.length-1;i>=0;i--){
            res[i] = res[i] + jinwei;
            jinwei = res[i]/10;
            res[i] = res[i]%10;
        }

        int count = 0;
        for(int i=0;i<res.length;i++){
            if(res[i] == 0)
                count++;
            else
                break;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=count;i<res.length;i++){
            sb.append(String.valueOf(res[i]));
        }
        return sb.toString();

    }


    //46
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        help46(res,temp,nums);
        return res;
    }


    private void help46(List<List<Integer>> res,List<Integer> temp,int[] nums){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!temp.contains(nums[i])){
                temp.add(nums[i]);
                help46(res,temp,nums);
                temp.remove(temp.size()-1);
            }
        }
    }


    //47
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        help47(res,temp,visit,nums);
        return res;
    }

    private void help47(List<List<Integer>> res,List<Integer> temp,boolean[] visit,int[] nums){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visit[i]){
                if(i>0&&nums[i]==nums[i-1]&&!visit[i-1])
                    continue;
                visit[i] = true;
                temp.add(nums[i]);
                help47(res,temp,visit,nums);
                visit[i] = false;
                temp.remove(temp.size()-1);
            }

        }
    }


    //48  翻转矩阵  上下 +  主对角线翻转
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        for(int i=0;i<size/2;i++){
            for(int j=0;j<size;j++){
                swap(matrix,i,j,size-1-i,j);
            }
        }

        for(int i=0;i<size;i++){
            for(int j=i;j<size;j++){
                swap(matrix,i,j,j,i);
            }
        }
    }

    private void swap(int[][] matrix,int x1,int y1,int x2,int y2){
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }


    //49
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String string = String.valueOf(s);
            if(!map.containsKey(string)){
                map.put(string,new ArrayList<>());
            }
            map.get(string).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    //50
    public double myPow(double x, int n) {
        return n >= 0 ? calcuPow(x, n) : 1.0 / calcuPow(x, -n);
    }

    public double calcuPow(double x, int n){
        if (n == 0) {
            return 1.0;
        }
        double y = calcuPow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }


    //53
    //    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    //    示例:
    //    输入: [-2,1,-3,4,-1,2,1,-5,4],
    //    输出: 6
    //    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for(int num:nums){
            if(sum>0)
                sum+=num;
            else
                sum=num;
            res = Math.max(sum,res);
        }
        return res;
    }

    public int maxSubArrayII(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for(int num:nums){
            if(sum<0)
                sum=0;
            sum += num;
            res = Math.max(res,sum);
        }
        return res;
    }


    //54
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new LinkedList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int rowbegin = 0;
        int colbegin = 0;
        int rowend = row-1;
        int colend = col-1;
        while(colbegin<=colend&&rowbegin<=rowend){
            for(int i=colbegin;i<=colend;i++){
                res.add(matrix[rowbegin][i]);
            }
            rowbegin++;
            for(int i=rowbegin;i<=rowend;i++){
                res.add(matrix[i][colend]);
            }
            colend--;
            for(int i=colend;i>=colbegin&&rowbegin<=rowend;i--){
                res.add(matrix[rowend][i]);
            }
            rowend--;
            for(int i=rowend;i>=rowbegin&&colbegin<=colend;i--){
                res.add(matrix[i][colbegin]);
            }
            colbegin++;
        }
        return res;
    }


    //55
//    给定一个非负整数数组，你最初位于数组的第一个位置。
//
//    数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//    判断你是否能够到达最后一个位置。
//
//    示例 1:
//
//    输入: [2,3,1,1,4]
//    输出: true
//    解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。

    public boolean canJump(int[] nums) {
        int reach = 1;
        if(nums.length==1)
            return true;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<reach){
                reach++;
            }
            else{
                reach=1;
            }
        }
        return reach==1;
    }


    //贪心算法
    public boolean canJumpII(int[] nums) {
        if(nums.length<=1)
            return true;
        int maxLen = nums[0];
        for(int i=1;i<nums.length-1;i++){
            if(i<=maxLen){
                maxLen = Math.max(maxLen,nums[i]+i);
            }
            else
                return false;
        }
        return maxLen>=nums.length-1;
    }

    //56
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] pre = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(pre);
        for(int i=1;i<intervals.length;i++){
            if(pre[1]>=intervals[i][0]){
                int[] temp = new int[]{pre[0],Math.max(intervals[i][1],pre[1])};
                pre = temp;
                res.remove(res.size()-1);
                res.add(temp);
            }
            else{
                pre = intervals[i];
                res.add(intervals[i]);
            }
        }
        
        int[][] result = new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }

    //57
    public int lengthOfLastWord(String s) {
        if(s==null||s.equals(" ")||s.length()==0)
            return 0;
        String[] strings = s.split(" ");
        int length = strings.length;
        return length>0?strings[strings.length-1].length():0;
    }


    //59
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int cur = 1;
        int end = n*n;

        int l=0;
        int r=n-1;
        int u=0;
        int d=n-1;
        while(cur <= end){
            for(int i=l;i<=r;i++){
                res[u][i] = cur++;
            }
            u++;
            for(int i=u;i<=d;i++){
                res[i][r] = cur++;
            }
            r--;
            if(u>d)
                break;
            for(int i=r;i>=l;i--){
                res[d][i] = cur++;
            }
            d--;
            if(l>r)
                break;
            for(int i=d;i>=u;i--){
                res[i][l] = cur++;
            }
            l++;
        }
        return res;
    }


    //60 康拓展开！！！
    public String getPermutation(int n, int k) {
        int m = n-1;
        StringBuilder sb  = new StringBuilder();
        int beichu = k-1;
        boolean[] flags = new boolean[n];
        int factor[]={1,1,2,6,24,120,720,5040,40320,362880};
        int shang = 0;
        int yushu = 0;
        while(m>=0){
            shang = beichu / factor[m];
            yushu = beichu % factor[m];
            m--;
            int count = 0;
            int i=0;
            for(;i<n;i++){
                if(!flags[i])
                    count++;
                if(count==shang+1)
                    break;
            }
            flags[i] = true;
            sb.append(i+1);
            beichu = yushu;
        }
        return sb.toString();

    }

    //61  旋转链表 相右移动k个单位
//     * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode cur = head;
        int count = 1;
        while(cur.next!=null){
            cur = cur.next;
            count++;
        }
        k = k%count;
        if(k==0)
            return head;
        cur.next=head;
        for(int i=0;i<count-k;i++){
            cur = cur.next;
            head = head.next;
        }
        cur.next=null;
        return head;
     }

     //62
     public int uniquePaths(int m, int n) {
      int[][] dp = new int[m+n][m+n];
      dp[0][0] = 0;
      dp[1][0] = 0;
      dp[1][1] = 0;
      if(m+n-2<=1)
          return dp[m+n-2][m-1];
      for(int i=2;i<m+n;i++){
          for(int j=0;j<=i;j++){
              if(i==0||j==0)
                  dp[i][j]=0;
              else {
                  dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
              }
          }
      }
      return dp[m+n-2][m-1];
     }

     //63
     public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m+1][n+1];
        dp[0][1]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(obstacleGrid[i-1][j-1]==1){
                    dp[i][j]=0;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m][n];
    }

    //64
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    if(j!=0){
                        dp[i][j] = dp[i][j-1]+grid[i][j];
                    }
                }
                else if(j==0){
                    if(i!=0){
                        dp[i][j] = dp[i-1][j]+grid[i][j];
                    }
                }
                else{
                    int res1 = dp[i-1][j]+grid[i][j];
                    int res2 = dp[i][j-1]+grid[i][j];
                    dp[i][j] = Math.min(res1,res2);
                }
            }
        }

        return dp[m-1][n-1];

//        int min = 0;
//        for(int i=0;i<m;i++)
//            min+=grid[i][0];
//        for(int i=1;i<n;i++)
//            min+=grid[m-1][i];
//        int temp = 0;
//        helper64(grid,0,0,min,temp);
//        return min;
    }

    private void helper64(int[][] grid,int x,int y,int min,int temp){
        int m = grid.length;
        int n = grid[0].length;
        if(x==m-1&&y==n-1){
            min=Math.min(min,temp);
            return;
        }

        if(x<m-1){
                helper64(grid,x+1,y,min,temp+grid[x][y]);
        }

        if(y<n-1){
            helper64(grid,x,y+1,min,temp+grid[x][y]);
        }
    }


    //66
    public int[] plusOne(int[] digits) {
        int jinwei = 1;
        for(int i=digits.length-1;i>=0;i--){
            int cur = digits[i]+jinwei;
            digits[i] = cur%10;
            jinwei = cur>=10?1:0;
        }
        if(jinwei==0){
            return digits;
        }
        else {
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            for(int i=0;i<digits.length;i++){
                ans[i+1] = digits[i];
            }
            return ans;
        }
    }



    //67
    public String addBinary(String a, String b) {
        int length1 = a.length();
        int length2 = b.length();
        int max = Math.max(length1,length2);
        for(int i=0;i<max-length1;i++){
            a = "0"+a;
        }
        for(int i=0;i<max-length2;i++){
            b = "0"+b;
        }

        int jinwei = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=max-1;i>=0;i--){
            int x1 = Integer.valueOf(a.charAt(i)-'0');
            int x2 = Integer.valueOf(b.charAt(i)-'0');
            if(x1+x2+jinwei>=2){
                int temp = x1+x2+jinwei-2;
                jinwei = 1;
                sb = sb.insert(0,temp);
            }
            else {
                int temp = x1+x2+jinwei;
                jinwei = 0;
                sb = sb.insert(0,temp);
            }

        }
        if(jinwei==1){
            return "1"+sb.toString();
        }
        return sb.toString();

    }

    //69
    public int mySqrt(int x) {
        if(x==1||x==0)
            return x;
        int left = 0;
        int right = x;
        while(left+1<right){
            int mid = left + (right-left)/2;
            if(x/mid == mid)
                return mid;
            else if(x/mid>mid)
                left = mid ;
            else
                right = mid ;
        }
        return left;
    }

    //70
    public int climbStairs(int n) {
        int[] res = new int[n+1];
        if(n==0||n==1)
            return n;
        res[0] = 0;
        res[1] = 1;
        for(int i=2;i<n+1;i++){
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }

    //71
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for(int i=0;i<strings.length;i++){
            if(!strings[i].equals(".")&&!strings[i].equals("..")&&!strings[i].equals("")) {
                stack.push(strings[i]);
            }
            else if(strings[i].equals("..")&&!stack.isEmpty()){
                stack.pop();
            }
        }

        String res = new String();
        List<String> list = new ArrayList<>();
        int size = stack.size();
        for(int i=0;i<size;i++){
            list.add(stack.pop());
        }
       for(int i=list.size()-1;i>=0;i--){
            res = res + "/" + list.get(i);
       }
        return res.length()==0?"/":res;
    }



    //73
//    给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
    // m+n 复杂度： 两个一维数组
    // o(2) 如下
    //
    public void setZeroes(int[][] matrix) {
        boolean rowflag = false;
        boolean colflag = false;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<col;i++){
            if(matrix[0][i]==0){
                rowflag = true;
                break;
            }
        }

        for(int i=0;i<row;i++){
            if(matrix[i][0]==0){
                colflag = true;
                break;
            }
        }


        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }

        }

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }

        }

        if(rowflag){
            for(int i=0;i<col;i++){
                matrix[0][i]=0;
            }
        }

        if(colflag){
            for(int i=0;i<row;i++){
                matrix[i][0]=0;
            }
        }
    }

    //74
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        if(col==0)
            return false;
        int i = 0;
        int j = col-1;
        while(true){
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]<target){
                if(i==row-1)
                    return false;
                else i++;
            }
            else {
                for(int l = j-1;l>=0;l--)
                    if(matrix[i][l]==target)
                        return true;
                return false;
            }
        }
    }

    //75
    public void sortColors(int[] nums) {


//        int r1 = -1;
//        int r2 = -1;
//        for(int i = 0;i < nums.length;i++){
//            if(nums[i] < 2)
//            {
//                r2++;
//                swap(nums,i,r2);
//                if(nums[r2] < 1)
//                {
//                    r1++;
//                    swap(nums,r1,r2);
//                }
//            }
//
//        }

        int ptr0 = 0;
        int ptr1 = nums.length-1;
        while(true){
            while(ptr0<nums.length&&nums[ptr0]==0)
                ptr0++;
            while(ptr1>=0&&nums[ptr1]!=0)
                ptr1--;
            if(ptr0>=ptr1)
                break;
            swapArray(nums,ptr0,ptr1);
            ptr0++;
            ptr1--;
        }

        ptr1 = nums.length-1;
        while(true){
            while(ptr0<nums.length&&nums[ptr0]==1)
                ptr0++;
            while(ptr1>=0&&nums[ptr1]!=1)
                ptr1--;
            if(ptr0>=ptr1)
                break;
            swapArray(nums,ptr0,ptr1);
            ptr0++;
            ptr1--;
        }

    }


    private void swapArray(int[] nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    //77
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper77(n,0,k,res,temp);
        return res;
    }

    private void helper77(int n,int cur,int k,List<List<Integer>> res,List<Integer> temp){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=cur;i<=n;i++){
            temp.add(i);
            helper77(n,i+1,k,res,temp);
            temp.remove(temp.size()-1);
        }
    }


    //78  子集
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            int size = res.size();
            for(int j=0;j<size;j++){
                List<Integer> temp = new ArrayList(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }

    //79
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(helper79(board,i,j,0,word))
                    return true;
            }
        }
        return false;
    }

    private boolean helper79(char[][] board,int x,int y,int step,String word){
        if(step == word.length()){
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        if(x<0||y<0||x>=row||y>=col||board[x][y]!=word.charAt(step))
            return false;
        board[x][y] += 26;
        boolean f1 = helper79(board,x-1,y,step+1,word)|| helper79(board,x+1,y,step+1,word)|| helper79(board,x,y+1,step+1,word)|| helper79(board,x,y-1,step+1,word);
        board[x][y] +=(-26);
        return f1;
    }

      //80
    public int removeDuplicatesII(int[] nums) {
        if(nums.length==1||nums.length==0)
            return nums.length;
        int length = nums.length;
        int duplicate = 1;
        int cur = 1;
        int pre = nums[0];
        for(int i=1;i<length;i++){
            if(nums[i] == pre){
                duplicate++;
            }
            else {
                duplicate = 1;
                pre = nums[i];
            }

            if(duplicate<3){
                nums[cur] = nums[i];
                cur++;
            }
        }
        return cur;
    }

    public int removeDuplicatesIII(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int index = 2;
        for(int i=2;i<nums.length;i++){
            if(nums[i]!=nums[index-2]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    //81
    public boolean searchII(int[] nums, int target) {
        if(nums.length==1)
            return nums[0] == target;
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            //处理重复的值
            while(left < right && nums[left] == nums[left+1])
                left++;
            while(left < right && nums[right] == nums[right-1])
                right--;
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
                return true;
            //右边有序
            else if(nums[mid] < nums[right]){
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            //左边有序
            else {
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    //82 删除链表中的重复元素 快慢指针
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next ==null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy.next;
        ListNode slow = dummy;
        while(fast != null){
            if(fast.next!=null && fast.val == fast.next.val) {
                while (fast.next != null && fast.val == fast.next.val)
                    fast = fast.next;
                slow.next = fast.next;
                fast = fast.next;
            }
            else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return dummy.next;
    }


    //83
    public ListNode deleteDuplicatesII(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode slow = res;
        ListNode fast = res.next;
        while(fast!=null&&fast.next!=null){
            if(fast.val == fast.next.val){
                while(fast.next != null&&fast.val == fast.next.val){
                    fast = fast.next;
                }
            }
            slow.next = fast;
            slow = slow.next;
            fast = fast.next;
        }
        return res.next;
    }
    public ListNode deleteDuplicatesIII(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        while(cur!=null&&cur.next!=null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }
        return head;
    }

    //84
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[heights.length+1];
        for(int i=0;i<heights.length;i++){
            nums[i] = heights[i];
        }
        nums[nums.length-1] = 0;
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty()&&nums[i]<nums[stack.peek()]){
                int top = stack.pop();
                res = Math.max(res,nums[top]*(stack.isEmpty()?i:(i- stack.peek()-1)));
            }
            stack.push(i);
        }
        return res;
    }

    public int largestRectangleAreaII(int[] heights) {
        int res = 0;
        for(int i=0;i<heights.length;i++){
            int mid = i;
            int width = 0;
            for(int j=i-1;j>=0&&heights[j]>=heights[i];j--){
                width++;
            }
            for(int j=i+1;j<heights.length&&heights[j]>=heights[i];j++){
                width++;
            }
            res = Math.max(res,heights[i]*(width+1));
        }
        return res;
    }
    
    //86 在两个链表合并的时候 需要将大于的链表尾 避免大链表尾连接到小链表尾部造成环
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode less = dummy1;
        ListNode large = dummy2;
        while(head!=null){
            if(head.val<x){
                less.next = head;
                head = head.next;
                less = less.next;
            }
            else {
                large.next = head;
                head = head.next;
                large = large.next;
            }
        }


        large.next = null;


        less.next = dummy2.next;
        return dummy1.next;
    }


    //88
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m+n-1;
        while(n>=0){
            if(nums1[m-1]>nums2[n-1]){
                nums1[last] = nums1[m-1];
                m--;
            }
            else {
                nums1[last] = nums2[n-1];
                n--;
            }
        }
    }

    public void mergeII(int[] nums1, int m, int[] nums2, int n) {
        int last = m-- + n-- -1;
        while(m>=0&&n>=0){
            if(nums1[m] > nums2[n]){
                nums1[last] = nums1[m];
                m--;
            }
            else {
                nums1[last] = nums2[n];
                n--;
            }
            last--;
        }
        while(n>=0){
            nums1[last] = nums2[n];
            last--;
            n--;
        }
    }

    public static void main(String[] args) {
        new LeetCodePraticeII().grayCode(2).forEach(System.out::println);
    }

    //89 底下版本为错误版本
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        List<String> temp = new ArrayList<>();
        for(int i=0;i<n;i++)
            sb.append("0");
        temp.add(sb.toString());
        while(true){
            boolean flag1 = true;
            boolean flag2 = true;
            for(int i=n-1;i>=0;i--){
                if(sb.charAt(i) == '0'){
                    sb.setCharAt(i,'1');
                    if(!temp.contains(sb.toString())){
                        temp.add(sb.toString());
                        flag1 = false;
                        continue;
                    }
                }
                else {
                    sb.setCharAt(i,'0');
                    if(!temp.contains(sb.toString())){
                        temp.add(sb.toString());
                        flag2 = false;
                        continue;
                    }
                }
            }
            if(flag1&&flag2)
                break;
        }

        for(int i=0;i<temp.size();i++)
            res.add(transfer(temp.get(i)));
        return res;
    }

    private int transfer(String s){
        int exp = 1;
        int res= 0;
        for(int i=s.length()-1;i>=0;i--){
            res += exp * (s.charAt(i)-'0');
            exp = exp<<1;
        }
        return res;
    }

    public List<Integer> grayCodeII(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<1<<n;i++){
            res.add(i^(i>>1));
        }
        return res;
    }

    //90
    /**
     * 这个题目的解题思想是这样的。由于nums内的元素存在重复，那么我们必然需要
     * 考虑如果元素重复了，怎么去处理这个元素。最直观的想法是说比如我碰到了
     * nums[i] == nums[i-1]表示当前元素我处理过了，拿题目中的数组举例子
     * nums:[1,2,2]  i=2的时候就满足上式，那么我们可以认为这个元素已经处理过了
     * 就直接跳过吗？ 显然不能 因为如果直接跳过我们就会漏掉[2,2] 和 [1,2,2]
     * 这两个组合。那么说明我们必须找出某种方式，将部分重复的元素去除。
     *
     * 我们仔细思考一下nums[1,2,2] 当i=0的时候由于我们用于存储所有已知集合的
     * retList只含有一个[]元素，那么不存在重复问题，我们经过这一步可以得到
     * retList: [] [1] 来到2的时候我们在看 由于也不存在重复我们的2可以和
     * 之前的retlist中的元素全组合一遍得到retList:[] [1] [2] [1,2]
     * 等i=2来到这个重复的2的时候，我们发现他和前面的元素重复了，那么如果我们
     * 先不考虑重复的问题重复会得到[] [1] [2] [1,2] [2] [1,2] [2,2] [1,2,2]
     * 我们发现[2] [1,2]这部分是重复的部分是需要被踢出的部分 那么我们的目标现在
     * 就转变成了如何鉴别出引起重复的这一部分，然后在组合的时候跳过他们。我们回忆一下
     * 重复的这个[2] [1,2]来源于 2 这个元素和 [] [1] 组合导致的，因为在这个重复的
     * 2之前，已经有一个2和[] [1]发生过组合，所以这里再去组合 必然发生重复现象。
     * 那实际上这个第二次出现的2，只应该和[2] [1,2]发生组合。在这个例子中[2] [1,2]
     * 是两个组合，很容易看出来，但是我们需要一个值，来表示说出现重复时我到底该匹配的值
     * 有多少个？ 这个值就是上一次没有出现重复元素时，retList的长度。这么说太抽象了
     * 我们举个例子 假设我们来到了[] [1] 现在2要和他们进行组合 此时2和1不相同，那么
     * 他应该和整个retList进行组合 需要进行组合的元素数为2.那么当 来到第二个2时，此时
     * retList中有四个元素[] [1] [2] [1,2] 按照刚才我们说的他只可以组合两个元素，
     * 否则必然引起重复，而且是从后往前数两个元素（这个方向是因为，新的组合总是添加在数组的
     * 尾巴上），如果照我们说的 他只应该和[2],[1,2]发生组合最后的出[] [1] [2] [1,2] [2,2] [1,2,2].
     *
     * 接下来说点别的，为什么第二个重复元素只能去和倒数的 上一次没有出现重复元素时，retList的长度个
     * 元素进行组合？
     *
     * 原因是这样的，比如当nums[i] != num[i-1]时，此时nums[i]需要和retList中所有元素进行组合
     * 该过程完成后retList的大小会由原大小m 变化为2m。当我们继续往后走时，当前nums[i] == nums[i-1]
     * 我们直到我们当前的nums[i]只应该和之前的nums[i-1]没处理过的部分，或者之前的nums[i-1]在上一次
     * 组合中新生成的部分进行组合（否则必然造成重复），那这个新生成部分的大小是多少呢？答案是m，因为再不重复时
     * 每一次的组合结束大小都会变为原来的1倍，一半是之前的值，一半是新生成的值，而这个m就是上一次没有出现重复元素时，retList的长度。
     *
     * 以此类推 当我们的nums[1,2,2,2] 当i=3时，这个时候他还是只需要和上一次retList的最后m个元素进行组合
     *
     *
     *
     * m: 下一次要从已存在集合里面拿出来的集合数目
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int m = 1;
        for(int i=0;i<nums.length;i++){
            int size = res.size();
            if(i==0 || nums[i] != nums[i-1])
                m = size;
            for(int j=size-1;j>=size-m;j--){
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }

}

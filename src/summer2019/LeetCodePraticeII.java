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

    public static void main(String[] args) {
        new LeetCodePraticeII().removeDuplicatesII(new int[]{1,1,1,2,2,3});
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
}

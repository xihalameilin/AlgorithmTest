LeetCode题目

## 3.最长回文子串

> 给你一个字符串 `s`，找到 `s` 中最长的回文子串。

- 动态规划 长度为0和1单独考虑

  ```java
  public String longestPalindrome(String s) {
          int n = s.length();
          String res = "";
          int maxLen = 0;
          boolean[][] dp = new boolean[n][n];
  
      	//长度
          for(int l = 0 ; l < n ; l++){
              for(int i = 0 ; i + l < n ; i++){
                  int j = i + l;
                  if(l == 0){
                      dp[i][j] = true;
                  }
                  else if(l == 1){
                      dp[i][j] = s.charAt(i) == s.charAt(j);
                  }
                  else{
                      dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                  }
                  if(dp[i][j] && j - i  + 1 > maxLen){
                      res = s.substring(i , j + 1);
                  }
              }
          }
          return res;
  
      }
  ```

  

##  6.Z形变换

> 将一个给定字符串 s 根据给定的行数 `numRows` ，以从上往下、从左到右进行 Z 字形排列。

- 声明一个`List<StringBuilder>`

  ```java
   public String convert(String s, int numRows) {
          if(numRows == 1)
              return s;
          List<StringBuilder> rows = new ArrayList<>();
          for(int i = 0 ; i < numRows ; i++){
              rows.add(new StringBuilder());
          }
          int row = 0;
          boolean flag = false;
          for(int i = 0 ; i < s.length() ; i++){
              rows.get(row).append(s.charAt(i));
              if(row == 0 || row == numRows - 1){
                  flag = !flag;
              }
              row += flag ? 1 : -1;
          }
          StringBuilder res = new StringBuilder();
          for(int i = 0 ; i < numRows ; i++){
              res.append(rows.get(i));
          }
          return res.toString();
      }
  ```



## 11.盛水最多的容器

> 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
>
> 说明：你不能倾斜容器。

- 类似双指针的想法 小的一边往中间走

  ```java
  public int maxArea(int[] height) {
          int n = height.length;
          int left = 0;
          int right = n-1;
          int res = 0;
          while(left < right){
              int h = Math.min(height[left],height[right]);
              int t = h * (right - left);
              res = Math.max(t, res);
              if(height[left] < height[right]){
                  left ++;
              }
              else{
                  right--;
              }
          }
          return res;
      }
  ```



## 14.最长公共前缀

> 编写一个函数来查找字符串数组中的最长公共前缀。
>
> 如果不存在公共前缀，返回空字符串 `""`。

- 两两比较

  ```java
   public String longestCommonPrefix(String[] strs) {
          if(strs.length == 0)
              return "";
          String res = strs[0];
          for(int i = 1 ; i < strs.length ; i++){
              res = help(res,strs[i]);
          }
          return res;
      }
  
      private String help(String s1,String s2){
          int len = 0;
          for(int i = 0 ; i < Math.min(s1.length(),s2.length()) ; i++){
              if(s1.charAt(i) == s2.charAt(i)){
                  len++;
              }
              else{
                  break;
              }
          }
          return s1.substring(0,len);
      }
  ```

  

## 15.三数之和

>给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
>
>注意：答案中不可以包含重复的三元组。

- 注意去重

  ```java
   public List<List<Integer>> threeSum(int[] nums) {
          Arrays.sort(nums);
          int n = nums.length;
          List<List<Integer>> res = new ArrayList<>();
          for(int i = 0 ; i < n - 2 ; i++){
              int sum = -nums[i];
              int left = i + 1;
              int right = n - 1;
              while(left < right){
                  if(nums[left] + nums[right] == sum){
                      List<Integer> temp = new ArrayList<>();
                      temp.add(nums[i]);
                      temp.add(nums[left]);
                      temp.add(nums[right]);
                      res.add(temp);
                      while(left < right && nums[left] == nums[left+1])
                          left++;
                      left++;
                  }
                  else if(nums[left] + nums[right] < sum){
                      left++;
                  }
                  else{
                      right--;
                  }
              }
              //这里不能少 要去重
              while(i < n - 3 && nums[i] == nums[i + 1])
                  i++;
          }
          return res;
      }
  ```



## 16.最接近的三数之和

> 给定一个包括 n 个整数的数组 `nums` 和 一个目标值 target。找出 `nums` 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

- 类似三数和

  ```java
   public int threeSumClosest(int[] nums, int target) {
          Arrays.sort(nums);
          int res = nums[0] + nums[1] + nums[2];
          for(int i = 0 ; i < nums.length - 2 ; i++){
              int left = i + 1;
              int right = nums.length - 1;
              while(left < right){
                  int temp = nums[i] + nums[left] + nums[right];
                  if(Math.abs(target - res) > Math.abs(target - temp)){
                      res = temp;
                  }
                  if(temp < target){
                      left++;
                  }
                  else if(temp > target){
                      right--;
                  }
                  else{
                      return target;
                  }
              }
          }
          return res;
      }
  ```

  

##17.电话号码组合

>给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
>
>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

- 回溯

  ```java
   private String[] map = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
  
      private StringBuilder sb = new StringBuilder();
  
      private List<String> res = new ArrayList<>();
      public List<String> letterCombinations(String digits) {
          if(digits == null || digits.length() == 0)
              return res;
          back(digits,0);
          return res;
      }
  
      private void back(String digits,int index){
          if(sb.length() == digits.length()){
              res.add(sb.toString());
              return;
          }
          String s = map[digits.charAt(index) - '2'];
          for(char c : s.toCharArray()){
              sb.append(c);
              back(digits,index + 1);
              sb.deleteCharAt(index);
          }
      }
  ```

  



## 22.括号生成

> 数字 `n` 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 **有效的** 括号组合。

- `dfs`

  ```java
   private List<String> res = new ArrayList<>();
  
      public List<String> generateParenthesis(int n) {
          dfs(n,n,"");
          return res;
      }
      
  
      private void dfs(int left,int right,String cur){
          if(left == 0 && right == 0){
              res.add(cur);
              return;
          }
          if(left > right){
              return;
          }
          if(left > 0){
              dfs(left-1,right,cur+"(");
          }
          if(right > 0){
              dfs(left,right-1,cur+")");
          }
      }
  ```





## 24.两两交换链表

> 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
>
> **你不能只是单纯的改变节点内部的值**，而是需要实际的进行节点交换。

- 递归（结束条件 找返回值 本级递归返回什么）

  ```java
   public ListNode swapPairs(ListNode head) {
          if(head == null || head.next == null){
              return head;
          }
          ListNode next = head.next;
          head.next = swapPairs(next.next);
          next.next = head;
          return next;
      }
  ```

  



## 26.删除排序数组的重复项

>给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
>
>不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

- 双指针

  ```java
  public int removeDuplicates(int[] nums) {
          int length = nums.length;
          int i = 0;
          int j = 1;
          while(j < length){
              if(nums[i] != nums[j]){
                  i++;
                  nums[i] = nums[j];
              }
              j++;
          }
          return i + 1;
      }
  ```



## 27.移除元素

> 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
>
> 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
>
> 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

- 双指针

  ```java
   public int removeElement(int[] nums, int val) {
   		int i=-1;
          int j=0;
          while(j<nums.length){
              if(nums[j] != val){
                  i++;
                  nums[i]=nums[j];
              }
              j++;
          }
          return i+1;
      }
  ```



## 32.最长有效括号

> 给你一个只包含 `'('` 和 `')'` 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

- 使用01串模拟，再寻找连续0最大长度

  ```java
   public int longestValidParentheses(String s) {
          int n = s.length();
          int[] nums = new int[n];
          Stack<Integer> stack = new Stack<>();
          for(int i = 0 ; i < n ; i++){
              char c = s.charAt(i);
              if(c == '('){
                  stack.push(i);
              }
              else{
                  if(stack.isEmpty()){
                      nums[i] = 1;
                  }
                  else{
                      stack.pop();
                  }
              }
          }
  
          //未匹配的左括号
          while(!stack.isEmpty()){
              int index = stack.pop();
              nums[index] = 1;
          }
  
          int res = 0;
          int curLen = 0;
          for(int i = 0 ; i < n ; i++){
              if(nums[i] == 0){
                  curLen++;
                  res = Math.max(res,curLen);
              }
              else{
                  curLen = 0;
              }
          }
          return res;
      }
  ```

  





## 33.组合总和

> 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
>
> candidates 中的数字可以无限制重复被选取。
>
> 说明：
>
> 所有数字（包括 target）都是正整数。
> 解集不能包含重复的组合。 

- 回溯

  ```java
  List<List<Integer>> res = new ArrayList<>();
      public List<List<Integer>> combinationSum(int[] candidates, int target) {
          Arrays.sort(candidates);
          back(candidates,0,new ArrayList<Integer>(),target);
          return res;
      }
  
      private void back(int[] candidates,int index,List<Integer> temp,int target){
          if(target == 0){
              res.add(new ArrayList<>(temp));
              return;
          }
          for(int i = index ; i < candidates.length ; i++){
              if(target >= candidates[i]){
                  temp.add(candidates[i]);
                  target -= candidates[i];
                  //元素可以重复使用 这个位置还是传递i
                  back(candidates,i,temp,  target);
                  target += candidates[i];
                  temp.remove(temp.size() - 1);
              }
              else{
                  break;
              }
          }
      }
  ```

  



##40.数组总和2

> 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
>
> candidates 中的每个数字在每个组合中只能使用一次。
>
> 说明：
>
> 所有数字（包括目标数）都是正整数。
> 解集不能包含重复的组合。 

- 回溯 注意去重的规则

  ```java
   List<List<Integer>> res = new ArrayList<>();
      public List<List<Integer>> combinationSum2(int[] candidates, int target) {
          Arrays.sort(candidates);
          back(candidates,0,new ArrayList<Integer>(),target);
          return res;
      }
  
      private void back(int[] candidates,int index,List<Integer> temp,int target){
          if(target == 0){
              res.add(new ArrayList<>(temp));
              return;
          }
          for(int i = index ; i < candidates.length ; i++){
              //这里是去重的规则
              if( i > index && candidates[i] == candidates[i - 1])
                  continue;
              if(target >= candidates[i]){
                  temp.add(candidates[i]);
                  target -= candidates[i];
                  back(candidates,i + 1,temp,  target);
                  target += candidates[i];
                  temp.remove(temp.size() - 1);
              }
              else{
                  break;
              }
          }
      }
  ```



## 41.缺失的第一个正数

> 给你一个未排序的整数数组 `nums` ，请你找出其中没有出现的最小的正整数。

- 利用元素与索引的关系

  ```java
   public int firstMissingPositive(int[] nums) {
    	int n = nums.length;
       //非正数特殊处理
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
  ```

  



## 42.接雨水

> 给定 *n* 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

- 左边最大右边最大 再算小的那个

  ```java
  public int trap(int[] height) {
          int[] leftMax = new int[height.length];
          int[] rightMax = new int[height.length];
          int right = 0;
          int left = 0;
          for(int i =  1 ; i < height.length ; i++){
              left = Math.max(left , height[i - 1]);
              leftMax[i] = left;
          }
          for(int i =  height.length - 2 ; i >= 0 ; i--){
              right = Math.max(right , height[i + 1]);
              rightMax[i] = right;
          }
          int res = 0;
          for(int i = 0 ; i < height.length ; i++){
              int min = Math.min(leftMax[i] , rightMax[i]);
              if(min > height[i])
                  res += (min - height[i]);
          }
          return res;
  
      }
  ```



## 46.全排列

> 给定一个 **没有重复** 数字的序列，返回其所有可能的全排列。

- 回溯

  ```java
     private List<List<Integer>> res = new ArrayList<>();
      public List<List<Integer>> permute(int[] nums) {
          List<Integer> temp = new ArrayList<>();
          help(temp,nums,new boolean[nums.length]);
          return res;
      }
  
  
      private void help(List<Integer> temp,int[] nums,boolean flag[]){
          if(temp.size() == nums.length){
              res.add(new ArrayList<>(temp));
              return;
          }
          for(int i = 0 ; i < nums.length ; i++){
              if(flag[i]){
                  continue;
              }
              temp.add(nums[i]);
              flag[i] = true;
              help(temp,nums,flag);
              flag[i] = false;
              temp.remove(temp.size() - 1);
          }
      }
  ```

  



## 47.全排列2

> 给定一个可包含重复数字的序列 `nums` ，**按任意顺序** 返回所有不重复的全排列。

- 回溯剪枝

  ```java
   List<List<Integer>> res = new ArrayList<>();
     public List<List<Integer>> permuteUnique(int[] nums) {
          Arrays.sort(nums);
          List<Integer> temp = new ArrayList<>();
          boolean[] visit = new boolean[nums.length];
          backtrack(temp,visit,nums);
          return res;
      }
  
      private void backtrack(List<Integer> temp,boolean[] visit,int[] nums){
          if(temp.size() == nums.length){
              res.add(new ArrayList<>(temp));
              return;
          }
          for(int i = 0;i < nums.length; i++){
              if(visit[i])
                  continue;
              if(i > 0 && (nums[i] == nums[i - 1]) && !visit[i - 1]){
                  continue;
              }
              temp.add(nums[i]);
              visit[i] = true;
              backtrack(temp,visit,nums);
              visit[i] = false;
              temp.remove(temp.size() - 1);
          }
      }
  ```

  



## 49.字母异位词分组

> 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

- 字符串排序 + hash

  ```java
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
  ```



## 53.最大子序列和

> 给定一个整数数组 `nums` ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

- 单趟扫描

  ```java
  public int maxSubArray(int[] nums) {
          int res = nums[0];
          int temp = 0;
          for(int i : nums){
              if(temp < 0)
                  temp = 0;
              temp +=  i;
              if(temp  > res)
                  res = temp;
          }
          return res;
      }
  ```

  

## 55.跳跃游戏

> 给定一个非负整数数组 `nums` ，你最初位于数组的 **第一个下标** 。
>
> 数组中的每个元素代表你在该位置可以跳跃的最大长度。
>
> 判断你是否能够到达最后一个下标。

- 贪心 求最远可以到达的位置

  ```java
  public boolean canJump(int[] nums) {
          if(nums.length <= 1)
              return true;
          int maxLen = nums[0];
          for(int i = 1 ; i < nums.length-1 ; i++){
              if(i <= maxLen){
                  maxLen = Math.max(maxLen,nums[i]+i);
              }
          }
          return maxLen>=nums.length-1;
      }
  ```




## 59.螺旋矩阵2

> 给你一个正整数 `n` ，生成一个包含 `1` 到 `n2` 所有元素，且元素按顺时针顺序螺旋排列的 `n x n` 正方形矩阵 `matrix` 。

- 转圈

  ```java
    public int[][] generateMatrix(int n) {
      int[][] res = new int[n][n];
          int cur = 1;
          int end = n*n;
  
          int left = 0;
          int right = n - 1;
          int top = 0;
          int buttom = n - 1;
          while(cur <= end){
              for(int i = left ; i <= right ; i ++){
                  res[top][i] = cur++;
              }
              top++;
              
  
              for(int i = top ; i <= buttom ; i++){
                  res[i][right] = cur++;
              }
              right--;
  
              for(int i = right ; i >= left ; i--){
                  res[buttom][i] = cur++;
              }
  
              buttom--;
  
              for(int i = buttom ; i >= top ; i--){
                  res[i][left] = cur++;
              }
              left++;
          }
          return res;
      }
  ```

  



## 63.不同路径2

> 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
>
> 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
>
> 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

- 动态规划

  ```java
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
          int m = obstacleGrid.length;
          int n = obstacleGrid[0].length;
          int[][] dp = new int[m + 1][n + 1];
          dp[0][1] = 1;
          for(int i = 1 ; i <= m ; i ++){
              for(int j = 1 ; j <= n ; j++){
                  if(obstacleGrid[i - 1][j - 1] == 0)
                      dp[i][j] = dp[i- 1][j] + dp[i][j - 1];
                  else
                      dp[i][j] = 0;
              }
          }
          return dp[m][n];
      }
  ```





## 69.求平方根

> 实现 `int sqrt(int x)` 函数。
>
> 计算并返回 *x* 的平方根，其中 *x* 是非负整数。
>
> 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去

- 二分

  ```java
      public int mySqrt(int x) {
          if(x==1 || x==0)
              return x;
          int left = 0;
          int right = x;
          while(left + 1< right){
              int mid = left + (right - left ) / 2;
              if(mid == x / mid){
                  return mid;
              }
              else if(mid < x / mid){
                  left = mid;
              }
              else {
                  right = mid;
              }
          }
      
          return left;
      }
  ```



## 76.最小覆盖子串(hard)

>
> 给你一个字符串 `s` 、一个字符串 `t` 。返回 `s` 中涵盖 `t` 所有字符的最小子串。如果 `s` 中不存在涵盖 `t` 所有字符的子串，则返回空字符串 `""` 。
>
> **注意：**如果 `s` 中存在这样的子串，我们保证它是唯一的答案。

- 滑动窗口 + map

  ```java
    public String minWindow(String s, String t) {
            Map<Character,Integer> target = new HashMap<>();
          Map<Character,Integer> window = new HashMap<>();
          for(int i = 0 ; i < t.length() ; i++){
              char c = t.charAt(i);
              target.put(c,target.getOrDefault(c,0)+1);
          }
          int left = 0;
          int right = -1;
          int len = Integer.MAX_VALUE;
          String res = new String();
          while(right < s.length() - 1){
              right++;
              char c = s.charAt(right);
              window.put(c,window.getOrDefault(c,0)+1);
  
              while(check(window,target)){
                  if(right - left + 1 < len) {
                      len = right - left + 1;
                      res = s.substring(left, right + 1);
                  }
                  char cc = s.charAt(left);
                  int num = window.get(cc);
                  num--;
                  if(num < 0)
                      num = 0;
                  window.put(cc,num);
                  left++;
              }
          }
          return res;
      }
  
      private boolean check(Map<Character,Integer> window,Map<Character,Integer> target){
          for(char c : target.keySet()){
              if(window.get(c) == null ||window.get(c) < target.get(c)){
                  return false;
              }
          }
          return true;
      }
  ```





## 77.子集

> 给你一个整数数组 `nums` ，数组中的元素 **互不相同** 。返回该数组所有可能的子集（幂集）。
>
> 解集 **不能** 包含重复的子集。你可以按 **任意顺序** 返回解集。

- 回溯

  ```java
  List<List<Integer>> res = new ArrayList<>();
      public List<List<Integer>> subsets(int[] nums) {
          backtrack(new ArrayList<>(),nums,0);
          return res;
      }
  
      private void backtrack(List<Integer> temp,int[] nums,int index){
          res.add(new ArrayList<>(temp));
          for(int i = index ; i < nums.length ; i++){
              temp.add(nums[i]);
              backtrack(temp,nums,i+1);
              temp.remove(temp.size() - 1);
          }
      }
  ```

  

## 80.删除重复元素

> 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
>
> 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
>

- 类似双指针的思想

  ```java
  public int removeDuplicates(int[] nums) {
          if(nums.length <= 2){
              return nums.length;
          }
          int left = 2;
          for(int i = 2 ; i < nums.length ; i ++){
              //右边索引是left - 2
              if(nums[i] != nums[left - 2]){
                  nums[left] = nums[i];
                  left++;
              }
          }
          return left;
      }
  ```





## 81.搜索旋转排序数组2

> 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
>
> ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
>
> 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
>

- 注意边界的情况

  ```java
  public boolean search(int[] nums, int target) {
          int left = 0;
          int right = nums.length - 1;
          while(left <= right){
              while(left < right && nums[left] == nums[left + 1])
                  left++;
              while(left < right && nums[right] == nums[right - 1])
                  right--;
              int mid = left + (right - left) / 2;
              if(nums[mid] == target)
                  return true;
              //右边有序
              if(nums[mid] < nums[right]){
                  if(target > nums[mid] && target <= nums[right]){
                      left = mid + 1;
                  }
                  else{
                      right = mid - 1;
                  }
              }
              else{
                  if(target >= nums[left] && target < nums[mid]){
                      right = mid - 1;
                  }
                  else{
                      left = mid + 1;
                  }
              }
          }
          return false;
      }
  ```



##82.删除链表中的重复元素2

> 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 *没有重复出现* 的数字。

- 递归

  ```java
   public ListNode deleteDuplicates(ListNode head) {
          if(head == null || head.next == null){
              return head;
          }
          if(head.val == head.next.val){
              while(head.next != null && head.val == head.next.val){
                  head = head.next;
              }
              head = deleteDuplicates(head.next);
          }
          else{
                head.next = deleteDuplicates(head.next);
          }
        
          return head;
      }
  ```





## 83.删除链表中的重复元素

> 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

- 递归

  ```java
  public ListNode deleteDuplicates(ListNode head) {
          if(head == null || head.next == null)
              return head;
          head.next = deleteDuplicates(head.next);
          if(head.val == head.next.val){
              head = head.next;
          }
          return head;
      }
  ```





## 86.分隔链表

> 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
>
> 你应当 保留 两个分区中每个节点的初始相对位置。

- 拆成两个链表再合并

  ```java
   public ListNode partition(ListNode head, int x) {
          ListNode less = new ListNode(-1);
          ListNode large = new ListNode(-1);
          ListNode cur1 = less;
          ListNode cur2 = large;
          while(head != null){
              if(head.val < x){
                  cur1.next = head;
                  cur1 = cur1.next;
              }
              else{
                  cur2.next = head;
                  cur2 = cur2.next;
              }
              head = head.next;
          }
          cur1.next = large.next;
          cur2.next = null;
          return less.next;
      }
  ```

  



## 108.将有序数组转化为二叉搜索树

> 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
>
> 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

- 递归

  ```java
  public TreeNode sortedArrayToBST(int[] nums) {
          return build(nums,0,nums.length - 1);
      }
  
      private TreeNode build(int[] nums,int left,int right){
          if(left > right)
              return null;
          int mid = left + (right - left) / 2;
          TreeNode root = new TreeNode(nums[mid]);
          root.left = build(nums,left,mid - 1);
          root.right = build(nums,mid + 1,right);
          return root;
      }
  ```




## 111.二叉树最小深度

> 给定一个二叉树，找出其最小深度。
>
> 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
>
> **说明：**叶子节点是指没有子节点的节点。

- 回溯

  ```java
    int min = Integer.MAX_VALUE;
      public int minDepth(TreeNode root) {
          if(root == null)
              return 0;
          backtrack(root,1);
          return min;
      }
  
      private void backtrack(TreeNode root,int curHeight){
          if(root != null){
              if(root.left == null && root.right == null){
                  min = Math.min(min,curHeight);
              }
              backtrack(root.left,curHeight + 1);
              backtrack(root.right,curHeight + 1);
          }
      }
  ```

- 递归

  ```java
  public int minDepth(TreeNode root) {
          if(root == null)
              return 0;
          if(root.left == null && root.right == null)
              return 1;
          else if(root.left == null){
              return 1 + minDepth(root.right);
          }
          else if(root.right == null){
              return 1 + minDepth(root.left);
          }
          return 1 + Math.min(minDepth(root.left),minDepth(root.right));
      }
  }
  ```

  





## 112.路径总和

> 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
>
> 叶子节点 是指没有子节点的节点。

- 回溯，到达叶节点判断

  ```java
    public boolean hasPathSum(TreeNode root, int targetSum) {
          return backtrack(root,targetSum);
      }
  
      private boolean backtrack(TreeNode root,int left){
          if(root == null)
              return false;
          left -= root.val;
          //到达叶节点
          if(root.left == null && root.right == null){
              if(left == 0)
                  return true;
          }
          return backtrack(root.left,left) || backtrack(root.right,left);
      }
  ```



## 113.路径总和II

> 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
>
> 叶子节点 是指没有子节点的节点。

- 回溯，**记得撤销选择**，也就是` temp.remove(temp.size() - 1)`

  ```java
      List<List<Integer>> res = new ArrayList<>();
      public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
          backtrack(root,targetSum,new ArrayList<>());
          return res;
      }
  
      private void backtrack(TreeNode root,int left,List<Integer> temp){
          if(root == null)
              return;
          left -= root.val;
          temp.add(root.val);
          if(root.left == null && root.right == null){
              if(left == 0){
                  res.add(new ArrayList(temp));
              }
          }
          if(root.left != null)
              backtrack(root.left,left,temp);
          if(root.right != null)
              backtrack(root.right,left,temp);
          temp.remove(temp.size() - 1);
      }
  ```

  



## 114.二叉树展开为链表

> 给你二叉树的根结点 root ，请你将它展开为一个单链表：
>
> 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
> 展开后的单链表应该与二叉树 先序遍历 顺序相同。

- 先序遍历

- 迭代 将左子树插入到右子树的地方 将原来的右子树接到左子树的最右边节点考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null

  ```java
      1
     / \
    2   5
   / \   \
  3   4   6
  
  //将 1 的左子树插入到右子树的地方
      1
       \
        2         5
       / \         \
      3   4         6        
  //将原来的右子树接到左子树的最右边节点
      1
       \
        2          
       / \          
      3   4  
           \
            5
             \
              6
              
   //将 2 的左子树插入到右子树的地方
      1
       \
        2          
         \          
          3       4  
                   \
                    5
                     \
                      6   
          
   //将原来的右子树接到左子树的最右边节点
      1
       \
        2          
         \          
          3      
           \
            4  
             \
              5
               \
                6         
    
  
  public void flatten(TreeNode root) {
          while(root != null){
              if(root.left == null){
                  root = root.right;
              }
              else{
                  TreeNode leftMax = root.left;
                  while(leftMax.right != null){
                      leftMax = leftMax.right;
                  }
                  leftMax.right = root.right;
                  root.right = root.left;
                  root.left = null;
                  root = root.right;
              }
          }
      }
  
  ```

  





## 116.[填充每个节点的下一个右侧节点指针](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/)

> 给定一个 **完美二叉树** ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
>
> ```java
> struct Node {
>   int val;
>   Node *left;
>   Node *right;
>   Node *next;
> }
> ```
>
> 
>
> 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
>
> 初始状态下，所有 next 指针都被设置为 NULL。
>

- 层序

  ```java
  public Node connect(Node root) {
          if(root == null){
              return root;
          }
          Queue<Node> queue = new LinkedList<>();
          queue.offer(root);
          while(!queue.isEmpty()){
              int size = queue.size();
              Node pre = queue.poll();
              if(pre.left != null){
                  queue.offer(pre.left);
              }
              if(pre.right != null){
                  queue.offer(pre.right);
              }
              Node cur = null;
              size--;
              while(size > 0){
                  cur = queue.poll();
                  if(cur.left != null){
                      queue.offer(cur.left);
                  }
                  if(cur.right != null){
                      queue.offer(cur.right);
                  }
                  pre.next = cur;
                  pre = cur;
                  size--;
              }
          }
          return root;
      }
  ```

- 递归

  ```java
   public Node connect(Node root) {
          if(root == null)
              return root;
          if(root.left != null){
              root.left.next = root.right;
          }
          //注意判断root.next 不为空
          if(root.right != null && root.next != null){
              root.right.next = root.next.left;
          }
          connect(root.left);
          connect(root.right);
          return root;
      }
  ```

  





## [117. 填充每个节点的下一个右侧节点指针 II](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/)

> 给定一个二叉树
>
> struct Node {
>   int val;
>   Node *left;
>   Node *right;
>   Node *next;
> }
> 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
>
> 初始状态下，所有 next 指针都被设置为 NULL。

- 递归先进行右边在进行左边

  ```java
  public Node connect(Node root) {
          if(root == null){
              return root;
          }
          if(root.left != null){
              if(root.right != null){
                  root.left.next = root.right;                
              }
              else{
                  root.left.next = getNext(root.next);
              }
          }       
          if(root.right != null){
              root.right.next = getNext(root.next);
          }
          connect(root.right);
          connect(root.left);
  
          return root;
      }
  
      private Node getNext(Node root){
          if(root == null)
              return null;
          if(root.left != null){
              return root.left;
          }
          if(root.right != null){
              return root.right;
          }
          return getNext(root.next);
      }
  ```




##[120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle/)

> 给定一个三角形 triangle ，找出自顶向下的最小路径和。
>
> 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。

- 回溯（超时）

  ```java
   private int min = Integer.MAX_VALUE;
      public int minimumTotal(List<List<Integer>> triangle) {
          backtrack(triangle,0,0,0);
          return min;
      }
  
      private void backtrack(List<List<Integer>> triangle,int level,int offset,int sum){
          if(level == triangle.size()){
              min = Math.min(min,sum);
              return;
          }
          sum += triangle.get(level).get(offset);
          backtrack(triangle,level + 1,offset,sum);
          backtrack(triangle,level + 1, offset + 1,sum);
      }
  ```

- 递归（超时）

  ```java
  public int minimumTotal(List<List<Integer>> triangle) {
          return  backtrack(triangle,0,0);
      }
  
      private int backtrack(List<List<Integer>> triangle,int level,int offset){
          if(level == triangle.size() - 1){
              return triangle.get(level).get(offset);
          }
          int left = backtrack(triangle,level + 1,offset);
          int right = backtrack(triangle,level + 1, offset + 1);
          return triangle.get(level).get(offset) + Math.min(left , right);
      }
  
  ```

- 动态规划(可以在原数据上做，继续降低空间开销)

  ```java
   public int minimumTotal(List<List<Integer>> triangle) {
          int row = triangle.size();
          int[] dp = new int[triangle.get(row - 1).size()];
          for(int i = 0 ; i < dp.length ; i++){
              dp[i] = triangle.get(row - 1).get(i);
          }
          for(int i = row - 2 ; i >= 0 ; i--){
              for(int j = 0 ; j <= i ; j ++){
                  dp[j] = Math.min(dp[j],dp[j + 1]) + triangle.get(i).get(j);
              }
          }
          return dp[0];
      }
  ```

  

## [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)

> 给定一个数组，它的第 *i* 个元素是一支给定股票第 *i* 天的价格。
>
> 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
>
> **注意：**你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）

- 动态规划`dp[][2]`第一个位置表示不持有股票的收益，第二个位置表示不持有股票的收益

  ```java
   public int maxProfit(int[] prices) {
          //dp
          int[][] dp = new int[prices.length][2];
          dp[0][0] = 0;
          dp[0][1] = - prices[0];
           for(int i = 1 ; i < prices.length ; i++){
              dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
              dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
          }
          return dp[prices.length - 1][0];
      }
  ```

- 贪心

  ```java
  public int maxProfit(int[] prices) {
          int ans = 0;
          int n = prices.length;
          for (int i = 1; i < n; ++i) {
              ans += Math.max(0, prices[i] - prices[i - 1]);
          }
          return ans;
      }
  ```

  
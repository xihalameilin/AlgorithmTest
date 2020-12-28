# 剑指offer题目

## 15. 二级制中1的个数

###  	包括正负数

- 无符号右移 >>>

  ```java
      /** 无符号右移 >>>
       * 执行耗时:1 ms,击败了97.57% 的Java用户
       * 内存消耗:35.2 MB,击败了83.96% 的Java用户
       */
      public int hammingWeight(int n) {
          int res = 0;
          while(n != 0){
              res += (n&1);
              n >>>= 1;
          }
          return res;
      }
  
  ```

- n&（n-1）

  ```java
    /**
       * 执行耗时:1 ms,击败了97.57% 的Java用户
       * 内存消耗:35.2 MB,击败了82.90% 的Java用户
       *
       */
      public int hammingWeight(int n) {
          int res = 0;
          while(n != 0){
              n &= (n-1);
              res ++;
          }
          return res;
      }
  ```



## 16.数值的整数次方

### 实现函数double Power(double base, int exponent)，求base的exponent次方

- 类似二分的思想

  ```java
    /**
       执行耗时:1 ms,击败了97.66% 的Java用户
       内存消耗:36.5 MB,击败了86.43% 的Java用户
       */
      public double myPow(double x, int n) {
          boolean positive = n > 0;
          double res = calculatePow(x,n);
          return positive? res : 1.0 /res;
      }
  
      private double calculatePow(double x,int n){
          if(n == 0)
             return 1;
          double y = calculatePow(x,n / 2);
          return n % 2 == 0 ? y  *y : y * y * x;
  
      }
  ```

- 快速幂

  - 比如x=2，n=10。n二进制表示就是1010，每个1就是x的对应次方数，相当于2^2*2^8，只需要找到每个1在二进制里面的位置，然后x对应次方就完了

  ```java
   /**
       * 快速幂
       执行耗时:1 ms,击败了97.66% 的Java用户
       内存消耗:37.8 MB,击败了36.93% 的Java用户
       */
      public double myPow(double x, int n) {
          double res = 1;
          boolean positive = n > 0;
          while(n != 0){
              if((n & 1) == 1){
                  res *= x;
              }
              x *=x;
              n /= 2;
          }
          return positive ? res : 1.0 / res;
      }
  ```

  

## 18.删除链表的节点

- 我自己的做法

  ```java
  /**
       * 执行耗时:0 ms,击败了100.00% 的Java用户
       * 内存消耗:37.9 MB,击败了67.63% 的Java用户
       */
      public ListNode deleteNode(ListNode head, int val) {
          if(head.val == val)
              return head.next;
          ListNode pre = null;
          ListNode cur = head;
          while(cur != null){
              if(cur.val == val){
                  pre.next = cur.next;
                  break;
              }
              pre = cur;
              cur = cur.next;
          }
          return head;
      }
  ```

- 引入一个新的开头节点，便于后续统一的操作

  ```java
  /**
       执行耗时:0 ms,击败了100.00% 的Java用户
       内存消耗:37.8 MB,击败了75.11% 的Java用户
       */
      public ListNode deleteNode(ListNode head, int val) {
          ListNode dummy = new ListNode(-1);
          dummy.next = head;
          ListNode pre = dummy;
          ListNode cur = head;
          while(cur != null){
              if(cur.val == val){
                  pre.next = cur.next;
                  break;
              }
              pre = cur;
              cur = cur.next;
          }
          return dummy.next;
      }
  ```

  **leetcode原书是在O（1）的时间复杂度下删除给定的节点，思路：将后一个节点的内容复制到要删除的节点，要删除的节点指向后面第二个节点**

  

-  关于删除链表重复节点的问题见原作122页



## 21. 调整数组顺序使奇数位于偶数前面

- 两个指针交换

  ```java
   /**
       执行耗时:2 ms,击败了98.94% 的Java用户
       内存消耗:46.4 MB,击败了63.05% 的Java用户
       */
      public int[] exchange(int[] nums) {
          int left = 0;
          int right = nums.length-1;
          while(left < right){
              while((nums[left] & 1) == 1 && left < right){
                  left ++;
              }
              while((nums[right] & 1) == 0 && left < right){
                  right --;
              }
              swap(nums,left,right);
          }
          return nums;
      }
  
      private void swap(int[] nums,int left,int right){
          int temp = nums[right];
          nums[right] = nums[left];
          nums[left] = temp;
      }
  ```

  

## 22.链表中倒数第K个节点

- 快慢指针：让快指针先往前跑K个位置，然后快慢指针一起跑

  ```java
  /**
       执行耗时:0 ms,击败了100.00% 的Java用户
       内存消耗:36.5 MB,击败了40.92% 的Java用户
       */
      public ListNode getKthFromEnd(ListNode head, int k) {
          ListNode slow = head;
          ListNode fast = head;
          while(k > 0){
              fast = fast.next;
              k--;
          }
          while(fast != null){
              fast = fast.next;
              slow = slow.next;
          }
          return slow;
      }
  ```



## 24.反转链表

- 熟练它

  ```java
   /**
       执行耗时:0 ms,击败了100.00% 的Java用户
       内存消耗:38.1 MB,击败了79.52% 的Java用户
       */
      public ListNode reverseList(ListNode head) {
          ListNode pre = null;
          ListNode cur = head;
          while(cur != null){
              ListNode next = cur.next;
              cur.next = pre;
              pre = cur;
              cur = next;
          }
          return pre;
      }
  ```

  

## 25.合并两个排序的链表

- 添加辅助头结点，两个指针分别指向两个链表

  ```java
   /**
       执行耗时:1 ms,击败了98.60% 的Java用户
       内存消耗:38.7 MB,击败了54.96% 的Java用户
       */
      public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
          ListNode dummy = new ListNode(-1);
          ListNode cur = dummy;
          while(l1 != null && l2 != null){
              if(l1.val < l2.val){
                  cur.next = l1;
                  l1 = l1.next;
              }
              else{
                  cur.next = l2;
                  l2 = l2.next;
              }
              cur = cur.next;
          }
  
          if(l1 != null){
              cur.next = l1;
          }
          else {
              cur.next = l2;
          }
          return dummy.next;
      }
  ```

  

## 26.树的子结构（这里要好好体会递归的想法）

- 分别判断某个节点开始能否满足条件

  ```java
   /**
       执行耗时:0 ms,击败了100.00% 的Java用户
       内存消耗:40.2 MB,击败了61.40% 的Java用户
       */
      public boolean isSubStructure(TreeNode A, TreeNode B) {
          if(B == null || A == null)
              return false;
          // 当前节点能否满足条件 || 左子树满足条件 || 右子树满足条件
          return help(A,B) || isSubStructure(A.left,B) || 				       isSubStructure(A.right,B);
      }
  
      // 判断某个节点开始能否满足条件
      private boolean help(TreeNode root,TreeNode target){
          if(target == null)
              return true;
  
          if(root == null || target.val != root.val)
              return false;
  
          return help(root.left,target.left) && help(root.right,target.right);
      }
  ```

  

## 27. 二叉树的镜像

- 按节点递归地往下走

  ```java
   /**
       执行耗时:0 ms,击败了100.00% 的Java用户
       内存消耗:35.7 MB,击败了78.77% 的Java用户
       */
      public TreeNode mirrorTree(TreeNode root) {
          if(root == null)
              return null;
          TreeNode temp = root.right;
          root.right = root.left;
          root.left = temp;
          mirrorTree(root.left);
          mirrorTree(root.right);
          return root;
      }
  ```



## 28.对称的二叉树（体会树递归的思想）

- 递归判断两个节点是否一样

  ```java
   /**
       执行耗时:0 ms,击败了100.00% 的Java用户
       内存消耗:36.2 MB,击败了90.77% 的Java用户
       */
      public boolean isSymmetric(TreeNode root) {
          if(root == null)
              return true;
          return help(root,root);
      }
  
      private boolean help(TreeNode left,TreeNode right){
          if(left == null && right == null)
              return true;
          if(left != null && right != null){
              if(left.val == right.val)
                  return help(left.left,right.right) && help(left.right,right.left);
              return false;
          }
          return false;
      }
  ```

  

## 29.顺时针打印矩阵

- 注意判断边界的条件

  ```java
  /**
       执行耗时:1 ms,击败了97.22% 的Java用户
       内存消耗:39.6 MB,击败了89.59% 的Java用户
       */
      public int[] spiralOrder(int[][] matrix) {
          int row = matrix.length;
          if(row == 0)
              return new int[]{};
          int col = matrix[0].length;
          if(col == 0)
              return new int[]{};
          int [] res = new int[row * col];
          int index = 0;
          int left = 0,right = col - 1,top = 0,button = row-1;
          while(true){
              for(int i = left ; i <= right ; i++){
                  res[index] = matrix[top][i];
                  index ++;
              }
              top++;
              // 每次都要判断
              if(top > button)
                  break;
  
  
              for(int i = top ; i <= button ; i++){
                  res[index] = matrix[i][right];
                  index ++;
              }
              right--;
              if(left > right)
                  break;
  
  
              for (int i = right; i >= left; i--) {
                  res[index] = matrix[button][i];
                  index++;
              }
              button--;
              if(button < top)
                  break;
  
  
              for(int i = button ; i >= top ; i--){
                  res[index] = matrix[i][left];
                  index ++;
              }
              left++;
              if(left > right)
                  break;
  
          }
          return res;
      }
  ```




## 30.包含min函数的栈   push、pop、min时间复杂度都为O（1）

- 设置辅助栈，保持大小与数据栈一致，每次push时判断如果x小于辅助栈栈顶元素，则辅助栈`push`x，否则`push`辅助栈的栈顶元素

  ```java
  class MinStack {
      private Stack<Integer> stack;
      private Stack<Integer> minStack;
      
      public MinStack() {
          stack = new Stack();
          minStack = new Stack();
      }
      
      public void push(int x) {
          stack.push(x);
          if(minStack.isEmpty()){
              minStack.push(x);
          }
          else{
              // 精髓在这里 辅助栈的push规则
              int temp = minStack.peek();
              if(temp <= x)
                  minStack.push(temp);
              else
                  minStack.push(x);
          }
      }
      
      public void pop() {
          stack.pop();
          if(!minStack.isEmpty()){
              minStack.pop();
          }
      }
      
      public int top() {
          return stack.peek();
      }
      
      public int min() {
          if(!minStack.isEmpty())
              return minStack.peek();
          return -1;
      }
  }
  ```




## 31.栈的压入、弹出序列

- 思路：设置一个辅助栈，每次往栈中`push`一个数据，然后从弹出序列中往后匹配

- 注意：`java`更加建议使用`Deque stack = new LinkedList<>()`的方式来创建栈

  ```java
  /**
       执行耗时:2 ms,击败了94.61% 的Java用户
       内存消耗:38.3 MB,击败了41.37% 的Java用户
       */
      public boolean validateStackSequences(int[] pushed, int[] popped) {
          Deque<Integer> stack = new LinkedList<>();
          int index = 0;
          for(int item : pushed){
              stack.push(item);
              while(!stack.isEmpty() && stack.peek() == popped[index]){
                  stack.pop();
                  index ++;
              }
          }
          return index == popped.length;
      }
  ```



## 32. 从上到下打印二叉树（二叉树层序遍历）

- 使用`Queue`实现 `Queue queue = new LinkedList<>()`

  ```java
  /**
       执行耗时:1 ms,击败了99.75% 的Java用户
       内存消耗:38.4 MB,击败了85.66% 的Java用户
       */
      public int[] levelOrder(TreeNode root) {
          Queue<TreeNode> queue = new LinkedList<>();
          if(root == null)
              return new int[0];
          List<Integer> res = new ArrayList<>();
          queue.offer(root);
          while(!queue.isEmpty()){
              int size = queue.size();
              for(int i = 0 ; i < size ; i++){
                  TreeNode temp = queue.poll();
                  res.add(temp.val);
                  if(temp.left != null)
                      queue.offer(temp.left);
                  if(temp.right != null)
                      queue.offer(temp.right);
              }
          }
          int[] array = new int[res.size()];
          for(int i = 0 ; i< array.length ; i++){
              array[i] = res.get(i);
          }
          return array;
      }
  ```

- 递归层次遍历（逐层打印）

  ```java
  class Solution {
      List<List<Integer>> node=new ArrayList();
      public List<List<Integer>> levelOrder(TreeNode root) {
          lei(root,0);
          return node;
      }
      public void lei(TreeNode root,int k){
          if(root!=null){
              if(node.size()<=k)
                  node.add(new ArrayList());
              node.get(k).add(root.val);
              lei(root.left,k+1);
              lei(root.right,k+1);
          }
      }
  }
  ```



## 32.之字形打印二叉树

- `List.add(0,val)`API使用

  ```java
   List<List<Integer>> res = new ArrayList<>();
          public List<List<Integer>> levelOrder(TreeNode root) {
              help(root,0);
              return res;
          }
  
          private void help(TreeNode root,int level){
              if(root == null)
                  return;
              if(res.size() == level)
                  res.add(new ArrayList<>());
              if((level & 1) == 0){
                  res.get(level).add(root.val);
              }
              else{
                  // 精髓所在
                  res.get(level).add(0,root.val);
              }
              help(root.left,level+1);
              help(root.right,level+1);
          }
  ```



## 33.二叉搜索树的后序遍历序列

- 思路：以序列最后一个元素为根，可以将前面的序列分成两个部分

- 递归结束条件：1. `left == right` 只有一个节点        2. `left > right`没有节点了

- 先找到第一个比根大的元素，继续往右遍历，如果有比根小的，说明不能构成搜索树

  ```java
   /**
       执行耗时:0 ms,击败了100.00% 的Java用户
       内存消耗:35.8 MB,击败了85.65% 的Java用户
       */
      public boolean verifyPostorder(int[] postorder) {
          return help(postorder,0,postorder.length-1);
      }
  
      private boolean help(int[] postorder,int begin,int end){
          if(begin >= end)
              return true;
          int root = postorder[end];
          int i = begin;
          for(; i < end ; i++){
              if(postorder[i] > root)
                  break;
          }
  
          // 继续往右遍历
          int j = i;
          for(; j < end ; j++){
              // 右子树有比根小的元素
              if(postorder[j] < root)
                  return false;
          }
          // i的位置是第一个比根大的元素的索引
          return  help(postorder,begin,i - 1) && help(postorder, i , end - 1);
      }
  ```




## 34. 二叉树中和某一值的路径

- 体会回溯思想

- 注意`treeNode == null`与`treeNode.left == null && treeNode.right == null`的区别

- 到达叶节点为啥不`return`？`return`应该写在哪里？

  ```java
  /**
       执行耗时:1 ms,击败了100.00% 的Java用户
       内存消耗:38.5 MB,击败了95.24% 的Java用户
       */
      List<List<Integer>> res = new ArrayList<>();
      public List<List<Integer>> pathSum(TreeNode root, int sum) {
          dfs(new ArrayList<>(),root,0,sum);
          return res;
      }
  
      private void dfs(List<Integer> temp,TreeNode treeNode,int tempSum,int sum){
          if(treeNode == null){
              return;
          }
  
          tempSum += treeNode.val;
          temp.add(treeNode.val);
          //到达叶节点
          if(treeNode.left == null && treeNode.right == null){
              if(tempSum == sum)
                  res.add(new ArrayList<>(temp));
              return;
          }
  
          dfs(temp,treeNode.left,tempSum,sum);
          dfs(temp,treeNode.right,tempSum,sum);
          temp.remove(temp.size()-1);
      }
  ```




## 35.复杂链表的复制

- 使用map保存原始链表的复制

  ```java
   /**
       执行耗时:0 ms,击败了100.00% 的Java用户
       内存消耗:38.3 MB,击败了43.17% 的Java用户
       */
      public Node copyRandomList(Node head) {
          if(head == null)
              return null;
          Map<Node,Node> map = new HashMap<>();
          Node cur = head;
          while(cur != null){
              map.put(cur,new Node(cur.val));
              cur = cur.next;
          }
  
          cur = head;
          while(cur != null){
              // 精髓所在
              map.get(cur).next = map.get(cur.next);
              map.get(cur).random = map.get(cur.random);
              cur = cur.next;
          }
          return map.get(head);
      }
  ```

- 原地在每个节点后面加上一个新的复制

  ```java
   /**
       执行耗时:0 ms,击败了100.00% 的Java用户
       内存消耗:38.1 MB,击败了61.13% 的Java用户
       */
      // 原地修改
      public Node copyRandomList(Node head) {
          if(head == null)
              return null;
          Node cur = head;
          // 在每个节点的后面添加一个复制
          while(cur != null){
              Node temp = new Node(cur.val);
              temp.next = cur.next;
              cur.next = temp;
              cur = cur.next.next;
          }
          // 安排random指针
          cur = head;
          while(cur != null){
              if(cur.random != null){
                  cur.next.random = cur.random.next;
              }
              cur = cur.next.next;
          }
  
          // 拆解成两个链表
          cur = head;
          Node res = head.next;
          Node curCopy = head.next;
          while(cur != null){
              cur.next = cur.next.next;
              cur = cur.next;
              if(curCopy.next != null){
                  curCopy.next = curCopy.next.next;
                  curCopy = curCopy.next;
              }
          }
          return res;
      }
  ```

  
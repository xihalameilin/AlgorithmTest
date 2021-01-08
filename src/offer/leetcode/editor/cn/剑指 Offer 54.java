package offer.leetcode.editor.cn;
//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 105 👎 0

import java.util.*;

public class ErChaSouSuoShuDeDiKdaJieDianLcof{
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            while(root != null && root.left != null){
                stack.push(root.left);
            }
            TreeNode temp = stack.pop();
            res.add(temp.val);
            root = root.right;
            if(root != null){
                stack.push(root);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     执行耗时:1 ms,击败了42.72% 的Java用户
     内存消耗:38.9 MB,击败了18.53% 的Java用户
     */
    List<Integer> res = new ArrayList<>();
//    public int kthLargest(TreeNode root, int k) {
//        midOrder(root);
//        return res.get(res.size() - k);
//    }
//
//    private void midOrder(TreeNode treeNode){
//        if(treeNode != null){
//            midOrder(treeNode.left);
//            res.add(treeNode.val);
//            midOrder(treeNode.right);
//        }
//    }


    //从右边往左边遍历

    /**
     执行耗时:1 ms,击败了42.72% 的Java用户
     内存消耗:38.2 MB,击败了71.38% 的Java用户
     */
//    public int kthLargest(TreeNode root, int k) {
//        Deque<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//        int count = 0;
//        TreeNode temp = root;
//        while(!stack.isEmpty()){
//            while(temp!= null && temp.right != null){
//                stack.push(temp.right);
//                temp = temp.right;
//            }
//            temp = stack.poll();
//            count++;
//            if(count == k)
//                return temp.val;
//            temp = temp.left;
//            if(temp != null){
//                stack.push(temp);
//            }
//        }
//        return -1;
//    }


    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            if(--k == 0)
                return root.val;
            root = root.left;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
package offer.leetcode.editor.cn;
//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 
// / \ 
// 2 2 
// / \ / \ 
//3 4 4 3 
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 
// / \ 
// 2 2 
// \ \ 
// 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// Related Topics 树 
// 👍 114 👎 0

 class DuiChengDeErChaShuLcof{
//    public static void main(String[] args) {
//        Solution solution = new DuiChengDeErChaShuLcof().new Solution();
//
//    }
//      public class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }

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
//class Solution {
//    /**
//     执行耗时:0 ms,击败了100.00% 的Java用户
//     内存消耗:36.2 MB,击败了90.77% 的Java用户
//     */
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null)
//            return true;
//        return help(root,root);
//    }
//
//    private boolean help(TreeNode left,TreeNode right){
//        if(left == null && right == null)
//            return true;
//        if(left != null && right != null){
//            if(left.val == right.val)
//                return help(left.left,right.right) && help(left.right,right.left);
//            return false;
//        }
//        return false;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

}
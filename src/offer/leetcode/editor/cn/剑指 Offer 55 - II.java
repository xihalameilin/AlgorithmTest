package offer.leetcode.editor.cn;
//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 1 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 102 👎 0

import java.util.LinkedList;
import java.util.Queue;

class PingHengErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new PingHengErChaShuLcof().new Solution();
        
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
     执行耗时:2 ms,击败了7.21% 的Java用户
     内存消耗:38.1 MB,击败了95.90% 的Java用户
     */
//    public boolean isBalanced(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        if(root == null)
//            return true;
//        queue.offer(root);
//        TreeNode temp;
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            while (size-- > 0){
//                temp = queue.poll();
//                if(Math.abs(getHeight(temp.right) - getHeight(temp.left)) > 1)
//                    return false;
//                if(temp.left != null)
//                    queue.offer(temp.left);
//                if(temp.right != null)
//                    queue.offer(temp.right);
//            }
//        }
//        return true;
//    }

    /**
     执行耗时:1 ms,击败了100.00% 的Java用户
     内存消耗:38.9 MB,击败了10.57% 的Java用户
     */
//    public boolean isBalanced(TreeNode root) {
//        if(root == null)
//            return true;
//        if(!isBalanced(root.left) ||!isBalanced(root.right))
//            return false;
//        return Math.abs(getHeight(root.right) - getHeight(root.left)) <= 1;
//    }
//
//    private int getHeight(TreeNode root){
//        if(root != null)
//            return 1 + Math.max(getHeight(root.left),getHeight(root.right));
//        else
//            return 0;
//    }


    /**
     执行耗时:1 ms,击败了100.00% 的Java用户
     内存消耗:38 MB,击败了98.71% 的Java用户
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) >= 0;
    }

    private int getHeight(TreeNode root){
        if(root == null)
            return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(left >=0 && right >= 0 && Math.abs(right - left) <= 1)
            return Math.max(right , left) + 1;
        return -1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
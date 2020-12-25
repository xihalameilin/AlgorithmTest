package offer.leetcode.editor.cn;
//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
// 4 
// / \ 
// 2 7 
// / \ / \ 
//1 3 6 9 
//镜像输出： 
//
// 4 
// / \ 
// 7 2 
// / \ / \ 
//9 6 3 1 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
// Related Topics 树 
// 👍 87 👎 0

class ErChaShuDeJingXiangLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeJingXiangLcof().new Solution();
        
    }

      public class TreeNode {
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
}
//leetcode submit region end(Prohibit modification and deletion)

}
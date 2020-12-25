package offer.leetcode.editor.cn;
//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 
// 👍 158 👎 0

class ShuDeZiJieGouLcof{
    public static void main(String[] args) {
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
        
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
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:40.2 MB,击败了61.40% 的Java用户
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null || A == null)
            return false;
        return help(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    private boolean help(TreeNode root,TreeNode target){
        if(target == null)
            return true;

        if(root == null || target.val != root.val)
            return false;

        return help(root.left,target.left) && help(root.right,target.right);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
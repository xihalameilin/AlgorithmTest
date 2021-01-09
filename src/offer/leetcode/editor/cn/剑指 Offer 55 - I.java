package offer.leetcode.editor.cn;
//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tre
//e/ 
// Related Topics 树 深度优先搜索 
// 👍 84 👎 0

import java.util.LinkedList;
import java.util.Queue;

class ErChaShuDeShenDuLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeShenDuLcof().new Solution();
        
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
//    /**
//     执行耗时:0 ms,击败了100.00% 的Java用户
//     内存消耗:38.1 MB,击败了92.83% 的Java用户
//     */
//    public int maxDepth(TreeNode root) {
//        if(root != null)
//            return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
//        else
//            return 0;
//    }

//    /**
//     执行耗时:1 ms,击败了20.90% 的Java用户
//     内存消耗:38.2 MB,击败了88.34% 的Java用户
//     */
//    public int maxDepth(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        if(root == null)
//            return 0;
//        queue.offer(root);
//        int height = 0;
//        while(!queue.isEmpty()){
//            height++;
//            int size = queue.size();
//            while(size-- > 0){
//                TreeNode treeNode = queue.poll();
//                if(treeNode.left != null)
//                    queue.add(treeNode.left);
//                if(treeNode.right != null)
//                    queue.add(treeNode.right);
//            }
//        }
//        return height;
//    }


    //dfs
    /**
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:38.3 MB,击败了77.23% 的Java用户
     */
    int res = 0;
    public int maxDepth(TreeNode root) {
        dfs(root,0);
        return res;
    }

    private void dfs(TreeNode root,int depth){
        if(root == null){
            res = Math.max(res,depth);
            return;
        }
        dfs(root.left,depth + 1);
        dfs(root.right,depth + 1);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
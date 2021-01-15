package offer.leetcode.editor.cn;
//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 424 👎 0

import java.util.ArrayList;
import java.util.List;

 class BinaryTreePaths{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        
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
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(new ArrayList<>(),root);
        List<String> ans = new ArrayList<>();
        for(List<Integer> list : res){
            StringBuilder sb = new StringBuilder();
            list.stream().forEach(i->sb.append(i + "->"));
            ans.add(sb.substring(0,sb.length()-2));
        }
        return ans;
    }

    private void dfs(List<Integer> temp,TreeNode root){
        if(root == null){
            return;
        }
        temp.add(root.val);
        if(root.left == null && root.right == null){
            res.add(new ArrayList<>(temp));
        }
        dfs(temp,root.left);
        dfs(temp,root.right);
        temp.remove(temp.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
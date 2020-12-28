package offer.leetcode.editor.cn;
//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 113 👎 0

import java.util.ArrayList;
import java.util.List;

 class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
        
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
        }

        dfs(temp,treeNode.left,tempSum,sum);
        dfs(temp,treeNode.right,tempSum,sum);
        temp.remove(temp.size()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
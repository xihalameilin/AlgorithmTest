package offer.leetcode.editor.cn;
//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 62 👎 0

import java.util.*;

class CongShangDaoXiaDaYinErChaShuIiiLcof {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         执行耗时:1 ms,击败了99.76% 的Java用户
         内存消耗:38.7 MB,击败了48.80% 的Java用户
         */
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
                res.get(level).add(0,root.val);
            }
            help(root.left,level+1);
            help(root.right,level+1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

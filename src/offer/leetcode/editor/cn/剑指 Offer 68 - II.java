package offer.leetcode.editor.cn;
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
//
// 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a
//-binary-tree/ 
// Related Topics 树 
// 👍 178 👎 0

import java.util.ArrayList;
import java.util.List;

class ErChaShuDeZuiJinGongGongZuXianLcof{
    public static void main(String[] args) {
            new ErChaShuDeZuiJinGongGongZuXianLcof().f();
    }

    public void f(){
        TreeNode root = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(1);
        root.left = treeNode1;
        root.right = treeNode2;
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(2);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        TreeNode treeNode5 = new TreeNode(0);
        TreeNode treeNode6 = new TreeNode(8);
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        TreeNode treeNode7 = new TreeNode(1);
        treeNode4.left = treeNode7;
        Solution solution = new Solution();
        solution.dfs(new ArrayList<>(),root,treeNode4);
    solution.res.get(0).forEach(i -> System.out.print(i.val +" "));
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
     执行耗时:9 ms,击败了23.01% 的Java用户
     内存消耗:39.2 MB,击败了96.37% 的Java用户
     */
    List<List<TreeNode>> res = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(new ArrayList<>(),root,p);
        dfs(new ArrayList<>(),root,q);
        int max = Math.min(res.get(0).size(),res.get(1).size());
        List<TreeNode> pPath = res.get(0);
        List<TreeNode> qPath = res.get(1);
        for(int i = max - 1 ; i >= 0 ; i--){
            if(pPath.get(i) == qPath.get(i))
                return pPath.get(i);
        }
        return null;
    }
    public void dfs(List<TreeNode> temp,TreeNode root,TreeNode target){
        if(root == null)
            return;
        temp.add(root);
        if(root == target){
            res.add(new ArrayList<>(temp));
            return;
        }
        dfs(temp,root.left,target);
        dfs(temp,root.right,target);
        temp.remove(temp.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
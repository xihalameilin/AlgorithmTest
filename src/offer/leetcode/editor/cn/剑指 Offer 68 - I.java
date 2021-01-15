package offer.leetcode.editor.cn;
//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
//
// 注意：本题与主站 235 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a
//-binary-search-tree/ 
// Related Topics 树 
// 👍 82 👎 0

import java.util.ArrayList;
import java.util.List;

class ErChaSouSuoShuDeZuiJinGongGongZuXianLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeZuiJinGongGongZuXianLcof().new Solution();
        
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
//     执行耗时:7 ms,击败了37.33% 的Java用户
//     内存消耗:39 MB,击败了79.04% 的Java用户
//     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<TreeNode> pList = getPath(root,p);
//        List<TreeNode> qList = getPath(root,q);
//        p = pList.get(0);
//        q = qList.get(0);
//        int index = 0;
//        while(p != null && q != null && p == q){
//            index++;
//            p = pList.get(index);
//            q = qList.get(index);
//        }
//        return pList.get(index - 1);
//    }
//
//    private List<TreeNode> getPath(TreeNode root,TreeNode p){
//        List<TreeNode> pList = new ArrayList<>();
//        TreeNode cur = root;
//        pList.add(root);
//        while(cur != p){
//            if(p.val < cur.val){
//                cur = cur.left;
//            }
//            else
//                cur = cur.right;
//            pList.add(cur);
//        }
//        pList.add(p);
//        return pList;
//    }

    /**
     执行耗时:7 ms,击败了37.33% 的Java用户
     内存消耗:39.1 MB,击败了67.50% 的Java用户
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left,p,q);
        else if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right,p,q);
        return root;
    }

    private boolean contain(TreeNode root,TreeNode child){
        if(root == null)
            return false;
        if(root == child)
            return true;
        if(root.val > child.val)
            return contain(root.left,child);
        else
            return contain(root.right,child);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
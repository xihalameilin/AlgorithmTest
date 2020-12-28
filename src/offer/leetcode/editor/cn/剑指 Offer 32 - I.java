package offer.leetcode.editor.cn;
//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
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
// 👍 52 👎 0

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CongShangDaoXiaDaYinErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
        
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
     执行耗时:1 ms,击败了99.75% 的Java用户
     内存消耗:38.4 MB,击败了85.66% 的Java用户
     */
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return new int[0];
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode temp = queue.poll();
                res.add(temp.val);
                if(temp.left != null)
                    queue.offer(temp.left);
                if(temp.right != null)
                    queue.offer(temp.right);
            }
        }
        int[] array = new int[res.size()];
        for(int i = 0 ; i< array.length ; i++){
            array[i] = res.get(i);
        }
        return array;
    }
 }
//leetcode submit region end(Prohibit modification and deletion)

}
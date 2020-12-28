package offer.leetcode.editor.cn;
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 157 👎 0

 class ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:35.8 MB,击败了85.65% 的Java用户
     */
    public boolean verifyPostorder(int[] postorder) {
        return help(postorder,0,postorder.length-1);
    }

    private boolean help(int[] postorder,int begin,int end){
        if(begin >= end)
            return true;
        int root = postorder[end];
        int i = begin;
        for(; i < end ; i++){
            if(postorder[i] > root)
                break;
        }

        int j = i;
        for(; j < end ; j++){
            if(postorder[j] < root)
                return false;
        }

        return  help(postorder,begin,i - 1) && help(postorder, i , end - 1);
    }

//    private boolean help(int[] postorder,int begin,int end){
//        if(end - begin <= 2 )
//            return true;
//        int left = begin,right = end - 1;
//        while(left < end && postorder[left] < postorder[end]){
//            left ++;
//        }
//        while(right >= begin && postorder[right] > postorder[end]){
//            right --;
//        }
//        if(left - right == 0 || left - right == 1){
//            return help(postorder,begin,left) && help(postorder,right+1,end-1);
//        }
//        return false;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
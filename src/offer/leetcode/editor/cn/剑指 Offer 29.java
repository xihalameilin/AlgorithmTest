package offer.leetcode.editor.cn;
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 166 👎 0

 class ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     执行耗时:1 ms,击败了97.22% 的Java用户
     内存消耗:39.6 MB,击败了89.59% 的Java用户
     */
    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if(row == 0)
            return new int[]{};
        int col = matrix[0].length;
        if(col == 0)
            return new int[]{};
        int [] res = new int[row * col];
        int index = 0;
        int left = 0,right = col - 1,top = 0,button = row-1;
        while(true){
            for(int i = left ; i <= right ; i++){
                res[index] = matrix[top][i];
                index ++;
            }
            top++;
            if(top > button)
                break;


            for(int i = top ; i <= button ; i++){
                res[index] = matrix[i][right];
                index ++;
            }
            right--;
            if(left > right)
                break;


            for (int i = right; i >= left; i--) {
                res[index] = matrix[button][i];
                index++;
            }
            button--;
            if(button < top)
                break;


            for(int i = button ; i >= top ; i--){
                res[index] = matrix[i][left];
                index ++;
            }
            left++;
            if(left > right)
                break;

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
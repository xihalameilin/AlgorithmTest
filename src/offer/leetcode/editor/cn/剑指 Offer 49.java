package offer.leetcode.editor.cn;
//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 102 👎 0

import java.util.Arrays;

class ChouShuLcof{
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
    System.out.println(solution.nthUglyNumber(7));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     执行耗时:2 ms,击败了99.14% 的Java用户
     内存消耗:37.6 MB,击败了40.91% 的Java用户
     */
    public int nthUglyNumber(int n) {
        int ptr1 = 0;
        int ptr2 = 0;
        int ptr3 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1 ; i < n ; i++){
            int x1 = dp[ptr1] * 2;
            int x2 = dp[ptr2] * 3;
            int x3 = dp[ptr3] * 5;
            dp[i] = Math.min(x1,Math.min(x2,x3));
            if(dp[i] == x1)
                ptr1++;
            if(dp[i] == x2)
                ptr2++;
            if(dp[i] == x3)
                ptr3++;
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
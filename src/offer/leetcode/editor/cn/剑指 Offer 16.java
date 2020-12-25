package offer.leetcode.editor.cn;
//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。 
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 103 👎 0

class ShuZhiDeZhengShuCiFangLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     执行耗时:1 ms,击败了97.66% 的Java用户
     内存消耗:36.5 MB,击败了86.43% 的Java用户
     */
//    public double myPow(double x, int n) {
//        boolean positive = n > 0;
//        double res = calculatePow(x,n);
//        return positive? res : 1.0 /res;
//    }
//
//    private double calculatePow(double x,int n){
//        if(n == 0)
//           return 1;
//        double y = calculatePow(x,n / 2);
//        return n % 2 == 0 ? y  *y : y * y * x;
//
//    }

    /**
     * 快速幂
     执行耗时:1 ms,击败了97.66% 的Java用户
     内存消耗:37.8 MB,击败了36.93% 的Java用户
     */
    public double myPow(double x, int n) {
        double res = 1;
        boolean positive = n > 0;
        while(n != 0){
            if((n & 1) == 1){
                res *= x;
            }
            x *=x;
            n /= 2;
        }
        return positive ? res : 1.0 / res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
package offer.leetcode.editor.cn;
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 递归 
// 👍 85 👎 0

class FeiBoNaQiShuLieLcof{
    public static void main(String[] args) {
        Solution solution = new FeiBoNaQiShuLieLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:35.2 MB,击败了82.59% 的Java用户
     */
    public int fib(int n) {
        if(n == 0 || n == 1)
            return n;
        int num1 = 0;
        int num2 = 1;
        while(n >= 2){
            int temp = num1 + num2;
            num1 = num2;
            num2 = temp % 1000000007;
            n--;
        }
        return num2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
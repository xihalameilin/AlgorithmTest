package offer.leetcode.editor.cn;
//编写一段程序来查找第 n 个超级丑数。 
//
// 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。 
//
// 示例: 
//
// 输入: n = 12, primes = [2,7,13,19]
//输出: 32 
//解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26
//,28,32] 。 
//
// 说明: 
//
// 
// 1 是任何给定 primes 的超级丑数。 
// 给定 primes 中的数字以升序排列。 
// 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。 
// 第 n 个超级丑数确保在 32 位有符整数范围内。 
// 
// Related Topics 堆 数学 
// 👍 141 👎 0


import java.util.*;

class SuperUglyNumber{
    public static void main(String[] args) {
        Solution solution = new SuperUglyNumber().new Solution();
        solution.nthSuperUglyNumber(12,new int[]{2,7,13,19});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int nthSuperUglyNumber(int n, int[] primes) {
//        int[] ptrs = new int[primes.length];
//        int[] dp = new int[n];
//        dp[0] = 1;
//        for(int i = 1 ; i < n ; i++){
//            List<Integer> temp = new ArrayList<>();
//            for(int j = 0 ; j < primes.length ; j++){
//                temp.add(dp[ptrs[j]] * primes[j]);
//            }
//            int min = findMin(temp);
//            for(int j = 0 ; j < temp.size() ; j++){
//                if(temp.get(j) == min){
//                    ptrs[j]++;
//                }
//            }
//            dp[i] = min;
//        }
//        return dp[n - 1];
//
//    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ptrs = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1 ; i < n ; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0 ; j < primes.length ; j++){
                dp[i] = Math.min(dp[ptrs[j]] * primes[j] , dp[i]);
            }
            for(int j = 0 ; j < primes.length ; j++){
                if(dp[i] == dp[ptrs[j]] * primes[j]){
                    ptrs[j]++;
                }
            }
        }
        return dp[n - 1];

    }

    private int findMin(List<Integer> res){
       int min = Integer.MAX_VALUE;
       for(int i : res){
           min = Math.min(min,i);
       }

       return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
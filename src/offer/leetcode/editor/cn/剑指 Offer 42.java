package offer.leetcode.editor.cn;
//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 191 👎 0

 class LianXuZiShuZuDeZuiDaHeLcof{
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    /**
////     执行耗时:1 ms,击败了98.13% 的Java用户
////     内存消耗:44.9 MB,击败了70.42% 的Java用户
////     */
////    public int maxSubArray(int[] nums) {
////        int curSum = 0;
////        // 这个结果的初始化有讲究的
////        int max = Integer.MIN_VALUE;
////        for(int i : nums){
////            // 如果当前的和小于0,加上这个和会让求和变小，舍弃
////            if(curSum < 0)
////                curSum = i;
////            else
////                curSum += i;
////            max = Math.max(max,curSum);
////        }
////        return max;
////    }


    /**
     执行耗时:1 ms,击败了98.13% 的Java用户
     内存消耗:44.6 MB,击败了96.66% 的Java用户
     */
    public int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        int res = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            if(i > 0 && dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            }
            else {
                dp[i] = nums[i];
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
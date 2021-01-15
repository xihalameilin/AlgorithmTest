package offer.leetcode.editor.cn;
//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// 👍 65 👎 0

 class HeWeiSdeLiangGeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLiangGeShuZiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     执行耗时:2 ms,击败了95.74% 的Java用户
     内存消耗:55.7 MB,击败了24.08% 的Java用户
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int res = nums[left] + nums[right];
            if(res == target){
                return new int[]{nums[left],nums[right]};
            }
            else if(res > target){
                right--;
            }
            else{
                left++;
            }
         }
        return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
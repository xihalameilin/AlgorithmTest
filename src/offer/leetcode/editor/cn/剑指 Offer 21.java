package offer.leetcode.editor.cn;
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 64 👎 0

class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     执行耗时:2 ms,击败了98.94% 的Java用户
     内存消耗:46.2 MB,击败了85.68% 的Java用户
     */
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            while((nums[left] & 1) == 1 && left < right){
                left ++;
            }
            while((nums[right] & 1) == 0 && left < right){
                right --;
            }
            swap(nums,left,right);
        }
        return nums;
    }

    private void swap(int[] nums,int left,int right){
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
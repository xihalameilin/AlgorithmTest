package offer.leetcode.editor.cn;
//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 
// 👍 236 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ShuZuZhongZhongFuDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        System.out.println(solution.findRepeatNumber(new int[]{0, 1, 2, 0, 4, 5, 6, 7, 8, 9}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int findRepeatNumber(int[] nums) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i : nums){
//            if(map.containsKey(i))
//                return i;
//            map.put(i,0);
//        }
//        return 0;
//    }

//    public int findRepeatNumber(int[] nums) {
//        for(int i = 0 ; i < nums.length ; i ++){
//            while(nums[i] != i){
//                if(nums[nums[i]] == nums[i])
//                    return nums[i];
//                int temp = nums[i];
//                nums[i] = nums[temp];
//                nums[temp] = temp;
//            }
//        }
//        return 0;
//    }

    // 二分法 求解 不对
//    public int findRepeatNumber(int[] nums) {
//        int left = 0;
//        int right = nums.length - 1;
//        while(right >= left){
//            int mid = left + (right - left) / 2;
//            int count = rangeCount(nums,left,mid);
//            if(left == right) {
//                if (count > 1)
//                    return left;
//                else break;
//            }
//            if(count > (mid - left + 1)){
//                right = mid;
//            }
//            else
//                left = mid + 1;
//        }
//        return -1;
//    }
//
//    private int rangeCount(int[] nums,int left,int right){
//        int res = 0;
//        for(int i : nums){
//            if(i >= left && i <= right){
//                res++;
//            }
//        }
//        return res;
//    }

    /**
     *
     执行耗时:1 ms,击败了87.83% 的Java用户
     内存消耗:45.9 MB,击败了93.93% 的Java用户
     */
    public int findRepeatNumber(int[] nums) {
        int[] comp = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            if(comp[nums[i]] != 0){
                return nums[i];
            }
            comp[nums[i]] = nums[i];
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
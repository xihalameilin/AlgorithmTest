package offer.leetcode.editor.cn;
//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 168 👎 0

import java.util.Deque;
import java.util.LinkedList;

 class HuaDongChuangKouDeZuiDaZhiLcof{
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
        执行耗时:17 ms,击败了38.47% 的Java用户
        内存消耗:47.2 MB,击败了36.65% 的Java用户
         */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)
            return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0 ; i < nums.length ; i++){
            if(!deque.isEmpty() && i - deque.peekFirst() >= k)
                deque.removeFirst();
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }
            deque.offer(i);
            if(i >= k- 1){
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
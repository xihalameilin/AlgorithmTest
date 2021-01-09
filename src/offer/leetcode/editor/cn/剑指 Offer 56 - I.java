package offer.leetcode.editor.cn;
//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 281 👎 0

class ShuZuZhongShuZiChuXianDeCiShuLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     执行耗时:2 ms,击败了70.26% 的Java用户
     内存消耗:40 MB,击败了73.51% 的Java用户
     */
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for(int i : nums){
            res ^= i;
        }
        int index = 0;
        while((res & 1) != 1){
            index++;
            res >>= 1;
        }
        int a = 0;
        int b = 0;
        for(int i : nums){
            if(((i >> index) & 1) == 1){
                a ^= i;
            }
            else
                b ^= i;
        }
        return new int[]{a,b};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
package offer.leetcode.editor.cn;
//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// 👍 113 👎 0

 class ShuZuZhongShuZiChuXianDeCiShuIiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     执行耗时:5 ms,击败了86.81% 的Java用户
     内存消耗:39.6 MB,击败了34.39% 的Java用户
     */
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for(int i : nums){
            for(int j = 0 ; j < 32 ; j++){
                count[j] += i & 1;
                i >>= 1;
            }
        }
        int res = 0;
        int i = 1;
        for(int j = 0 ; j < 32 ; j++){
            if(count[j] % 3 == 1){
                res += i;
            }
            i <<= 1;
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
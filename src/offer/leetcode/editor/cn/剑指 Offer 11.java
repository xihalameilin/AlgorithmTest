package offer.leetcode.editor.cn;
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找 
// 👍 193 👎 0

class XuanZhuanShuZuDeZuiXiaoShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:38.5 MB,击败了30.88% 的Java用户
     */
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(numbers[right] < numbers[mid])
                left = mid + 1;
            else if(numbers[right] > numbers[mid])
                right = mid;
            else
                right --;
        }
        return numbers[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
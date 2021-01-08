package offer.leetcode.editor.cn;
//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 139 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

 class BaShuZuPaiChengZuiXiaoDeShuLcof{
    public static void main(String[] args) {
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     执行耗时:7 ms,击败了54.20% 的Java用户
     内存消耗:38.1 MB,击败了55.27% 的Java用户
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        //Collections.sort(strs,(o1, o2)->(o1 + o2).compareTo(o2 + o1 ));
        quickSort(strs,0,strs.length-1);
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s);
        }
        return sb.toString();
    }


    void quickSort(String[] nums,int left,int right){
        if(left >= right){
            return;
        }
        int i = left,j = right;
        String temp = nums[left];
        while(i < j){
            while((nums[j] + nums[left]).compareTo(nums[left] + nums[j]) >=0 && i < j)
                j--;
            while((nums[i] + nums[left]).compareTo(nums[left] + nums[i]) <=0 && i < j)
                i++;
            String s = nums[i];
            nums[i] = nums[j];
            nums[j] = s;
        }
        nums[left] = nums[i];
        nums[i] = temp;
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
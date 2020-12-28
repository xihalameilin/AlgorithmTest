package offer.leetcode.editor.cn;
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// 👍 288 👎 0

import java.util.Scanner;

class ShuZuZhongDeNiXuDuiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int count = sc.nextInt();
//        for(int k = 0; k <count ; k++){
//            int n = sc.nextInt();
//            int[] array = new int[n];
//            for(int i = 0 ; i < n ; i++){
//                array[i] = sc.nextInt();
//            }
//            System.out.println();
//        }
//    }
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return mergeSort(copy, 0, len - 1, temp);
    }

    private int mergeSort(int[] nums,int left,int right,int[] temp){
        if(left >= right)
            return 0;
        int mid = left + (right - left) / 2;
        int leftCount = mergeSort(nums,left,mid,temp);
        int rightCount = mergeSort(nums,mid+1,right,temp);
        if(nums[mid] < nums[mid+1]){
            return leftCount + rightCount;
        }

        int mergeCount = merge(nums,left,mid,right,temp);
        return leftCount + rightCount + mergeCount;
    }

    private int merge(int[] nums,int left,int mid,int right,int[] temp){
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
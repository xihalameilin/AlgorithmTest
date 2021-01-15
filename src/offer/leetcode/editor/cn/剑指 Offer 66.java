package offer.leetcode.editor.cn;
//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// 👍 71 👎 0

import java.util.Arrays;

 class GouJianChengJiShuZuLcof{
    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     执行耗时:3 ms,击败了11.24% 的Java用户
     内存消耗:51.1 MB,击败了55.72% 的Java用户
     */
//    public int[] constructArr(int[] a) {
//        if(a.length == 0)
//            return new int[0];
//        int[] left = new int[a.length];
//        int[] right = new int[a.length];
//        Arrays.fill(left,1);
//        Arrays.fill(right,1);
//        int temp = 1;
//        for(int i = 1 ; i < a.length ; i++){
//            temp *= a[i - 1];
//            left[i] = temp;
//        }
//        right[a.length - 1] = 1;
//        temp = 1;
//        for(int i = a.length - 2 ; i >= 0 ; i--){
//            temp *= a[i + 1];
//            right[i] = temp;
//        }
//        for(int i = 0 ; i < a.length ; i++){
//            left[i] *= right[i];
//        }
//        return left;
//    }

    /**
     执行耗时:2 ms,击败了78.07% 的Java用户
     内存消耗:51 MB,击败了68.69% 的Java用户
     */
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        int temp = 1;
        Arrays.fill(res,1);
        for(int i = 0 ; i < a.length ; i++){
            res[i] *= temp;
            temp *= a[i];
        }

        temp = 1;
        for(int i = a.length - 1 ; i >= 0 ; i--){
            res[i] *= temp;
            temp *= a[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
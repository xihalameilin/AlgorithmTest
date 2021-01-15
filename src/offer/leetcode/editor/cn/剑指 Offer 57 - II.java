package offer.leetcode.editor.cn;
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 197 👎 0

import java.util.ArrayList;
import java.util.List;

 class HeWeiSdeLianXuZhengShuXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     执行耗时:3 ms,击败了84.13% 的Java用户
     内存消耗:36.9 MB,击败了11.04% 的Java用户
     */
//    public int[][] findContinuousSequence(int target) {
//        int n = 2;
//        List<List<Integer>> list = new ArrayList<>();
//        while(target - n * (n - 1) / 2 > 0){
//            int temp = target - n * (n - 1) / 2;
//            if(temp % n == 0){
//                List<Integer> ans = new ArrayList<>();
//                for(int i = temp / n ; i < temp / n + n ; i++){
//                    ans.add(i);
//                }
//                list.add(ans);
//            }
//            n++;
//        }
//        int[][] res = new int[list.size()][];
//        int index = 0;
//        for(List<Integer> item : list){
//            int[] t = new int[item.size()];
//            for(int i = 0 ; i < item.size() ; i++){
//                t[i] = item.get(i);
//            }
//            res[index++] = t;
//        }
//        Arrays.sort(res, Comparator.comparingInt(o -> o[0]));
//        return res;
//    }

    /**
     执行耗时:4 ms,击败了61.30% 的Java用户
     内存消耗:36.6 MB,击败了54.74% 的Java用户
     */
    //滑动窗口
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        for(int l = 1,r = 2 ; l < r;){
            int sum = (l + r) * (r - l + 1) / 2;
            if(sum == target){
                int[] temp = new int[r - l + 1];
                for(int i = l ; i <= r ; i++){
                    temp[i - l] = i;
                }
                res.add(temp);
                l++;
            }
            else if(sum < target){
                r++;
            }else {
                l++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
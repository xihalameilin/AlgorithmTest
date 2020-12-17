package summer2019;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//300开始
public class LeetCodePraticeIIII {


    //301 删除括号
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        set.add(s);
        while(true){
            for(String item : set){
                if(help301(item))
                    res.add(item);
            }

            //精髓所在
            if(res.size() >0)
                return res;
            Set<String> nextSet = new HashSet<>();
            for(String item : set){
                for(int i = 0 ; i < item.length() ; i ++){
                    if(item.charAt(i) == '(' || item.charAt(i) == ')'){
                        nextSet.add(item.substring(0,i) + item.substring(i+1));
                    }
                }
            }
            set = nextSet;
        }
    }

    private boolean help301(String s){
        char[] chars = s.toCharArray();
        int count = 0;
        for(char item : chars){
            if(item == '(')
                count++;
            else if(item == ')')
                count--;
            if(count < 0)
                return false;
        }
        return count == 0;
    }


    //303
    class NumArray {

        private int[] arrays;
        public NumArray(int[] nums) {
            arrays = new int[nums.length];
            if(nums.length == 0)
                return;
            arrays[0] = nums[0];
            for(int i = 1 ; i < nums.length ; i ++){
                arrays[i] = arrays[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if(i == 0)
                return arrays[j];
            else
                return arrays[j] - arrays[i - 1];
        }
    }

    //304
    class NumMatrix {

        private int[][] matrix;
        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for(int i = row1 ; i <= row2 ; i++){
                for(int j = col1 ; j <= col2 ; j++){
                    sum += matrix[i][j];
                }
            }
            return sum;
        }
    }


    class NumMatrixII {

        private int[][] dp;
        public NumMatrixII(int[][] matrix) {
            if (matrix.length == 0) return;
            dp = new int[matrix.length + 1][matrix[0].length + 1];
            for(int i = 0 ; i < matrix.length ; i++){
                for(int j = 0 ; j < matrix[0].length; j++){
                    dp[i + 1][j + 1] = matrix[i][j] + dp[i + 1][j] + dp[i][j + 1] - dp[i][j];
                }
            }


        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row1][col2 + 1] - dp[row2 + 1][col1];
        }
    }

    //307 线段数组  参考https://blog.csdn.net/Yaokai_AssultMaster/article/details/79492190
    class NumArrayIII {
        int[] nums;
        int[] sums;
        public NumArrayIII(int[] nums) {
            this.nums = nums;
            this.sums = new int[nums.length + 1];
            for(int i = 0 ; i < nums.length ; i++){
                updateTree(i + 1,nums[i]);
            }
        }

        public void update(int i, int val) {
            updateTree(i + 1,val-nums[i]);
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            return query(j + 1) - query(i);
        }

        private void updateTree(int index,int val){
            while(index < sums.length){
                sums[index] += val ;
                index += and(index);
            }

        }

        private int query(int i){
            int res = 0;
            while(i > 0){
                res += sums[i];
                i -= and(i);
            }
            return res;
        }

        private int and(int x){
            return x & (-x);
        }
    }


    //309
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - prices[0]);
        for(int i = 2; i < prices.length ; i++){
            buy[i] = Math.max(sell[i-2] - prices[i],buy[i-1]);
            sell[i] = Math.max(buy[i-1] + prices[i],sell[i-1]);
        }
        return sell[prices.length-1];
     }


     //dp 思路：第i天结束有股票  1 无股票，冷却  2 无股票，无冷却
    public int maxProfitII(int[] prices) {
        int[][] dp = new int[prices.length][3];
        if(prices.length < 2)
            return 0;
        dp[0][0] = -prices[0];
        for(int i = 1 ; i < prices.length ; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
        }
        return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
    }


}

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
}

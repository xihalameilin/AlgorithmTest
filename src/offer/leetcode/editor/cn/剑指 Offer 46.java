package offer.leetcode.editor.cn;
//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 167 👎 0

 class BaShuZiFanYiChengZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
    System.out.println(solution.translateNum(25));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private int count = 0;

//    /**
//     *  回溯法 并不理想
//     执行耗时:1 ms,击败了13.72% 的Java用户
//     内存消耗:35.4 MB,击败了28.99% 的Java用户
//     */
//    public int translateNum(int num) {
//        count = 0;
//        dfs(String.valueOf(num),0);
//        return count;
//    }
//
//    private void dfs(String num,int begin){
//        if(begin == num.length()){
//            count++;
//            return;
//        }
//        int x = num.charAt(begin) - '0';
//        if (x >= 0 && x <= 25) {
//            if (begin + 1 <= num.length()) {
//                dfs(num, begin + 1);
//            }
//
//      if (begin + 2 <= num.length()) {
//            String s = num.substring(begin, begin + 2);
//            int y = Integer.valueOf(s);
//            if (y >= 10 && y <= 25) {
//              dfs(num, begin + 2);
//            }
//        }
//      }
//    }


    /**
     * dp
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:35 MB,击败了89.86% 的Java用户
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i <= s.length() ; i++){
            char c = s.charAt(i - 2);
            //String temp = s.substring(i - 2, i );
            //if(temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0){
            if(c == '1' || (c == '2' && s.charAt(i - 1) <= '5')){
                dp[i] = dp[i - 2] + dp[i - 1] ;
            }
            else{
                dp[i] = dp[i - 1] ;
            }
        }
        return dp[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
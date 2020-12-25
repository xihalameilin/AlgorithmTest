package offer.leetcode.editor.cn;
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 55 👎 0

class TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     *
     执行耗时:3 ms,击败了13.43% 的Java用户
     内存消耗:36.6 MB,击败了39.21% 的Java用户
     */
//    public String replaceSpace(String s) {
//        return s.replaceAll(" ","%20");
//    }

    /**
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:36.5 MB,击败了53.68% 的Java用户
     */
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i ++){
            if(s.charAt(i) == ' ')
                sb.append("%20");
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
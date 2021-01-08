package offer.leetcode.editor.cn;
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 65 👎 0

 class DiYiGeZhiChuXianYiCiDeZiFuLcof{
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     执行耗时:8 ms,击败了77.05% 的Java用户
     内存消耗:38.8 MB,击败了62.04% 的Java用户
     */
    public char firstUniqChar(String s) {
        int[] res = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            res[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < s.length() ; i++){
            if(res[s.charAt(i) - 'a'] == 1)
                return s.charAt(i);
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
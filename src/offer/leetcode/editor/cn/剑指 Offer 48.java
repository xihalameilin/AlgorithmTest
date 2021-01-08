package offer.leetcode.editor.cn;
//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 138 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

 class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        solution.lengthOfLongestSubstring("abba");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     执行耗时:435 ms,击败了5.04% 的Java用户
     内存消耗:39.1 MB,击败了11.27% 的Java用户
     */
//    public int lengthOfLongestSubstring(String s) {
//        int left = 0;
//        int right = 0;
//        int length = s.length();
//        int max = 0;
//        while(left < length && right != length + 1){
//            if(isValid(s,left,right)){
//                max = Math.max(max,right - left);
//                right++;
//            }
//            else {
//                while(left < right){
//                    left++;
//                    if(isValid(s,left,right)){
//                        max = Math.max(max,right - left);
//                        break;
//                    }
//                }
//            }
//        }
//        return max;
//    }

    private boolean isValid(String s,int left,int right){
        if(s == null || s.length() == 0){
            return true;
        }
        Set<Character> set = new HashSet<>();
        for(int i = left ; i < right ; i++){
            if(set.contains(s.charAt(i)))
                return false;
            else
                set.add(s.charAt(i));
        }
        return true;
    }

//    /**
//     执行耗时:9 ms,击败了33.93% 的Java用户
//     内存消耗:38.5 MB,击败了60.81% 的Java用户
//     */
//    public int lengthOfLongestSubstring(String s) {
//        int left = 0;
//        int res = 0;
//        Set<Character> set = new HashSet<>();
//        for(int i = 0 ; i < s.length(); i++){
//            char c = s.charAt(i);
//            // 这个位置要while不能if
//            while(set.contains(c)){
//                set.remove(s.charAt(left++));
//            }
//            set.add(c);
//            res = Math.max(res,i - left + 1);
//
//        }
//        return res;
//    }

    /**
     执行耗时:9 ms,击败了33.93% 的Java用户
     内存消耗:38.5 MB,击败了63.18% 的Java用户
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left = -1;
        int res =  0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                left = Math.max(left,map.get(c));
            }
            map.put(c,i);
            res = Math.max(res,i - left);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
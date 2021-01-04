package offer.leetcode.editor.cn;
//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 155 👎 0

import java.util.*;

class ZiFuChuanDePaiLieLcof{
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        String[] res = solution.permutation("abc");
        Arrays.stream(res).forEach(item -> System.out.println(item));
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//        Set<String> set = new HashSet<>();
//    public String[] permutation(String s) {
//        help(s,new boolean[s.length()],new StringBuilder());
//        String[] res = new String[set.size()];
//        Iterator<String> ite = set.iterator();
//        int index = 0;
//        while(ite.hasNext()){
//            res[index++] = ite.next();
//        }
//        return res;
//    }
//
//    private void help(String s,boolean[] visited,StringBuilder temp){
//        if(temp.length() == s.length()){
//            set.add(temp.toString());
//            return;
//        }
//        for(int i = 0 ; i < s.length() ; i++){
//            if(visited[i] == false){
//                temp.append(s.charAt(i));
//                visited[i] = true;
//                help(s,visited,temp);
//                visited[i] = false;
//                temp.deleteCharAt(temp.length()-1);
//            }
//        }
//    }


    /**
     执行耗时:14 ms,击败了48.08% 的Java用户
     内存消耗:42.6 MB,击败了87.49% 的Java用户
     */
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        dfs(chars,new StringBuilder(),new boolean[s.length()]);
        return res.toArray(new String[res.size()]);
    }
    List<String> res = new ArrayList<>();
    private void dfs(char[] s,StringBuilder temp,boolean[] visited){
        if(temp.length() == s.length){
            res.add(temp.toString());
            return;
        }
        for(int i = 0 ; i < s.length ; i++){
            if(visited[i])
                continue;
            if(i > 0 && s[i] == s[i - 1] && visited[i - 1])
                continue;
            temp.append(s[i]);
            visited[i] = true;
            dfs(s,temp,visited);
            temp.deleteCharAt(temp.length()-1);
            visited[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
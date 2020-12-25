package offer.leetcode.editor.cn;
//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 213 👎 0

class JuZhenZhongDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        visited = new boolean[row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(isExist(board,visited,word,0,i,j))
                    return true;
            }
        }
        return false;
    }

//    private boolean isExist(char[][] board,String word,int step,int x,int y){
//        if(step == word.length())
//            return true;
//        int row = board.length;
//        int col = board[0].length;
//        if(x < 0 || x >= row || y < 0 || y >= col || board[x][y] != word.charAt(step))
//            return false;
//        board[x][y] += 30;
//        boolean res = isExist(board,word,step+1,x-1,y)
//                || isExist(board,word,step+1,x+1,y)
//                || isExist(board,word,step+1,x,y-1)
//                || isExist(board,word,step+1,x,y+1);
//        board[x][y] -= 30;
//        return res;
//    }
private boolean isExist(char[][] board,boolean[][] visited,String word,int step,int x,int y){
    if(step == word.length())
        return true;
    int row = board.length;
    int col = board[0].length;
    if(x < 0 || x >= row || y < 0 || y >= col || visited[x][y] || board[x][y] != word.charAt(step))
        return false;
    visited[x][y] = true;
    boolean res = isExist(board,visited,word,step+1,x-1,y)
            || isExist(board,visited,word,step+1,x+1,y)
            || isExist(board,visited,word,step+1,x,y-1)
            || isExist(board,visited,word,step+1,x,y+1);
    visited[x][y] = false;
    return res;
}
}
//leetcode submit region end(Prohibit modification and deletion)

}
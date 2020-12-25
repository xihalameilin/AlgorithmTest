package offer.leetcode.editor.cn;
//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 193 👎 0

class JiQiRenDeYunDongFanWeiLcof{
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return dfs(m,n,k,0,0);
    }

    private int dfs(int m,int n,int k,int x,int y){
        if(x < 0 || x >= m || y<0 || y >= n || visited[x][y] || !isValid(x,y,k))
            return 0;
        visited[x][y] = true;
        int res = 1 +  + dfs(m,n,k,x+1,y) + dfs(m,n,k,x,y+1);
        return res;
    }

    private boolean isValid(int x,int y,int k){
        return getSum(x) + getSum(y) <= k;
    }


    private int getSum(int x){
        int sum = 0;
        while(x > 0){
            int digit = x % 10;
            x = x / 10;
            sum += digit;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
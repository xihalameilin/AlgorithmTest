package niukewang;

public class Test {

    boolean[][] visited;
    public int solve (char[][] grid) {
        // write code here
        if(grid == null || grid.length == 0)
            return 0;
        if(grid[0].length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];
        int res = 0;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid,int x,int y){
        int row = grid.length;
        int col = grid[0].length;
        if(x < 0 || x >= row || y < 0 || y >= col || visited[x][y] || grid[x][y] != 1){
            return;
        }
        visited[x][y] = true;
        dfs(grid,x-1,y);
        dfs(grid,x+1,y);
        dfs(grid,x,y-1);
        dfs(grid,x,y+1);

    }
}

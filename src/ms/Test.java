package ms;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private void help(int[][] arr){
        if(arr == null || arr.length == 0)
            return ;
        if(arr[0].length == 0)
            return;
        if(arr.length != arr[0].length)
            return;
        //先左右
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n/2 ;j++){
                swap(arr,i,j,i,n-1-j);
            }
        }

        //再对角线
        for(int i = 0 ; i < n ; i++){     //n=4  i=0 j <3
            for(int j = 0 ; j < n - 1 - i ; j++){
                swap(arr,i,j,n-1-j,n-1-i);
            }
        }

    }

    private void swap(int[][] arr,int x1,int y1,int x2,int y2){
        int temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    //[1 2]  [2 1]  [3 1]
    //[3 4]  [4 3]  [4 2]  j    1 - i        (i,j) - > (j , (len+1)/2-i )  0 1  -> 1  1

    //3
    //[1 2 3]    (i,j)(0,0)  横着d = (1 - j) 竖着d =(1 - i)    (i,j) - > (j , 2-i )
    //[4 5 6]     1 - ( 1 - j) = j     1 + 1 -  i  = 2 - i
    //[7 8 9]

   static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] arg){
        int[][] maze = new int[][]{
                {0,1,0,0,0},
                {0,1,0,1,0},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,1,0}
        };
        bfs(maze,new boolean[5][5],0,0,new ArrayList<>());
        res.forEach(point -> System.out.print("("+point.x + "," + point.y+") "));
    }
    static List<Point> res = new ArrayList<>();
    static int min = Integer.MAX_VALUE;


    private static void bfs(int[][] maze,boolean[][] visited,int x,int y,List<Point> path){
        int n = maze.length;
        //到达右下角
        if(x == n - 1 && y == n - 1){
            path.add(new Point(x, y));
            if(min > path.size()){
                min = path.size();
                res = new ArrayList<>(path);
            }
            path.remove(path.size() - 1);
            return;
        }

        //
        if(x < 0 || x > n - 1 || y < 0 || y > n -1 || maze[x][y] == 1 || visited[x][y]){
            return;
        }
        path.add(new Point(x,y));
        visited[x][y] = true;
        bfs(maze,visited,x + 1,y,path);
        bfs(maze,visited,x - 1,y,path);
        bfs(maze,visited,x ,y - 1,path);
        bfs(maze,visited,x ,y + 1,path);
        visited[x][y] = false;
        path.remove(path.size() - 1);
    }

}

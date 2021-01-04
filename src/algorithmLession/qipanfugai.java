package algorithmLession;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class qipanfugai{

    static int num_l = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int testCaseNum = sc.nextInt();
            while(testCaseNum-- > 0){
                num_l = 1;
                int length = (int)Math.pow(2,sc.nextInt());
                int[][] chess = new int[length][length];
                int special_x = sc.nextInt();
                int special_y = sc.nextInt();
                int x = sc.nextInt();
                int y = sc.nextInt();
                chess[special_x][special_y] = num_l;
                paintChess(chess,0,0,length,special_x,special_y);
                //printChess(chess);
                search(chess,x,y);
            }
        }
    }


    private static void search(int[][] chess,int x,int y){
        List<Integer> res = new ArrayList<>(4);
        int length = chess.length;
        int top = x - 1 >= 0 ? x - 1 : x;
        int bottom = x + 1 < length ? x + 1 : length - 1;
        int left = y - 1 >= 0 ? y - 1 : y;
        int right = y + 1 < length ? y + 1 : length - 1;
        for(int i = top ; i <= bottom ; i++){
            for(int j = left ; j <= right ; j++){
                if(i == x && j == y)
                    continue;
                if(chess[i][j] == chess[x][y]){
                    res.add(i);
                    res.add(j);
                }
            }
        }
        int x1 = res.get(0);
        int y1 = res.get(1);
        int x2 = res.get(2);
        int y2 = res.get(3);
        System.out.println(x1+ " " + y1 + "," + x2 + " " +y2);

    }

    private static void printChess(int[][] chess){
        for(int[] row : chess){
            for(int i : row){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void paintChess(int[][] chess,int begin_x,int begin_y,int size,int special_x,int special_y){
        if(size == 1)
            return;
        int s = size / 2;
        int color = ++num_l;
        // 特殊点在左上区域
        if(special_x < begin_x + s && special_y < begin_y + s){
            paintChess(chess,begin_x,begin_y,s,special_x,special_y);
        }
        else {
            chess[begin_x + s - 1][begin_y + s - 1] = color;
            paintChess(chess,begin_x,begin_y,s,begin_x + s - 1,begin_y + s - 1);
        }


        // 右上
        if(special_x < begin_x + s && special_y >= begin_y + s){
            paintChess(chess,begin_x,begin_y + s,s,special_x,special_y);
        }
        else {
            chess[begin_x + s - 1][begin_y + s ] = color;
            paintChess(chess,begin_x,begin_y + s,s,begin_x + s,begin_y + s - 1);
        }

        // 左下
        if(special_x >= begin_x + s && special_y < begin_y + s){
            paintChess(chess,begin_x + s,begin_y,s,special_x,special_y);
        }
        else {
            chess[begin_x + s][begin_y + s - 1] = color;
            paintChess(chess,begin_x + s,begin_y,s,begin_x + s,begin_y + s - 1);
        }

        // 右下
        if(special_x >= begin_x + s && special_y >= begin_y + s){
            paintChess(chess,begin_x + s,begin_y + s,s,special_x,special_y);
        }
        else {
            chess[begin_x + s][begin_y + s] = color;
            paintChess(chess,begin_x + s,begin_y + s,s,begin_x + s,begin_y + s);
        }


    }

}

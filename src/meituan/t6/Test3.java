package meituan.t6;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            String[] s = sc.nextLine().split(" ");
            for(int j = 0 ; j < m ; j++){
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }
        getMin(matrix,n,m);

    }

    private static void getMin(int[][] matrix,int n,int m){
        for(int i = 1 ; i < n ; i++){
            if(n % i != 0)
                continue;
            if(judge(matrix,i,m)) {
                for(int a = 0 ; a < i ; a++){
                    for(int b = 0 ; b < m ; b++){
                        System.out.print(matrix[a][b]+" ");
                    }
                    System.out.println();
                }
                break;
            }

        }
    }


    private static boolean judge(int[][] matrix,int len,int m){
        int[][] one = new int[len][m];
        for(int i = 0 ; i < len ; i++){
            one[i] = matrix[i];
        }

        int[][] reverse = reverse(one,len,m);

        boolean flag = true;
        for(int i = 0 ; i < matrix.length ; i+=len){
            if(flag){
                if(!isSame(matrix,one,i,m))
                    return false;
            }
            else{
                if(!isSame(matrix,reverse,i,m)){
                    return false;
                }
            }
            flag = !flag;
        }
        return true;
    }


    private static boolean isSame(int[][] matrix,int[][] item,int row,int m){
        for(int i = row ; i < row + item.length ; i++){
            for(int j = 0 ; j < m ; j++ ){
                if(matrix[i][j] != item[i - row][j])
                    return false;
            }
        }
        return true;
    }

    private static int[][] reverse(int[][] matrix,int n,int m){
        int[][] res = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            res[i] = matrix[n - 1 - i];
        }
        return res;
    }

}

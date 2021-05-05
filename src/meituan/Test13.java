package meituan;

import java.util.Scanner;

public class Test13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int gain = sc.nextInt();
        int loss = sc.nextInt();
        sc.nextLine();
        int x = 0,y = 0;
        String[][] arr = new String[n][m];
        for(int i = 0 ; i < n ; i++){
            String s = sc.nextLine();
            for(int j = 0 ; j < m ; j++){
                if(s.charAt(j) == 'S'){
                    x = i;
                    y = j;
                    arr[i][j] = "0";
                }
                else if(s.charAt(j) == 'O'){
                    arr[i][j] = String.valueOf(gain);
                }
                else if(s.charAt(j) == 'X'){
                    arr[i][j] = String.valueOf(-loss);
                }
                else if(s.charAt(j) == '#'){
                    arr[i][j] = "#";
                }
                else{
                    arr[i][j] = "0";
                }
            }
        }

//        for(int i = 0 ; i < n ; i++){
//            for (int j =  0 ; j < m ; j++){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        int res = 0;
        String cmd = sc.nextLine();
        for(int i = 0 ; i < cmd.length() ; i++){
            if(cmd.charAt(i) == 'W'){
                if(x - 1 < 0 || arr[x - 1][y].equals("#"))
                    continue;
                x--;
                res += Integer.parseInt(arr[x][y]);
                arr[x][y] = "0";
            }
            else if(cmd.charAt(i) == 'A'){
                if(y - 1 < 0 || arr[x][y - 1].equals("#"))
                    continue;
                y--;
                res += Integer.parseInt(arr[x][y]);
                arr[x][y] = "0";
            }
            else if(cmd.charAt(i) == 'D'){
                if(y + 1 >= m || arr[x][y + 1].equals("#"))
                    continue;
                y++;
                res += Integer.parseInt(arr[x][y]);
                arr[x][y] = "0";
            }
            else if(cmd.charAt(i) == 'S'){
                if(x + 1 >= n || arr[x + 1][y].equals("#"))
                    continue;
                x++;
                res += Integer.parseInt(arr[x][y]);
                arr[x][y] = "0";
            }
        }
        System.out.println(res);
    }
}

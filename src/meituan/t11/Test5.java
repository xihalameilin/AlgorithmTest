package meituan.t11;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1){
            System.out.println(1);
            return;
        }
        long day = sc.nextLong();
        sc.nextLine();
        int[][] arr = new int[n + 1][n + 1];
        for(int i = 0 ; i < n ; i++){
            String[] s = sc.nextLine().split(" ");
            for(int j = 0 ; j < n ; j++){
                arr[i + 1][j + 1] = Integer.parseInt(s[j]);
            }
        }
        if(day == 1) {
            System.out.println(1);
            return;
        }
        if(day == 2){
            System.out.println(2);
            return;
        }
        int before = 1;
        int now = 2;
        for(int k = 3 ; k <= day ; k++){
            int i = now;
            int j = before;
            int next = arr[i][j];
            before = now;
            now = next;
        }
        System.out.println(now);
    }
}

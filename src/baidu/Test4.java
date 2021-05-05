package baidu;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        for(int i = 1 ; i <= m ; i++)
            dp[i][i] = 1;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                for(int k = 1 ; k <= m ; k++) {
                    if (k == j) {
                        continue;
                    }
                    if (i - j >= 1)
                        dp[i][j] += dp[i - j][k];
                }
            }
        }
        int sum = 0;
        for(int i = 1 ; i <= m ; i++){
            sum += dp[n][i];
        }
        System.out.println(sum);
    }

}

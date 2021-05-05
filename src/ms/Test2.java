package ms;

public class Test2 {
    public static void main(String[] args) {
        for(int i = 0 ; i < 15 ; i++){
            for(int j = 0 ; j < 10 ;j++) {
                int x = (int) (Math.random() * 100) - 50;
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    private static int get(int n,int len){
        int[][] dp = new int[n + 1][len];
        dp[0][0] = 1;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < len ; j++){
                dp[i][j] = dp[i - 1][(j - 1 + len) % len] + dp[i - 1][(j + 1) % len];
            }
        }
        System.out.println(dp[n][0]);
        return dp[n][0];
    }
}

package algorithmLession;

import java.util.Scanner;

public class xuhaochengfang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseNum = sc.nextInt();
        while (testCaseNum-- > 0 ){
            long p = sc.nextLong();
            kill(p);
        }


    }

    private static void kill(long p){
        long ans = 0;
        long low = 0;
        long high = 144224;
        long mid;
        while(low <= high){
            mid = (high - low) / 2 + low;
            if(mid * (mid + 1) * (2 * mid + 1) / 6 > p){
                high = mid - 1;
            }
            else{
                ans = mid;
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }
}

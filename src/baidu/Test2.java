package baidu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        String s = sc.nextLine();
        //最早出现的位置
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            arr[i] = s.charAt(i) - '0';
            if(!map.containsKey(arr[i])){
                map.put(arr[i],i);
            }
        }

        int[] dp = new int[n];
        //Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i = 0 ; i < n ; i++){
            if(i > 0)
                dp[i] = dp[i - 1] + 1;
            int num = arr[i];
            if(map.containsKey(num) && map.get(num) < i)
                dp[i] = Math.min(dp[map.get(num)] + 1,dp[i]);
        }
        System.out.println(dp[n - 1]);
    }
}

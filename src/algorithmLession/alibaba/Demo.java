package algorithmLession.alibaba;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[][] points = new int[count][2];
        for(int i = 0 ; i < count ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[] t = new int[]{x,y};
            points[i] = t;
        }
        List<int[]> res = new ArrayList<>();
        for(int i = 0 ; i < count ; i++){
            boolean flag = false;
            for(int j = 0 ; j < count ; j++){
                if(points[j][0] > points[i][0] && points[j][1] > points[i][1]){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                res.add(points[i]);
            }
            Collections.sort(res,(a,b)->(a[0] - b[0]));
        }
        res.stream().forEach(i -> System.out.println(i[0] +" "+ i[1]));
    }

    public static String minWindow(String s, String t) {
        Map<Character,Integer> target = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(int i = 0 ; i < t.length() ; i++){
            char c = t.charAt(i);
            if(target.containsKey(c)){
                int num = target.get(c);
                target.put(c,num + 1);
            }
            else{
                target.put(c,1);
            }
        }
        int left = 0;
        int right = -1;
        int len = Integer.MAX_VALUE;
        String res = new String();
        while(left < s.length() && right < s.length() - 1){
            right++;
            char c = s.charAt(right);
            if(window.containsKey(c)){
                int num = window.get(c);
                window.put(c,num + 1);
            }else{
                window.put(c,1);
            }

            while(check(window,target)){
                if(right - left + 1 < len) {
                    len = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                char cc = s.charAt(left);
                int num = window.get(cc);
                num--;
                if(num < 0)
                    num = 0;
                window.put(cc,num);
                left++;
            }
        }
        System.out.println(res);
        return res;
    }

    private static boolean check(Map<Character,Integer> window,Map<Character,Integer> target){
        for(char c : target.keySet()){
            if(window.get(c) == null ||window.get(c) < target.get(c)){
                return false;
            }
        }
        return true;
    }

    private static int getMax(String[] arr){
        int dp[] = new int[arr.length];
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        int res = arr[0].length();
        dp[0] = arr[0].length();
        for(int i = 1 ; i < arr.length ; i++){
            int preMaxLen = 0;
            for(int j = i - 1 ; j >= 0 ; j--){
                if(arr[i].charAt(0) > arr[j].charAt(arr[j].length() - 1)){
                    preMaxLen = Math.max(preMaxLen,dp[j]);
                    dp[i] = Math.max(dp[j] + arr[i].length() , dp[i]);
                }
                else{
                    dp[i] = Math.max(arr.length , dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
        return res;
    }
}

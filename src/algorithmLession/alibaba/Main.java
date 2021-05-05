package algorithmLession.alibaba;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;
public class Main {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()) {
//            int testCaseCount = sc.nextInt();
//            int[] arr = new int[testCaseCount];
//            int max = 0;
//            for (int i = 0; i < testCaseCount; i++) {
//                arr[i] = sc.nextInt();
//                max = Math.max(max, arr[i]);
//            }
//
//
//            long[] dp = new long[max + 1];
//            dp[1] = 12;
//            long a = 6, b = 6;
//            for (int i = 2; i <= max; i++) {
//                long t1 = a * 3 + b * 2;
//                long t2 = a * 2 + b * 2;
//                a = t1;
//                b = t2;
//                dp[i] = (a + b) % (int) (Math.pow(10, 9) + 7);
//            }
//
//
//            for (int i = 0; i < testCaseCount; i++) {
//                System.out.println(dp[arr[i]]);
//            }
//        }
//    }


    public static void main(String[] args) {
        System.out.println(solution("H"));
        System.out.println(solution("HH-HH"));
        System.out.println(solution("-H-H-H-H-H"));
        System.out.println(solution("-"));
        System.out.println(solution("-H-HH-"));
        System.out.println(solution("HHHHHHH"));
    }



    private static int solution(String s){
        char[] arr = s.toCharArray();
        int res = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != 'H'){
                continue;
            }

            if(i == 0){
                if(i + 1 >= arr.length)
                    return -1;
                if( arr[i + 1] == '-'){
                    arr[i + 1] = 'T';
                    res++;
                }
                else if(arr[i  + 1] == 'H'){
                    return -1;
                }
            }
            else if(i == arr.length - 1){
                if( arr[i - 1] == '-'){
                    arr[i - 1] = 'T';
                    res++;
                }
                else if(arr[i  - 1] == 'H'){
                    return -1;
                }
            }

            else if(arr[i - 1] == 'T' || arr[i + 1] == 'T'){
                continue;
            }
            else if(arr[i - 1] == '-' && arr[i + 1] == 'H'){
                arr[i - 1] = 'T';
                res++;
            }
            else if(arr[i - 1] == 'H' && arr[i + 1] == '-'){
                arr[i + 1] = 'T';
                res++;
            }
            else if(arr[i - 1] == '-' && arr[i + 1] == '-'){
                arr[i + 1] = 'T';
                res++;
            }
            else if(arr[i - 1] == 'H' && arr[i + 1] == 'H'){
                return -1;
            }
        }
        for(char c : arr){
            System.out.print(c);
        }
        System.out.println();

        return res;
    }
}

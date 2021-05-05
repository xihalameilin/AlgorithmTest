package meituan;

import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseNum = sc.nextInt();
        sc.nextLine();
        while(testCaseNum-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt();
            }
            int[] res = getMax2(arr);
            System.out.println(Math.max(res[0],res[2]-res[1]));
        }
    }

    private static int[] getMax2(int[] arr){
        int n = arr.length;
        int max = 0;
        int min = 0;
        int temp = 0;
        int temp2 = 0;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(temp < 0){
                temp = 0;
            }
            if(temp2 > 0)
                temp2 = 0;
            temp += arr[i];
            temp2 += arr[i];
            max = Math.max(max,temp);
            min = Math.min(min,temp2);
            sum += arr[i];
        }
        return new int[]{max,min,sum};
    }

    private static int getMin2(int[] arr){
        int n = arr.length;
        int res = 0;
        int temp = 0;
        for(int i = 0 ; i < n ; i++){
            if(temp > 0){
                temp = 0;
            }
            temp += arr[i];
            res = Math.min(res,temp);
        }
        return res;
    }

    private static int getMax(int[] arr,int begin){
        int n = arr.length;
        int end = (begin - 1 + n) % n;
        int temp = 0;
        int i = begin;
        int res = 0;
        while(i != end){
            if(temp < 0){
                temp = 0;
            }
            temp += arr[i];
            res = Math.max(res,temp);
            i = (i + 1) % n;
        }
        if(temp < 0)
            temp = 0;
        res = Math.max(res,temp + arr[end]);
        return res;
    }
}

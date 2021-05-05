package meituan.t6;

import java.util.Scanner;


public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++ ){
            arr[i] = sc.nextInt();
        }
        int res = 0;
        for(int i = 0 ; i < n - m + 1 ; i++){
            if(isValid(arr,i,m,k)){
                res++;
            }
        }
        System.out.println(res);
    }

    private static boolean isValid(int[] arr,int left,int m,int k){
        for(int i = left ; i < left + m ; i ++){
            if(arr[i] < k)
                return false;
        }
        return true;
    }

}

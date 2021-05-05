package meituan.t5;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int res = 0;
        for(int i = 0 ; i < n ; i++){
            res = res ^ (cal(arr[i],n,i + 1));
        }
        System.out.println(res);
    }

    private static int cal(int a,int n,int i){
        int res = a;
        for(int j = 1 ; j <= n ; j ++){
            res = res ^ (i % j);
        }
        return res;
    }
}

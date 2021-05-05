package meituan.t6;

import java.util.Scanner;

public class Test2 {
    static int count = 0;
    static int top = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int d = sc.nextInt();
        top = d;
        help(n,k,Integer.MIN_VALUE);
        System.out.println(count);
    }

    private static void help(int left,int k,int max){
        if(left < 0)
            return;
        if(left == 0){
            if(max >= top){
                count = (count + 1) % 998244353;
            }
            return;
        }

        for(int i = 1 ; i <= k ; i++){
            help(left - i , k , Math.max(max,i));
        }
    }
}

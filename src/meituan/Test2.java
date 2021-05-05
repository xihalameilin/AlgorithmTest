package meituan;


import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr =  new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int times = 0;
        for(int i = 0 ; i < n ; i++){
            times += Math.abs(i + 1 - arr[i]);
        }
        System.out.println(times);

    }
}

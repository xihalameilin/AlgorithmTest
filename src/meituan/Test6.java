package meituan;


import java.util.Arrays;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr,(o1,o2)->o2-o1);
        int res = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] >= arr[x - 1] && arr[i] > 0){
                res++;
            }
        }
        System.out.println(res);


    }
}

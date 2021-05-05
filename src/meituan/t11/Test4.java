package meituan.t11;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int max = calculate(arr,m);
        if(max % c == 0)
            System.out.println(max / c);
        else
            System.out.println(max / c + 1);

    }

    private static int calculate(int[] arr,int people){
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++){
            max += arr[i];
        }

        int low = 0,high = max;
        while(low < high){
            int mid = low + (high - low ) / 2;
            if(isEnough(arr,people,mid)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean isEnough(int[] arr,int people,int height){
        int sum = 0;
        int need = 1;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > height)
                return false;
            if(sum + arr[i] <= height){
                sum += arr[i];
            }
            else{
                sum = arr[i];
                need++;
            }
        }
        return need <= people;
    }
}

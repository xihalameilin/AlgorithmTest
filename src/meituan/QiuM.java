package meituan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QiuM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);

        }
        Arrays.sort(arr);
        int sum = 0;
        for(int i = arr[0] ; i < arr[n - 1] ; i++){
            if(map.containsKey(i))
                sum += map.get(i);
            if(sum >= x && sum <= y && n - sum >= x && n - sum <= y){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}

package meituan.t11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1){
            System.out.println(1);
            return;
        }
        long day = sc.nextLong();
        sc.nextLine();
        int[][] arr = new int[n + 1][n + 1];
        for(int i = 0 ; i < n ; i++){
            String[] s = sc.nextLine().split(" ");
            for(int j = 0 ; j < n ; j++){
                arr[i + 1][j + 1] = Integer.parseInt(s[j]);
            }
        }
        if(day == 1) {
            System.out.println(1);
            return;
        }
        if(day == 2){
            System.out.println(2);
            return;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int before = 1;
        int now = 2;
        while(true){
            int i = now;
            int j = before;
            int next = arr[i][j];
            list.add(next);
            before = now;
            now = next;
            if(before == 1 && now == 2){
                break;
            }
        }
        long len = day % (list.size() - 2);
        if(len == 0){
            System.out.println(list.get(list.size() - 1 - 2));
            return;
        }
        System.out.println(list.get((int)len - 1));
    }
}

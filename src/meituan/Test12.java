package meituan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Test12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        count(low,high);
    }

    private static int count(int low,int high){
        int res = 0;
        for(int i = low ; i <= high ; i++){
            if(isValid(i))
                res++;
        }
        System.out.println(res);
        return res;
    }

    private static boolean isValid(int x){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 6 ; i++){
            list.add(0,x % 10);
            x = x / 10;
        }
        if(new HashSet<>(list).size() < 6 )
            return false;
        if(list.get(0) == 0 || list.get(2) == 0 || list.get(4) == 0)
            return false;
        return list.get(0) * 10 + list.get(1) + list.get(2) * 10 + list.get(3)
                == list.get(4) * 10 + list.get(5);
    }
}

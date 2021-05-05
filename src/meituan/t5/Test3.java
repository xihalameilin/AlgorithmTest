package meituan.t5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < p ; i++){
            set.add(sc.nextInt());
        }
        sc.nextLine();
        int common = 0;
        for(int i = 0 ; i < q ; i++){
            if(set.contains(sc.nextInt())){
                common++;
            }
        }
        System.out.println((p - common) + " " + (q - common) + " " + common);
    }
}

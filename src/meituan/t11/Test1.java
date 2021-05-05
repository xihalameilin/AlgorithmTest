package meituan.t11;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String target = sc.nextLine();
        long res = 0;
        int j = 0;
        int index = 0;
        while(j != target.length()){
            if(s.charAt(index) != target.charAt(j)){
                res++;
            }
            else{
                j++;
            }
            index++;
            index = index % 26;
        }
        System.out.println(res);
    }
}

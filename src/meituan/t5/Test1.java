package meituan.t5;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int up = 0;
        int down = 0;
        for(char c : s.toCharArray()){
            if(c >= 'a' && c <= 'z'){
                down ++;
            }
            else{
                up++;
            }
        }
        System.out.println(Math.abs(up-down) / 2);
    }
}

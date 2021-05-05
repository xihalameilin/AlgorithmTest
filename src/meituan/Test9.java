package meituan;

import java.util.Scanner;

public class Test9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int temp = 0;
        int res = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(temp < 0){
                temp = 0;
            }
            if(s.charAt(i) == 'E'){
                temp++;
            }
            else{
                temp--;
            }
            res = Math.max(res,temp);
        }
        System.out.println(res);
    }
}

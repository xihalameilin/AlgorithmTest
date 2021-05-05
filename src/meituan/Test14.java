package meituan;


import java.util.Scanner;

public class Test14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String t = sc.nextLine();
        int j = 0;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == t.charAt(j)){
                j++;
                sum += i + 1;
            }
        }
        if(j == m){
            System.out.println("Yes");
            System.out.println(sum);
        }
        else{
            System.out.println("No");
        }

    }
}


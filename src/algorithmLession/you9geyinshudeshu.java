package algorithmLession;

import org.omg.CORBA.MARSHAL;

import java.util.Scanner;

public class you9geyinshudeshu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            System.out.println(count(n));
        }
    }

    private static int count(int n){
        int res = 0;
        for(int i = 6; i * i < n ; i++){
            if(judge(i * i)){
                res++;
            }
        }
        return res;
    }

    private static boolean judge(int n){
        int res = 0;
        for(int i = 1 ; i < Math.sqrt(n); i++){
            if(n % i == 0)
                res += 2;
        }
        int sqrt = (int)Math.sqrt(n);
        if(sqrt * sqrt == n) {
            res++;
        }
        return res == 9;
    }
}

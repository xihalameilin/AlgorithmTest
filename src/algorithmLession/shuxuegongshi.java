package algorithmLession;

import java.util.Scanner;

public class shuxuegongshi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseNum = sc.nextInt();
        while(testCaseNum-- > 0){
            int x = sc.nextInt();
            int e = sc.nextInt();
            int a = sc.nextInt();
            System.out.println(getPow(x,e,a)%a);
        }
    }

    private static int getPow(int x,int e,int a){
        if(e == 0)
            return 1;
        int y = getPow(x,e/2,a);
        if((e & 1) == 1)
            return y * y *x % a;
        else
            return y * y % a;
    }
}

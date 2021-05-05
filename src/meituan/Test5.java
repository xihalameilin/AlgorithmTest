package meituan;


import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] firstLine = sc.nextLine().split(" ");
            String[] secondLine = sc.nextLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int m = Integer.parseInt(firstLine[1]);
            int min = Math.min(Integer.parseInt(firstLine[2]),Integer.parseInt(firstLine[3]));
            int max = Math.max(Integer.parseInt(firstLine[2]),Integer.parseInt(firstLine[3]));
            int[] arr = new int[m];
            int min_al = Integer.MAX_VALUE;
            int max_al = Integer.MIN_VALUE;
            for(int i = 0 ; i < m ; i++){
                arr[i] = Integer.parseInt(secondLine[i]);
                max_al = Math.max(max_al,arr[i]);
                min_al = Math.min(min_al,arr[i]);
            }
            if(min_al < min || max_al > max){
                System.out.println("NO");
            }
            else{
                int res = 2;
                if(max_al == max)
                    res--;
                if(min_al == min)
                    res--;
                if(n - m >= res)
                    System.out.println("YES");
                else
                    System.out.println("NO");

            }


        }
    }
}

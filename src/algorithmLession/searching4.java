package algorithmLession;

import javafx.beans.binding.DoubleExpression;

import java.util.Scanner;

public class searching4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            int n = Integer.parseInt(sc.nextLine());
            String[] strings = sc.nextLine().split(" ");
            int[] arr = new int[n];
            for(int i = 0 ; i < strings.length ; i++){
                arr[i] = Integer.parseInt(strings[i]);
            }

            for(int i = 0 ; i < arr.length - 1 ; i++){
                double res = calculate(arr,i);
                double ret = (double)Math.round(res*100)/100;
                System.out.print(String .format("%.2f",ret));
                if(i != arr.length - 2)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }


    private static double calculate(int arr[],int index){
        double left = arr[index];
        double right = arr[index + 1];
        double delta = 0.0000000000001;
        double mid = 0;
        while(true){
            mid = left + (right - left) / 2.0;
            //System.out.println(mid);
            double f1 = 0.0;
            double f2 = 0.0;
            for(int i = 0 ; i <= index ; i++){
                f1 += 1.0 / (mid - arr[i]);
            }
            for(int i = index + 1 ; i < arr.length ; i++){
                f2 += 1.0 / (arr[i] - mid);
            }

            if(f1 - f2 > delta){
                left = mid;
            }
            else if(f2 - f1 > delta) {
                right = mid;
            }
            else
                break;
        }
        return mid;
    }
}

package algorithmLession.homework3;

import java.util.Scanner;

public class zhengshuchaxun {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0){
      t--;
      int n = sc.nextInt();
      int m = sc.nextInt();
      int a[] = new int[n];
      for(int i = 0;i < n;i++){
        a[i] = sc.nextInt();
      }
      for(int i = 0;i < m;i++){
        int b = sc.nextInt();
        int ret = 0;
        for(int j = 0;j < n;j++){
          if(a[j] % b == 0){
            ret++;
          }
        }
        if(i != m-1) {
          System.out.print(ret + " ");
        }else {
          System.out.print(ret);
        }
      }
      System.out.println();
    }
  }

}

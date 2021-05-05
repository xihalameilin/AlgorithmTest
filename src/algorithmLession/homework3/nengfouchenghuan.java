package algorithmLession.homework3;

import java.util.Scanner;

public class nengfouchenghuan {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0){
      t--;
      int n = sc.nextInt();
      if(n == 0){
        System.out.println(0);
        continue;
      }else if(n == 1){
        String s = sc.next();
        if(s.charAt(0) == s.charAt(s.length()-1)){
          System.out.println(1);
        }else {
          System.out.println(0);
        }
        continue;
      }
      char a[][] = new char[n][2];
      for(int i = 0;i < n;i++){
        String str = sc.next();
        a[i][0] = str.charAt(0);
        a[i][1] = str.charAt(str.length() - 1);
      }
      int b[] = new int[n];
      System.out.println(solve(a,n,0,0,b));

    }
  }

  private static int solve(char[][] a, int n,int p, int num, int[] b) {
    if(num == n){
      return 1;
    }
    for(int i = 0;i < n;i++){
      if(b[i] == 0 && i != p){
        if(a[p][1] == a[i][0]){
          b[i] = 1;
          int k = solve(a,n,i,num+1,b);
          if(k == 1){
            return 1;
          }
          b[i] = 0;
        }
      }
    }
    return 0;
  }

}

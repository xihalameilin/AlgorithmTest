package algorithmLession.homework3;

import java.util.Scanner;

public class zijuzhen {
  private static int maxn;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0){
      t--;
      int n = sc.nextInt(),m = sc.nextInt();
      int a[][] = new int[n][m];
      for(int i = 0;i < n;i++){
        for(int j = 0;j < m;j++){
          a[i][j] = sc.nextInt();
        }
      }
      maxn = 0;
      for(int i = 0;i < n;i++){
        for(int j = 0;j < m;j++){
          if(a[i][j] == 1){
            solve(a,i,j,i-1,j,0);
            solve(a,i,j,i,j-1,0);
          }
        }
      }
      System.out.println(maxn);
    }
  }

  private static void solve(int[][] a, int i, int j, int p, int q, int num) {
    if(p < 0 || q < 0){
      return;
    }
    for(int w = p;w <= i;w++){
      for(int e = q;e <= j;e++){
        if(a[w][e] == 0){
          return;
        }
      }
    }
    int t = (i+1-p)*(j+1-q);
    if(t > maxn){
      maxn = t;
    }
    solve(a,i,j,p-1,q,num);
    solve(a,i,j,p,q-1,num);
  }
}

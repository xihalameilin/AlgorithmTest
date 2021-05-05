package algorithmLession.homework3;

import java.util.Scanner;

public class duichengzifuchuan {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while (t > 0){
      t--;
      String str = sc.nextLine();
      int k = str.length() / 2;
      int leftSum[][] = new int[str.length()][str.length()+2];
      for(int i = 0;i < str.length();i++){
        for(int j = 0;j < str.length()+2;j++){
          leftSum[i][j] = -1;
        }
      }
      while (k > 0){
        int f = 0;
        for(int i = 0;i+2*k <= str.length();i++){
          if(leftSum[i][k] == -1){
            int ret = 0;
            for(int j = i;j < i+k;j++){
              ret += str.charAt(j)-'0';
              leftSum[i][j-i+1] = ret;
            }
          }
          if(leftSum[i+k][k] == -1){
            int ret = 0;
            for(int j = i+k;j < i+k*2;j++){
              ret += str.charAt(j)-'0';
              leftSum[i+k][j-i-k+1] = ret;
            }
          }
          if(leftSum[i][k] == leftSum[i+k][k]){
            f = 1;
            break;
          }
        }
        if(f == 1){
          break;
        }
        k--;
      }
      System.out.println(k*2);
    }
  }
}

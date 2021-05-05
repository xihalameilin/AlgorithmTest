package algorithmLession.homework3;

import java.util.Scanner;

public class shuzichongzuzhenghewenti {
  private static int maxn;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0){
      t--;
      String n = sc.next();
      int i = 0;
      while (i < n.length() && n.charAt(i) == '0'){
        i++;
      }
      if(i == n.length()){
        System.out.println("Not Possible");
        continue;
      }
      n = n.substring(i);
      maxn = -1;
      int a[] = new int[n.length()];
      solve(n,"",a);
      if(maxn != -1) {
        System.out.println(maxn);
      }else {
        System.out.println("Not Possible");
      }
    }
  }

  private static void solve(String n,String str,int a[]) {
    if(str.length() == n.length()){
      if(Integer.parseInt(str) % 17 == 0 && Integer.parseInt(str) > maxn){
        maxn = Integer.parseInt(str);
      }
    }else {
      for(int i = 0;i < n.length();i++){
        if(a[i] == 0) {
          a[i] = 1;
          String s = str + n.charAt(i);
          solve(n, s,a);
          a[i] = 0;
        }

      }
    }
  }

}

package algorithmLession.homework3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class zuichanggonggongzixulie {

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while (t > 0){
      t--;
      String s1 = sc.nextLine();
      String s2 = sc.nextLine();
      if(s1.length() == 0 || s2.length() == 0){
        continue;
      }
      if(s1.length() > s2.length()){
        String q = s1;
        s1 = s2;
        s2 = q;
      }
      int dist[] = new int[s1.length()];
      List<String> ret = new ArrayList<>();
      solve(dist,0,0,s1,s2,ret,0);
      ret.sort(Comparator.naturalOrder());
      for(String s : ret){
        System.out.println(s);
      }
    }
  }

  private static void solve(int[] dist, int i, int j, String s1, String s2, List<String> ret,int maxLen) {
    if(i == s1.length()){
      if(ret.size() == 0 || ret.get(0).length() == maxLen){
        StringBuilder sb = new StringBuilder();
        for(int k = 0;k < dist.length;k++){
          if(dist[k] != 0){
            sb.append(s1.charAt(k));
          }
        }
        ret.add(sb.toString());
      }else if(ret.get(0).length() < maxLen){
        ret.clear();
        StringBuilder sb = new StringBuilder();
        for(int k = 0;k < dist.length;k++){
          if(dist[k] != 0){
            sb.append(s1.charAt(k));
          }
        }
        ret.add(sb.toString());
      }
      return;
    }
    int k = j;
    for(;k < s2.length();k++){
      if(s2.charAt(k) == s1.charAt(i)){
        dist[i] = maxLen+1;
        solve(dist,i+1,k+1,s1,s2,ret,maxLen+1);
        dist[i] = 0;
      }
    }
    solve(dist,i+1,j,s1,s2,ret,maxLen);
  }
}

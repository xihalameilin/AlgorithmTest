package algorithmLession.homework3;

import java.util.Scanner;

public class hezuidalianxujiangxu {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-->0) {
      char[] s = sc.next().toCharArray();
      boolean[] ch = new boolean[26];
      for(int i = 0; i<s.length; i++)
        ch[s[i]-'A'] = true;
      String res = "";
      for(int i = 1; i<26; i++) {
        for(int j = 25; j>=0; j--) {
          if(ch[j]) {
            String temp = "";
            temp+=(char)('A'+j);
            for(int k = j-i; k>=0; k-=i) {
              if(ch[k])
                temp+=(char)('A'+k);
              else
                break;
            }
            if(temp.length()>res.length())
              res = temp;
          }
        }
      }
      System.out.println(res);
    }
  }
}

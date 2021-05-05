package algorithmLession.homework3;

import java.util.PriorityQueue;
import java.util.Scanner;

public class qujiandikxiao {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    while (t > 0){
      t--;
      String str[] = sc.nextLine().split(" ");
      int a[] = new int[str.length];
      for(int i = 0;i < str.length;i++){
        a[i] = Integer.parseInt(str[i]);
      }
      String[] lr = sc.nextLine().split(" ");
      int l = Integer.parseInt(lr[0]) - 1,r = Integer.parseInt(lr[1])-1;
      int k = Integer.parseInt(sc.nextLine());
      PriorityQueue<Integer> que = new PriorityQueue<>((o1,o2) -> o2-o1);
      for(int i = l;i <= r;i++){
        if(que.isEmpty() || que.size() < k){
          que.offer(a[i]);
        }
        else if(que.peek() > a[i]){
          que.poll();
          que.offer(a[i]);
        }
      }
      System.out.println(que.peek());
    }
  }
}

package wy;

import baidu.MapDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test3 {
  static int max = Integer.MIN_VALUE;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String[] s = sc.nextLine().split(" ");
    int arr[] = new int[n];
    List<List<Integer>> list = new ArrayList<>();
    for(int i = 0 ; i < 6 ; i++){
      list.add(new ArrayList<>());
    }
    for(int i = 0 ; i < n ; i++){
      int x = Integer.parseInt(s[i]);
      list.get(x % 6).add(x);
    }
    int res = 0;
    for(int i = 0 ; i < 6 ; i++){
      Collections.sort(list.get(i),((o1, o2) -> (o2-o1)));
    }

    for(int i = 0 ; i < list.get(0).size() ; i++){
      if(list.get(0).get(i) > 0)
        res += list.get(0).get(i);
    }

    int ptr = 0;
    while(ptr < list.get(1).size() &&
      ptr < list.get(5).size()&&
      list.get(1).get(ptr) + list.get(5).get(ptr) > 0){
      res += list.get(1).get(ptr);
      res += list.get(5).get(ptr);
      ptr++;
    }

    ptr = 0;
    while(ptr < list.get(2).size() &&
      ptr < list.get(4).size()&&
      list.get(2).get(ptr) + list.get(4).get(ptr) > 0){
      res += list.get(2).get(ptr);
      res += list.get(4).get(ptr);
      ptr++;
    }

    List<Integer> temp = new ArrayList<>();
    for(int i = 0 ; i < list.get(3).size() ; i++){
      if(list.get(3).get(i) > 0){
        temp.add(list.get(3).get(i));
        res += list.get(3).get(i);
      }
    }

    if(temp.size() % 2 == 1){
      res -= temp.get(temp.size() - 1);
    }
    System.out.println(res == 0 ? -1 : res);
  }


  private static void backtrace(int[] arr,int begin,int sum){
    if(sum % 6 == 0)
      max = Math.max(sum,max);
    for(int i = begin ; i < arr.length ; i++){
      backtrace(arr,i + 1,sum + arr[i]);
    }
  }

}

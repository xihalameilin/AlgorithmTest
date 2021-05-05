package wy;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String[] s = sc.nextLine().split(" ");
    int[] arr = new int[n];
    for(int i = 0 ; i < n ; i++){
      arr[i] = Integer.parseInt(s[i]);
    }

    int res = 0;
    for(int i = 1 ; i < arr.length ; i++){
      res = Math.max(res,getMax(arr,i));
    }
    System.out.println(res);

  }

  private static int getMax(int[] arr,int begin){
    int count = 2;
    List<Boolean> list = new ArrayList<>();
    //第一个位置
    if(arr[begin] > arr[begin - 1])
      list.add(true);
    else if(arr[begin] == arr[begin - 1]){
      return 0;
    }
    else{
      list.add(false);
    }
    for(int i = begin + 1 ; i < arr.length ; i++){
      if(arr[i] == arr[i - 1]){
        break;
      }

      //第二个位置
      if(i == begin + 1){
        if(list.get(list.size() - 1)){
          if(arr[i] <= arr[ i - 1]) {
            break;
          }
        }
        if(!list.get(list.size() - 1)){
          if(arr[i] >= arr[i - 1])
            break;
        }
        list.add(arr[i] > arr[i - 1]);
      }
      else{
        boolean cur = arr[i] > arr[i - 1];
        if(cur == list.get(list.size() - 2)){
          return count - 1 > 4 ? count - 1 : 0;
        }
        list.add(arr[i] > arr[i - 1]);
      }
      count++;

    }
    return count > 4 ? count : 0;
  }
}

package baidu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        //数字最大索引
        Map<Integer,Integer> map = new HashMap<>();
        String s = sc.nextLine();
        for(int i = 0 ; i < n ; i++){
            arr[i] = s.charAt(i) - '0';
            map.put(arr[i],i);
        }

        int res = 0;
        int index = 0;
        while(index != n - 1){
            int num = arr[index];
            int can = map.get(num);
            if(can > index){
                index = can;
            }else{
                index++;
            }
            res++;
        }
        System.out.println(res);
    }
}

package meituan.t11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long m = sc.nextLong();
        sc.nextLine();
        long[] A = new long[n];
        Map<Long,Long> map = new HashMap();
        String[] s = sc.nextLine().split(" ");
        for(int i = 0 ; i < n ; i++){
            A[i] = Long.valueOf(s[i]);
        }
        String[] ss = sc.nextLine().split(" ");
        for(int i = 0 ; i < n ; i++){
            Long t = Long.valueOf(ss[i]);
            map.put(t,map.getOrDefault(t,0L) + 1);
        }


        for(int i = 1 ; i < Long.MAX_VALUE ; i++){
            if(judge(A,new HashMap<>(map),i,m)){
                System.out.println(i);
                break;
            }
        }

    }

    private static boolean judge(long[] arr,Map<Long,Long> map,int k,long m){
        for(int i = 0 ; i < arr.length ; i++){
            long temp = (arr[i] + k ) % m;
            if(!map.containsKey(temp))
                return false;
            else {
                long value = map.get(temp);
                if(value == 1)
                    map.remove(temp);
                else
                    map.put(temp,value - 1);
            }
        }
        return true;
    }
}

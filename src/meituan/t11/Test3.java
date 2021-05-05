package meituan.t11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long m = sc.nextLong();
        sc.nextLine();
        Map<Long,Long> A = new HashMap<>();
        Map<Long,Long> map = new HashMap();
        String[] s = sc.nextLine().split(" ");
        for(int i = 0 ; i < n ; i++){
           Long t = Long.valueOf(s[i]);
           A.put(t,A.getOrDefault(t,0L) + 1);
        }
        String[] ss = sc.nextLine().split(" ");
        for(int i = 0 ; i < n ; i++){
            Long t = Long.valueOf(ss[i]);
            map.put(t,map.getOrDefault(t,0L) + 1);
        }


        for(int i = 1 ; i < m ; i++){
            if(judge(new HashMap<>(A),new HashMap<>(map),i,m)){
                System.out.println(i);
                break;
            }
        }

    }

    private static boolean judge(Map<Long,Long> A,Map<Long,Long> map,int k,long m){
        Map<Long,Long> newMap = new HashMap<>();
        for(Map.Entry<Long,Long> entry : A.entrySet()){
            newMap.put((entry.getKey()+k) % m , entry.getValue());
        }
        for(Map.Entry<Long,Long> entry : newMap.entrySet()){
            if(!map.containsKey(entry.getKey()) || entry.getValue() != map.get(entry.getKey()))
                return false;
        }
        return true;
    }
}

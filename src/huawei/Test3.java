package huawei;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.equals("[]")){
            System.out.println(0);
            return;
        }
        String[] arr = s.substring(1,s.length() - 1).split(",");
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            int caps = Integer.parseInt(arr[i].trim());
            map.put(caps,map.getOrDefault(caps,0)+ 1);
        }
        int res = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            res += (key + 1) * ((val - 1 ) / (key + 1) + 1);
        }
        System.out.println(res);

    }
}

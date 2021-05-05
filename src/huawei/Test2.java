package huawei;

import baidu.MapDemo;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String target = sc.nextLine();
        int cur = Integer.parseInt(sc.nextLine());
        Map<Character,List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(map.get(s.charAt(i)) == null){
                map.put(s.charAt(i),new ArrayList<>());
            }
            map.get(s.charAt(i)).add(i);
        }

        int res = 0;
        int len = 0;
        while(len != target.length()){
            char c = target.charAt(len);
            int nextIndex = getMin(map.get(c),cur,s.length());
            res += Math.min(Math.abs(nextIndex - cur),Math.abs(cur + s.length() - nextIndex));
            cur = nextIndex;
            len++;
        }
        System.out.println(res);
    }

    private static int getMin(List<Integer> list,int cur,int max){
        int min = Integer.MAX_VALUE;
        int res = cur;
        for(int i : list){
            if(Math.abs(i - cur) < min){
                min = Math.abs(i - cur);
                res = i;
            }
            if(Math.abs(max + cur - i) < min){
                min = Math.abs(i - cur);
                res = i;
            }
        }
        return res;
    }
}

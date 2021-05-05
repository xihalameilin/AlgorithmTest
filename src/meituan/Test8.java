package meituan;

import java.util.*;

public class Test8 {
    static Map<Integer,Integer> origin = new HashMap<>();
    static Map<Integer,Integer> map = new HashMap<>();
    static boolean[] locked ;
    //小团借到的书
    static List<Integer> exits = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        locked = new boolean[n + 1];
        int m = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        while (q-- > 0){
            String[] cmd = sc.nextLine().split(" ");
            process(cmd);
        }
    }

    private static void process(String[] cmd){
        if(cmd[0].equals("1")){
            int x = Integer.parseInt(cmd[1]);
            int y = Integer.parseInt(cmd[2]);
            if(exits.indexOf(x) != -1)
                return;
            if(locked[y] || map.containsKey(x)){
                return;
            }
            map.put(x,y);
            origin.put(x,y);
        }
        else if(cmd[0].equals("2")){
            Integer x = Integer.parseInt(cmd[1]);
            locked[x] = true;
        }
        else if(cmd[0].equals("3")){
            Integer x = Integer.parseInt(cmd[1]);
            locked[x] = false;
        }
        else if(cmd[0].equals("4")){
            Integer x = Integer.parseInt(cmd[1]);
            if(!map.containsKey(x) || locked[map.get(x)] ){
                System.out.println(-1);
                return;
            }
            System.out.println(map.get(x));
            map.remove(x);
            exits.add(x);
        }
        else if(cmd[0].equals("5")){
            Integer x = Integer.parseInt(cmd[1]);
            if(exits.indexOf(x) != -1)
                return;
            map.put(x,origin.get(x));
        }

    }
}

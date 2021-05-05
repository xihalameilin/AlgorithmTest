package algorithmLession;

import java.util.*;

public class anzhaolingyigeshuzupaixu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String[] two = sc.nextLine().split(" ");
            int len1 = Integer.parseInt(two[0]);
            int len2 = Integer.parseInt(two[1]);
            String[] ori = sc.nextLine().split(" ");
            String[] standand = sc.nextLine().split(" ");
            List<Integer> list = new ArrayList<>(len1);

            for(int i = 0 ; i <len1 ; i++){
                list.add(Integer.valueOf(ori[i]));
            }

            Map<Integer,Integer> map = new HashMap<>();
            List<Integer> list2 = new ArrayList<>();
            for(int i = 0 ; i < len2 ; i++){
                map.put(Integer.parseInt(standand[i]),0);
                list2.add(Integer.parseInt(standand[i]));
            }


            List<Integer> append = new ArrayList<>();
            for(int i = 0 ; i < len1 ; i++){
                if(map.containsKey(list.get(i))){
                    map.put(list.get(i),map.get(list.get(i)) + 1);
                }
                else{
                    append.add(list.get(i));
                }
            }


            List<Integer> res = new ArrayList<>();
            for(int i = 0 ; i < len2 ; i++){
                int times = map.get(list2.get(i));
                for(int  j = 0 ; j < times ; j++){
                    res.add(list2.get(i));
                }
            }

            Collections.sort(append);
            res.addAll(append);
            for(int i : res){
                System.out.print(i + " ");
            }
            System.out.println();

        }

    }
}

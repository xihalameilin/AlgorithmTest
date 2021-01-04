package algorithmLession;

import java.util.*;
import java.util.stream.Collectors;

public class anzhaoshuzhigeshupaixu {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseNum = sc.nextInt();
        while (testCaseNum-- > 0){
            int num = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            while(num-- > 0){
                list.add(sc.nextInt());
            }
            sort(list);
        }
    }



    private static void sort(List<Integer> array){
        Map<Integer,Long> map = array.stream().collect(Collectors.groupingBy(x->x, Collectors.counting()));
        List<Map.Entry<Integer,Long>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            if(o1.getValue() == o2.getValue()){
                return o1.getKey() - o2.getKey();
            }
            return o2.getValue().compareTo(o1.getValue());
        });

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer,Long> entry : list){
            int key = entry.getKey();
            Long value = entry.getValue();
            while(value-- > 0) {
                sb.append(key + " ");
            }
        }
        System.out.println(sb.toString().trim());

    }
}

package algorithmLession;

import java.util.*;

public class hebingshuzu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int testCaseNum = Integer.parseInt(sc.nextLine());
            while (testCaseNum-- > 0) {
                int sum = Integer.parseInt(sc.nextLine());
                String[] arrays = sc.nextLine().split(" ");
                List<Integer> list = new ArrayList<>();
                Arrays.stream(arrays).forEach(item -> list.add(Integer.parseInt(item)));
                merge(list);
            }
        }
    }

    private static void merge(List<Integer> list){
        Collections.sort(list);
        list.forEach(integer -> System.out.print(integer+" "));
        System.out.println();
    }
}

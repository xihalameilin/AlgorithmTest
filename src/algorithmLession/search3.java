package algorithmLession;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class search3 {
   static class Pair{
        Long left;
        Long right;
        Long count;
        public Pair(Long left,Long right){
            this.left = left;
            this.right = right;
            this.count = right - left + 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            while (t-- > 0) {
                String[] two = sc.nextLine().split(" ");
                int n = Integer.parseInt(two[0]);
                int q = Integer.parseInt(two[1]);
                String[] strings = sc.nextLine().split(" ");
                List<Pair> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    Long left = Long.valueOf(strings[2 * i]);
                    Long right = Long.valueOf(strings[2 * i + 1]);
                    list.add(new Pair(left, right));
                }

                list.sort(((o1, o2) -> {
                    if(o1.left > o2.left)
                        return 1;
                    else if(o1.left < o2.left)
                        return -1;
                    else
                        return 0;
                }));

                String[] qs = sc.nextLine().split(" ");
                for (int i = 0; i < q; i++) {
                    Long sum = 0L;
                    Long target = Long.valueOf(qs[i]);
                    //System.out.println(target);
                    for (int j = 0; j < list.size(); j++) {
                        Pair cur = list.get(j);
                        sum += cur.count;
                        if (target <= sum) {
                            if(i == q - 1){
                                System.out.print((cur.right - (sum - target)));
                                break;
                            }
                            System.out.print((cur.right - (sum - target)) + " ");
                            break;
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}

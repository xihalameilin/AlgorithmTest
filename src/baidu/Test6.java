package baidu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test6 {
    //tx no.3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<ArrayList<Long>> arr = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            arr.add(new ArrayList<>());
            String[] s = sc.nextLine().split(" ");
            for(int j = 1 ; j < s.length ; j++){
                arr.get(i).add(Long.valueOf(s[j]));
            }
        }
        int q = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i < q ; i++){
            String cmd = sc.nextLine();
            String[] s = cmd.split(" ");
            int count = Integer.valueOf(s[0]);
            ArrayList<Long> mergedList = new ArrayList<>();
            for(int k = 1 ; k <= count ; k++){
                int index = Integer.parseInt(s[k]);
                mergedList.addAll(arr.get(index - 1));
            }

            int k = Integer.parseInt(s[s.length - 1]);
            Collections.sort(mergedList);
            //mergedList.forEach(t -> System.out.println(t));
            //System.out.println("----------");
            System.out.println(mergedList.get(k - 1));
        }
    }
}

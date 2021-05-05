package meituan;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int e = sc.nextInt();
        int f = sc.nextInt();
        int g = sc.nextInt();

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        queue.offer(new int[]{a,e});
        queue.offer(new int[]{b,f});
        queue.offer(new int[]{c,g});
        Long res = 0L;
        while(!queue.isEmpty() && d > 0){
            int[] temp = queue.poll();
            res += Math.min(temp[0],d) * temp[1];
            d -= temp[0];
        }
        System.out.println(res);
    }
}

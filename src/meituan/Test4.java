package meituan;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseNum = sc.nextInt();
        sc.nextLine();
        while(testCaseNum-- > 0){
            int n = sc.nextInt();
            int[] desks = new int[n];
            sc.nextLine();
            String s = sc.nextLine();
            PriorityQueue<Integer> singleDeque = new PriorityQueue<>();
            PriorityQueue<Integer> noneDeque  = new PriorityQueue<>();
            for(int i = 0 ; i < n ; i++){
                desks[i] = s.charAt(i) - '0';
                if(desks[i] == 0){
                    noneDeque.offer(i);
                }
                else if(desks[i] == 1){
                    singleDeque.offer(i);
                }
            }
            int m = sc.nextInt();
            sc.nextLine();
            String people = sc.nextLine();
            help(people,noneDeque,singleDeque);
        }
    }

    private static void help(String people,PriorityQueue<Integer> noneDeque,PriorityQueue<Integer> singleDeque){
        for(int i = 0 ; i < people.length() ; i++){
            //先找单桌和没人桌的位置
            char c = people.charAt(i);
            if(c == 'M'){
                if(singleDeque.size() > 0){
                    int no = singleDeque.poll();
                    singleDeque.remove(no);
                    System.out.println(no + 1);
                }else{
                    int no = noneDeque.poll();
                    System.out.println(no + 1);
                    singleDeque.offer(no);
                }

            }
            else{
                if(noneDeque.size() > 0){
                    int no = noneDeque.poll();
                    System.out.println(no + 1);
                    singleDeque.offer(no);
                }else{
                    int no = singleDeque.poll();
                    System.out.println(no + 1);
                }
            }
        }
    }
}

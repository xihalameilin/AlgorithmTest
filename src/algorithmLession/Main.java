package algorithmLession;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseNum = Integer.parseInt(sc.nextLine());
        while(testCaseNum-- > 0){
            int num = Integer.parseInt(sc.nextLine());
            String[] arrivals ;
            String[] departments;
            String line = sc.nextLine();
            arrivals = line.split(" ");
            departments = sc.nextLine().split(" ");
            int[] arrival = new int[num];
            int[] department = new int[num];
            for(int i = 0 ; i < num ; i++){
                arrival[i] = Integer.parseInt(arrivals[i]);
            }
            for(int i = 0 ; i < num ; i++){
                department[i] = Integer.parseInt(departments[i]);
            }
            getMax(arrival,department);
        }
    }

    private static void  getMax(int[] arrivals,int[] departments){
        Arrays.sort(arrivals);
        Arrays.sort(departments);
        int index1 = 0;
        int index2 = 0;
        int end = Math.max(arrivals[arrivals.length-1],departments[departments.length-1]);
        int time = 0;
        int max = 0;
        int timeRes = 0;
        int customers = 0;
        while(time <= end){
            while(index1 < arrivals.length && arrivals[index1] <= time){
                index1++;
                customers++;
            }
            while(index2 < departments.length && departments[index2] <= time){
                index2++;
                customers--;
            }
            if(customers > max){
                timeRes = time;
                max = customers;
            }
            time++;
        }
        System.out.println(max + " "+timeRes);
    }
}

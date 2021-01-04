package algorithmLession;

import java.util.Arrays;
import java.util.Scanner;

public class Keliuliang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int testCaseNum = Integer.parseInt(sc.nextLine());
            while (testCaseNum-- > 0) {
                int num = Integer.parseInt(sc.nextLine());
                String[] arrivals;
                String[] departments;
                String line = sc.nextLine();
                arrivals = line.split(" ");
                departments = sc.nextLine().split(" ");
                int[] arrival = new int[num];
                int[] department = new int[num];
                for (int i = 0; i < num; i++) {
                    arrival[i] = Integer.parseInt(arrivals[i]);
                }
                for (int i = 0; i < num; i++) {
                    department[i] = Integer.parseInt(departments[i]);
                }
                getMax(arrival, department);
            }
        }
    }

    private static void  getMax(int[] arrivals,int[] departments){
        Arrays.sort(arrivals);
        Arrays.sort(departments);
//        int n = arrivals.length;
//        int guests_in = 0, max_guests = 0, time = arrivals[0];
//        int i = 0, j = 0;
//
//        // Similar to merge in merge sort to process
//        // all events in sorted order
//        while (i < n && j < n)
//        {
//            // If next event in sorted order is arrival,
//            // increment count of guests
//            if (arrivals[i] <= departments[j])
//            {
//                guests_in++;
//
//                // Update max_guests if needed
//                if (guests_in > max_guests)
//                {
//                    max_guests = guests_in;
//                    time = arrivals[i];
//                }
//                i++; //increment index of arrival array
//            }
//            else // If event is exit, decrement count
//            { // of guests.
//                guests_in--;
//                j++;
//            }
//        }
        int time = 0;
        int max = 0;
        for(int i = 0 ; i < arrivals.length ; i++){
            int customers = i + 1;
            for(int j = 0 ; j < departments.length ; j++){
                if(departments[j] < arrivals[i]){
                    customers-- ;
                }
            }
            if(customers > max){
                max = customers;
                time = arrivals[i];
            }
        }

        System.out.println(max + " "+time);
    }
}

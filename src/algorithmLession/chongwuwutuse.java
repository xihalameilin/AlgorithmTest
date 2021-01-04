package algorithmLession;

import java.util.Arrays;
import java.util.Scanner;

public class chongwuwutuse {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        //int testCaseNum = Integer.parseInt(sc.nextLine());
//        int testCaseNum = 20;
//        while(testCaseNum-- > 0){
////            String[] items = sc.nextLine().split(" ");
////            int painter = Integer.parseInt(items[0]);
////            int[] boards = new int[Integer.parseInt(items[1])];
////            String[] arrays = sc.nextLine().split(" ");
//
//            int painter = (int)(Math.random()*30) + 1;
//            int[] boards = new int[(int)(Math.random()*50)+1];
//            for(int i = 0 ; i < boards.length ; i++) {
//                boards[i] = (int)(Math.random()*500) + 1;
//            }
//            System.out.print("测试用例： ");
//            Arrays.stream(boards).forEach(item -> System.out.print(item +" "));
//            System.out.print("painter :" + painter);
//            System.out.println();
////            for(int i = 0 ; i < boards.length ; i++){
////                boards[i] = Integer.parseInt(arrays[i]);
////            }
//            System.out.println(paint(boards,painter));
//        }
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int testCaseNum = Integer.parseInt(sc.nextLine());
            while (testCaseNum-- > 0) {
                String[] items = sc.nextLine().split(" ");
                int painter = Integer.parseInt(items[0]);
                int[] boards = new int[Integer.parseInt(items[1])];
                String[] arrays = sc.nextLine().split(" ");
                for (int i = 0; i < boards.length; i++) {
                    boards[i] = Integer.parseInt(arrays[i]);
                }
                System.out.println(paint(boards, painter));
            }
        }
    }


    private static int paint(int[] boards,int painter){
        int low = 0;
        int sum = 0;
        for(int board : boards){
            sum += board;
        }
        int high = sum;
        int res = Integer.MAX_VALUE;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(isEnough(boards,painter,mid)){
                high = mid;
                res = Math.min(res,mid);
            }
            else {
                low = mid + 1;
            }
        }
        return res == Integer.MAX_VALUE ? sum : res;
    }

    private static boolean isEnough(int[] boards,int painter,int minSize){
        int painterRequired = 1;
        int sum = 0;
        for(int board : boards){
            if(board > minSize)
                return false;
            sum += board;
            if(sum > minSize){
                painterRequired++;
                sum = board;
            }
            if(painterRequired > painter)
                return false;
        }
        return true;
    }


}

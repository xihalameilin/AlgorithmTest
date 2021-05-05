//package algorithmLession;
//
//import java.util.Scanner;
//
//public class qigouwu {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()) {
//            int t = sc.nextInt();
//            sc.nextLine();
//            while (t-- > 0) {
//                String[] two = sc.nextLine().split(" ");
//                int painter = Integer.parseInt(two[0]);
//                int n = Integer.parseInt(two[1]);
//                String[] strings = sc.nextLine().split(" ");
//                int[] arr = new int[n];
//                for (int i = 0; i < n; i++) {
//                    arr[i] = Integer.parseInt(strings[i]);
//                }
//                System.out.println(calculate(arr, painter));
//            }
//        }
//
//    }
//
//    private static int calculate(int[] arr,int painter){
//        int max = 0;
//        for(int i = 0 ; i < arr.length ; i++){
//            max += arr[i];
//        }
//
//        int low = 0,high = max;
//        while(low < high){
//            int mid = low + (high - low ) / 2;
//            if(isEnough(arr,painter,mid)){
//                high = mid;
//            }
//            else{
//                low = mid + 1;
//            }
//        }
//        return low;
//    }
//
//    private static boolean isEnough(int[] arr,int painter,int height){
//        int sum = 0;
//        int need = 1;
//        for(int i = 0 ; i < arr.length ; i++){
//            if(arr[i] > height)
//                return false;
//            if(sum + arr[i] <= height){
//                sum += arr[i];
//            }
//            else{
//                sum = arr[i];
//                need++;
//            }
//        }
//        return need <= painter;
//    }
//
//
//}

package algorithmLession;

import java.util.Scanner;

public class BookAllocation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseNum = sc.nextInt();
        for (int i = 0; i < testCaseNum; i++) {
            int bookNum = sc.nextInt();
            int[] books = new int[bookNum];
            for (int j = 0; j < bookNum; j++) {
                books[j] = sc.nextInt();
            }
            int stuNum = sc.nextInt();
            System.out.println(find(books, stuNum));
        }
    }


    private static int find(int[] books,int stuNum){
        if(books.length < stuNum)
            return -1;
        long sum = 0;
        int start = 0;
        for(int i : books)
            sum += i;
        int end = (int)sum;
        int res = Integer.MAX_VALUE;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(isEnough(books,stuNum,mid)){
                end = mid ;
                res = Math.min(res,mid);
            }
            else{
                start = mid + 1;
            }
        }
        return res;
    }


    private static boolean isEnough(int[] books,int stuNum,int minCap){
        int sum = 0;
        int stuRequired = 1;
        for(int i = 0 ; i < books.length ; i++){
            if(books[i] > minCap)
                return false;
            sum += books[i];
            if(sum > minCap){
                stuRequired ++;
                sum = books[i];
            }

            if(stuRequired > stuNum)
                return false;
        }
        return true;
    }





//    private void f(){
//        Scanner sc = new Scanner(System.in);
//        int testCaseNum = read(sc);
//        for(int i = 0 ; i < testCaseNum ; i++){
//            int bookNum = read(sc);
//            int[] books = new int[bookNum];
//            for(int j = 0 ; j < bookNum ; j++){
//                books[j] = read(sc);
//            }
//            int stuNum = read(sc);
//            System.out.println(getCap(books,stuNum,getMin(books),getSum(books)));
//        }
//    }
//
//    private int getMin(int[] books){
//        int min = books[0];
//        for(int i = 0 ; i < books.length ; i++){
//            min = Math.min(min,books[i]);
//        }
//        return min;
//    }
//
//    private int getSum(int[] books){
//        int res = 0;
//        for(int i = 0 ; i < books.length ; i++){
//            res += books[i];
//        }
//        return res;
//    }
//
//    private int getCap(int[] books,int stuNum,int min,int max){
//        if(max == min)
//            return max;
//        int mid_cap = min + (max - min) / 2;
//        int temp = help(books,mid_cap);
//        if(temp <= stuNum)
//            return getCap(books,stuNum,min,mid_cap);
//        else
//            return getCap(books,stuNum,mid_cap + 1,max);
//    }
//
//    private int help(int[] books,int min){
//        int res = 1,sum = 0;
//        for(int book : books){
//            sum += book;
//            if(sum > min){
//                res++;
//                sum = book;
//            }
//        }
//        return res;
//    }
//
//    private int read(Scanner scanner){
//        return scanner.nextInt();
//    }
}

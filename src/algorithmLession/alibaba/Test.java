package algorithmLession.alibaba;

import java.awt.*;
import java.util.Stack;

public class Test {
    class Point2D {
        public int x;
        public int y;
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 500 ; i++){
            sb.append("[" + 0 + "," + i + "],");
        }
        System.out.println(sb.toString());
    }


    public int solution(Point2D[] A) {
        // write your code in Java SE 8
        if(A.length <= 2){
            return 0;
        }
        int res = 0;
        for(int i = 0 ; i < A.length - 2 ; i ++){
            for(int j = i + 1 ; j < A.length - 1 ; j++){
                for(int m = j + 1 ; m < A.length ; m++){
                    Point2D[] B = new Point2D[3];
                    B[0] = A[i];
                    B[1] = A[j];
                    B[2] = A[m];
                    if(judge(B)){
                        res++;
                    }
                }
            }
        }
        if(res > 100000000)
            return -1;
        else
            return res;
    }


    private boolean judge(Point2D[] B){
        Point2D a = B[0];
        Point2D b = B[1];
        Point2D c = B[2];
        if(a.x == b.x){
            return b.x == c.x;
        }
        else if(a.x == c.x){
            return a.x == b.x;
        }
        else if(b.x == c.x){
            return a.x == b.x;
        }
        else{
            double k1 = (double)(b.y - a.y)*1.0 / (b.x - a.x);
            double k2 = (double)(c.y - a.y)*1.0 / (c.x - a.x);
            return k1 == k2;
        }
    }

//    public int solution(String S) {
//        // write your code in Java SE 8
//        String[] arr = S.split(" ");
//        Stack<Integer> stack = new Stack<>();
//        for(int i = 0 ; i < arr.length ; i++){
//            if(arr[i].equals("DUP")){
//                if(stack.isEmpty()){
//                    return -1;
//                }
//                else{
//                    stack.push(stack.peek());
//                }
//            }
//            else if(arr[i].equals("POP")){
//                if(stack.isEmpty()){
//                    return -1;
//                }
//                else{
//                    stack.pop();
//                }
//            }
//            else if(arr[i].equals("+")){
//                if(stack.isEmpty() || stack.size() <= 1){
//                    return -1;
//                }
//                else{
//                    int a = stack.pop();
//                    int b = stack.pop();
//                    if(a + b > Math.pow(2,21)- 2){
//                        return -1;
//                    }
//                    else{
//                        stack.push(a+b);
//                    }
//                }
//            }
//            else if(arr[i].equals("-")){
//                if(stack.isEmpty() || stack.size() <= 1){
//                    return -1;
//                }
//                else{
//                    int a = stack.pop();
//                    int b = stack.pop();
//                    if(a - b < 1 - Math.pow(2,20)){
//                        return -1;
//                    }
//                    else{
//                        stack.push(a-b);
//                    }
//                }
//            }
//            else{
//                stack.push(Integer.valueOf(arr[i]));
//            }
//        }
//        if(stack.isEmpty())
//            return -1;
//        else
//            return stack.pop();
//    }
}

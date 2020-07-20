package java8;

public class Java8Tester {
    public static void main(String args[]){
      MathOperation addition = (int a,int b) -> a+b;
      System.out.println(addition.operation(1,2));
    }

    interface MathOperation {
        int operation(int a, int b);
    }


}

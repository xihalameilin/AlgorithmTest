package summer2019;


import java.util.ArrayDeque;

public class Main {
  public static void main(String[] args) {
      ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
      arrayDeque.offerLast(1);
      arrayDeque.offerLast(2);
      arrayDeque.offerLast(3);
      System.out.println(arrayDeque.peekLast());
      arrayDeque.pollLast();
      System.out.println(arrayDeque.peekLast());
  }
}

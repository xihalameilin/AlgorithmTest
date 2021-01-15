package java8;

public class testImpl implements test{
  public static void main(String[] args) {

      new testImpl().f();
      new testImpl().f2();
  }
  void f2(){
    System.out.println(2);
  }
}

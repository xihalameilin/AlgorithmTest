package mutipleThread;

public class SychronizedDemo {

    public void method(){
        synchronized (this){
            System.out.println("method1 start");
        }
    }

    public synchronized void test(){
        System.out.println("test");
    }
}

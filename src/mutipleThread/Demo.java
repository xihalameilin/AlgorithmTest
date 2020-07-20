package mutipleThread;

public class Demo {
    public static class MyThread extends Thread{
        public void run(){
            System.out.println("My thread");
        }
    }

    public static void main(String[] args){
        Thread mythread = new MyThread();
        mythread.start();

        new Thread(()->{
            System.out.println("java 8 匿名类");
        }).start();
    }


}

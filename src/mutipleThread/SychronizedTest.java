package mutipleThread;

import sort.Test;

public class SychronizedTest {
    private void test1() throws InterruptedException {
        System.out.println("test1 in");
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"enter sychronized");
            Thread.sleep(5000);
        }
        System.out.println("test1 out");
    }


    private void test2() throws InterruptedException {
        System.out.println("test2 in");
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"enter sychronized");
            Thread.sleep(5000);
        }
        System.out.println("test2 out");
    }


    public static void main(String[] args) {
        SychronizedTest test = new SychronizedTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.test1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.test2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}

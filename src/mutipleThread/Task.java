package mutipleThread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }



    private static void demo4(){
        AtomicInteger ctl = new AtomicInteger(2);
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    if (ctl.compareAndSet(1, 2)) {
                        System.out.println("success");
                        break;
                    }
                    else{
                        System.out.println("fail");
                    }
                }
                System.out.println("end");
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    ctl.set(1);
                } catch (InterruptedException e) {

                }
            }
        });

        b.start();
        a.start();
    }

    public static void main(String[] args) {
        demo4();
    }
}

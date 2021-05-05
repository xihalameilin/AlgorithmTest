package mutipleThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before() {
        lock.lock();
        System.out.println("before拿到锁");
        try {
            System.out.println("before");
            condition.signalAll();
        } finally {
            System.out.println("before释放锁");
            lock.unlock();

        }
    }

    public void after() {
        lock.lock();
        System.out.println("after拿到锁");
        try {
            condition.await();
            System.out.println("after");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("after释放锁");
            lock.unlock();
        }
    }


    public static void main(String[] args) throws Exception{
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequestCount; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.print(semaphore.availablePermits() + " ");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
        System.out.println(semaphore.availablePermits());
        executorService.shutdown();
    }
}

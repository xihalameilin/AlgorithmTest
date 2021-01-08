package mutipleThread;

public class Demo {
    public static class MyThread extends Thread{
        public void run(){
            while (true){

            }
        }
    }

    public static void main(String[] args){
       new Thread(new MyThread()).start();
    }


}

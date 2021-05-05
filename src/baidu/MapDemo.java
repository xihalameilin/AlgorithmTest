package baidu;


import java.util.*;

public class MapDemo {

    private static synchronized void f1(){
        try {
            System.out.println("f1");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static synchronized void f2(){
        try {
            System.out.println("f2");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        List<Integer> set = new ArrayList<>();
        for(int i = -1000 ; i  < -985 ; i++){
            set.add(i);
            set.add(i);
        }
        for(int i = 100 ; i  < 120 ; i++){
            set.add(i);
            set.add(i);
        }
        set.add(0);
        Collections.shuffle(set);
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

    }
}

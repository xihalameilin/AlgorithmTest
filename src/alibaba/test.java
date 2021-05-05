package alibaba;

import java.util.HashMap;

public class test {
    static class A{
        int a = 0;
        @Override
        public int hashCode() {
            return 3;
        }
        public A(int a){
            this.a = a;
        }
    }

    public static void main(String[] args) {
        HashMap<A,Integer> hashMap = new HashMap();
        for(int i = 0 ; i < 20 ; i++){
            System.out.println(hashMap.put(new A(i),i));
        }
        for(A a : hashMap.keySet()){
            System.out.println(hashMap.get(a));
        }
    }
}

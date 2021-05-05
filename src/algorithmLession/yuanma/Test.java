package algorithmLession.yuanma;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(128);
        list.add(128);
        System.out.println(list.get(0) == list.get(1));
        System.out.println(list.get(0).equals(list.get(1)));
    }
}

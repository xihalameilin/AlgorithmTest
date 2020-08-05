package summer2019;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LeetCodePraticeII test = new LeetCodePraticeII();
        List<Integer> temp =new ArrayList<>();
        temp.add(2);
        List<List<Integer>> tra = new ArrayList<>();
        tra.add(temp);
        temp = new ArrayList<>();
        temp.add(3);
        temp.add(4);
        tra.add(temp);
        temp = new ArrayList<>();
        temp.add(6);
        temp.add(5);
        temp.add(7);
        tra.add(temp);
        temp = new ArrayList<>();
        temp.add(4);
        temp.add(1);
        temp.add(8);
        temp.add(3);
        tra.add(temp);
        test.minimumTotal(tra);
    }
}

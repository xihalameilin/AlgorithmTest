package pailie;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    private static ArrayList<String> arrayList;

    public static void main(String[] args) {
        arrayList = new ArrayList<>();
        for(int i=0;i<4;i++){
            arrayList.add(String.valueOf(i+1));
        }
        f("");
    }

    public static void f(String s){

        if(s.split(" ").length==arrayList.size()){
            System.out.println(s);
            return;
        }
        else{
            List<String> strings= Arrays.asList(s.split(""));
            List<String> strs = new ArrayList<>();
            for(int i=0;i<arrayList.size();i++){
                if(!strings.contains(arrayList.get(i))){
                    strs.add(arrayList.get(i));
                }
            }

            for(int i=0;i<strs.size();i++){
                String s1 = s+strs.get(i)+" ";
                f(s1);
            }

        }
    }
}

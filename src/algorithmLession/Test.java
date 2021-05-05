package algorithmLession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        new Test().combinationSum2(new int[]{1,2,3,5,6},8);
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        back(candidates,new ArrayList<>(),target,new boolean[candidates.length],0);
        return res;
    }

    private void back(int[] candidates, List<Integer> temp, int target, boolean[] flag,int index){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            temp.stream().forEach(i -> System.out.print(i));
            System.out.println();
            return;
        }
        for(int i = index ; i < candidates.length ; i++){
            if( i > index && candidates[i] == candidates[i - 1] || flag[i])
                continue;
            temp.add(candidates[i]);
            target -= candidates[i];
            flag[i] = true;
            back(candidates,temp, target,flag,i + 1);
            flag[i] = false;
            target += candidates[i];
            temp.remove(temp.size() - 1);
        }
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        ArrayList<Integer> list = new ArrayList<>();
        for(int a : A){
            if(a  > 0){
                list.add(a);
            }
        }
        Arrays.sort(A);
        for(int i = 0 ; i < list.size() ; i++){
            int index = Math.abs(list.get(i));
            if(index - 1 < list.size()) {
                list.set(index - 1, -Math.abs(list.get(i)));
            }
        }
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i) > 0){
                return i + 1;
            }
        }
        return list.size() + 1;
    }
}

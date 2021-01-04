package algorithmLession;

import java.util.*;

public class zuixiaohuanhuancishu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseNum = sc.nextInt();
        while(testCaseNum-- > 0){
            int num = sc.nextInt();
            List<Integer> nums = new ArrayList<>();
            for(int i = 0 ; i < num ; i++){
                nums.add(sc.nextInt());
            }
            System.out.println(minswap(nums));
        }
    }

    // 一个环上有N个数 则需要交换(N-1)次
    // 如 3， 1 ，2
    private static int minswap(List<Integer> nums){
        List<Integer> comp = new ArrayList<>(nums);
        Collections.sort(comp);

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.size() ; i++){
            map.put(comp.get(i),i);
        }

        int count = 0;
        for(int i = 0 ; i < nums.size() ; i++){
            // 元素应该在的位置
            int location = map.get(nums.get(i));
            while (location != i){
                int temp = nums.get(location);
                nums.set(location,nums.get(i));
                nums.set(i,temp);
                count++;
                location = map.get(nums.get(i));
            }
        }
        return count;
    }
}

package algorithmLession;

import java.util.*;

public class Heweidingzhishuzu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int testCaseNum = sc.nextInt();
            while (testCaseNum-- > 0) {
                int num = sc.nextInt();
                int target = sc.nextInt();
                int[] nums = new int[num];
                for (int i = 0; i < num; i++) {
                    nums[i] = sc.nextInt();
                }
                fourSum(nums, target);
            }
        }
    }

    public static void fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i=0;
        int j=0;
        int length = nums.length;
        if(length < 4)
            return ;
        for(i=0;i<length-3;i++){
            for(j=i+3;j<length;j++){
                int remainder = target - nums[i] - nums[j];
                int l = i+1;
                int r = j-1;
                while(l<r){
                    if(nums[l]+nums[r] == remainder){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        temp.add(nums[j]);
                        result.add(temp);
                        while(l+1<length&&nums[l]==nums[l+1])
                            l++;
                        while(r-1>0&&nums[r]==nums[r-1])
                            r--;
                        l++;
                        r--;
                    }
                    else if(nums[l]+nums[r]<remainder){
                        l++;
                    }
                    else{
                        r--;
                    }
                }
            }
        }
        for(List<Integer> list : result){
            for(int item : list){
                System.out.print(item +" ");
            }
            System.out.print("$");
        }
        System.out.println();
    }
}

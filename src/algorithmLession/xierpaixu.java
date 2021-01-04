package algorithmLession;

import java.util.Arrays;
import java.util.Scanner;

public class xierpaixu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseNum = Integer.parseInt(sc.nextLine());
        while(testCaseNum-- > 0){
            String[] nums = sc.nextLine().split(" ");
            int[] array = new int[nums.length];
            for(int i = 0 ; i < nums.length ; i++){
                array[i] = Integer.parseInt(nums[i]);
            }
            String[] gaps = sc.nextLine().split(" ");
            shellSort(array,gaps);
        }
    }



    private static void shellSort(int[] nums,String[] gaps){
        for(int i = 0 ; i < gaps.length ; i++){
            shell(nums,Integer.parseInt(gaps[i]));
        }
        // 真的恶心 最后一个元素后面不能有空格
        StringBuilder sb = new StringBuilder();
        Arrays.stream(nums).forEach(item -> sb.append(item + " "));
        System.out.println(sb.substring(0,sb.length()-1));
    }

    private static void shell(int[] nums,int gap){
        int temp;
        int j;
        for(int i = gap ; i < nums.length ; i++){
            temp = nums[i];
            for(j = i - gap ; j >= 0 ; j -= gap){
                if(nums[j] > temp){
                    nums[j + gap] = nums[j];
                }
                else
                    break;
            }
            nums[j + gap] = temp;
        }
    }
}

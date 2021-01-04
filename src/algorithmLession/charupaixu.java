package algorithmLession;


import java.util.Arrays;
import java.util.Scanner;

public class charupaixu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int[] nums = new int[sc.nextInt()];
            for(int i = 0 ; i < nums.length ; i++){
                nums[i] = sc.nextInt();
            }
            insertSort(nums);
        }
    }


    // 插入排序应该从1开始循环
    private static void insertSort(int[] nums){
        int len = nums.length;
        for(int i = 1 ; i < len ; i++){
            int temp = nums[i];
            int j = i;
            for(; j > 0 && nums[j - 1] > temp ; j--){
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
       for(int i = 0 ; i < len ; i ++){
           System.out.print(nums[i] + " ");
       }
        System.out.println();
    }
}

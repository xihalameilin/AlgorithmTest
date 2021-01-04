package algorithmLession;

import java.util.Scanner;

public class maopaopaixu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] nums = new int[sc.nextInt()];
            for(int i = 0 ; i < nums.length ; i++){
                nums[i] = sc.nextInt();
            }
            bubbleSort(nums);
        }
    }
    private static void bubbleSort(int[] nums){
        int len = nums.length;
        for(int i = 0 ; i < len - 1 ; i++){
            for(int j = i + 1 ; j < len ; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for(int i = 0 ; i < len ; i ++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}

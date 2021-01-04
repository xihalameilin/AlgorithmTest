package algorithmLession;

import java.util.Arrays;
import java.util.Scanner;

public class feidiguiguibing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] nums = new int[sc.nextInt()];
            for(int i = 0 ; i < nums.length ; i++){
                nums[i] = sc.nextInt();
            }
            mergeSort(nums);
        }
    }


    private static void mergeSort(int[] nums){
        for(int i = 1 ; i <= nums.length ; i = i * 2){
            for(int j = 0 ; j + i <= nums.length ; j += i * 2){
                merge(nums, j ,j + i - 1, Math.min(nums.length - 1,j + i * 2 - 1));
            }
        }
        Arrays.stream(nums).forEach(item -> System.out.print(item + " "));
        System.out.println();
    }


    private static void merge(int[] nums,int left,int center,int right){
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = center + 1;
        int index = 0;
        while(i <= center && j <= right){
            if(nums[i] <= nums[j]){
                temp[index++] = nums[i++];
            }
            else{
                temp[index++] = nums[j++];
            }
        }

        while(i <= center){
            temp[index++] = nums[i++];
        }

        while(j <= right){
            temp[index++] = nums[j++];
        }

        for(int k = left ; k <= right ; k++){
            nums[k] = temp[k-left];
        }

    }
}

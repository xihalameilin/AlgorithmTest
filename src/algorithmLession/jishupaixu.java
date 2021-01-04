package algorithmLession;


import java.util.Scanner;

public class jishupaixu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] nums = new int[sc.nextInt()];
            for(int i = 0 ; i < nums.length ; i++){
                nums[i] = sc.nextInt();
            }
            jishuSort(nums);
        }
    }




    private static void jishuSort(int [] nums){
        int max = getMax(nums) + 1;
        int[] bucket = new int[max];
        for(int i : nums){
            bucket[i] ++;
        }

        for(int i = 0 ; i < bucket.length ; i++){
            while(bucket[i] > 0 ){
                System.out.print (i + " ");
                bucket[i]--;
            }

        }
        System.out.println();
    }

    private static int getMax(int[] nums){
        int max = nums[0];
        for(int i : nums){
            max = Math.max(max,i);
        }
        return max;
    }

}

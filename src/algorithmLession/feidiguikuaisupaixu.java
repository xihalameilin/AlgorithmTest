package algorithmLession;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class feidiguikuaisupaixu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] nums = new int[sc.nextInt()];
            for(int i = 0 ; i < nums.length ; i++){
                nums[i] = sc.nextInt();
            }
            quickSort(nums,0, nums.length-1);
            print(nums);
        }
    }

    private static void print(int[] nums){
            Arrays.stream(nums).forEach(i -> System.out.print(i+" "));
            System.out.println();
    }

    private static void quickSort(int[] nums,int left,int right){
        Deque<Integer> stack = new LinkedList<>();
        stack.push(left);
        stack.push(right);
        while(!stack.isEmpty()){
            int high = stack.pop();
            int low = stack.pop();
            if(low >= high)
                continue;
            int l = low;
            int r = high;
            int stand = nums[low];
            while(low < high){
                while (low < high && nums[high] >= stand){
                    high--;
                }

                while (low < high && nums[low] <= stand){
                    low++;
                }
                swap(nums,low,high);
            }
            swap(nums,low,l);
            stack.push(l);
            stack.push(low-1);
            stack.push(low+1);
            stack.push(r);
        }
    }


    private static void swap(int[] nums,int left,int right){
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}

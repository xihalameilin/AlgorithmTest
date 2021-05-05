package sort;

import java.util.Arrays;

public class MergeCount {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2};
        int[] temp = new int[arr.length];
        int count = new MergeCount().mergeSort(arr,0,arr.length - 1,temp);
        System.out.println(count);
        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }


    private int mergeSort(int[] arr,int left,int right,int[] temp){
        if(left >= right){
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = mergeSort(arr,left,mid,temp);
        int rightCount = mergeSort(arr,mid + 1,right,temp);
        if(arr[mid] < arr[mid + 1]) {
            return leftCount + rightCount;
        }
        int midCount = merge(arr,left,mid,right,temp);
        return leftCount + midCount +rightCount;
    }

    private int merge(int[] arr,int left,int mid,int right,int[] temp){
        for(int i = left ; i <= right ; i++){
            temp[i] = arr[i];
        }

        int count = 0;
        int low = left;
        int high = mid + 1;
        int index = left;
        for(int i = left ; i  <= right ; i++){
            if(low == mid + 1){
                arr[index++] = temp[high++];
            }
            else if(high == right + 1){
                arr[index++] = temp[low++];
            }
            else if(temp[low] <= temp[high]){
                arr[index++] = temp[low++];
            }
            else if(temp[low] > temp[high]){
                arr[index++] = temp[high++];
                count += (mid - low + 1);
            }
        }
        return count;
    }
}

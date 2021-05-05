package sort;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,8,9,6,4,0,8};
        new Test2().mergeSort(arr,0,arr.length - 1);
        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }


    private void mergeSort(int[] arr,int left,int right){
        if(left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid + 1,right);
        merge(arr,left,mid,right);
    }

    private void merge(int[] arr,int left,int mid,int right){
        int[] temp = new int[arr.length];
        for(int i = left ; i <= right ; i++){
            temp[i] = arr[i];
        }

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
            }
        }

    }
}

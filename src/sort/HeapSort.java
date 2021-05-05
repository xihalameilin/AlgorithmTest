package sort;

public class HeapSort {
    private int[] arr = new int[]{5,8,9,7,1,3,5};

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        sort.heapSort();
        sort.print();
    }

    private void heapSort(){
        for(int i = arr.length / 2 - 1 ; i >= 0 ; i--){
            adjustHeap(i,arr.length);
        }
        for(int i = arr.length - 1 ; i > 0 ; i--){
            swap(0,i);
            adjustHeap(0,i);
        }
    }

    private void print(){
        for(int a : arr){
            System.out.print(a);
        }
    }
    private void swap(int l,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    private void adjustHeap(int left,int right){
        int temp = arr[left];
        for(int k = left * 2 + 1; k < right ; k = k * 2 + 1){
            if(k + 1 < right && arr[k + 1] > arr[k]){
                k++;
            }

            if(arr[k] > temp){
                arr[left] = arr[k];
                left = k ;
            }
            else{
                break;
            }
        }
        arr[left] = temp;
    }
}

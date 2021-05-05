package sort;

public class Test3 {

    private static int partion(int[] arr,int left,int right,int k){
        int key = arr[left];
        int i = left;
        int j = right;
        while(i < j){
            while(i < j && arr[j] <= key){
                j--;
            }
            while(i < j && arr[i] >= key){
                i++;
            }
            swap(arr,i,j);
        }
        swap(arr,i,left);
        return i;
    }

    private static void swap(int[] arr,int l,int r){
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

    private static int quickSort(int[] arr,int left,int right,int k){
        int p = partion(arr,left,right,k);
        if(p == k - 1){
            return arr[p];
        }
        else if(p > k - 1){
            return quickSort(arr,left,p - 1,k);
        }
        else{
            return quickSort(arr,p + 1,right,k);
        }
    }

    public static void main(String[] args) {
        System.out.println(quickSort(new int[]{3, 1, 2, 5, 6}, 0, 4, 2));
    }
}

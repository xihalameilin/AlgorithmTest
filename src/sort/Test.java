package sort;

public class Test {

    public static void main(String[] args) {
        //mergeSort(array,0,array.length-1,new int[array.length]);
        quickSort(array,0,array.length-1);
        print(array);
    }

    private class MyTest{
        public void f(){
            Test.this.re();
        }
    }

    public void re(){

    }

    private static void quickSort(int[] array,int left,int right){
        if(left < right){
            int key = array[right];
            int i = left;
            int j = right;
            while(i < j ){
                while (i < j && array[j] >= key){
                    j--;
                }
                while(i < j && array[i] <= key){
                    i++;
                }
                swap(array,i,j);
            }
            swap(array,i,right);
            quickSort(array,left,i - 1);
            quickSort(array,i + 1,right);
        }
    }

    private static void swap(int[] array,int l,int r){
        int t = array[l];
        array[l] = array[r];
        array[r] = t;
    }

    private static int[] array = {3,5,5,3};

    public static void print(int[] array){
        for(int a:array){
            System.out.println(a);
        }
    }

    public static  void insertSort(int[] array){
        int j = 0;
        for(int i=1;i<array.length;i++){
            int temp = array[i];
            for(j=i;j>0&&temp<array[j-1];j--){
                array[j] = array[j-1];
            }
            array[j] = temp;
        }
    }

    public static void bubbleSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){

            }
        }
    }

    public static void mergeSort(int[] nums,int left,int right,int[] temp){
        if(left < right){
            int mid = left + (right - left)/2;
            mergeSort(nums,left,mid,temp);
            mergeSort(nums,mid + 1 ,right,temp);
            merge(nums,left,mid,right,temp);
        }
    }

    private static void merge(int[] nums,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid + 1;
        int t = left;
        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]){
                temp[t++] = nums[i++];
            }
            else{
                temp[t++] = nums[j++];
            }
        }


        while(i <= mid){
            temp[t++] = nums[i++];
        }

        while(j <= right){
            temp[t++] = nums[j++];
        }

        for(int k = left; k <= right ; k++){
            nums[k] = temp[k];
        }
    }
}

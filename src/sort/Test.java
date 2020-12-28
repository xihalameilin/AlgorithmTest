package sort;

public class Test {

    public static void main(String[] args) {
        mergeSort(array,0,array.length-1,new int[array.length]);
        print(array);
    }

    private class MyTest{
        public void f(){
            Test.this.re();
        }
    }

    public void re(){

    }

    private static int[] array = {20,8,75,45,60};

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

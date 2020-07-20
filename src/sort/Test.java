package sort;

public class Test {

    public static void main(String[] args) {
        insertSort(array);
        print(array);
    }

    private class MyTest{
        public void f(){
            Test.this.re();
        }
    }

    public void re(){

    }

    private static int[] array = {20,18,75,45,60};

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
}

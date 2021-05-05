package baidu;


public class Test5 {
    static long min = Long.MAX_VALUE;
    public static void main(String[] args) {
        backtrace(20,0);
        System.out.println(min);
    }

    private static void backtrace(long n,long times){
        if(n == 0){
            min = Math.min(times,min);
            return;
        }
        backtrace(n - 1,times + 1);
        if(n % 2 == 0){
            backtrace(n / 2,times + 1);
        }
        if(n % 3 == 0){
            backtrace(n / 3 , times + 1);
        }
    }
}

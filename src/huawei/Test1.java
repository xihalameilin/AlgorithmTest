package huawei;


import java.util.*;

public class Test1 {
    static long res = Long.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String target = sc.nextLine();
        int cur = Integer.parseInt(sc.nextLine());
        backtrace(s,target,cur,0,0);
        System.out.println(res);
    }

    private static void backtrace(String s,String target,int begin,int index,int sum){
        if(index == target.length()){
            res = Math.min(res,sum);
            return;
        }
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == s.charAt(index)){
                int l1 = Math.abs(i - begin);
                int l2 = Math.abs(i + s.length() - begin);
                sum += Math.min(l1,l2);
                backtrace(s,target,i,index + 1 ,sum);
            }
        }
    }

}

package baidu;


import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        String[] s = sc.nextLine().split(" ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        for(int i = 0 ; i < m ; i++){
            String[] cmd = sc.nextLine().split(" ");
            int l = Integer.parseInt(cmd[1]);
            int r = Integer.parseInt(cmd[2]);
            if(cmd[0].equals("1")){
                cal(arr,l - 1 , r -1, true);
            }else {
                cal(arr,l - 1 , r -1, false);
            }
        }

    }

    private static void cal(int[] arr,int l,int r,boolean flag){
        long jishu = 0;
        long oushu = 0;
        for(int i = l ; i <= r ; i++){
            if((arr[i] & 1) == 1){
                jishu++;
            }
            else{
                oushu++;
            }
        }
        if(flag){
            long res = (long)Math.pow(2,jishu) - 1;
            System.out.println(res % (1000000007));

        }
        else{
            long res = oushu * (long)(Math.pow(2,oushu) - 1) * (long) Math.pow(2,jishu);
            System.out.println(res % (1000000007));
        }
    }
}

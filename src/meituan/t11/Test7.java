package meituan.t11;

import java.util.Scanner;
import java.util.Stack;

public class Test7 {
    public static void main(String[] args) {
        //System.out.println(String.format("%.5f",20.0));
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int c = sc.nextInt();
        Stack<String> stack = new Stack<>();
        stack.push(m + "#" + String.format("%.5f",c*1.0));
        sc.nextLine();
        int cmdCount = sc.nextInt();
        sc.nextLine();
        boolean lastCmd = false;
        for(int i = 0 ; i < cmdCount ; i++){
            String[] cmd = sc.nextLine().split(" ");
            if(cmd[0].equals("A")){
                int m1 = Integer.parseInt(cmd[1]);
                int c1 = Integer.parseInt(cmd[2]);
                String[] old = stack.peek().split("#");
                int oldm = Integer.parseInt(old[0]);
                double oldc = Double.valueOf(old[1]);
                double newc = 1.0 * (oldc / 100.0 * oldm + m1 * c1 * 1.0 / 100.0 )/ (double) (m1 + oldm) * 100;
                stack.push((m1 + oldm) + "#" + String.format("%.5f",newc));
                System.out.println((m1 + oldm) + " " + String.format("%.5f",newc));
                lastCmd = true;
            }
            else{
                //上一条命令是添加
                if(lastCmd == true){
                    stack.pop();
                    String[] s = stack.peek().split("#");
                    System.out.println(s[0] + " " +s[1]);
                }
                else{
                    if(stack.isEmpty())
                        continue;
                    String[] s = stack.peek().split("#");
                    System.out.println(s[0] + " " + s[1]);
                }
                lastCmd = false;
            }
        }

    }
}

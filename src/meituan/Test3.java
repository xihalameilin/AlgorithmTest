package meituan;

import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseNum = sc.nextInt();
        sc.nextLine();
        while(testCaseNum-- > 0){
            int n = sc.nextInt();
            int[] desks = new int[n];
            sc.nextLine();
            String s = sc.nextLine();
            for(int i = 0 ; i < n ; i++){
                desks[i] = s.charAt(i) - '0';
            }
            int m = sc.nextInt();
            sc.nextLine();
            String people = sc.nextLine();
            help(desks,people);
        }
    }

    private static void help(int[] desk,String people){
        int single = 0;
        int none = 0;
        for(int i = 0 ; i < people.length() ; i++){
            //先找单桌和没人桌的位置
            boolean singleExist = false;
            boolean noneExist = false;
            for(int j = Math.min(single,none) ; j < desk.length ; j++){
                if(desk[j] == 1){
                    single = j;
                    singleExist = true;
                    break;
                }
            }
            for(int j = none ; j < desk.length ; j++){
                if(desk[j] == 0){
                    none = j;
                    noneExist = true;
                    break;
                }
            }
            char c = people.charAt(i);
            if(c == 'M'){
                if(singleExist){
                    desk[single] = 2;
                    System.out.println(single + 1);
                }
                else{
                    desk[none] = 1;
                    System.out.println(none + 1);
                }

            }
            else{
                if(noneExist){
                    desk[none] = 1;
                    System.out.println(none + 1);
                }
                else{
                    desk[single] = 2;
                    System.out.println(single + 1);
                }
            }
        }
    }
}

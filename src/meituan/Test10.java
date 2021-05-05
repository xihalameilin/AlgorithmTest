package meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test10 {
    public static void main(String[] args){
        //a,b,c,d,e,f,g
        Scanner sc = new Scanner(System.in);
        Long a = sc.nextLong();
        Long b = sc.nextLong();
        Long c = sc.nextLong();
        Long d = sc.nextLong();

        Long e = sc.nextLong();
        Long f = sc.nextLong();
        Long g = sc.nextLong();

//        int maxProfict = Math.max(e,Math.max(f,g));
//        int minProfict = Math.min(e,Math.min(f,g));
//        List<Integer> p = new ArrayList<>();
//        p.add(e);p.add(f);p.add(g);
//        p.remove(p.indexOf(maxProfict));
//        p.remove(p.indexOf(minProfict));


        long res = 0;
        if(e >= f && e >= g){
            // a b c
            if(f >= g){
                while(d > 0 && a > 0){
                    res += e;
                    d--;
                    a--;
                }
                while(d > 0 && b > 0){
                    res += f;
                    d--;
                    a--;
                }
                while(d > 0 && c > 0){
                    res += g;
                    d--;
                    c--;
                }
                System.out.println(res);
            }
            //a c b
            else{
                while(d > 0 && a > 0){
                    res += e;
                    d--;
                    a--;
                }
                while(d > 0 && c > 0){
                    res += g;
                    d--;
                    c--;
                }
                while(d > 0 && b > 0){
                    res += f;
                    d--;
                    b--;
                }
                System.out.println(res);

            }
        }

        else if(f >= e && f >= g){
            //b a c
            if(e >= g){
                while(d > 0 && b > 0){
                    res += f;
                    d--;
                    b--;
                }
                while(d > 0 && a > 0){
                    res += e;
                    d--;
                    a--;
                }
                while(d > 0 && c > 0){
                    res += g;
                    d--;
                    c--;
                }
                System.out.println(res);
            }
            else{
                //b c a
                while(d > 0 && b > 0){
                    res += e;
                    d--;
                    b--;
                }
                while(d > 0 && c > 0){
                    res += g;
                    d--;
                    c--;
                }
                while(d > 0 && a > 0){
                    res += f;
                    d--;
                    a--;
                }
                System.out.println(res);
            }
        }
        else{
            //c a b
            if(e >= f){
                while(d > 0 && c > 0){
                    res += g;
                    d--;
                    c--;
                }
                while(d > 0 && a > 0){
                    res += e;
                    d--;
                    a--;
                }
                while(d > 0 && b > 0){
                    res += f;
                    d--;
                    b--;
                }
                System.out.println(res);

            }
            else{
                //c b a
                while(d > 0 && c > 0){
                    res += g;
                    d--;
                    c--;
                }
                while(d > 0 && b > 0){
                    res += f;
                    d--;
                    b--;
                }
                while(d > 0 && a > 0){
                    res += e;
                    d--;
                    a--;
                }
                System.out.println(res);
            }
        }
    }
}

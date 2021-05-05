package algorithmLession;

import java.util.*;

public class shenduyouxianbianli {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String s1 = sc.nextLine();
            int size = s1.charAt(0) - '0';
            int begin = s1.charAt(2) - 'a';
            int[][] edges = new int[size][size];
            String[] nodes = sc.nextLine().split(" ");
            //数字到字母的映射
            Map<Integer,String> map = new HashMap<>();
            for(int i = 0 ; i < nodes.length ; i++){
                map.put(i,nodes[i]);
            }
            for(int i = 0 ; i < size ; i++){
                String ss = sc.nextLine();
                String[] line = ss.substring(2).split(" ");
                for(int j = 0 ; j < line.length ; j++){
                    edges[i][j] = Integer.parseInt(line[j]);
                }
            }

            int ret = backtrace(edges,begin,0,new boolean[size]);
            System.out.println(ret);
        }
    }

    private static int backtrace(int[][] edges,int begin,int cur,boolean[] visited){
        int ret = cur;
        for(int i = 0 ; i < edges.length ; i++){
            if(edges[begin][i] == 1 && !visited[i]){
                visited[i] = true;
                ret = Math.max(ret,backtrace(edges,i,cur + 1,visited));
                visited[i] = false;
            }
        }
        return ret;
    }
}

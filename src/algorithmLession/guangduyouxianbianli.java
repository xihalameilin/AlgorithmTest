package algorithmLession;

import java.util.*;

public class guangduyouxianbianli {
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

            Queue<Integer> points = new LinkedList<>();
            points.offer(begin);
            boolean[] visited = new boolean[size];
            visited[begin] = true;
            while(!points.isEmpty()){
                int start = points.poll();
                System.out.println(map.get(start) + " ");
                for(int i = 0 ; i < size ; i++){
                    if(edges[start][i] == 1 && !visited[i]){
                        points.offer(i);
                        visited[i] = true;
                    }

                }
                System.out.println();
            }
        }

    }
}

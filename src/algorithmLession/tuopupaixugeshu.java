package algorithmLession;

import java.util.*;
public class tuopupaixugeshu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int size = 26;
        while (t-- > 0){
            sc.nextLine();
            String s = sc.nextLine();
            String[] eds = s.split(",");

            Set<Integer> nodes = new HashSet<>();
            int[] indegrees = new int[size];
            int[][] edges = new int[size][size];
            for(String i : eds){
                int a = i.charAt(0) - 'a';
                int b = i.charAt(2) - 'a';
                edges[a][b] = 1;
                nodes.add(a);
                nodes.add(b);
                indegrees[b]++;
            }
            int res = 1;
            while(!nodes.isEmpty()){
                List<Integer> remove = new ArrayList<>();
                for(int i : nodes){
                    if(indegrees[i] == 0){
                        remove.add(i);
                    }
                }

                res *= remove.size();

                for(int i : remove){
                    for(int j = 0 ; j < size ; j++){
                        if(edges[i][j] > 0){
                            indegrees[j]--;
                        }
                    }
                    nodes.remove(i);
                }
            }
            System.out.println(res);
        }
    }
}

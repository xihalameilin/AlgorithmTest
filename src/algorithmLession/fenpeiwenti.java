package algorithmLession;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fenpeiwenti {
    static int min = 0;
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                sc.nextLine();
                String[] items = sc.nextLine().split(",");
                int[][] cost = new int[n][n];
                for (int i = 0; i < items.length; i++) {
                    String[] item = items[i].split(" ");
                    int a = Integer.parseInt(item[0]) - 1;
                    int b = Integer.parseInt(item[1]) - 1;
                    int c = Integer.parseInt(item[2]);
                    cost[a][b] = c;
                    //System.out.println(cost[a][b]);
                }
                min = Integer.MAX_VALUE;
                res = new ArrayList<>();
                backtrace(cost, new boolean[n], new ArrayList<>(), 0);
                res.sort(((o1, o2) -> {
                    for(int i = 0 ; i < o1.size() ; i++){
                        if(o1.get(i) > o2.get(i))
                            return -1;
                        else if(o1.get(i) < o2.get(i))
                            return 1;
                    }
                    return 0;
                }));

                for(int i  = 0 ; i < res.size() ; i++){
                    List<Integer> item = res.get(i);
                    for(int j = 0 ; j < item.size() ; j++){
                        if(j == item.size() - 1){
                            System.out.print(item.get(j));
                        }
                        else {
                            System.out.print(item.get(j) + " ");
                        }
                    }
                    if(i != res.size() - 1){
                        System.out.print(",");
                    }
                }
                System.out.println();
            }
        }
    }

    private static void backtrace(int[][] cost, boolean[] visited, List<Integer> temp,int sum){
        if(temp.size() == cost.length){
            if(sum < min){
                min = sum;
                res.clear();
                res.add(new ArrayList<>(temp));
            }
            else if(sum == min){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        int x = temp.size();
        for(int i = 0 ; i < cost.length ; i++){
            if(!visited[i] ){
                visited[i] = true;
                temp.add(i + 1);
                sum += cost[x][i];
                backtrace(cost,visited,temp,sum);
                sum -= cost[x][i];
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}

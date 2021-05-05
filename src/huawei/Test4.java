package huawei;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26];
        Set<Integer> teams = new HashSet<>();
        while(true){
            String detail = sc.nextLine();

            if(detail == null || detail.length() == 0){
                break;
            }
            String[] items = detail.split(" ");
            int team1 = items[0].charAt(0) - 'a';
            int team2 = items[0].charAt(2) - 'a';
            int score1 = Integer.parseInt(items[1].split(":")[0]);
            int score2 = Integer.parseInt(items[1].split(":")[1]);
            if(score1 > score2){
                arr[team1] += 3;
            }
            else if(score1 == score2){
                arr[team1] += 1;
                arr[team2] += 1;
            }
            else{
                arr[team2] += 3;
            }
            teams.add(team1);
            teams.add(team2);
        }


        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < 26 ; i++){
            if(teams.contains(i)){
                if(map.get(arr[i]) == null){
                    map.put(arr[i],new ArrayList<>());
                }
                map.get(arr[i]).add(i);
            }
        }



        StringBuilder sb = new StringBuilder();
        String table = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0 ; i < 26 ; i++){
            if(map.get(arr[i]) != null){
                Collections.sort(map.get(arr[i]));
            }
        }


        List<Integer> scores = new ArrayList<>(map.keySet());
        Collections.sort(scores,((o1, o2) -> (o2-o1)));
        for(int i = 0 ; i < scores.size() ; i++){
            List<Integer> ts = map.get(scores.get(i));
            for(int j : ts){
                char team = table.charAt(j);
                sb.append(team);
                sb.append(" ");
                sb.append(scores.get(i)+",");
            }
        }

        if(sb.length() == 0){
            System.out.println("");
        }
        else{
            System.out.println(sb.toString().substring(0,sb.length() - 1));
        }
    }
}

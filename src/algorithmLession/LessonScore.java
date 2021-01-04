package algorithmLession;


import java.util.*;

public class LessonScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseNum = sc.nextInt();
        while(testCaseNum-- > 0){
            int num = sc.nextInt();
            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0 ; i < num ; i++){
                List<Integer> temp = new ArrayList<>();
                temp.add(sc.nextInt());
                temp.add(sc.nextInt());
                temp.add(sc.nextInt());
                list.add(temp);
            }
            sort1(list,0);
            //print(list);
            //System.out.println("---------------------");

            for(int i = 0 ; i < num-1 ; i++){
                List<List<Integer>> to = new ArrayList<>();
                to.add(list.get(i));
                int begin = i;
                while(i+1 < num && list.get(i).get(0) == list.get(i+1).get(0)){
                    to.add(list.get(i+1));
                    i++;
                }
                int end = i;
                sort2(to,1);
//                System.out.println(">>>>>>>>>>>>>");
//                print(to);
//                System.out.println(">>>>>>>>>>>>>");
                int index = 0;
                for(;begin <= end ; begin++){
                    list.set(begin,to.get(index++));
                }
            }

            //print(list);
            //System.out.println("---------------------");
            for(int i = 0 ; i < num-1 ; i++){
                List<List<Integer>> to = new ArrayList<>();
                to.add(list.get(i));
                int begin = i;
                while(i+1 < num && list.get(i).get(1) == list.get(i+1).get(1) && list.get(i).get(0) == list.get(i+1).get(0)){
                    to.add(list.get(i+1));
                    i++;
                }
                int end = i ;
                sort1(to,2);
                int index = 0;
                for(;begin <= end ; begin++){
                    list.set(begin,to.get(index++));
                }

            }

            print(list);
        }
    }

    private static void print(List<List<Integer>> list){
        for(int i = 0 ; i < list.size() ; i ++){
            System.out.print(list.get(i).get(0) + " ");
            System.out.print(list.get(i).get(1) + " ");
            System.out.println(list.get(i).get(2));
        }
    }

    private static void sort1(List<List<Integer>> list,int index){
        Collections.sort(list, (o1, o2) -> o1.get(index) - o2.get(index));
    }

    private static void sort2(List<List<Integer>> list,int index){
        Collections.sort(list, (o1, o2) -> o2.get(index) - o1.get(index));
    }

}

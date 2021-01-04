package algorithmLession;

import java.util.*;

public class erchashu {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int testCaseNum = Integer.parseInt(sc.nextLine());
//        while(testCaseNum-- > 0){
//            int count = Integer.parseInt(sc.nextLine());
//            List<Integer> nodes = new ArrayList<>();
//            String[] items = sc.nextLine().split(" ");
//            Arrays.stream(items).forEach(item -> nodes.add(Integer.parseInt(item)));
//            levelTraversal(nodes);
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int testCaseNum = sc.nextInt();
            while (testCaseNum-- > 0) {
                int count = sc.nextInt();
                List<Integer> nodes = new ArrayList<>();
                while (count-- > 0) {
                    nodes.add(sc.nextInt());
                }
                levelTraversal(nodes);
            }
        }
    }

//    public static void main(String[] args) {
//        int t = 100;
//        while(t-- > 0){
//            int num = (int) (Math.random()*100);
//            List<Integer> temp = new ArrayList<>();
//            while(num-- > 0){
//                temp.add((int)(Math.random()*10));
//            }
//            System.out.print("测试用例: ");
//            temp.stream().forEach(item -> System.out.print(item+" "));
//            System.out.println();
//            levelTraversal(temp);
//        }
//    }



    private static void levelTraversal(List<Integer> nodes){
        int count = 1;
        int index = 0;
        int size = nodes.size();
        while(index < size){
            StringBuilder sb = new StringBuilder();
            int end = index + count < size ? index + count : size;
            List<Integer> temp = new ArrayList<>();
            for(int i = index ; i < end ; i++){
                temp.add(nodes.get(i));
            }
            index = end;
            Collections.sort(temp);
            count *= 2;
            for(int i = 0 ; i < temp.size() ; i++){
                if(i > 0){
                    if(temp.get(i) != temp.get(i-1)) {
                        System.out.print(temp.get(i));
                        if (i != size - 1)
                            System.out.print(" ");
                    }
                }
                else{
                    System.out.print(temp.get(0));
                    if(i != size-1)
                        System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
}

package algorithmLession;
//双向链表----开始

//class DoubleLinkNode {
//
//    public class TwoWayLinkedList {
//        private Node head;//表示链表头
//        private Node tail;//表示链表尾
//        private int size;//表示链表的节点个数
//
//        private class Node{
//            private Object data;
//            private Node next;
//            private Node prev;
//
//            public Node(Object data){
//                this.data = data;
//            }
//        }
//
//        public TwoWayLinkedList(){
//            size = 0;
//            head = null;
//            tail = null;
//        }
//
//        //在链表头增加节点
//        public void addHead(Object value){
//            Node newNode = new Node(value);
//            if(size == 0){
//                head = newNode;
//                tail = newNode;
//                size++;
//            }else{
//                head.prev = newNode;
//                newNode.next = head;
//                head = newNode;
//                size++;
//            }
//        }
//
//        //在链表尾增加节点
//        public void addTail(Object value){
//            Node newNode = new Node(value);
//            if(size == 0){
//                head = newNode;
//                tail = newNode;
//                size++;
//            }else{
//                newNode.prev = tail;
//                tail.next = newNode;
//                tail = newNode;
//                size++;
//            }
//        }
//
//        //删除链表头
//        public Node deleteHead(){
//            Node temp = head;
//            if(size != 0){
//                head = head.next;
//                head.prev = null;
//                size--;
//            }
//            return temp;
//        }
//
//        //删除链表尾
//        public Node deleteTail(){
//            Node temp = tail;
//            if(size != 0){
//                tail = tail.prev;
//                tail.next = null;
//                size--;
//            }
//            return temp;
//        }
//
//        //获得链表的节点个数
//        public int getSize(){
//            return size;
//        }
//        //判断链表是否为空
//        public boolean isEmpty(){
//            return (size == 0);
//        }
//
//        //显示节点信息
//        public void display(){
//            if(size >0){
//                Node node = head;
//                int tempSize = size;
//                if(tempSize == 1){//当前链表只有一个节点
//                    System.out.println("["+node.data+"]");
//                    return;
//                }
//                while(tempSize>0){
//                    if(node.equals(head)){
//                        System.out.print("["+node.data+"->");
//                    }else if(node.next == null){
//                        System.out.print(node.data+"]");
//                    }else{
//                        System.out.print(node.data+"->");
//                    }
//                    node = node.next;
//                    tempSize--;
//                }
//                System.out.println();
//            }else{//如果链表一个节点都没有，直接打印[]
//                System.out.println("[]");
//            }
//
//        }
//    }
//}
//双向链表----结束

//图的深度优先遍历、深度优先遍历----开始
//class GraphTraversing {
//    private Map<String, List<String>> graph = new HashMap<String, List<String>>();
//
//    /**
//     * 初始化图数据：使用邻居表来表示图数据。
//     */
//    public void initGraphData() {
////        图结构如下
////          1
////        /   \
////       2     3
////      / \   / \
////     4  5  6  7
////      \ | / \ /
////        8    9
//        graph.put("1", Arrays.asList("2", "3"));
//        graph.put("2", Arrays.asList("1", "4", "5"));
//        graph.put("3", Arrays.asList("1", "6", "7"));
//        graph.put("4", Arrays.asList("2", "8"));
//        graph.put("5", Arrays.asList("2", "8"));
//        graph.put("6", Arrays.asList("3", "8", "9"));
//        graph.put("7", Arrays.asList("3", "9"));
//        graph.put("8", Arrays.asList("4", "5", "6"));
//        graph.put("9", Arrays.asList("6", "7"));
//    }
//
//    /**
//     * 宽度优先搜索(BFS, Breadth First Search)
//     * BFS使用队列(queue)来实施算法过程
//     */
//    private Queue<String> queue = new LinkedList<String>();
//    private Map<String, Boolean> status = new HashMap<String, Boolean>();
//
//    /**
//     * 开始点
//     *
//     * @param startPoint
//     */
//    public void BFSSearch(String startPoint) {
//        //1.把起始点放入queue；
//        queue.add(startPoint);
//        status.put(startPoint, false);
//        bfsLoop();
//    }
//
//    private void bfsLoop() {
//        //  1) 从queue中取出队列头的点；更新状态为已经遍历。
//        String currentQueueHeader = queue.poll(); //出队
//        status.put(currentQueueHeader, true);
//        System.out.println(currentQueueHeader);
//        //  2) 找出与此点邻接的且尚未遍历的点，进行标记，然后全部放入queue中。
//        List<String> neighborPoints = graph.get(currentQueueHeader);
//        for (String poinit : neighborPoints) {
//            if (!status.getOrDefault(poinit, false)) { //未被遍历
//                if (queue.contains(poinit)) continue;
//                queue.add(poinit);
//                status.put(poinit, false);
//            }
//        }
//        if (!queue.isEmpty()) {  //如果队列不为空继续遍历
//            bfsLoop();
//        }
//    }
//
//
//    /**
//     * 深度优先搜索(DFS, Depth First Search)
//     * DFS使用队列(queue)来实施算法过程
//     * stack具有后进先出LIFO(Last Input First Output)的特性，DFS的操作步骤如下：
//     */
////     1、把起始点放入stack；
////     2、重复下述3步骤，直到stack为空为止：
////    从stack中访问栈顶的点；
////    找出与此点邻接的且尚未遍历的点，进行标记，然后全部放入stack中；
////    如果此点没有尚未遍历的邻接点，则将此点从stack中弹出。
//
//    private Stack<String> stack = new Stack<String>();
//    public void DFSSearch(String startPoint) {
//        stack.push(startPoint);
//        status.put(startPoint, true);
//        dfsLoop();
//    }
//
//    private void dfsLoop() {
//        if(stack.empty()){
//            return;
//        }
//        //查看栈顶元素，但并不出栈
//        String stackTopPoint = stack.peek();
//        //  2) 找出与此点邻接的且尚未遍历的点，进行标记，然后全部放入queue中。
//        List<String> neighborPoints = graph.get(stackTopPoint);
//        for (String point : neighborPoints) {
//            if (!status.getOrDefault(point, false)) { //未被遍历
//                stack.push(point);
//                status.put(point, true);
//                dfsLoop();
//            }
//        }
//        System.err.println(stack.size());
//        String popPoint =  stack.pop();
//        System.out.println(popPoint);
//    }
//
//    public static void main(String[] args) {
//        GraphTraversing test = new GraphTraversing();
//        test.initGraphData();
//        test.BFSSearch("1");
////        test.DFSSearch("1");
//    }
//}

//图的深度优先遍历、深度优先遍历----结束

//Map排序，map排序----开始
//public class MapSort {
//
//    /**
//     * 根据map的key排序
//     *
//     * @param map 待排序的map
//     * @param isDesc 是否降序，true：降序，false：升序
//     * @return 排序好的map
//     * @author zero 2019/04/08
//     */
//    public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map, boolean isDesc) {
//        Map<K, V> result = new LinkedHashMap<>();
//        if (isDesc) {
//            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed())
//                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
//        } else {
//            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey())
//                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
//        }
//        return result;
//    }
//
//    /**
//     * 根据map的value排序
//     *
//     * @param map 待排序的map
//     * @param isDesc 是否降序，true：降序，false：升序
//     * @return 排序好的map
//     * @author zero 2019/04/08
//     */
//    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, boolean isDesc) {
//        Map<K, V> result = new LinkedHashMap<>();
//        if (isDesc) {
//            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue().reversed())
//                    .forEach(e -> result.put(e.getKey(), e.getValue()));
//        } else {
//            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue())
//                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
//        }
//        return result;
//    }
//}
//Map排序，map排序----结束

//获取排列可能性----开始
///**
// * JAVA获得一个数组的指定长度的排列组合。<br>
// *
// * @author JAVA世纪网(java2000.net, laozizhu.com)
// */
//public class PaiLie {
//    public static void main(String[] args) {
//        PaiLie t = new PaiLie();
//        Object[] arr = { 1, 2, 3 };
//        // 循环获得每个长度的排列组合
//        for (int num = 1; num <= arr.length; num++) {
//            t.getSequence(arr, 0, num);
//        }
//    }
//
//    private List<List> gaterList=new ArrayList<>();
//    // 存储结果的堆栈
//    private Stack<Object> stack = new Stack<Object>();
//    /**
//     * 获得指定数组从指定开始的指定数量的数据组合<br>
//     *
//     * @param arr 指定的数组
//     * @param begin 开始位置
//     * @param num 获得的数量
//     */
//    public void getSequence(Object[] arr, int begin, int num) {
//        if (num == 0) {
//            List<Object> stackList=new ArrayList<Object>(stack);
//            gaterList.add(stackList);
//            System.out.println(stack); // 找到一个结果
//
//        } else {
//            // 循环每个可用的元素
//            for (int i = begin; i < arr.length; i++) {
//                // 当前位置数据放入结果堆栈
//                stack.push(arr[i]);
//                // 将当前数据与起始位置数据交换
//                swap(arr, begin, i);
//                // 从下一个位置查找其余的组合
//                getSequence(arr, begin + 1, num - 1);
//                // 交换回来
//                swap(arr, begin, i);
//                // 去除当前数据
//                stack.pop();
//            }
//        }
//    }
//    /**
//     * 交换2个数组的元素
//     *
//     * @param arr 数组
//     * @param from 位置1
//     * @param to 位置2
//     */
//    public static void swap(Object[] arr, int from, int to) {
//        if (from == to) {
//            return;
//        }
//        Object tmp = arr[from];
//        arr[from] = arr[to];
//        arr[to] = tmp;
//    }
//}

//获取排列可能性----结束

//获取所有的组合，组合----开始
//public class ZUHE {
//
//    static List<List<Integer>> allGather=new ArrayList<>();
//
//    static void getAllGather(int num,int target){
//        int[] a=new int[num];
//        for (int i=1;i<=num;i++){
//            a[i-1]=i;
//        }
//        int[] b=new int[target];//存放组合结果的数组
//        submit(a,0,0,target,b);
//
//    }
//    static void submit(int[] a,int c,int i,int n,int[] b)
//    {//a原始数组，c循环的开始值，i数组b索引，n控制递归的次数，b存放结果的数组
//        for(int j=c;j<a.length-(n-1);j++)
//        {
//            b[i]=a[j];
//            if(n==1)
//            {
//                List<Integer> re=new ArrayList<>();
//                for (int intInb:b){
//                    re.add(intInb);
//                }
//                allGather.add(re);
////                System.out.println(Arrays.toString(b));
//            }
//            else
//            {
//                n--;
//                i++;
//                submit(a,j+1,i,n,b);//递归调用
//                n++;//还原n,i的值
//                i--;
//            }
//        }
//    }
//}

//获取所有的组合，组合----结束


//单向链表，单链表---开始
//public class SingleLinkNode {
//
//    public class SingleLinkedList {
//        private int size;//链表节点的个数
//        private Node head;//头节点
//
//        public SingleLinkedList(){
//            size = 0;
//            head = null;
//        }
//
//        //链表的每个节点类
//        private class Node{
//            private Object data;//每个节点的数据
//            private Node next;//每个节点指向下一个节点的连接
//
//            public Node(Object data){
//                this.data = data;
//            }
//        }
//
//        //在链表头添加元素
//        public Object addHead(Object obj){
//            Node newHead = new Node(obj);
//            if(size == 0){
//                head = newHead;
//            }else{
//                newHead.next = head;
//                head = newHead;
//            }
//            size++;
//            return obj;
//        }
//
//        //在链表头删除元素
//        public Object deleteHead(){
//            Object obj = head.data;
//            head = head.next;
//            size--;
//            return obj;
//        }
//
//        //查找指定元素，找到了返回节点Node，找不到返回null
//        public Node find(Object obj){
//            Node current = head;
//            int tempSize = size;
//            while(tempSize > 0){
//                if(obj.equals(current.data)){
//                    return current;
//                }else{
//                    current = current.next;
//                }
//                tempSize--;
//            }
//            return null;
//        }
//
//        //删除指定的元素，删除成功返回true
//        public boolean delete(Object value){
//            if(size == 0){
//                return false;
//            }
//            Node current = head;
//            Node previous = head;
//            while(current.data != value){
//                if(current.next == null){
//                    return false;
//                }else{
//                    previous = current;
//                    current = current.next;
//                }
//            }
//            //如果删除的节点是第一个节点
//            if(current == head){
//                head = current.next;
//                size--;
//            }else{//删除的节点不是第一个节点
//                previous.next = current.next;
//                size--;
//            }
//            return true;
//        }
//
//        //判断链表是否为空
//        public boolean isEmpty(){
//            return (size == 0);
//        }
//
//        //显示节点信息
//        public void display(){
//            if(size >0){
//                Node node = head;
//                int tempSize = size;
//                if(tempSize == 1){//当前链表只有一个节点
//                    System.out.println("["+node.data+"]");
//                    return;
//                }
//                while(tempSize>0){
//                    if(node.equals(head)){
//                        System.out.print("["+node.data+"->");
//                    }else if(node.next == null){
//                        System.out.print(node.data+"]");
//                    }else{
//                        System.out.print(node.data+"->");
//                    }
//                    node = node.next;
//                    tempSize--;
//                }
//                System.out.println();
//            }else{//如果链表一个节点都没有，直接打印[]
//                System.out.println("[]");
//            }
//
//        }
//
//    }
//}

//单向链表，单链表---结束


///**
// * 书本分发
// * 给您N本书。
// * 每一本书都有Pi页数。
// * 您必须将图书分配给M个学生。
// * 可以有很多方法或排列方式。
// * 在每个排列中，将为M个学生之一分配最大页面数。
// * 在所有这些排列中，任务是找到特定排列，
// * 在该特定排列中分配给学生的最大页面数是所有其他排列中最小的页面，然后打印该最小值。
// * 每本书都会分配给一位学生。 每个学生至少要分配一本书。
// *
// * N个数字分M
// * 最大值的最小值
// */
//public class BooksDivide {
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testCaseNum=Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testCaseNum;i++){
//            int booksNum=Integer.parseInt(scanner.nextLine());
//            String[] bookPagesSplit = scanner.nextLine().split(" ");
//            List<Integer> bookPages=new ArrayList<>();
//            for (int m=0;m<booksNum;m++){
//                bookPages.add(Integer.parseInt(bookPagesSplit[m]));
//            }
//            int studentNum=Integer.parseInt(scanner.nextLine());
//            System.out.println(getTotalMinTime(bookPages,booksNum,studentNum));
//        }
//    }
//
//    //类似于用桶装东西的二分法
//
//    public static int getTotalMinTime(List<Integer> wallTime, int wallsNum, int paintersNum){
//        if (wallsNum==1){
//            return wallTime.get(0);
//        }
//        int sum=0;
//        int singleMax=0;
//        for (int eachT:wallTime){
//            if (eachT>singleMax){
//                singleMax=eachT;
//            }
//            sum+=eachT;
//        }
//
//        if (paintersNum==1){
//            return sum;
//        }
//
////        Collections.sort(wallTime);
//        return getSuitableTime(wallTime,singleMax,sum,paintersNum);
//
//    }
//
//    public static int getSuitableTime(List<Integer> wallTime, int minTime, int maxTime, int paintersNum){
//        if (minTime==maxTime){
//            return maxTime;
//        }
//        int mid=(minTime+maxTime)/2;
//        int tempSum=0;
//        int workers=1;
//        for (int eachT:wallTime){
//            tempSum=tempSum+eachT;
//            if (tempSum>mid){
//                workers++;
//                tempSum=eachT;
//            }
//
//        }
////        System.err.println(minTime+":"+maxTime+":"+mid+":"+workers);
//        if (workers<=paintersNum){
//            return getSuitableTime(wallTime,minTime,mid,paintersNum);
//        }else{
//            return getSuitableTime(wallTime,mid+1,maxTime,paintersNum);
//        }
//    }
//}
//
//
//package Review;
//
//        import java.util.HashMap;
//        import java.util.Map;
//        import java.util.Scanner;
//
///**
// * 牛的繁殖问题
// * 奇怪的奶牛，一直生
// */
//public class BornCow {
//
//    static Map<Long, Long> map = new HashMap<Long, Long>();
//
//    public static long fib(long n) {
//        if (n == 0)
//            return 0;
//        if (n == 2 || n == 1)
//            return 1;
////check if already exists in map ( precalculated val)
//        if (map.containsKey(n))
//            return map.get(n);
//        if (n % 2 != 0) {
//            long k = (n + 1) / 2;
//            map.put(n, (fib(k) * fib(k) + fib(k - 1) * fib(k - 1)) % 1000000007);
//        } else {
//            long k = n / 2;
//            map.put(n, (fib(k) * ((fib(k - 1) << 1) + fib(k))) % 1000000007);
//
//        }
//        return map.get(n);
//    }
//
//    public static void main(String[] args) {
//        Scanner ab = new Scanner(System.in);
//        int t = ab.nextInt();
//        while (t-- > 0) {
//            System.out.println(fib(ab.nextLong() + 1));
//        }
//    }
//}
//
//
//
///**
// * 冒泡排序
// * 相邻的互换
// */
//public class BubbleSort {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        while (scanner.hasNextLine()){
//            String[] s = scanner.nextLine().split(" ");
//            int[] arr=new int[Integer.parseInt(s[0])];
//            for (int i=1;i<s.length;i++){
//                arr[i-1]=Integer.parseInt(s[i]);
//            }
//            copeBubbleSort(arr);
//        }
//    }
//
//    public static void copeBubbleSort(int[] arr){
//        arr=bubbleSort(arr);
//        StringBuilder stringBuilder=new StringBuilder();
//        for (int eachNum:arr){
//            stringBuilder.append(eachNum).append(" ");
//        }
//        System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
//    }
//
//    public static int[] bubbleSort(int[] arr){
//        if (arr.length<=1){
//            return arr;
//        }
//
//        for (int i=arr.length-1;i>=0;i--){
//            for (int j=0;j<=i-1;j++){
//                if (arr[j]>arr[j+1]){
//                    int temp=arr[j];
//                    arr[j]=arr[j+1];
//                    arr[j+1]=temp;
//                }
//            }
//        }
//        return arr;
//    }
//}
//
//
///**
// * 如何花最少的钱购买蔬菜
// * 买蔬菜
// * 相邻的不买一样的蔬菜
// */
//public class BuyVegetables {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cases = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < cases; i++) {
//            int n = Integer.parseInt(scanner.nextLine());
//            int[][] array = new int[n][3];
//            for (int j = 0; j < n; j++) {
//                String[] info = scanner.nextLine().split("\\s");
//                array[j][0] = Integer.parseInt(info[0]);
//                array[j][1] = Integer.parseInt(info[1]);
//                array[j][2] = Integer.parseInt(info[2]);
//            }
//
//            System.out.println(purchase(array, n));
//        }
//    }
//
//    public static int purchase(int[][] array, int n) {
//        int[][] dp = new int[n][3];
//
//        for (int i = 0; i < 3; i++) {
//            dp[0][i] = array[0][i];
//        }
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < 3; j++) {
//                dp[i][j] = Math.min(getMin(dp[i - 1], 0, j - 1), getMin(dp[i - 1], j + 1, 2)) + array[i][j];
//            }
//        }
//        int result = Integer.MAX_VALUE;
//        for (int i = 0; i < 3; i++) {
//            if (dp[n - 1][i] < result) {
//                result = dp[n - 1][i];
//            }
//        }
//        return result;
//    }
//
//    private static int getMin(int[] array, int start, int end) {
//        int min = Integer.MAX_VALUE;
//        for (int i = start; i <= end; i++) {
//            if (array[i] < min) {
//                min = array[i];
//            }
//        }
//        return min;
//    }
//}
//
//
///**
// * 是否能通过考试
// * 描述
// *
// * 小张想要通过明天的考试。他知道考题的分值分布，也知道考试中要拿到每一个题目需要耗费的时间。假设考试时长为h，共n个题目，需要拿到p分才能通过考试。
// * 现在已知每个考题的得分与耗时，请你判断小张能否通过合理安排时间，而通过考试，并给出通过考试的最短时间。
// */
//public class CanPassTheExam {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int z = scanner.nextInt();
//        for (int a = 0; a < z; a++) {
//            int n = scanner.nextInt();
//            int time = scanner.nextInt();
//            int score = scanner.nextInt();
//            int dp[][] = new int[n + 1][time + 1];
//            for (int i = 1; i <= n; i++) {
//                int t = scanner.nextInt();
//                int p = scanner.nextInt();
//                for (int j = 0; j <= time; j++) {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
//                    if (j + t <= time) {
//                        dp[i][j + t] = dp[i - 1][j] + p;
//                    }
//                }
//            }
//            int min = time + 1;
//            for (int i = 0; i <= time; i++) {
//                if (dp[n][i] >= score) {
//                    min = i;
//                    break;
//                }
//            }
//            if (min > time) {
//                System.out.println("NO");
//            } else {
//                System.out.println("YES " + min);
//            }
//        }
//    }
//}
//
//package Review;
//
//        import java.util.Arrays;
//        import java.util.Scanner;
//
///**
// * 硬币最小数量
// * 描述
// * 根据给定的硬币计算出是否能组成规定的金额
// * Given the list of coins of distinct denominations and total amount of money.
// * Output the minimum number of coins required to make up that amount.
// * Output -1 if that money cannot be made up using given coins.
// * You may assume that there are infinite numbers of coins of each type.
// * 输入
// * The first line contains 'T' denoting the number of test cases.
// * Then follows description of test cases.
// * Each cases begins with the two space separated integers 'n' and 'amount'
// * denoting the total number of distinct coins and total amount of money respectively.
// * The second line contains N space-separated integers A1, A2, ..., AN denoting the values of coins.
// * Constraints:1<=T<=30，1<=n<=100，1<=Ai<=1000，1<=amount<=100000
// * 输入样例 1
// *
// * 2
// * 3 11
// * 1 2 5
// * 2 7
// * 2 6
// * 输出样例 1
// *
// * 3
// * -1
// */
//public class CompositeMoneyByIcons {
//    public static void main (String[] args)
//    {
//        Scanner s = new Scanner(System.in);
//        int t = s.nextInt();
//        while(t-->0){
//            int m = s.nextInt();
//            int v = s.nextInt();
//            int[] coins = new int[m];
//
//            for(int i=0;i<m;i++){
//                coins[i] = s.nextInt();
//            }
//            int[] dp = new int[v+1];
//            Arrays.fill(dp,Integer.MAX_VALUE);
//            dp[0] = 0;
//            for(int i=0;i<=v;i++){
//                for(int j=0;j<m;j++){
//                    if(i>=coins[j]){
//                        if(dp[i-coins[j]]!=Integer.MAX_VALUE && dp[i-coins[j]]+1<dp[i]){
//                            dp[i] = dp[i-coins[j]]+1;
//                        }
//                    }
//                }
//            }
//            if(dp[v]!=Integer.MAX_VALUE)
//                System.out.println(dp[v]);
//            else
//                System.out.println(-1);
//        }
//    }
//}
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * 计数排序
// * 类似于桶排序，只不过区间间隔为1
// */
//public class CountingSort {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        while (scanner.hasNextLine()){
//            String[] s = scanner.nextLine().split(" ");
//            int[] arr=new int[Integer.parseInt(s[0])];
//            for (int i=1;i<s.length;i++){
//                arr[i-1]=Integer.parseInt(s[i]);
//            }
//            copeCountSort(arr);
//        }
//    }
//
//    public static void copeCountSort(int[] arr){
//        arr=countSort(arr);
//        StringBuilder stringBuilder=new StringBuilder();
//        for (int eachNum:arr){
//            stringBuilder.append(eachNum).append(" ");
//        }
//        System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
//    }
//
//    public static int[] countSort(int[] arr){
//        if (arr.length<=1){
//            return arr;
//        }
//        int minValue=arr[0];
//        int maxValue=arr[1];
//        for (int eachNum:arr){
//            minValue=Math.min(eachNum,minValue);
//            maxValue=Math.max(eachNum,maxValue);
//        }
//
//        int[] countingArr=new int[maxValue-minValue+1];
//        for (int i=0;i<countingArr.length;i++){
//            countingArr[i]=0;
//        }
//        for (int eachN:arr){
//            countingArr[eachN-minValue]=countingArr[eachN-minValue]+1;
//        }
//
//        int index=0;
//        for (int i=0;i<maxValue-minValue+1;i++){
//            int num=minValue+i;
//            if (countingArr[i]>0){
//                for (int m=0;m<countingArr[i];m++){
//                    arr[index]=num;
//                    index++;
//                }
//            }
//
//        }
//
//        return arr;
//    }
//}
//
//package Review;
//
//        import java.util.Arrays;
//        import java.util.Comparator;
//        import java.util.PriorityQueue;
//        import java.util.Scanner;
//
///**
// * 格子里的整数
// * 棋盘最短路径
// * 最短路径
// */
//public class FindShortestPathInChessBord {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int t=sc.nextInt();
//        while(t>0) {
//            int n=sc.nextInt();
//            int[][] a=new int[n][n];
//            for(int i=0; i<n; i++) {
//                for(int j=0; j<n; j++)
//                    a[i][j]=sc.nextInt();
//            }
//            mcp(a, n);
//            t--;
//        }
//    }
//
//    static boolean isVal(int x, int y, int n) {
//        return ((x>=0) && (y>=0) && (x<n) && (y<n));
//    }
//
//    static void mcp(int[][] a, int n) {
//
//        int[] dx={-1,0,1,0};
//        int[] dy={0,1,0,-1};
//
//        int[][] d=new int[n][n];
//        for(int i=0; i<n; i++)
//            Arrays.fill(d[i], Integer.MAX_VALUE);
//        d[0][0]=a[0][0];
//
//        PriorityQueue<Pair> pq=new PriorityQueue<>(10, new myComp());
//        pq.add(new Pair(0, 0, a[0][0]));
//        boolean[][] vis=new boolean[n][n];
//
//        while(!pq.isEmpty()) {
//
//            Pair p=pq.poll();
//            vis[p.x][p.y]=true;
//
//            if((p.x==(n-1)) && (p.y==(n-1)))
//                break;
//
//            for(int i=0; i<4; i++) {
//
//                int newx=p.x+dx[i];
//                int newy=p.y+dy[i];
//
//                if(!isVal(newx, newy, n))
//                    continue;
//
//                if(!vis[newx][newy]) {
//
//                    if(d[newx][newy]>(d[p.x][p.y]+a[newx][newy]))
//                        d[newx][newy]=d[p.x][p.y]+a[newx][newy];
//                    pq.add(new Pair(newx, newy, d[newx][newy]));
//                    vis[newx][newy]=true;
//                }
//            }
//        }
//
//        System.out.println(d[n-1][n-1]);
//    }
//}
//
//class Pair {
//
//    int x, y, d;
//    Pair(int x, int y, int d) {
//
//        this.x=x;
//        this.y=y;
//        this.d=d;
//    }
//}
//
//class myComp implements Comparator<Pair> {
//
//    public int compare(Pair p1, Pair p2) {
//
//        return (p1.d-p2.d);
//    }
//}
//
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * 路上的球
// * 球分布在路上两边，只有一样数据
// */
//public class GetBallsOnRoads {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testcaseNum=Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testcaseNum;i++){
//            int firstRoadBalls=scanner.nextInt();
//            int secondRoadBalls=scanner.nextInt();
//            int[] firstBallArr=new int[firstRoadBalls];
//            int[] secondBallArr=new int[secondRoadBalls];
//            for (int m=0;m<firstRoadBalls;m++){
//                firstBallArr[m]=scanner.nextInt();
//            }
//            for (int m=0;m<secondRoadBalls;m++){
//                secondBallArr[m]=scanner.nextInt();
//            }
//
//
//            System.out.println(getMAXBalls(firstRoadBalls,secondRoadBalls,firstBallArr,secondBallArr));
//        }
//    }
//
//    public static long getMAXBalls(int firstBalls,int secondBalls,int[] firstBallArr,int[] secondBallArr){
//        long firstSum = 0, secondSum = 0, res = 0;
//        int i = 0, j = 0;
//        while (i < firstBalls && j < secondBalls) {
//            if (firstBallArr[i] < secondBallArr[j]) {
//                firstSum += firstBallArr[i++];
//            } else if (firstBallArr[i] > secondBallArr[j]) {
//                secondSum += secondBallArr[j++];
//            } else {
//                res += Math.max(firstSum, secondSum) + firstBallArr[i];
//                firstSum = 0;
//                secondSum = 0;
//                ++i;
//                ++j;
//            }
//        }
//        while (i < firstBalls) {
//            firstSum += firstBallArr[i++];
//        }
//        while (j < secondBalls) {
//            secondSum += secondBallArr[j++];
//        }
//        res += Math.max(firstSum, secondSum);
//        return res;
//
//    }
//}
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * 有9个因数的数
// * 9因数
// */
//public class HaveNineDivisor {
//    // Function to count numbers having
//// exactly 9 divisors
//    static int countNumbers(int n) {
//        int c = 0;
//
//        int limit = (int) Math.sqrt(n);
//
//        // Sieve array
//        int prime[] = new int[limit + 1];
//
//        // initially prime[i] = i
//        for (int i = 1; i <= limit; i++) {
//            prime[i] = i;
//        }
//
//        // use sieve concept to store the
//        // first prime factor of every number
//        for (int i = 2; i * i <= limit; i++) {
//            if (prime[i] == i) {
//                // mark all factors of i
//                for (int j = i * i; j <= limit; j += i) {
//                    if (prime[j] == j) {
//                        prime[j] = i;
//                    }
//                }
//            }
//        }
//
//        // check for all numbers if they can be
//        // expressed in form p*q
//        for (int i = 2; i <= limit; i++) {
//            // p prime factor
//            int p = prime[i];
//
//            // q prime factor
//            int q = prime[i / prime[i]];
//
//            // if both prime factors are different
//            // if p*q<=n and q!=
//            if (p * q == i && q != 1 && p != q) {
//                c += 1;
//            } else if (prime[i] == i) {
//
//                // Check if it can be expressed as p^8
//                if (Math.pow(i, 8) <= n) {
//
//                    c += 1;
//                }
//            }
//        }
//
//        return c;
//    }
//    // Driver Code
//    public static void main (String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cases = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < cases; i++) {
//            int num=Integer.parseInt(scanner.nextLine());
//            System.out.println(countNumbers(num));
//        }
//    }
//}
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * 插入排序
// */
//public class InsertSort {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testCaseNum=Integer.parseInt(scanner.nextLine());
//        while (testCaseNum>0){
//            String[] s = scanner.nextLine().split(" ");
//            int arr[]=new int[s.length-1];
//            for (int i=1;i<s.length;i++){
//                arr[i-1]=Integer.parseInt(s[i]);
//            }
//            copeInsertSort(arr);
//            testCaseNum--;
//        }
//    }
//
//    public static void copeInsertSort(int[] arr){
//        arr=insertSort(arr);
//        StringBuilder stringBuilder=new StringBuilder();
//        for (int eachNum:arr){
//            stringBuilder.append(eachNum).append(" ");
//        }
//        System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
//    }
//
//    public static int[] insertSort(int[] arr){
//        if (arr.length==1){
//            return arr;
//        }
//
//        for (int i=1;i<arr.length;i++){
//            int temp=arr[i];
//            int position=i;
//            for (int j=i-1;j>=0;j--){
//                if (arr[j]>temp){
//                    position--;
//
//                }else {
//                    break;
//                }
//            }
//            for (int j=i;j>position;j--){
//                arr[j]=arr[j-1];
//            }
//            arr[position]=temp;
//        }
//
//        return arr;
//    }
//}
//
//
//package Review;
//
//        import java.util.ArrayList;
//        import java.util.List;
//        import java.util.Scanner;
//
///**
// * 序号乘方
// * 用自己的力量杀人
// * Description
// *
// * There are Infinite People Standing in a row,
// * indexed from 1.A person having index 'i' has strength of (i*i).
// * You have Strength 'P'.
// * You need to tell what is the maximum number of People You can Kill With your Strength P.
// * You can only Kill a person with strength 'X' if P >= 'X' and after killing him,
// * Your Strength decreases by 'X'.
// *
// *
// * Input
// *
// * First line contains an integer 'T'
// * - the number of testcases,Each of the next 'T' lines
// * contains an integer 'P'- Your Power.
// * Constraints:1<=T<=100001<=P<=1000000000000000
// *
// *
// * Output
// *
// * For each testcase Output The maximum Number of People You can kill.
// */
//public class KillPersonWithPower {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testCaseNum=Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testCaseNum;i++){
//            long myPower=Long.parseLong(scanner.nextLine());
//            killPersonWithPower(myPower);
//        }
//    }
//
//    public static void killPersonWithPower(long power){
//        List<Long> strengthNeedToKill=new ArrayList<>();
//        strengthNeedToKill.add((long) 1);
//        long newStrength=0L;
//
//        while (power>=newStrength){
//            long preStrength=strengthNeedToKill.get(strengthNeedToKill.size()-1);
//            newStrength=(long) (preStrength+Math.pow(strengthNeedToKill.size()+1,2));
//            strengthNeedToKill.add(newStrength);
//
//        }
//        System.out.println(strengthNeedToKill.size()-1);
//    }
//}
//
//
//package Review;
//
//        import java.util.ArrayList;
//        import java.util.Collections;
//        import java.util.List;
//        import java.util.Scanner;
//
///**
// * https://blog.csdn.net/ydc_ss/article/details/102807967
// */
//
///**
// * 最长公共子序列
// * 描述
// * 给定两个字符串，返回两个字符串的最长公共子序列（不是最长公共子字符串），可能是多个。
// * 输入
// * 输入第一行为用例个数， 每个测试用例输入为两行，一行一个字符串
// *
// * 输出
// * 如果没有公共子序列，不输出，如果有多个则分为多行，按字典序排序。
// *
// * 输入样例 1
// *
// * 1
// * 1A2BD3G4H56JK
// * 23EFG4I5J6K7
// * 输出样例 1
// *
// * 23G456K
// * 23G45JK
// */
//
//public class LongestPublicSeq {
//
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int cases = Integer.valueOf(input.nextLine());
//        while(cases > 0) {
//            cases--;
//            String str1 = input.nextLine();
//            String str2 = input.nextLine();
//            firWay(str1, str2);
//        }
//
//    }
//
//    public static void firWay(String str1, String str2) {
//        int[][] count = new int[str1.length()+1][str2.length()+1];
//        int maxLen = 0;
//        for(int i=1; i<str1.length()+1; i++) {
//            for(int j=1; j<str2.length()+1;j++) {
//                if(str1.charAt(i-1) == str2.charAt(j-1)) {
//                    count[i][j] = count[i-1][j-1] + 1;
//                }
//                else {
//                    count[i][j] = Math.max(count[i-1][j], count[i][j-1]);
//                }
//                if(count[i][j] > maxLen) {
//                    maxLen = count[i][j];
//                }
//            }
//        }
//        List<String> maxFlag = new ArrayList<>();
//        String flag;
//        for(int i=1; i<str1.length()+1; i++) {
//            for(int j=1; j<str2.length()+1;j++) {
//                if(count[i][j] == maxLen) {
//                    flag = String.valueOf(i) + " " +String.valueOf(j);
//                    maxFlag.add(flag);
//                }
//            }
//        }
//        List<String> list = new ArrayList<>();
//        for(int f=0; f<maxFlag.size(); f++) {
//            String[] tip = maxFlag.get(f).split(" ");
//            int i = Integer.valueOf(tip[0]);
//            int j = Integer.valueOf(tip[1]);
//            String item = "";
//            findStr(list, count, str1, str2, i, j, item);
//        }//for
//        Collections.sort(list);
//        for(int i=0; i<list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//
//    }
//
//    public static void findStr(List<String> list, int[][] count, String str1, String str2, int i, int j, String item) {
//        if(i==0 || j==0) {
//            if(list.indexOf(item) == -1)
//                list.add(item);
//            return;
//        }
//        else {
//            if(str1.charAt(i-1) == str2.charAt(j-1)) {
//                String string = str1.charAt(i-1) + item;
//                findStr(list, count, str1, str2, i-1, j-1, string);
//            }
//            else if(count[i-1][j] > count[i][j-1]){
//                findStr(list, count, str1, str2, i-1, j, item);
//            }
//            else if(count[i-1][j] < count[i][j-1]) {
//                findStr(list, count, str1, str2, i, j-1, item);
//            }
//            else {
//                findStr(list, count, str1, str2, i-1, j, item);
//                findStr(list, count, str1, str2, i, j-1, item);
//            }
//        }
//    }
//}
//
//
//package Review;
//
//        import java.util.ArrayList;
//        import java.util.List;
//        import java.util.Scanner;
//
///**
// * 磁铁距离的相关计算
// * 磁铁
// * 左右两侧受力
// */
//public class MagnetDistance {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int test = sc.nextInt();
//        for (int i = 0; i < test; i++) {
//            int len = sc.nextInt();
//            int[] magnets = new int[len];
//            for (int j = 0; j < len; j++) {
//                magnets[j] = sc.nextInt();
//            }
//            System.out.println(String.join(" ", zeroForce(magnets)));
//        }
//    }
//
//    private static List<String> zeroForce(int[] magnets) {
//        List<String> res = new ArrayList<>();
//        for (int i = 0; i < magnets.length - 1; i++) {
//            res.add(String.format("%.2f", findPos(magnets, i, i + 1)));
//        }
//        return res;
//    }
//
//    private static double findPos(int[] magnets, int loIndex, int hiIndex) {
//        double lo = magnets[loIndex];
//        double hi = magnets[hiIndex];
//        double mid = (hi + lo) / 2;
//        double left = leftForce(magnets, loIndex, mid);
//        double right = rightForce(magnets, hiIndex, mid);
//        while (Math.abs(left - right) > 0.00001) {
//            if (Double.compare(left, right) < 0) {
//                hi = mid - 0.0000000000001;
//            } else {
//                lo = mid + 0.0000000000001;
//            }
//            mid = (hi + lo) / 2;
//            left = leftForce(magnets, loIndex, mid);
//            right = rightForce(magnets, hiIndex, mid);
//        }
//        return mid;
//    }
//
//    private static double leftForce(int[] magnets, int loIndex, double pos) {
//        double leftForce = 0;
//        for (int i = 0; i <= loIndex; i++) {
//            leftForce += 1.0 / (pos - magnets[i]);
//        }
//        return leftForce;
//    }
//
//    private static double rightForce(int[] magnets, int hiIndex, double pos) {
//        double rightForce = 0;
//        for (int i = hiIndex; i < magnets.length; i++) {
//            rightForce += 1.0 / (magnets[i] - pos);
//        }
//        return rightForce;
//    }
//}
//
//
//package Review;
//
//        import java.util.HashMap;
//        import java.util.Map;
//        import java.util.Scanner;
//
///**
// * 距离问题
// * 曼哈顿距离和欧几里得距离
// * 在给定的笛卡尔平面中，有N个点。 我们需要找到点对数（A，B）使得
// *
// * 点A和点B不重合。
// * 点之间的曼哈顿距离和欧几里得距离应相等。
// * 注意：2点对（A，B）与2点对（B，A）相同。
// *
// * 曼哈顿距离= | x2-x1 | + | y2-y1 |
// *
// * 欧氏距离=（（x2-x1）^ 2 +（y2-y1）^ 2）^ 0.5其中点是（x1，y1）和（x2，y2）。
// *
// * 约束：1 <= T <= 50，1 <= N <= 2 * 10 ^ 5，0 <=（| Xi |，| Yi |）<= 10 ^ 9
// */
//public class ManhattanEuclideanDistance {
//
//    public static void main (String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        while (t-- > 0) {
//            Map<Integer, Integer> x = new HashMap<>();
//            Map<Integer, Integer> y = new HashMap<>();
//            Map<String, Integer> xy = new HashMap<>();
//            for(int i = in.nextInt(); i > 0; i--) {
//                int cx = in.nextInt();
//                int cy = in.nextInt();
//                x.put(cx, x.getOrDefault(cx, 0) + 1);
//                y.put(cy, y.getOrDefault(cy, 0) + 1);
//                String key = cx + " " + cy;
//                xy.put(key, xy.getOrDefault(key, 0) + 1);
//            }
//
//            int res = 0;
//            for (Map.Entry<String, Integer> entry : xy.entrySet()) {
//                String[] key = entry.getKey().split(" ");
//                int cx = Integer.parseInt(key[0]);
//                int cy = Integer.parseInt(key[1]);
//                res += x.get(cx) + y.get(cy) - 2*entry.getValue();
//            }
//            System.out.println(res / 2);
//        }
//    }
//}
//
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * 字符串匹配问题
// * 描述
// *
// * Given a text txt[0..n-1] and a pattern pat[0..m-1],
// * write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[].
// * You may assume that n > m.
// *
// *
// * 输入
// *
// * 输入第一行是用例个数，
// * 后面一行表示一个用例；用例包括两部分，
// * 第一部分为给定文本，第二部分为搜索串，两部分使用","隔开。
// *
// *
// * 输出
// *
// * 每一个用例输出一行，每行按照找到的位置先后顺序排列，使用空格隔开。
// */
//public class MatchCaseInString {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testCaseNum=Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testCaseNum;i++){
//            String str=scanner.nextLine();
//            String[] strSplit=str.split(",");
//            String origin=strSplit[0];
//            String target=strSplit[1];
//            findAllPos(origin,target);
//        }
//    }
//
//    static void findAllPos(String origin,String target){
//        StringBuilder stringBuilder=new StringBuilder();
//        int cutNum=0;
//        while (origin.contains(target)){
//            int pos=origin.indexOf(target);
//            stringBuilder.append(pos+cutNum+" ");
//            cutNum=cutNum+pos+1;
//            origin=origin.substring(pos+1);
//        }
//        if (cutNum!=0){
//            System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
//        }else {
//            System.out.println();
//        }
//    }
//}
//
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * 数学公式
// * Implement pow(A, B) % C.In other words, given A, B and C, find (A^B)%C
// * 大数除法
// * 乘方 除法
// */
//public class MathDivideCompute {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cases = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < cases; i++) {
//            String[] nums = scanner.nextLine().split("\\s");
//            long result = calculate(nums);
//            System.out.println(result);
//        }
//    }
//
//    public static long calculate(String[] nums) {
//        long A = Long.parseLong(nums[0]);
//        long B = Long.parseLong(nums[1]);
//        long C = Long.parseLong(nums[2]);
//
//        return exp_mod(A, B, C);
//    }
//
//    private static long exp_mod(long a, long n, long b) {
//        long t;
//        if (n == 0) return 1 % b;
//        if (n == 1) return a % b;
//        t = exp_mod(a, n / 2, b);
//        t = t * t % b;
//        if ((n & 1) == 1) t = t * a % b;
//        return t;
//    }
//
//}
//
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * 矩阵计算
// * C(n)= 3C(i-1) + 4C(i-2) + 5C(i-3) + 6C(i-4)
// * 7的倍数
// */
//public class MatrixCompute {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cases = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < cases; i++) {
//            int n = Integer.parseInt(scanner.nextLine());
//
//            int count = 0;
//            for (int j = 1; j <= n; j++) {
//                for (int k = 1; k <= n; k++) {
//                    int tmp = (j * k) % 7;
//                    tmp = ((int) Math.pow(tmp, 3)) % 7;
//
//                    if (tmp == 2 || tmp == 3 || tmp == 4 || tmp == 6 || tmp == 0) {
//                        count++;
//                    }
//                }
//            }
//
//            System.out.println(count);
//        }
//    }
//}
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * 和最大的连续降序字符
// * 描述
// *
// * Archana is very fond of strings.
// * She likes to solve many questions related to strings.
// * She comes across a problem which she is unable to solve.
// * Help her to solve.
// * The problem is as follows: Given is a string of length L.
// * Her task is to find the longest string from the given string
// * with characters arranged in descending order of their ASCII code and in arithmetic progression.
// * She wants the common difference should be as low as possible(at least 1)
// * and the characters of the string to be of higher ASCII value.
// *
// *
// * 输入
// *
// * The first line of input contains
// * an integer T denoting the number of test cases.
// * Each test contains a string s of lengthL.
// *
// * 1<= T <= 100
// *
// * 3<= L <=1000
// *
// * A<=s[i]<=Z
// *
// * The string contains minimum three different characters.
// *
// *
// * 输出
// *
// * For each test case print the longest string.
// * Case 1:Two strings of maximum length are possible- “CBA” and “RPQ”.
// * But he wants the string to be of higher ASCII value therefore,
// * the output is “RPQ”.Case 2:The String of maximum length is “JGDA”.
// *
// * 输入样例 1
// *
// * 2
// * ABCPQR
// * ADGJPRT
// *
// * 输出样例 1
// *
// * RQP
// * JGDA
// */
//public class MaxSumReverseCharacter {
//
//    public static void main (String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while(t-->0) {
//            char[] s = sc.next().toCharArray();
//            boolean[] ch = new boolean[26];
//            for(int i = 0; i<s.length; i++)
//                ch[s[i]-'A'] = true;
//            String res = "";
//            for(int i = 1; i<26; i++) {
//                for(int j = 25; j>=0; j--) {
//                    if(ch[j]) {
//                        String temp = "";
//                        temp+=(char)('A'+j);
//                        for(int k = j-i; k>=0; k-=i) {
//                            if(ch[k])
//                                temp+=(char)('A'+k);
//                            else
//                                break;
//                        }
//                        if(temp.length()>res.length())
//                            res = temp;
//                    }
//                }
//            }
//            System.out.println(res);
//        }
//    }
//}
//
//package Review;
//
//        import java.util.ArrayList;
//        import java.util.Collections;
//        import java.util.List;
//        import java.util.Scanner;
//
///**
// * 按照要求保留数组元素使得和最大
// * 每次从数组中取一个值出来，并且删除与他数值上邻近的数字，要使得取出来的数值和最大
// * Ai-1
// * Ai
// */
//public class MaxSumWithDeleteElementNearby {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cases = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < cases; i++) {
//            int length = Integer.parseInt(scanner.nextLine());
//            String[] numStr = scanner.nextLine().split("\\s");
//            List<Integer> nums = new ArrayList<>();
//            for (String e : numStr) {
//                nums.add(Integer.parseInt(e));
//            }
//            System.out.println(findSum(nums));
//        }
//    }
//
//    public static int findSum(List<Integer> nums) {
//        int sum = 0;
//        Collections.sort(nums);
//
//        while (!nums.isEmpty()) {
//            int max = nums.get(nums.size() - 1);
//            nums.remove(nums.size() - 1);
//            for (int i = 0; i < nums.size(); i++) {
//                if (nums.get(i) == (max - 1)) {
//                    nums.remove(i);
//                    i--;
//                }
//            }
//
//            sum = sum + max;
//        }
//
//        return sum;
//    }
//
//}
//
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * 最小化初始点
// * 给定一个数组,由多个数字组成
// * ,假设一个值为X,代表我们的生命
// * 从array[0] [0]开始,向右或者向下移动,每次只能移动一步,
// * 每移动一次,将X加上当前格子里的数array[i] [j] (当然如果这里的数是负数就要扣掉我们的生命)
// * 最终目标是走到最后一个格子即:array[-1] [-1]
// * 问能到达最后一个格子,所需要的初始血量X,最少是多少
// * 到达每个点,更新后的值必须要大于1,任意时刻(哪怕是最后一个格子),小于1则不行
// * 最小生命值题目
// * 最低初始血量
// *
// * 每个用例的第一行两个数字分别代码行的数量和列的数量
// */
//public class MinInitialValue {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testcaseNum=Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testcaseNum;i++){
//            int R=scanner.nextInt();
//            int C=scanner.nextInt();
//            int[][] matrix=new int[R][C];
//            for (int m=0;m<R;m++){
//                for (int n=0;n<C;n++){
//                    matrix[m][n]=scanner.nextInt();
//                }
//            }
//            System.out.println(minInitialPoints(matrix,R,C));
//        }
//    }
//
//    //R：行的数量，C：列的数量
//    static int minInitialPoints(int points[][],int R,int C)
//    {
//        // dp[i][j] represents the minimum initial points player
//        // should have so that when starts with cell(i, j) successfully
//        // reaches the destination cell(m-1, n-1)
//        int dp[][] = new int[R][C];
//        int m = R, n = C;
//
//        // Base case
//        dp[m-1][n-1] = points[m-1][n-1] > 0? 1:
//                Math.abs(points[m-1][n-1]) + 1;
//
//        // Fill last row and last column as base to fill
//        // entire table
//        for (int i = m-2; i >= 0; i--)
//            dp[i][n-1] = Math.max(dp[i+1][n-1] - points[i][n-1], 1);
//        for (int j = n-2; j >= 0; j--)
//            dp[m-1][j] = Math.max(dp[m-1][j+1] - points[m-1][j], 1);
//
//        // fill the table in bottom-up fashion
//        for (int i=m-2; i>=0; i--)
//        {
//            for (int j=n-2; j>=0; j--)
//            {
//                int min_points_on_exit = Math.min(dp[i+1][j], dp[i][j+1]);
//                dp[i][j] = Math.max(min_points_on_exit - points[i][j], 1);
//            }
//        }
//
//        return dp[0][0];
//    }
//
//
//}
//
//
//package Review;
//
//        import java.util.ArrayList;
//        import java.util.List;
//        import java.util.Scanner;
//
///**
// * 时间分隔
// * 描述
// * 火车到站为题
// * 最少需要多少个站台
// * Given arrival and departure times of all trains that reach a railway station.
// * Your task is to find the minimum number of platforms required
// * for the railway station so that no train waits.
// * Note: Consider that all the trains arrive on the same day and leave on the same day.
// * Also, arrival and departure times must not be same for a train.
// *
// *
// * 输入样例 1
// *
// * 1
// * 6
// * 900  940 950  1100 1500 1800
// * 910 1200 1120 1130 1900 2000
// * 输出样例 1
// *
// * 3
// */
//public class MinTrainPlatform {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testCaseNum=Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testCaseNum;i++){
//            int trainNum=scanner.nextInt();
//            int[] arriveArray=new int[trainNum];
//            int[] departArray=new int[trainNum];
//            for (int m=0;m<trainNum;m++){
//                arriveArray[m]=scanner.nextInt();
//            }
//            for (int m=0;m<trainNum;m++){
//                departArray[m]=scanner.nextInt();
//            }
//            int minTrainPlatform = getMinTrainPlatform(trainNum, arriveArray, departArray);
//            System.out.println(minTrainPlatform);
//        }
//    }
//
//    public static int getMinTrainPlatform(int trainNum,int[] arriveArray,int[] departArray){
//        List<Integer> stayDepartTime=new ArrayList<>();
//        stayDepartTime.add(-1);
//        int maxStay=1;
//        for (int i=0;i<trainNum;i++){
//            int tempArrive=arriveArray[i];
//            int tempMAX=1;
//            for (int m=0;m<stayDepartTime.size();m++){
//                if (stayDepartTime.get(m)>tempArrive){
//                    tempMAX++;
//                }
//            }
//            stayDepartTime.add(departArray[i]);
//            maxStay= Math.max(maxStay,tempMAX);
//        }
//
//        return maxStay;
//    }
//}
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * 无重复字符子集问题
// * 子集里面没有两个数字含有相同的字符数字
// */
//public class NoDuplicateCharSubArray {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int testCaseNum = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < testCaseNum; i++) {
//            int numLen = Integer.parseInt(scanner.nextLine());
//            String numString = scanner.nextLine();
//            int[] allNums = new int[numLen];
//            String[] numSplit = numString.split("\\s");
//            for (int m = 0; m < numSplit.length; m++) {
//                allNums[m] = Integer.parseInt(numSplit[m]);
//            }
//            String last = "";
//            int maxSumOfSubArrayWithNoSameDigit = getMaxSumOfSubArrayWithNoSameDigit(allNums, numLen, last);
//            System.out.println(maxSumOfSubArrayWithNoSameDigit);
//        }
//    }
//
//    private static int getMaxSumOfSubArrayWithNoSameDigit(int[] nums, int arrayLen, String last) {
//        if (arrayLen == 0) {
//            return 0;
//        }
//
//        if (last.isEmpty()) {
//            String s = String.valueOf(nums[arrayLen - 1]);
//            int op1 = nums[arrayLen - 1] + getMaxSumOfSubArrayWithNoSameDigit(nums, arrayLen - 1, s);
//            int op2 = getMaxSumOfSubArrayWithNoSameDigit(nums, arrayLen - 1, last);
//            return Math.max(op1, op2);
//        } else {
//            String present = String.valueOf(nums[arrayLen - 1]);
//            int op1 = getMaxSumOfSubArrayWithNoSameDigit(nums, arrayLen - 1, last);
//            int op2 = 0;
//            if (!haveSameElementBetweenTwoString(present, last)) {
//                op2 = nums[arrayLen - 1] + getMaxSumOfSubArrayWithNoSameDigit(nums, arrayLen - 1, present + last);
//            }
//            return Math.max(op1, op2);
//        }
//    }
//
//    private static boolean haveSameElementBetweenTwoString(String a, String b) {
//        for (int i = 0; i < a.length(); i++) {
//            for (int j = 0; j < b.length(); j++) {
//                if (a.charAt(i) == b.charAt(j)) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//}
//
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * 非递归的归并排序
// * 归并排序
// * 合并排序
// * 非递归
// */
//public class NoneRecursiveMerge {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        while (scanner.hasNextLine()){
//            String[] s = scanner.nextLine().split(" ");
//            int[] arr=new int[Integer.parseInt(s[0])];
//            for (int i=1;i<s.length;i++){
//                arr[i-1]=Integer.parseInt(s[i]);
//            }
//            arr=mergeSort(arr);
//            StringBuilder stringBuilder=new StringBuilder();
//            for (int eachNum:arr){
//                stringBuilder.append(eachNum).append(" ");
//            }
//            System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
//        }
//    }
//
//    /**
//     * 归并排序（非递归）
//     * 从切分的数组长度为1开始，一次归并变回原来长度的2倍
//     * @param nums 待排序数组
//     * @return 排好序的数组
//     */
//    private static int[] mergeSort(int[] nums) {
//        int len = 1;
//        while (len <= nums.length) {
//            for (int i = 0; i + len <= nums.length; i += len * 2) {
//                int low = i, mid = i + len - 1, high = i + 2 * len - 1;
//                if (high > nums.length - 1) {
//                    high = nums.length - 1; //整个待排序数组为奇数的情况
//                }
//                merge(nums, low, mid, high);
//            }
//            len *= 2;
//        }
//        return nums;
//    }
//
//    /**
//     * 将切分的数组进行归并排序，同递归版
//     * @param nums 带排序数组
//     * @param low 左边数组第一个元素索引
//     * @param mid 左边数组最后一个元素索引，mid + 1为右边数组第一个元素索引
//     * @param high 右边数组最后一个元素索引
//     */
//    private static void merge(int[] nums, int low, int mid, int high) {
//        int[] tmpArray = new int[nums.length];
//        int rightIndex = mid + 1;
//        int tmpIndex = low;
//        int begin = low;
//        while (low <= mid && rightIndex <= high) {
//            if (nums[low] <= nums[rightIndex]) {
//                tmpArray[tmpIndex++] = nums[low++];
//            } else {
//                tmpArray[tmpIndex++] = nums[rightIndex++];
//            }
//        }
//        while (low <= mid) {
//            tmpArray[tmpIndex++] = nums[low++];
//        }
//        while (rightIndex <= high) {
//            tmpArray[tmpIndex++] = nums[rightIndex++];
//        }
//        while (begin <= high) {
//            nums[begin] = tmpArray[begin++];
//        }
//    }
//}
//
//
//package Review;
//
//
//        import java.util.Scanner;
//
///**
// * 非递归快排
// * 用栈实现
// */
//public class NoneRecursiveQuickSort {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        while (scanner.hasNextLine()){
//            String[] s = scanner.nextLine().split(" ");
//            int[] arr=new int[Integer.parseInt(s[0])];
//            for (int i=1;i<s.length;i++){
//                arr[i-1]=Integer.parseInt(s[i]);
//            }
//            QuickSort(arr);
//            StringBuilder stringBuilder=new StringBuilder();
//            for (int eachNum:arr){
//                stringBuilder.append(eachNum).append(" ");
//            }
//            System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
//        }
//    }
//
//    public static int partition(int []array, int low, int high){
//
//        int tmp=array[low];
//        while(low<high){
//            while(low<high&&array[high]>=tmp){
//                --high;
//            }
//            if(low>=high){
//                break;
//            }else{
//                array[low]=array[high];
//            }
//            while(low<high&&array[low]<=tmp){
//                ++low;
//            }
//            if(low>=high){
//                break;
//            }else{
//                array[high]=array[low];
//            }
//
//        }
//        array[low]=tmp;
//        return low;
//
//    }
//    //快速排序的非递归用栈来做
//    public static void QuickSort(int[]array){
//        int[]stack=new int[array.length];
//        int top=0;
//        int low=0;
//        int high=array.length-1;
//        int par= partition(array,low,high);
//        //入栈
//        if(par>low+1){
//            stack[top++]=low;
//            stack[top++]=par-1;
//        }
//        if(par<high-1){
//            stack[top++]=par+1;
//            stack[top++]=high;
//        }
//        //出栈
//        while(top>0){
//            high=stack[--top];
//            low=stack[--top];
//            par= partition(array,low,high);
//            if(par>low+1){
//                stack[top++]=low;
//                stack[top++]=par-1;
//            }
//            if(par<high-1){
//                stack[top++]=par+1;
//                stack[top++]=high;
//
//            }
//
//        }
//    }
//}
//
//
//package Review;
//
//        import java.util.ArrayList;
//        import java.util.Collections;
//        import java.util.List;
//        import java.util.Scanner;
//
///**
// * 漆狗屋
// * Description
// * Dilpreet wants to paint his dog- Buzo's home that has n boards
// * with different lengths[A1, A2,..., An].
// * He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board.
// * The problem is to find the minimum time to get this job done
// * under the constraints that any painter will only paint continuous sections of boards,
// * say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
// * Constraints:1<=T<=100,1<=k<=30,1<=n<=50,1<=A[i]<=500
// *
// *
// * Input
// *
// * The first line consists of a single integer T,
// * the number of test cases. For each test case,
// * the first line contains an integer k denoting the number of painters and
// * integer n denoting the number of boards.
// * Next line contains n- space separated integers denoting the size of boards.
// *
// *
// * Output
// *
// * For each test case, the output is an integer displaying the minimum time for painting that house.
// */
//public class PaintWalls {
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testCaseNum=Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testCaseNum;i++){
//            String[] paintGeneralSplit = scanner.nextLine().split(" ");
//            int personNum=Integer.parseInt(paintGeneralSplit[0]);
//            int wallNum=Integer.parseInt(paintGeneralSplit[1]);
//            String[] wallTimeSplit = scanner.nextLine().split(" ");
//            List<Integer> wallTimes=new ArrayList<>();
//            for (int m=0;m<wallNum;m++){
//                wallTimes.add(Integer.parseInt(wallTimeSplit[m]));
//            }
//            System.out.println(getTotalMinTime(wallTimes,wallNum,personNum));
//        }
//    }
//
//    //类似于用桶装东西的二分法
//
//    public static int getTotalMinTime(List<Integer> wallTime,int wallsNum,int paintersNum){
//        if (wallsNum==1){
//            return wallTime.get(0);
//        }
//        int sum=0;
//        int singleMax=0;
//        for (int eachT:wallTime){
//            if (eachT>singleMax){
//                singleMax=eachT;
//            }
//            sum+=eachT;
//        }
//
//        if (paintersNum==1){
//            return sum;
//        }
//
////        Collections.sort(wallTime);
//        return getSuitableTime(wallTime,singleMax,sum,paintersNum);
//
//    }
//
//    public static int getSuitableTime(List<Integer> wallTime,int minTime,int maxTime,int paintersNum){
//        if (minTime==maxTime){
//            return maxTime;
//        }
//        int mid=(minTime+maxTime)/2;
//        int tempSum=0;
//        int workers=1;
//        for (int eachT:wallTime){
//            tempSum=tempSum+eachT;
//            if (tempSum>mid){
//                workers++;
//                tempSum=eachT;
//            }
//
//        }
////        System.err.println(minTime+":"+maxTime+":"+mid+":"+workers);
//        if (workers<=paintersNum){
//            return getSuitableTime(wallTime,minTime,mid,paintersNum);
//        }else{
//            return getSuitableTime(wallTime,mid+1,maxTime,paintersNum);
//        }
//    }
//
//}
//
//package Review;
//
//        import java.util.ArrayList;
//        import java.util.List;
//        import java.util.Scanner;
//
///**
// * 管道网络
// * 描述
// * 水管水龙头
// * Every house in the colony has at most one pipe going into it and at most one pipe going out of it.
// * Tanks and taps are to be installed in a manner such that every house with one outgoing pipe
// * but no incoming pipe gets a tank installed on its roof
// * and every house with only an incoming pipe and no outgoing pipe gets a tap.
// * Find the efficient way for the construction of the network of pipes.
// *
// *
// * 输入
// *
// * The first line contains an integer T denoting the number of test cases.
// * For each test case,
// * the first line contains two integer
// * n & p denoting the number of houses and number of pipes respectively.
// * Next, p lines contain 3 integer inputs a, b & d,
// * d denoting the diameter of the pipe from the house a to house b.
// * Constraints:1<=T<=50，1<=n<=20，1<=p<=50，1<=a, b<=20，1<=d<=100
// *
// *
// * 输出
// *
// * For each test case,
// * the output is the number of pairs of tanks and taps installed i.e
// * n followed by n lines that contain three integers:
// * house number of tank,
// * house number of tap and
// * the minimum diameter of pipe between them.
// */
//public class PipeNetwork {
//
//    static int rd[] = new int[1100];
//    static int wt[] = new int[1100];
//    static int cd[] = new int[1100];
//    static List<Integer> a = new ArrayList<Integer>();
//    static List<Integer> b = new ArrayList<Integer>();
//    static List<Integer> c = new ArrayList<Integer>();
//    static int ans;
//    static int dfs(int w) {
//        if (cd[w] == 0)
//            return w;
//        if (wt[w] < ans)
//            ans = wt[w];
//        return dfs(cd[w]);
//    }
//
//
//    static void solve(int n, int p, int arr[][]) {
//        int i = 0;
//        while (i < p) {
//            int q = arr[i][0];
//            int h = arr[i][1];
//            int t = arr[i][2];
//            cd[q] = h;
//            wt[q] = t;
//            rd[h] = q;
//            i++;
//        }
//        a = new ArrayList<Integer>();
//        b = new ArrayList<Integer>();
//        c = new ArrayList<Integer>();
//
//        for (int j = 1; j <= n; ++j)
//            if (rd[j] == 0 && cd[j] > 0) {
//                ans = 1000000000;
//                int w = dfs(j);
//                a.add(j);
//                b.add(w);
//                c.add(ans);
//            }
//
//        System.out.println(a.size());
//
//        for (int j = 0; j < a.size(); ++j)
//            System.out.println(a.get(j) + " "
//                    + b.get(j) + " " + c.get(j));
//    }
//
//    public static void main(String args[]) {
//        for (int i = 0; i < 1100; i++)
//            rd[i] = cd[i] = wt[i] = 0;
//
//        Scanner scanner = new Scanner(System.in);
//        int cases = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < cases; i++) {
//            String[] info1 = scanner.nextLine().split("\\s");
//            int n = Integer.parseInt(info1[0]);
//            int p = Integer.parseInt(info1[1]);
//
//            int[][] arr = new int[p][3];
//            for (int j = 0; j < p; j++) {
//                String[] lines = scanner.nextLine().split("\\s");
//                arr[j][0] = Integer.parseInt(lines[0]);
//                arr[j][1] = Integer.parseInt(lines[1]);
//                arr[j][2] = Integer.parseInt(lines[2]);
//            }
//
//            solve(n, p, arr);
//        }
//    }
//
//}
//
//
//package Review;
//
//        import java.util.ArrayList;
//        import java.util.Scanner;
//
///**
// * 数组查询
// * 描述
// * 从数组最多删除一个元素，求子字符串最大和
// * 正着查一遍，反着查一遍
// *
// * Given an array,
// * the task is to complete the function which finds the maximum sum subarray,
// * where you may remove at most one element to get the maximum sum.
// *
// *
// * 输入
// *
// * 第一行为测试用例个数T；
// * 后面每两行表示一个用例，
// * 第一行为用例中数组长度N，第二行为数组具体内容。
// *
// *
// * 输出
// *
// * 每一行表示对应用例的结果。
// */
//public class QueryArrayDP {
//
//    public static void main(String[] args) {
//        Scanner scanner =new Scanner(System.in);
//        int testCaseNum=Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testCaseNum;i++){
//            int arrayLength=Integer.parseInt(scanner.nextLine());
//            String[] numsSplit = scanner.nextLine().split(" ");
//            int[] allNums=new int[arrayLength];
//            for (int m=0;m<arrayLength;m++){
//                allNums[m]=Integer.parseInt(numsSplit[m]);
//            }
//            System.out.println(getMaxSumOfSubArrayWithDeleteMostOneElement(allNums,arrayLength));
//        }
//    }
//
//    public static int getMaxSumOfSubArrayWithDeleteMostOneElement(int[] arr,int n){
//        int fw[] = new int[n];
//        int bw[] = new int[n];
//        int cur_max = arr[0], max_so_far = arr[0];
//        fw[0] = arr[0];
//
//        for (int i = 1; i < n; i++) {
//
//            cur_max = Math.max(arr[i], cur_max + arr[i]);
//            max_so_far = Math.max(max_so_far, cur_max);
//            fw[i] = cur_max;
//        }
//        cur_max = max_so_far = bw[n - 1] = arr[n - 1];
//
//        for (int i = n - 2; i >= 0; i--) {
//            cur_max = Math.max(arr[i], cur_max + arr[i]);
//            max_so_far = Math.max(max_so_far, cur_max);
//            bw[i] = cur_max;
//        }
//        int fans = max_so_far;
//        for (int i = 1; i < n - 1; i++)
//            fans = Math.max(fans, fw[i - 1] + bw[i + 1]);
//
//        return fans;
//
//    }
//}
//
//package Review;
//
///**
// * 递归的归并排序
// * 归并排序
// * 合并排序
// * 递归合并排序
// */
//public class RecursiveMerge {
//
//    /**
//     * 归并排序
//     * @param nums 待排序数组序列
//     * @return 排好序的数组序列
//     */
//    private static int[] mergeSort(int[] nums) {
//        segment(nums, 0, nums.length - 1);
//        return nums;
//    }
//
//    /**
//     * 递归切分待排
//     * @param nums 待切分数组
//     * @param left 待切分最后第一个元素的索引
//     * @param right 待切分数组最后一个元素的索引
//     */
//    private static void segment(int[] nums, int left, int right) {
//        if (left >= right)
//            return;
//        // 找出中间索引
//        int center = (left + right) / 2;
//        // 对左边数组进行递归
//        segment(nums, left, center);
//        // 对右边数组进行递归
//        segment(nums, center + 1, right);
//        // 合并
//        merge(nums, left, center, right);
//    }
//
//    /**
//     * 两两归并排好序的数组（2路归并）
//     * @param nums 带排序数组对象
//     * @param left 左边数组的第一个索引
//     * @param center 左数组的最后一个索引，center + 1右数组的第一个索引
//     * @param right 右数组的最后一个索引
//     */
//    private static void merge(int[] nums, int left, int center, int right) {
//        int[] tmpArray = new int[nums.length];
//        int rightIndex = center + 1;   // 右数组第一个元素索引
//        int tmpIndex = left;    //临时数组索引
//        int begin = left;   // 缓存左数组第一个元素的索引，用于将排好序的数组拷贝回原数组
//        while (left <= center && rightIndex <= right) {
//            if (nums[left] <= nums[rightIndex]) {
//                tmpArray[tmpIndex++] = nums[left++];
//            } else {
//                tmpArray[tmpIndex++] = nums[rightIndex++];
//            }
//        }
//        while (left <= center) {
//            tmpArray[tmpIndex++] = nums[left++];
//        }
//        while (rightIndex <= right) {
//            tmpArray[tmpIndex++] = nums[rightIndex++];
//        }
//        while (begin <= right) {
//            nums[begin] = tmpArray[begin++];
//        }
//    }
//}
//
//package Review;
//
///**
// * 递归快排
// * 先找基准，然后左右两边分别快排
// */
//public class RecursiveQuickSort {
//
//    //返回基准的下标
//    public static int partition(int []array, int low, int high){
//
//        int tmp=array[low];
//        while(low<high){
//            while(low<high&&array[high]>=tmp){
//                --high;
//            }
//            if(low>=high){
//                break;
//            }else{
//                array[low]=array[high];
//            }
//            while(low<high&&array[low]<=tmp){
//                ++low;
//            }
//            if(low>=high){
//                break;
//            }else{
//                array[high]=array[low];
//            }
//
//        }
//        array[low]=tmp;
//        return low;
//
//    }
//
//    public static void Quick(int[]array,int low,int high){
//        int par= partition(array,low,high);
//        if(par>low+1){//左边还需要快排
//            Quick(array,low,par-1);
//        }
//        if(par<high-1){//右边还需要快排
//            Quick(array,par+1,high);
//        }
//
//    }
//    public static void QuickSort(int[]array){
//        Quick(array,0,array.length-1);
//    }
//}
//
//package Review;
//
//        import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.ArrayList;
//        import java.util.Arrays;
//        import java.util.Collections;
//        import java.util.Scanner;
//
///**
// * 数字重组整除问题
// *  可以将数字的每一位交换顺序，重组，变成新的数字
// */
//public class ReRangeNumToDivide {
//
//    public static void main (String[] args)throws IOException
//    {
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        int t=Integer.parseInt(br.readLine());
//        while(t-- >0){
//            String str = br.readLine();
//            printArrayList(getPermutation(str));
//            System.out.println();
//
//        }
//    }
//    static void printArrayList(ArrayList<String> arrL)
//    {
//        arrL.remove("");
//
//        int h=arrL.size();
//        int[] arr=new int[h];
//        for (int i = 0; i < arrL.size(); i++) {
//            arr[i]=Integer.parseInt(arrL.get(i));
//        }
//        Arrays.sort(arr);
//        int count=0;
//        int nu=0;
//        for(int i=h-1;i>=0;i--){
//            if(arr[i]%17==0){
//                nu=arr[i];
//                count=1;
//                break;
//            }
//
//        }
//        if(count==1){
//            System.out.print(nu+" ");
//        }
//        else if(count==0){
//            System.out.print("Not Possible");
//        }
//    }
//
//
//
//
//
//
//
//    public static ArrayList<String> getPermutation(String str) {
//
//        if (str.length() == 0) {
//            ArrayList<String> empty = new ArrayList<>();
//            empty.add("");
//            return empty;
//        }
//
//
//        char ch = str.charAt(0);
//
//        String subStr = str.substring(1);
//
//
//        ArrayList<String> prevResult = getPermutation(subStr);
//
//
//        ArrayList<String> Res = new ArrayList<>();
//
//        for (String val : prevResult) {
//            for (int i = 0; i <= val.length(); i++) {
//                Res.add(val.substring(0, i) + ch + val.substring(i));
//            }
//        }
//
//
//        return Res;
//    }
//}
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * 倒置个数
// * 描述
// *
// * 有一个由N个实数构成的数组，
// * 如果一对元素A[i]和A[j]是倒序的，
// * 即i<j但是A[i]>A[j]则称它们是一个倒置，
// * 设计一个计算该数组中所有倒置数量的算法。
// * 要求算法复杂度为O(nlogn)
// * 输入
// * 输入有多行，第一行整数T表示为测试用例个数，后面是T个测试用例，每一个用例包括两行，第一行的一个整数是元素个数，第二行为用空格隔开的数组值。
// *
// * 输出
// * 输出每一个用例的倒置个数，一行表示一个用例。
// *
// * 输入样例 1
// *
// * 1
// * 8
// * 8 3 2 9 7 1 5 4
// * 输出样例 1
// *
// * 17
// */
//public class ReversePairInList {
//
//    static int pairNum=0;
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testCaseNum=Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testCaseNum;i++){
//            pairNum=0;
//            int arrayLength=Integer.parseInt(scanner.nextLine());
//            String[] arrayStringSplit = scanner.nextLine().split(" ");
//            int[] arr=new int[arrayLength];
//            for (int m=0;m<arrayLength;m++){
//                arr[m]=Integer.parseInt(arrayStringSplit[m]);
//            }
//            System.out.println(getReversePair(arr,arrayLength));
//        }
//    }
//
//    /**
//     * 根据归并排序的基本思想，我们来到计算逆序对。
//     * 在归并排序的合并操作时，数组被划分左右两部分，
//     * 此时假设左部分的逆序对有a个 ，右边有b个，
//     * 如果左边存在一个数a[i]大于右边的数b[j]，
//     * 由于两数组分别是有序的，那么从a[i]到左边结束部分的数字都比b[j]大，
//     * 即与b[j]有关的逆序对数=(左边部分的end)-i+1 个。
//     * 那么我们只需要在每次合并操作时统计这部分个数并求和，仅在merge函数内加一条语句。
//     * （ps:左右两部分内部的分别排序不会影响两部分之间的逆序对数，因为只是内部有序。）
//     */
//
//    static void merge(int a[],int start,int mid,int end){
//        int[] tmp=new int[end-start+1];
//        int s=start;
//        int m=mid+1;
//        int e=end;
//        int k=0;
//
//        while(s<=mid && m<=e){
//            if(a[s]>a[m]){
//                tmp[k++]=a[m++];
//                pairNum+=mid-s+1;           //逆序数增加 end- i + 1个
//            }
//            else{
//                tmp[k++]=a[s++];
//            }
//        }
//
//        while(s<=mid)
//            tmp[k++]=a[s++];
//        while(m<=e)
//            tmp[k++]=a[m++];
//
//        for (int i = 0; i < k; i++)
//            a[start + i] = tmp[i];
//
//    }
//
//
//
//    static void mergeSort(int[] a, int start, int end){
//        if(start==end)
//            return;
//
//        int mid=(start+end)/2;
//
//        mergeSort(a,start,mid);
//        mergeSort(a,mid+1,end);
//
//        merge(a,start,mid,end);
//
//    }
//
//
//    public static int getReversePair(int[] num,int arrLength){
//
//        mergeSort(num,0,arrLength-1);
//        return pairNum;
//    }
//}
//
//package Review;
//
//        import java.util.Arrays;
//        import java.util.Scanner;
//        import java.util.stream.Collectors;
//
///**
// * 根据给定的大小索引找数字
// */
//public class SearchIndexNumInServerArray {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for (int n = 0; n < t; n++) {
//            int nog = sc.nextInt(), noq = sc.nextInt();
//            long[] marks = new long[2 * nog];
//            long[] rank = new long[noq];
//            for (int i = 0; i < 2 * nog; i++) {
//                marks[i] = sc.nextLong();
//            }
//
//            for (int i = 0; i < noq; i++) {
//                rank[i] = sc.nextLong();
//            }
//
//            String res = Arrays.stream(search(marks, rank))
//                    .mapToObj(String::valueOf)
//                    .collect(Collectors.joining(" "));
//            System.out.println(res);
//        }
//    }
//
//    static long[] search(long[] interval, long[] rank) {
//        long[] res = new long[rank.length];
//        for (int i = 0; i < rank.length; i++) {
//            res[i] = marks(interval, rank[i]);
//        }
//        return res;
//    }
//
//    static long marks(long[] interval, long rank) {
//        long lMarks;
//        long rMarks;
//        for (int i = 0; i < interval.length - 1; i += 2) {
//            lMarks = interval[i];
//            rMarks = interval[i + 1];
//            long span = rMarks - lMarks + 1;
//            if (rank <= span) {
//                return lMarks + rank - 1;
//            } else {
//                rank = rank - span;
//            }
//        }
//        return 0;
//    }
//
//}
//
//package Review;
//
//        import java.util.ArrayList;
//        import java.util.List;
//        import java.util.Scanner;
//
///**
// * 整除查询
// * 描述
// *
// * Given an array of positive integers and many queries for divisibility.
// * In every query Q[i], we are given an integer K ,
// * we need to count all elements in the array which are perfectly divisible by K.
// *
// * Constraints:1<=T<=1001<=N,M<=1051<=A[i],Q[i]<=105
// *
// *
// * 输入
// *
// * The first line of input contains an integer T denoting the number of test cases.
// * Then T test cases follow. Each test case consists of three lines.
// * First line of each test case contains two integers N & M,
// * second line contains N space separated array elements
// * and third line contains M space separated queries.
// *
// *
// * 输出
// *
// * For each test case,In new line print the required count for each query Q[i].
// */
//public class SearchInteger {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testCaseNum=Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testCaseNum;i++){
//            String[] testCaseDesSplit = scanner.nextLine().split(" ");
//            int arrNum=Integer.parseInt(testCaseDesSplit[0]);
//            int queryNum=Integer.parseInt(testCaseDesSplit[1]);
//            List<Integer> allNums=new ArrayList<>();
//            List<Integer> allQuery=new ArrayList<>();
//            String[] allNumsSplit = scanner.nextLine().split(" ");
//            String[] allQuerySplit = scanner.nextLine().split(" ");
//            for (String eachS:allNumsSplit){
//                allNums.add(Integer.parseInt(eachS));
//            }
//            for (String eachQ:allQuerySplit){
//                allQuery.add(Integer.parseInt(eachQ));
//            }
//            getEachQueryNum(allNums,allQuery);
//        }
//    }
//
//    public static void getEachQueryNum(List<Integer> allNums,List<Integer> allQuery){
//        StringBuilder stringBuilder=new StringBuilder();
//        for (int eachQ:allQuery){
//            int t=0;
//            for (int eachN:allNums){
//                if (eachN%eachQ==0){
//                    t++;
//                }
//            }
//            stringBuilder.append(t).append(" ");
//        }
//
//        System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
//    }
//}
//
//package Review;
//
//        import java.util.ArrayList;
//        import java.util.List;
//        import java.util.Scanner;
//
///**
// * 实现Shell排序
// * shell排序中间输出结果
// * 描述
// * 实现Shell排序，对给定的无序数组，按照给定的间隔变化（间隔大小即同组数字index的差），
// * 打印排序结果，注意不一定是最终排序结果！
// * 输入
// * 输入第一行表示测试用例个数，后面为测试用例，
// * 每一个用例有两行，第一行为给定数组，第二行为指定间隔，每一个间隔用空格隔开。
// *
// * 输出
// * 输出的每一行为一个用例对应的指定排序结果。
// *
// * 输入样例 1
// *
// * 1
// * 49 38 65 97 76 13 27 49 55 4
// * 5 3
// * 输出样例 1
// *
// * 13 4 49 38 27 49 55 65 97 76
// */
//public class ShellSortMidPart {
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testCase = Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testCase;i++){
//            String sortingNumStr=scanner.nextLine();
//            String[] sortingNumSplit = sortingNumStr.split(" ");
//            List<Integer> allNums=new ArrayList<>();
//            for (String eachSortNumSplit:sortingNumSplit){
//                allNums.add(Integer.parseInt(eachSortNumSplit));
//            }
//            String stepString = scanner.nextLine();
//            String[] stepSplit=stepString.split(" ");
//            List<Integer> allSteps=new ArrayList<>();
//            for (String eachStepSplit:stepSplit){
//                allSteps.add(Integer.parseInt(eachStepSplit));
//            }
//            semiShell(allNums,allSteps);
//        }
//    }
//
//    public static void semiShell(List<Integer> sortingList, List<Integer> stepList){
//        for (int step :stepList) {
//            for (int i = 0; i < step; ++i)
//            {
//                /*
//                 * 以下，insertSort的变异
//                 */
//                for (int j = i + step; j < sortingList.size(); j += step)
//                {
//                    int k = j - step;
//                    for (; k >= i; k -= step)
//                        if (sortingList.get(k) <= sortingList.get(j))
//                            break;
//                    if (k != j - step)
//                    {
//                        int tmp = sortingList.get(j);
//                        for (int m = j; m > k + step; m -= step)
//                            sortingList.set(m,sortingList.get(m-step));
//                        sortingList.set(k + step, tmp);
//                    }
//                }
//            }
//        }
//
//        StringBuilder resBuilder=new StringBuilder();
//        for (int i=0;i<sortingList.size();i++){
//            resBuilder.append(sortingList.get(i)).append(" ");
//        }
//        System.out.println(resBuilder.substring(0,resBuilder.length()-1));
//    }
//}
//
//package Review;
//
//        import java.util.Arrays;
//        import java.util.Scanner;
//
///**
// * 按照另一个数组排序
// * 将第一个数字内部的数按照第二个数组的顺序排序
// */
//public class SortByAnotherArray {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String listNums = scanner.nextLine();
//
//        int listNumber = Integer.parseInt(listNums);
//        for (int i = 0; i < listNumber; i++) {
//            String line1=scanner.nextLine();
////            String[] numSplit=line1.split(" ");
////            int oneLength=Integer.parseInt(numSplit[0]);
////            int twoLength=Integer.parseInt(numSplit[1]);
//            String list1=scanner.nextLine();
//            String list2=scanner.nextLine();
//            String[] listOneSplit=list1.split(" ");
//            String[] listTwoSplit=list2.split(" ");
////            List<Integer> firstList=new ArrayList<>();
////            List<Integer> secondList=new ArrayList<>();
//            int[] firstList=new int[listOneSplit.length];
//            int[] secondList=new int[listTwoSplit.length];
//            for (int j=0;j<listOneSplit.length;j++){
//                firstList[j]=(Integer.parseInt(listOneSplit[j]));
////                firstList.add(Integer.parseInt(listOneSplit[j]));
//            }
//            for (int k=0;k<listTwoSplit.length;k++){
//                secondList[k]=(Integer.parseInt(listTwoSplit[k]));
////                secondList.add(Integer.parseInt(listTwoSplit[k]));
//            }
//            sortAccording(firstList,secondList,firstList.length,secondList.length);
//            printArray(firstList,firstList.length);
//        }
//    }
//
//    static int first(int arr[], int low, int high,
//                     int x, int n)
//    {
//        if (high >= low) {
//            /* (low + high)/2; */
//            int mid = low + (high - low) / 2;
//
//            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
//                return mid;
//            if (x > arr[mid])
//                return first(arr, (mid + 1), high,
//                        x, n);
//            return first(arr, low, (mid - 1), x, n);
//        }
//        return -1;
//    }
//
//    // Sort A1[0..m-1] according to the order
//    // defined by A2[0..n-1].
//    static void sortAccording(int A1[], int A2[], int m,
//                              int n)
//    {
//        // The temp array is used to store a copy
//        // of A1[] and visited[] is used to mark the
//        // visited elements in temp[].
//        int temp[] = new int[m], visited[] = new int[m];
//        for (int i = 0; i < m; i++) {
//            temp[i] = A1[i];
//            visited[i] = 0;
//        }
//
//        // Sort elements in temp
//        Arrays.sort(temp);
//
//        // for index of output which is sorted A1[]
//        int ind = 0;
//
//        // Consider all elements of A2[], find them
//        // in temp[] and copy to A1[] in order.
//        for (int i = 0; i < n; i++) {
//            // Find index of the first occurrence
//            // of A2[i] in temp
//            int f = first(temp, 0, m - 1, A2[i], m);
//
//            // If not present, no need to proceed
//            if (f == -1)
//                continue;
//
//            // Copy all occurrences of A2[i] to A1[]
//            for (int j = f; (j < m && temp[j] == A2[i]);
//                 j++) {
//                A1[ind++] = temp[j];
//                visited[j] = 1;
//            }
//        }
//
//        // Now copy all items of temp[] which are
//        // not present in A2[]
//        for (int i = 0; i < m; i++)
//            if (visited[i] == 0)
//                A1[ind++] = temp[i];
//    }
//
//    // Utility function to print an array
//    static void printArray(int arr[], int n)
//    {
//        for (int i = 0; i < n; i++)
//            System.out.print(arr[i] + " ");
//        System.out.println();
//    }
//}
//
//
//package Review;
//
//        import java.util.*;
//
///**
// * 按照数值个数排序
// * 描述
// * 对给定数组中的元素按照元素出现的次数排序，出现次数多的排在前面，
// * 如果出现次数相同，则按照数值大小排序。
// * 例如，给定数组为{2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}，
// * 则排序后结果为{3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}。
// *
// * 输入
// * 输入的第一行为用例个数；后面每一个用例使用两行表示，第一行为数组长度，第二行为数组内容，数组元素间使用空格隔开。
// *
// * 输出
// * 每一个用例的排序结果在一行中输出，元素之间使用空格隔开。
// *
// * 输入样例 1
// *
// * 1
// * 4
// * 2 3 2 5
// * 输出样例 1
// *
// * 2 2 3 5
// */
//public class SortByAppearTimes {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testCaseNum=Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testCaseNum;i++){
//            int arrayLength=Integer.parseInt(scanner.nextLine());
//            String[] arrayStringSplit = scanner.nextLine().split(" ");
//            List<Integer> allNumList=new ArrayList<>();
//            for (int m=0;m<arrayLength;m++){
//                allNumList.add(Integer.parseInt(arrayStringSplit[m]));
//            }
//            copeSortByAppear(allNumList);
//        }
//    }
//
//    public static <K, V> void copeSortByAppear(List<Integer> nums){
//        Map<Integer,Integer> numAndTimesMap=new HashMap<>();
//        for (int eachN:nums){
//            if (numAndTimesMap.containsKey(eachN)){
//                numAndTimesMap.put(eachN,numAndTimesMap.get(eachN)+1);
//            }else{
//                numAndTimesMap.put(eachN,1);
//            }
//        }
//
//        LinkedHashMap<Integer,Integer> sortMapByKey=new LinkedHashMap<>();
//        numAndTimesMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
//                .forEachOrdered(e->sortMapByKey.put(e.getKey(),e.getValue()));
//        LinkedHashMap<Integer,Integer> sortMap=new LinkedHashMap<>();
//        sortMapByKey.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
//                .forEach(e->sortMap.put(e.getKey(),e.getValue()));
//        StringBuilder stringBuilder=new StringBuilder();
//        for (int i:sortMap.keySet()){
//            for (int m=0;m<sortMap.get(i);m++){
//                stringBuilder.append(i).append(" ");
//            }
//        }
//        System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
//    }
//}
//
//
//package Review;
//
//        import java.util.ArrayList;
//        import java.util.Collections;
//        import java.util.List;
//        import java.util.Scanner;
//
//
///**
// * 最小交换次数
// *
// * Given an array of N distinct elementsA[ ],
// * find the minimum number of swaps required to sort the array.
// * Your are required to complete the function which returns an integer
// * denoting the minimum number of swaps, required to sort the array.
// *
// *
// * 输入
// *
// * The first line of input contains an integer T denoting the no of test cases .
// * Then T test cases follow .
// * Each test case contains an integer N denoting the no of element of the array A[ ].
// * In the next line are N space separated values of the array A[ ] .
// * (1<=T<=100;1<=N<=100;1<=A[] <=1000)
// * 输出
// *
// * For each test case in a new line output
// * will be an integer denoting minimum umber of swaps that are required to sort the array.
// *
// *
// * 输入样例 1
// *
// * 2
// * 4
// * 4 3 2 1
// * 5
// * 1 5 4 3 2
// * 输出样例 1
// *
// * 2
// * 2
// */
//
///**
// *
// * 创建一个数组,该数组是原数组排序后的版本,对应着原数组中元素应该在的正确的位置
// * 从头到尾遍历原数组,若原数组与新数组的对应位置上的元素不一致,
// * 就在原数组上把应该在这个位置上的元素与当前位置元素对调,使这个位置上放上正确的元素,若一致则向下遍历.
// * 这样就保证了每次交换必定使一个元素回到了它自己的位置
// */
//public class SortOfMinSwapTimes {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testCaseNum=Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testCaseNum;i++){
//            int arrayLength=Integer.parseInt(scanner.nextLine());
//            List<Integer> allNumsList=new ArrayList<>();
//            String[] numStringSplit = scanner.nextLine().split(" ");
//            for (String eachS:numStringSplit){
//                allNumsList.add(Integer.parseInt(eachS));
//            }
//            getMinSwapTimes(allNumsList);
//        }
//    }
//
//    public static void getMinSwapTimes(List<Integer> nums){
//        List<Integer> numsCopy = new ArrayList<>(nums);
//        Collections.sort(numsCopy);
//
//        int swapTimes=0;
//        for (int i=0;i<nums.size();i++){
//            if (!nums.get(i).equals(numsCopy.get(i))){
//                swapTimes++;
//                for (int j=i+1;j<nums.size();j++){
//                    if (nums.get(j).equals(numsCopy.get(i))){
//                        nums.set(j,nums.get(i));
//                        nums.set(i,numsCopy.get(i));
//                        break;
//                    }
//                }
//            }
//        }
//
//        System.out.println(swapTimes);
//    }
//}
//
//package Review;
//
//        import java.util.ArrayList;
//        import java.util.Scanner;
//
///**
// * 能否成环
// * 是否成环
// * 描述
// *
// * Given an array of strings A[ ],
// * determine if the strings can be chained together to form a circle.
// * A string X can be chained together with another string Y
// * if the last character of X is same as first character of Y.
// * If every string of the array can be chained, it will form a circle.
// * For example, for the array arr[] = {"for", "geek", "rig", "kaf"}
// * the answer will be Yes as the given strings can be chained as "for", "rig", "geek" and "kaf".
// *
// *
// * 输入
// *
// * The first line of input contains an integer T denoting the number of test cases.
// * Then T test cases follow.
// * The first line of each test case contains a positive integer N,
// * denoting the size of the array.
// * The second line of each test case contains a N space seprated strings,
// * denoting the elements of the array A[ ].
// *
// * 1 <= T
// * 0 < N
// * 0 < A[i]
// *
// * 输出
// *
// * If chain can be formed, then print 1, else print 0.
// *
// *
// * 输入样例 1
// *
// * 2
// * 3
// * abc bcd cdf
// * 4
// * ab bc cd da
// * 输出样例 1
// *
// * 0
// * 1
// */
//public class StringCanBeCycle {
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int t = s.nextInt();
//        s.nextLine();
//        while (t-- > 0) {
//            int n = Integer.parseInt(s.nextLine());
//            String[] str = s.nextLine().trim().split(" ");
//            Graph g = new Graph(26);
//            for (int i = 0; i < str.length; i++) {
//                char start = str[i].charAt(0);
//                char end = str[i].charAt(str[i].length() - 1);
//                g.addEdge(start - 'a', end - 'a');
//            }
//            boolean res = g.isEulerian();
//            if (res) {
//                System.out.println(1);
//            } else {
//                System.out.println(0);
//            }
//        }
//    }
//}
//
//
//class Graph {
//    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//    int[] count = new int[26];
//    int V;
//
//    Graph(int v) {
//        this.V = v;
//        for (int i = 0; i < v; i++) {
//            list.add(new ArrayList<Integer>());
//        }
//    }
//
//    public void addEdge(int i, int j) {
//        ArrayList<Integer> temp = list.get(i);
//        temp.add(j);
//        list.add(temp);
//        count[j]++;
//    }
//
//    public boolean isEulerian() {
//        if (!isSc()) {
//            return false;
//        }
//        for (int i = 0; i < V; i++) {
//            if (list.get(i).size() != count[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean isSc() {
//        boolean[] visited = new boolean[V];
//        for (int i = 0; i < V; i++) {
//            visited[i] = false;
//        }
//        int i = 0;
//        int start = 0;
//        for (i = 0; i < V; i++) {
//            if (list.get(i).size() > 0) {
//                start = i;
//                break;
//            }
//        }
//        DFS(visited, start);
//        for (i = 0; i < V; i++) {
//            if (list.get(i).size() > 0 && !visited[i]) {
//                return false;
//            }
//        }
//
//        Graph gr = getTranspose();
//        for (i = 0; i < V; i++) {
//            visited[i] = false;
//        }
//        gr.DFS(visited, start);
//        for (i = 0; i < V; i++) {
//            if (list.get(i).size() > 0 && !visited[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public Graph getTranspose() {
//        Graph gr = new Graph(V);
//        for (int i = 0; i < V; i++) {
//            ArrayList<Integer> temp = list.get(i);
//            for (int j = 0; j < temp.size(); j++) {
//                gr.addEdge(temp.get(j), i);
//            }
//        }
//        return gr;
//    }
//
//    public void DFS(boolean[] visited, int n) {
//        visited[n] = true;
//        for (int i = 0; i < list.get(n).size(); i++) {
//            int node = list.get(n).get(i);
//            if (!visited[node]) {
//                DFS(visited, node);
//            }
//        }
//    }
//}
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * 无限递归字符串查询
// * Consider a string A = "12345".
// * An infinite string s is built by performing infinite steps on A recursively.
// * In i-th step, A is concatenated with ‘$’ i times followed by reverse of A.
// * A=A|$...$|reverse(A), where | denotes concatenation.
// */
//
//public class StringDoubleWithDollarCorrect {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        while (--T >= 0) {
//            long l = sc.nextLong();
//            if (l == 0) System.out.println();
//            else
//                findTheNo(l);
//        }
//    }
//
//    static void findTheNo(long k) {
//        long o = k;
//        while (k > 11) {
//            long p = 0;
//            long i = 1;
//            long N = 5;
//            while (k > N) {
//                p = N;
//                N = N * 2 + i;
//                i++;
//            }
//            k -= p;
//            if (k <= i - 1) {
//                System.out.println("$");
//                return;
//            }
//            k -= (i - 1);
//        }
//        try {
//            char array[] = {'1', '2', '3', '4', '5', '$', '5', '4', '3', '2', '1'};
//            System.out.println(array[(int) k - 1]);
//        } catch (Exception e) {
//            System.out.println("Exception=" + o);
//        }
//    }
//
//}
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * 素数和
// * 判断一个偶数能否变成两个素数的和
// */
//public class SuShuSumOfEven {
////    def no_of_primes(n):
////    no_list = [1] * (n + 1)
////    no_list[0] = 0
////    no_list[1] = 0
////            for i in range(2, n + 1):
////            if no_list[i] == 1:
////            for j in range(2 * i, n + 1, i):
////    no_list[j] = 0
////            return no_list
////
////
////if __name__ == '__main__':
////    t = int(input().strip())
////            for i in range(t):
////    n = int(input())
////    no_list = no_of_primes(n)
////        for i in range(0, n):
////            if no_list[i] == 1 and no_list[n - i] == 1:
////    print(i, (n - i))
////            break
//}
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * 对称子字符串
// * 寻求最大子字符串，要求子字符串长度为2k，且左右两部分和相等
// * 输入样例 1
// *
// * 1
// * 1538023
// * 输出样例 1
// *
// * 4
// */
//public class SymmetricalSumSubString {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testCaseNum=Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testCaseNum;i++){
//            String numString=scanner.nextLine();
//            System.out.println(findLength(numString));
//        }
//    }
//
//    //动态规划
//    static int findLength(String str)
//    {
//        int n = str.length();
//        int maxlen = 0;
//
//        int sum[][] = new int[n][n];
//
//        for (int i = 0; i < n; i++)
//            sum[i][i] = str.charAt(i) - '0';
//
//        for (int len = 2; len <= n; len++)
//        {
//            for (int i = 0; i < n - len + 1; i++)
//            {
//                int j = i + len - 1;
//                int k = len/2;
//
//                //每个和分左右两部分处理
//                sum[i][j] = sum[i][j-k] +
//                        sum[j-k+1][j];
//
//                //观察当前i-j之间左右两半部分的和
//                if (len % 2 == 0 && sum[i][j-k] ==
//                        sum[(j-k+1)][j] && len > maxlen)
//                    maxlen = len;
//            }
//        }
//        return maxlen;
//    }
//}
//
//package Review;
//
//        import java.util.ArrayList;
//        import java.util.Collections;
//        import java.util.Comparator;
//        import java.util.Scanner;
//
///**
// * 时间与收益
// * 描述
// * 每个工作都有一个ddl，要获取最大的收益
// * Given a set of n jobs where each job i has a deadline and profit associated to it.
// * Each job takes 1 unit of time to complete and only one job can be scheduled at a time.
// * We earn the profit if and only if the job is completed by its deadline.
// * The task is to find the maximum profit and the number of jobs done.
// *
// *
// * 输入
// *
// * The first line of input contains an integer T denoting the number of test cases.
// * Each test case consist of an integer N denoting the number of jobs
// * and the next line consist of Job id, Deadline and the Profit associated to that Job.
// *
// * Constraints:1<=T<=100，1<=N<=100，1<=Deadline<=100，1<=Profit<=500
// *
// *
// * 输出
// *
// * Output the number of jobs done and the maximum profit.
// *
// *
// * 输入样例 1
// *
// * 2
// * 4
// * 1 4 20 2 1 10 3 1 40 4 1 30
// * 5
// * 1 2 100 2 1 19 3 2 27 4 1 25 5 1 15
// * 输出样例 1
// *
// * 2 60
// * 2 127
// */
//public class TimeAndJobProfit {
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testCaseNum=Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testCaseNum;i++){
//            int jobNum=Integer.parseInt(scanner.nextLine());
//            String[] numStringSplit = scanner.nextLine().split(" ");
//            int[] jobDetailArray=new int[jobNum*3];
//
//            for (int m=0;m<jobDetailArray.length;m++){
//                jobDetailArray[m]=Integer.parseInt(numStringSplit[m]);
//            }
//
//            ArrayList<Job> jobList=new ArrayList<>();
//            for (int m=0;m<jobNum;m++){
//                jobList.add(new Job(Integer.parseInt(numStringSplit[m*3]),Integer.parseInt(numStringSplit[m*3+1]),Integer.parseInt(numStringSplit[m*3+2])));
//            }
//            Job.printJobScheduling(jobList);
//        }
//    }
//
//
//}
//
//class DisjointSet
//{
//    int parent[];
//
//    DisjointSet(int n)
//    {
//        parent = new int[n + 1];
//        for (int i = 0; i <= n; i++)
//            parent[i] = i;
//    }
//
//    int find(int s)
//    {
//        if (s == parent[s])
//            return s;
//        return parent[s] = find(parent[s]);
//    }
//
//    void merge(int u, int v)
//    {
//        parent[v] = u;
//    }
//}
//
//class Job implements Comparator<Job>
//{
//    int id;
//    int deadline, profit;
//
//    public Job() { }
//    public Job(int id,int deadline,int profit)
//    {
//        this.id = id;
//        this.deadline = deadline;
//        this.profit = profit;
//    }
//
//    public static int findMaxDeadline(ArrayList<Job> arr)
//    {
//        int ans = Integer.MIN_VALUE;
//        for (Job temp : arr)
//            ans = Math.max(temp.deadline, ans);
//        return ans;
//    }
//
//    public static void printJobScheduling(ArrayList<Job> arr)
//    {
//
//        Collections.sort(arr, new Job());
//
//        int maxDeadline = findMaxDeadline(arr);
//        DisjointSet dsu = new DisjointSet(maxDeadline);
//
//        int sum=0;
//        int totalTask=0;
//        for (Job temp : arr)
//        {
//            int availableSlot = dsu.find(temp.deadline);
//            if (availableSlot > 0)
//            {
//                dsu.merge(dsu.find(availableSlot - 1),
//                        availableSlot);
//                totalTask++;
//                sum=sum+temp.profit;
//            }
//        }
//        System.out.println(totalTask+ " "+sum);
//    }
//    public int compare(Job j1, Job j2)
//    {
//        return j1.profit > j2.profit? -1: 1;
//    }
//}
//
//
//package Review;
//
//        import java.util.*;
//
///**
// * 凸包
// * tubao
// */
//public class TUBao {
//
//    static class Point {
//        int x;
//        int y;
//
//        Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = Integer.parseInt(sc.nextLine());
//        for (int i = 0; i < num; i++) {
//            int n = sc.nextInt();
////            String[] arr_str = sc.nextLine().split("\\s");
//            Point[] points = new Point[n];
//            for (int j = 0; j < n * 2; j = j + 2) {
//                int x = sc.nextInt();
//                int y = sc.nextInt();
//                points[j / 2] = new Point(x, y);
//            }
//            List<Point> hull = outerTrees(points);
//            if(hull.size()<3){
//                System.out.println(-1);
//                break;
//            }
//            hull.sort(new Comparator<Point>() {
//                @Override
//                public int compare(Point o1, Point o2) {
//                    return Long.compare(o1.x, o2.x);
//                }
//            });
//            StringBuilder sb = new StringBuilder();
//            for (int k = 0; k < hull.size(); k++) {
//                Point cur = hull.get(k);
//                sb.append(cur.x);
//                sb.append(' ');
//                sb.append(cur.y);
//                if (k != hull.size() - 1) {
//                    sb.append(", ");
//                }
//            }
//            System.out.println(sb.toString());
//        }
//    }
//
//    private static int orientation(Point p, Point q, Point r) {
//        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
//    }
//
//    private static List<Point> outerTrees(Point[] points) {
//        Arrays.sort(points, new Comparator<Point>() {
//            public int compare(Point p, Point q) {
//                return q.x - p.x == 0 ? q.y - p.y : q.x - p.x;
//            }
//        });
//        Stack<Point> hull = new Stack<>();
//        for (int i = 0; i < points.length; i++) {
//            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0)
//                hull.pop();
//            hull.push(points[i]);
//        }
//        hull.pop();
//        for (int i = points.length - 1; i >= 0; i--) {
//            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0)
//                hull.pop();
//            hull.push(points[i]);
//        }
//        return new ArrayList<>(new HashSet<>(hull));
//    }
//
//
//}
//
//class PointHull {
//    int x, y;
//
//    PointHull(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//
//
//package Review;
//
//        import java.util.Scanner;
//
///**
// * Description
// *
// * Rahul and Ankit are the only two waiters in Royal Restaurant.
// * Today, the restaurant received N orders.
// * The amount of tips may differ when handled by different waiters,
// * if Rahul takes the ith order,
// * he would be tipped Ai rupees and if Ankit takes this order,
// * the tip would be Bi rupees.
// * In order to maximize the total tip value
// * they decided to distribute the order among themselves.
// * One order will be handled by one person only.
// * Also, due to time constraints Rahul cannot take more than firstMax orders
// * and Ankit cannot take more than secondMax orders.
// * It is guaranteed that firstMax + secondMax is greater than or equal to N,
// * which means that all the orders can be handled by either Rahul or Ankit.
// * Find out the maximum possible amount of total tip money after processing all the orders.
// *
// *
// * Input
// *
// * • The first line contains one integer, number of test cases.
// *
// * • The second line contains three integers N, firstMax, secondMax.
// *
// * • The third line contains N integers. The ith integer represents Ai.
// *
// * • The fourth line contains N integers. The ith integer represents Bi.
// *
// *
// * Output
// *
// * Print a single integer representing the maximum tip money they would receive.
// */
//public class WaiterTaskAndTips {
//
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int testCaseNum=Integer.parseInt(scanner.nextLine());
//        for (int i=0;i<testCaseNum;i++){
//            String ordersAndWaiterOrdersString=scanner.nextLine();
//            String firstWaiterTips=scanner.nextLine();
//            String secondWaiterTips=scanner.nextLine();
//            String[] ordersAndWaiterOrdersSplit = ordersAndWaiterOrdersString.split(" ");
//            int orders=Integer.parseInt(ordersAndWaiterOrdersSplit[0]);
//            int firstMax=Integer.parseInt(ordersAndWaiterOrdersSplit[1]);
//            int secondMax=Integer.parseInt(ordersAndWaiterOrdersSplit[2]);
//
//            String[] firstWaiterTipsSplit = firstWaiterTips.split(" ");
//            String[] secondWaiterTipsSplit = secondWaiterTips.split(" ");
//            int[] firstTips=new int[orders];
//            int[] secondTips=new int[orders];
//            for (int m=0;m<orders;m++){
//                firstTips[m]=Integer.parseInt(firstWaiterTipsSplit[m]);
//            }
//
//            for (int m=0;m<orders;m++){
//                secondTips[m]=Integer.parseInt(secondWaiterTipsSplit[m]);
//            }
//            getMaxTotalTips(firstTips,firstMax,secondTips,secondMax,orders);
//        }
//    }
//
//    public static void getMaxTotalTips(int[] firstTips,int firstMax,int[] secondTips,int secondMax,int totalOrders){
//
//        int dp[][]=new int[firstMax+1][secondMax+1];
//
//        for(int i=1;i<=firstMax;i++)
//            dp[i][0]= firstTips[i-1] + dp[i-1][0];
//        for(int i=1;i<=secondMax;i++)
//            dp[0][i]= secondTips[i-1] + dp[0][i-1];
//
//        for(int i=1;i<=firstMax;i++)
//        {
//            for(int j=1;j<=secondMax;j++)
//            {
//                if(i+j <= totalOrders)
//                {
//                    int op1= firstTips[i+j-1] + dp[i-1][j]; // GIVING TO firstMax (CHECK firstMax IN FOR)-> ROW
//                    int op2= secondTips[i+j-1] + dp[i][j-1]; // TO secondMax
////                    System.err.println("op1=firstTips["+(i+j-1)+"]+ dp["+(i-1)+"]["+j+"]="+op1);
////                    System.err.println("op2=secondTips["+(i+j-1)+"]+ dp["+(i)+"]["+(j-1)+"]="+op2);
//
//                    dp[i][j] = Math.max( op1 , op2 );
////                    System.out.println("dp["+i+"]["+j+"]="+dp[i][j]);
////                    System.err.println();
//                }
//                else
//                    dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1] );
//            }
//        }
//
//        for (int i=0;i<firstMax+1;i++){
//            for (int j=0;j<secondMax+1;j++){
//                System.out.print(dp[i][j]+"\t");
//            }
//            System.out.println();
//        }
//
//        System.out.println(dp[firstMax][secondMax]);
//    }
//
//    public static void printMatrix(int[][] matrix){
//        for (int i=0;i<matrix.length;i++){
//            for (int j=0;j<matrix[0].length;j++){
//                System.err.print(matrix[i][j]+"\t");
//            }
//            System.err.println();
//        }
//    }
//}


///**
// * 数字重组整除问题
// *
// * Babul’s favourite number is 17. He likes the numbers which are divisible by 17.
// * This time what he does is that he takes a number N and tries to find the largest number which is divisible by 17,
// * by rearranging the digits. As the number increases he gets puzzled with his own task. So you as a programmer
// * have to help him to accomplish his task.Note: If the number is not divisible by rearranging the digits,
// * then print “Not Possible”. N may have leading zeros.
// */
//public class 数字重组整除问题 {
////    from itertools import permutations
////
////if __name__ == '__main__':
////            for _ in range(int(input())):
////    s = input()
////    array = list(map(lambda x: x, s))  # 把输入字符转成一个字符数组
////            pailie = list(set(permutations(array)))  # 将数字全排列并去重
////            max_z = 0
////        for x in pailie:
////    z = int("".join(x))  # 字符数组拼接成一个字符串,并转为数字
////            if z % 17 == 0:
////    max_z = max(max_z, z)  # 由于一个全排列可能有多个满足条件的数,因此选择一个最大的
////        if max_z == 0:  # 注意,这里0一定要排除掉
////    print("Not Possible")
////        else:
////    print(max_z)
//}

///**
// * 汉诺塔
// *
// * 汉诺塔问题中限制不能将一层塔直接从最左侧移动到最右侧，也不能直接从最右侧移动到最左侧，而是必须经过中间。求当有N层塔的时候移动步数。
// */
//public class Solution4 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < N; i++) {
//            int num = Integer.parseInt(scanner.nextLine());
//            System.out.println(moveTower(num));
//        }
//    }
//
//    public static int moveTower(int N) {
//        if (N == 1) {
//            return 2;
//        }
//
//        return 3 * moveTower(N - 1) + 2;
//    }
//}


///**
// * 数组和窗口
// *
// * 给定一个整型数组arr和一个大小为w的窗口，窗口从数组最左边滑动到最右边，每次向右滑动一个位置，求出每一次滑动时窗口内最大元素的和。
// */
//public class Solution3 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int caseNum = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < caseNum; i++) {
//            String line = scanner.nextLine();
//            String[] nums = line.split("\\s");
//            int[] array = new int[nums.length];
//            for (int j = 0; j < nums.length; j++) {
//                array[j] = Integer.parseInt(nums[j]);
//            }
//            int target = Integer.parseInt(scanner.nextLine());
//            System.out.println(count(array, target));
//        }
//    }
//
//    public static int count(int[] array, int w) {
//        if (array == null || array.length == 0) {
//            return 0;
//        }
//
//        int index_i = 0;
//        int index_j = 0;
//        int count = 0;
//
//        Deque<Integer> max = new LinkedList<>();
//        while (index_i < array.length - w + 1) {
//            while (!max.isEmpty() && array[max.peekLast()] <= array[index_j]) {
//                max.pollLast();
//            }
//            max.addLast(index_j);
//
//            while (max.peekFirst() < index_i) {
//                max.pollFirst();
//            }
//
//            if (index_j >= w - 1) {
//                count = count + array[max.peekFirst()];
////                System.out.println("max:" + max.peekFirst());
//                index_i++;
//                index_j++;
//            } else {
//                index_j++;
//            }
//
//        }
//
//        return count;
//    }
//}

///**
// * 子矩阵问题
// *
// * 给定一个矩形区域，每一个位置上都是1或0，求该矩阵中每一个位置上都是1的最大子矩形区域中的1的个数。
// */
//public class Solution2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int caseNums = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < caseNums; i++) {
//            String[] range = scanner.nextLine().split("\\s");
//            int n = Integer.parseInt(range[0]);
//            int m = Integer.parseInt(range[1]);
//            String[][] matrix = new String[n][m];
//            for (int j = 0; j < n; j++) {
//                String[] col = scanner.nextLine().split("\\s");
//                matrix[j] = col;
//            }
//
//            System.out.println(maximalRectangle(matrix));
//        }
//    }
//
//    public static int maximalRectangle(String[][] matrix) {
//        if (matrix.length == 0) {
//            return 0;
//        }
//        int[] heights = new int[matrix[0].length];
//        int maxArea = 0;
//        for (int row = 0; row < matrix.length; row++) {
//            //遍历每一列，更新高度
//            for (int col = 0; col < matrix[0].length; col++) {
//                if (matrix[row][col].equals("1")) {
//                    heights[col] += 1;
//                } else {
//                    heights[col] = 0;
//                }
//            }
//            //调用上一题的解法，更新函数
//            maxArea = Math.max(maxArea, largestRectangleArea(heights));
//        }
//        return maxArea;
//    }
//
//    public static int largestRectangleArea(int[] heights) {
//        int maxArea = 0;
//        Stack<Integer> stack = new Stack<>();
//        int p = 0;
//        while (p < heights.length) {
//            //栈空入栈
//            if (stack.isEmpty()) {
//                stack.push(p);
//                p++;
//            } else {
//                int top = stack.peek();
//                //当前高度大于栈顶，入栈
//                if (heights[p] >= heights[top]) {
//                    stack.push(p);
//                    p++;
//                } else {
//                    //保存栈顶高度
//                    int height = heights[stack.pop()];
//                    //左边第一个小于当前柱子的下标
//                    int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
//                    //右边第一个小于当前柱子的下标
//                    int RightLessMin = p;
//                    //计算面积
//                    int area = (RightLessMin - leftLessMin - 1) * height;
//                    maxArea = Math.max(area, maxArea);
//                }
//            }
//        }
//        while (!stack.isEmpty()) {
//            //保存栈顶高度
//            int height = heights[stack.pop()];
//            //左边第一个小于当前柱子的下标
//            int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
//            //右边没有小于当前高度的柱子，所以赋值为数组的长度便于计算
//            int RightLessMin = heights.length;
//            int area = (RightLessMin - leftLessMin - 1) * height;
//            maxArea = Math.max(area, maxArea);
//        }
//        return maxArea;
//    }
//}

///**
// * 子数组的取值范围
// *
// * 给定数组arr和整数num，求arr的连续子数组中满足：其最大值减去最小值的结果大于num的个数。请实现一个时间复杂度为O(length(arr))的算法。
// */
//public class Solution1 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int caseNum = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < caseNum; i++) {
//            String line = scanner.nextLine();
//            String[] nums = line.split("\\s");
//            int[] array = new int[nums.length];
//            for (int j = 0; j < nums.length; j++) {
//                array[j] = Integer.parseInt(nums[j]);
//            }
//            int target = Integer.parseInt(scanner.nextLine());
//            System.out.println(count(array, target));
//        }
//    }
//
//    public static int count(int[] array, int num) {
//        if (array == null || array.length == 0) {
//            return 0;
//        }
//
//        int index_i = 0;
//        int index_j = 0;
//        int count = 0;
//
//        Deque<Integer> max = new LinkedList<>();
//        Deque<Integer> min = new LinkedList<>();
//        while (index_i < array.length) {
//            while (index_j < array.length) {
//                while (!max.isEmpty() && array[max.peekLast()] <= array[index_j]) {
//                    max.pollLast();
//                }
//                max.addLast(index_j);
//
//                while (!min.isEmpty() && array[min.peekLast()] >= array[index_j]) {
//                    min.pollLast();
//                }
//                min.addLast(index_j);
//
//                int judgeNum = array[max.peekFirst()] - array[min.peekFirst()];
//                if (judgeNum > num) {
//                    break;
//                }
//
//                index_j++;
//            }
//            count = count + array.length - index_j;
//
//            if (max.peekFirst() == index_i) {
//                max.pollFirst();
//            }
//
//            if (min.peekFirst() == index_i) {
//                min.pollFirst();
//            }
//
//            index_i++;
////            System.out.println("max:"+ Arrays.toString(max.toArray()));
////            System.out.println("min:"+ Arrays.toString(min.toArray()));
//        }
//
//        return count;
//    }
//
//    public static int count2(int[] array, int num) {
//        int count = 0;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i; j < array.length; j++) {
//                boolean result = compare(array, i, j + 1, num);
//                if (result) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    public static int count3(int[] array, int num) {
//        int res = 0;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                if (Math.abs(array[i] - array[j]) > num) {
//                    res += (array.length - j);
//                    break;
//                }
//            }
//        }
//        return res;
//    }
//
//    private static boolean compare(int[] array, int start, int end, int num) {
//        if (end - start == 0) {
//            return false;
//        }
//
//        int max = array[start];
//        int min = array[start];
//
//        for (int i = start; i < end; i++) {
//            if (array[i] > max) {
//                max = array[i];
//            }
//
//            if (array[i] < min) {
//                min = array[i];
//            }
//        }
//
//        if (max - min > num) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//}

///**
// * 区间第k最小
// *
// * 找到给定数组的给定区间内的第K小的数值。
// */
//public class Solution5 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int length = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < length; i++) {
//            String[] numStrs = scanner.nextLine().split("\\s");
//            int[] arrays = new int[numStrs.length];
//            for (int j = 0; j < numStrs.length; j++) {
//                arrays[j] = Integer.parseInt(numStrs[j]);
//            }
//            String[] range = scanner.nextLine().split("\\s");
//            int startIndex = Integer.parseInt(range[0]) - 1;
//            int endIndex = Integer.parseInt(range[1]) - 1;
//
//            int k = Integer.parseInt(scanner.nextLine());
//            System.out.println(findK(arrays, startIndex, endIndex, k));
//
//        }
//    }
//
//    public static int findK(int[] array, int start, int end, int k) {
//        int length = end - start + 1;
//        int[] targetArray = new int[length];
//        System.arraycopy(array, start, targetArray, 0, length);
//        Arrays.sort(targetArray);
//
//        return targetArray[k - 1];
//    }
//}

///**
// * 固定和的元素对
// *
// * 输入一个数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字，统计这样两个数的对数。
// */
//public class Solution6 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int length = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < length; i++) {
//            String[] numStrs = scanner.nextLine().split("\\s");
//            int[] arrays = new int[numStrs.length];
//            for (int j = 0; j < numStrs.length; j++) {
//                arrays[j] = Integer.parseInt(numStrs[j]);
//            }
//
//            int target = Integer.parseInt(scanner.nextLine());
//            System.out.println(count(arrays, target));
//        }
//    }
//
//    public static int count(int[] array, int target) {
//        Arrays.sort(array);
//        int start = 0;
//        int end = array.length - 1;
//
//        int count = 0;
//        while (start < end) {
//            int sum = array[start] + array[end];
//            if (sum > target) {
//                end--;
//            } else if (sum < target) {
//                start++;
//            } else {
//                count++;
//                start++;
//                end--;
//            }
//        }
//        return count;
//    }
//}

///**
// * 先升后降
// *
// * 从一列不重复的数中筛除尽可能少的数使得从左往右看，这些数是从小到大再从大到小的。
// */
//public class Solution7 {
//    private static List<String> res = new ArrayList<>();
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int length = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < length; i++) {
//            String[] numStrs = scanner.nextLine().split("\\s");
//            int[] array = new int[numStrs.length];
//            for (int j = 0; j < numStrs.length; j++) {
//                array[j] = Integer.parseInt(numStrs[j]);
//            }
//            find(array);
//            res = new ArrayList<>();
//        }
//    }
//
//    public static void find(int[] array) {
//        for (int i = array.length; i >= 0; i--) {
//            combination(array, 0, i, new ArrayList<>());
//
//            if (res.size() != 0) {
//                Collections.sort(res);
//                for (String s : res) {
//                    System.out.println(s);
//                }
//                break;
//            }
//        }
//    }
//
//    private static void combination(int[] arr, int start, int remain, List<Integer> list) {
//        if (remain == 0) {
//            if (isValid(list)) {
//                StringBuilder sb = new StringBuilder();
//                for (int i = 0; i < list.size(); i++) {
//                    sb.append(list.get(i));
//                    if (i != list.size() - 1) {
//                        sb.append(' ');
//                    }
//                }
//                res.add(sb.toString());
//            }
//            return;
//        }
//
//        if ((arr.length - start) > remain) {
//            List<Integer> copy = new ArrayList<>(list);
//            combination(arr, start + 1, remain, list);
//            copy.add(arr[start]);
//            combination(arr, start + 1, remain - 1, copy);
//        } else if ((arr.length - start) == remain) {
//            list.add(arr[start]);
//            combination(arr, start + 1, remain - 1, list);
//        }
//    }
//
//
//    private static boolean isValid(List<Integer> element) {
//        if (element == null || element.size() == 0) {
//            return false;
//        }
//
//        if (element.size() == 1) {
//            return true;
//        }
//
//        int prev = element.get(0);
//        boolean isMax = false;
//
//        if (prev > element.get(1)) {
//            isMax = true;
//        }
//
//        for (int i = 1; i < element.size() - 1; i++) {
//            int now = element.get(i);
//            int next = element.get(i + 1);
//            if (now > next && !isMax) {
//                isMax = true;
//                prev = now;
//                continue;
//            }
//
//            if (prev < now && isMax) {
//                return false;
//            }
//
//            prev = now;
//        }
//        int last = element.get(element.size() - 1);
//        if (last > prev && isMax) {
//            return false;
//        }
//
//        return true;
//    }
//}

///**
// * 调整数组使差最小
// *
// * 有两个序列 a,b，大小都为 n,序列元素的值任意整数，无序； 要求：通过交换 a,b 中的元素，使[序列 a 元素的和]与[序列 b 元素的和]之间的差最小。
// */
//public class Solution8 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int length = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < length; i++) {
//            String[] nums1 = scanner.nextLine().split("\\s");
//            String[] nums2 = scanner.nextLine().split("\\s");
//            List<Integer> combineList = new ArrayList<>();
//            for (int j = 0; j < nums1.length; j++) {
//                combineList.add(Integer.parseInt(nums1[j]));
//                combineList.add(Integer.parseInt(nums2[j]));
//            }
//
//            System.out.println(calculate(combineList));
//        }
//    }
//
//    public static int calculate(List<Integer> list) {
//        List<Integer> backupList = new ArrayList<>(list);
//        List<List<Integer>> combineList = combine(backupList, backupList.size() / 2);
//
//        int result = Integer.MAX_VALUE;
//        int sum = calculateSumList(list);
//        for (List<Integer> combined : combineList) {
//            int sum1 = calculateSumList(combined);
//            int abs = Math.abs((2 * sum1) - sum);
//            if (abs < result) {
//                result = abs;
//            }
//        }
//        return result;
//    }
//
//    private static List<List<Integer>> combine(List<Integer> list, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (target == 1) {
//            for (Integer num : list) {
//                List<Integer> integerList = new ArrayList<>();
//                integerList.add(num);
//                result.add(integerList);
//            }
//            return result;
//        }
//
//
//        for (int i = 0; i < list.size(); ) {
//            List<Integer> newList = new ArrayList<>();
//            newList.addAll(list);
//            newList.remove(i);
//            List<List<Integer>> combineList = combine(newList, target - 1);
//            for (int j = 0; j < combineList.size(); j++) {
//                combineList.get(j).add(list.get(i));
//                result.add(combineList.get(j));
//            }
//            list.remove(i);
//        }
//        return result;
//    }
//
//    private static int calculateSumList(List<Integer> list) {
//        int sum = 0;
//        for (Integer num : list) {
//            sum += num;
//        }
//        return sum;
//    }
//
//}

///**
// * 分配问题
// * <p>
// * 对给定的n个任务与n个人之间的成本矩阵完成成本最低的任务分配策略。
// */
//public class 分配问题 {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cases = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < cases; i++) {
//            int tasks = Integer.parseInt(scanner.nextLine());
//            String[] infos = scanner.nextLine().split(",");
//            List<Task> taskList = new ArrayList<>();
//            for (String e : infos) {
//                String[] info = e.split("\\s");
//                Task task = new Task(Integer.parseInt(info[0]), Integer.parseInt(info[1]), Integer.parseInt(info[2]));
//                taskList.add(task);
//            }
//            List<List<Task>> result = findTask(taskList, tasks, new HashSet<>(), new HashSet<>());
//
//            System.out.println(handleResult(result, tasks));
//        }
//    }
//
//    public static String handleResult(List<List<Task>> result, int needTaskNum) {
//
//        //filter
//        List<List<Task>> realTask = new ArrayList<>();
//        int min = Integer.MAX_VALUE;
//        for (List<Task> t : result) {
//            if (t.size() == needTaskNum) {
//                int sum = sumOfCost(t);
//                if (sum < min) {
//                    min = sum;
//                    realTask.clear();
//                    realTask.add(t);
//                } else if (sum == min) {
//                    realTask.add(t);
//                }
//            }
//        }
//
//        List<String> strings = new ArrayList<>();
//        for (List<Task> taskList : realTask) {
//            StringBuilder builder = new StringBuilder();
//            Collections.sort(taskList);
//            for (Task task : taskList) {
//                builder.append(task.getTaskNum()).append(" ");
//            }
//            builder.deleteCharAt(builder.length() - 1);
//            strings.add(builder.toString());
//        }
//        Collections.sort(strings);
//        StringBuilder builder = new StringBuilder();
//        for (int k = strings.size() - 1; k >= 0; k--) {
//            builder.append(strings.get(k)).append(",");
//        }
//        builder.deleteCharAt(builder.length() - 1);
//        return builder.toString();
//    }
//
//    private static int sumOfCost(List<Task> t) {
//        int sum = 0;
//        for (Task task : t) {
//            sum = sum + task.getCost();
//        }
//        return sum;
//    }
//
//    public static List<List<Task>> findTask(List<Task> tasks, int needTaskNum, Set<Integer> usedTasks, Set<Integer> usedPeople) {
//        List<List<Task>> result = new ArrayList<>();
//        if (needTaskNum == 1) {
//            for (Task task : tasks) {
//                if (!usedPeople.contains(task.getPeopleNum()) && !usedTasks.contains(task.getTaskNum())) {
//                    List<Task> taskList = new ArrayList<>();
//                    taskList.add(task);
//                    result.add(taskList);
//                }
//            }
//        }
//
//        for (int i = 0; i < tasks.size(); i++) {
//            Task task = tasks.get(i);
//
//            List<Task> newTasks = new ArrayList<>(tasks);
//            Set<Integer> newUsedTasks = new HashSet<>(usedTasks);
//            Set<Integer> newUsedPeople = new HashSet<>(usedPeople);
//
//            newUsedTasks.add(task.getTaskNum());
//            newUsedPeople.add(task.getPeopleNum());
//
//            newTasks.remove(i);
//            List<List<Task>> lists = findTask(newTasks, needTaskNum - 1, newUsedTasks, newUsedPeople);
//            for (List<Task> e : lists) {
//                boolean isValid = true;
//                for (Task t : e) {
//                    if (usedPeople.contains(task.getPeopleNum()) || usedTasks.contains(task.getTaskNum())) {
//                        isValid = false;
//                    }
//                }
//                if (isValid) {
//                    e.add(0, task);
//                }
//            }
//            result.addAll(lists);
//            tasks.remove(i);
//            i--;
//        }
//
//        return result;
//    }
//
//}
//
//
//class Task implements Comparable<Task> {
//
//    private int peopleNum;
//
//    private int taskNum;
//
//    private int cost;
//
//    public Task(int peopleNum, int taskNum, int cost) {
//        this.peopleNum = peopleNum;
//        this.taskNum = taskNum;
//        this.cost = cost;
//    }
//
//    public boolean isAvailable(Task task) {
//        if (task.getPeopleNum() == this.peopleNum || task.getTaskNum() == this.taskNum) {
//            return false;
//        }
//        return true;
//    }
//
//    public int getPeopleNum() {
//        return peopleNum;
//    }
//
//    public int getTaskNum() {
//        return taskNum;
//    }
//
//    public int getCost() {
//        return cost;
//    }
//
//    @Override
//    public int compareTo(Task o) {
//        if (this.peopleNum > o.peopleNum) {
//            return 1;
//        } else {
//            return -1;
//        }
//    }
//}

///**
// * 棋盘覆盖问题
// * <p>
// * 棋盘覆盖问题：给定一个大小为2^n2^n个小方格的棋盘，其中有一个位置已经被填充，现在要用一个L型（22个小方格组成的大方格中去掉其中一个小方格）形状去覆盖剩下的小方格。
// * 求出覆盖方案，即哪些坐标下的小方格使用同一个L型格子覆盖。注意：坐标从0开始。左上方的第一个格子坐标为(0,0)，第一行第二个坐标为(0,1)，第二行第一个为(1,0)，以此类推。
// */
//public class 棋盘覆盖问题 {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cases = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < cases; i++) {
//            String[] infos = scanner.nextLine().split("\\s");
//            String[] points = scanner.nextLine().split("\\s");
//
//            //init
//            int n = Integer.parseInt(infos[0]);
//            int length = (int) Math.pow(2, n);
//            boolean[][] board = new boolean[length][length];
//            Point point = new Point(Integer.parseInt(points[0]), Integer.parseInt(points[1]));
//            //涂黑
//            board[Integer.parseInt(infos[1])][Integer.parseInt(infos[2])] = true;
//
//            List<List<Point>> lists = fillL(board, 0, length - 1, 0, length - 1);
//            for (List<Point> v : lists) {
//                if (v.contains(point)) {
//                    Collections.sort(v);
//                    StringBuilder builder = new StringBuilder();
//                    for (Point p : v) {
//                        if (!p.equals(point)) {
//                            builder.append(p.getX()).append(" ").append(p.getY()).append(",");
//                        }
//                    }
//                    builder.deleteCharAt(builder.length() - 1);
//                    System.out.println(builder.toString());
//                    break;
//                }
//            }
//        }
//    }
//
//    public static List<List<Point>> fillL(boolean[][] board, int left, int right, int up, int down) {
//        List<List<Point>> result = new ArrayList<>();
//
//        int full = (right - left + 1) * (down - up + 1);
//        if (full == 4) {
//            List<Point> points = new ArrayList<>();
//            for (int i = left; i <= right; i++) {
//                for (int j = up; j <= down; j++) {
//                    if (!board[i][j]) {
//                        Point point = new Point(i, j);
//                        board[i][j] = true;
//                        points.add(point);
//                    }
//                }
//            }
//            result.add(points);
//            return result;
//        }
//
//        int rowMid = ((right - left) / 2) + left;
//        int colMid = ((down - up) / 2) + up;
//
//        if (isSpecial(board, left, rowMid, up, colMid)) { //left-up
//            List<Point> points = new ArrayList<>();
//            //format to L
//            Point point1 = new Point(rowMid + 1, colMid);
//            Point point2 = new Point(rowMid + 1, colMid + 1);
//            Point point3 = new Point(rowMid, colMid + 1);
//            points.add(point1);
//            points.add(point2);
//            points.add(point3);
//
//            //fill
//            board[point1.getX()][point1.getY()] = true;
//            board[point2.getX()][point2.getY()] = true;
//            board[point3.getX()][point3.getY()] = true;
//            result.add(points);
//        } else if (isSpecial(board, left, rowMid, colMid + 1, down)) {  //left-down
//            List<Point> points = new ArrayList<>();
//            //format to L
//            Point point1 = new Point(rowMid, colMid);
//            Point point2 = new Point(rowMid + 1, colMid);
//            Point point3 = new Point(rowMid + 1, colMid + 1);
//            points.add(point1);
//            points.add(point2);
//            points.add(point3);
//
//            //fill
//            board[point1.getX()][point1.getY()] = true;
//            board[point2.getX()][point2.getY()] = true;
//            board[point3.getX()][point3.getY()] = true;
//            result.add(points);
//        } else if (isSpecial(board, rowMid + 1, right, up, colMid)) { //right-up
//            List<Point> points = new ArrayList<>();
//            //format to L
//            Point point1 = new Point(rowMid, colMid);
//            Point point2 = new Point(rowMid, colMid + 1);
//            Point point3 = new Point(rowMid + 1, colMid + 1);
//            points.add(point1);
//            points.add(point2);
//            points.add(point3);
//
//            //fill
//            board[point1.getX()][point1.getY()] = true;
//            board[point2.getX()][point2.getY()] = true;
//            board[point3.getX()][point3.getY()] = true;
//            result.add(points);
//        } else if (isSpecial(board, rowMid + 1, right, colMid + 1, down)) { //right-down
//            List<Point> points = new ArrayList<>();
//            //format to L
//            Point point1 = new Point(rowMid, colMid);
//            Point point2 = new Point(rowMid + 1, colMid);
//            Point point3 = new Point(rowMid, colMid + 1);
//            points.add(point1);
//            points.add(point2);
//            points.add(point3);
//
//            //fill
//            board[point1.getX()][point1.getY()] = true;
//            board[point2.getX()][point2.getY()] = true;
//            board[point3.getX()][point3.getY()] = true;
//            result.add(points);
//        }
//
//        List<List<Point>> leftUp = fillL(board, left, rowMid, up, colMid);
//        List<List<Point>> leftDown = fillL(board, left, rowMid, colMid + 1, down);
//        List<List<Point>> rightUp = fillL(board, rowMid + 1, right, up, colMid);
//        List<List<Point>> rightDown = fillL(board, rowMid + 1, right, colMid + 1, down);
//
//        result.addAll(leftUp);
//        result.addAll(leftDown);
//        result.addAll(rightUp);
//        result.addAll(rightDown);
//        return result;
//    }
//
//    private static boolean isSpecial(boolean[][] board, int left, int right, int up, int down) {
//        for (int i = left; i <= right; i++) {
//            for (int j = up; j <= down; j++) {
//                if (board[i][j]) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//}
//
//class Point implements Comparable<Point> {
//    private int x;
//    private int y;
//
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Point point = (Point) o;
//        return x == point.x &&
//                y == point.y;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(x, y);
//    }
//
//    @Override
//    public int compareTo(Point o) {
//        if (this.x > o.x) {
//            return 1;
//        } else if (this.x == o.x) {
//            if (this.y > o.y) {
//                return 1;
//            } else {
//                return -1;
//            }
//        } else {
//            return -1;
//        }
//    }
//}

///**
// * 拓扑排序解的个数
// *
// * 给定有向无环图中所有边，计算图的拓扑排序解的个数。
// */
//public class 拓扑排序解的个数 {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cases = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < cases; i++) {
//            String info = scanner.nextLine();
//            Map<String, Integer> inDegree = buildInDegree(info);
//            Map<String, Set<String>> graph = build(info);
//            List<List<String>> result = topologicalSort(graph, inDegree);
//            System.out.println(result.size());
//        }
//    }
//
//    public static List<List<String>> topologicalSort(Map<String, Set<String>> graph, Map<String, Integer> inDegree) {
//
//        List<List<String>> result = new ArrayList<>();
//        int count = 0;
//        String lastElement = null;
//        for (String key : inDegree.keySet()) {
//            if (inDegree.get(key) != null) {
//                count++;
//                lastElement = key;
//            }
//        }
//
//        if (count == 1) {
//            List<String> info = new ArrayList<>();
//            info.add(lastElement);
//            result.add(info);
//            return result;
//        }
//
//        for (String key : inDegree.keySet()) {
//            if (inDegree.get(key) != null && inDegree.get(key) == 0) {
//                Map<String, Integer> newInDegree = new HashMap<>(inDegree);
//                newInDegree.put(key, null);
//                Set<String> content = graph.get(key);
//                for (String v : content) {
//                    newInDegree.put(v, newInDegree.get(v) - 1);
//                }
//                List<List<String>> sortResult = topologicalSort(graph, newInDegree);
//                for (List<String> e : sortResult) {
//                    e.add(0, key);
//                }
//                result.addAll(sortResult);
//            }
//        }
//
//        return result;
//    }
//
//    public static Map<String, Integer> buildInDegree(String info) {
//        String[] edges = info.split(",");
//        Map<String, Integer> map = new HashMap<>();
//
//        for (String edge : edges) {
//            String[] infos = edge.split("\\s");
//            if (!map.containsKey(infos[0])) { //init
//                map.put(infos[0], 0);
//            }
//
//            if (!map.containsKey(infos[1])) {
//                map.put(infos[1], 1);
//            } else {
//                map.put(infos[1], map.get(infos[1]) + 1);
//            }
//        }
//
//        return map;
//    }
//
//    public static Map<String, Set<String>> build(String info) {
//        String[] edges = info.split(",");
//        Map<String, Set<String>> map = new HashMap<>();
//
//        for (String edge : edges) {
//            String[] infos = edge.split("\\s");
//            if (!map.containsKey(infos[0])) {
//                Set<String> content = new HashSet<>();
//                content.add(infos[1]);
//                map.put(infos[0], content);
//            } else {
//                map.get(infos[0]).add(infos[1]);
//            }
//        }
//        return map;
//    }
//}

///**
// * 广度优先遍历图
// *
// * 按照给定的起始顶点广度优先遍历图，每一次通过字母顺序选择顶点查找下一层邻接点，打印遍历顺序。
// */
//public class 广度优先遍历图 {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cases = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < cases; i++) {
//            String[] infos = scanner.nextLine().split("\\s");
//            String start = infos[1];
//            int length = Integer.parseInt(infos[0]);
//            String points[] = scanner.nextLine().split("\\s");
//            int[][] metrics = new int[length][length];
//            for (int j = 0; j < length; j++) {
//                String[] elements = scanner.nextLine().split("\\s");
//                for (int k = 1; k < elements.length; k++) {
//                    metrics[j][k - 1] = Integer.parseInt(elements[k]);
//                }
//            }
//
//            //init
//            Map<String, Integer> map = new HashMap<>();
//            boolean[] visited = new boolean[points.length];
//            for (int j = 0; j < visited.length; j++) {
//                visited[j] = false;
//                map.put(points[j], j);
//            }
//
//            StringBuilder builder = new StringBuilder(start + " ");
//            bfs(points, metrics, start, visited, map, builder);
//            builder.deleteCharAt(builder.length() - 1);
//            System.out.println(builder.toString());
//        }
//    }
//
//    public static void bfs(String[] points, int[][] metrics, String start, boolean[] visited, Map<String, Integer> map, StringBuilder builder) {
//        visited[map.get(start)] = true;
//        int index = map.get(start);
//
//        List<Integer> indexs = new ArrayList<>();
//        for (int i = 0; i < metrics[index].length; i++) {
//            if (metrics[index][i] == 1) {
//                if (!visited[i]) {
//                    builder.append(points[i]).append(" ");
//                    visited[i] = true;
//                    indexs.add(i);
//                }
//            }
//        }
//
//        for (int e : indexs) {
//            bfs(points, metrics, points[e], visited, map, builder);
//        }
//    }
//}

///**
// * 深度优先遍历
// *
// * 按照给定的起始顶点深度优先遍历给定的无向图，尝试所有可能的遍历方式，打印遍历过程中出现的最大深度。
// */
//public class 深度优先遍历 {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int cases = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < cases; i++) {
//            String[] infos = scanner.nextLine().split("\\s");
//            String start = infos[1];
//            int length = Integer.parseInt(infos[0]);
//            String points[] = scanner.nextLine().split("\\s");
//            int[][] metrics = new int[length][length];
//            for (int j = 0; j < length; j++) {
//                String[] elements = scanner.nextLine().split("\\s");
//                for (int k = 1; k < elements.length; k++) {
//                    metrics[j][k - 1] = Integer.parseInt(elements[k]);
//                }
//            }
//
//            //init
//            Map<String, Integer> map = new HashMap<>();
//            boolean[] visited = new boolean[points.length];
//            for (int j = 0; j < visited.length; j++) {
//                visited[j] = false;
//                map.put(points[j], j);
//            }
//
//            int result = dfs(points, metrics, start, visited, map, 1);
//            System.out.println(result);
//        }
//    }
//
//    public static int dfs(String[] points, int[][] metrics, String start, boolean[] visited, Map<String, Integer> map, int depth) {
//        visited[map.get(start)] = true;
//        int index = map.get(start);
//        int max = Integer.MIN_VALUE;
//        boolean isEnd = true;
//        for (int i = 0; i < metrics[index].length; i++) {
//            if (metrics[index][i] == 1) {
//                if (!visited[i]) {
//                    isEnd = false;
//                    int result = dfs(points, metrics, points[i], visited, map, depth + 1);
//                    if (result > max) {
//                        max = result;
//                    }
//                }
//            }
//        }
//        if (isEnd) {
//            return depth;
//        } else {
//            return max;
//        }
//    }
//
//    private static boolean isEnd(boolean[] visited) {
//        for (boolean e : visited) {
//            if (!e) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//}

///**
// * 堆排序 -
// * 堆排序的思想借助于二叉堆中的最大堆得以实现。
// * 首先，将待排序数列抽象为二叉树，并构造出最大堆；
// * 然后，依次将最大元素（即根节点元素）与待排序数列的最后一个元素交换（即二叉树最深层最右边的叶子结点元素）；
// * 每次遍历，刷新最后一个元素的位置（自减1），直至其与首元素相交，即完成排序。
// *
// * 时间复杂度：O(NlogN) 　
// * 稳定性：不稳定
// *
// */
//
//#include<vector>
//#include "profile.h"
//
//        /*堆排序*/
//        //根节点元素自顶向下移动到合适的位置以构成最大堆
//        void downToMaxHeap(vector<int> &arr, int bgn, int end)
//        {
//        int child;
//        int parent = bgn;
//
//        /*假根节点向下移动至合适的位置 --整个堆排序的核心代码块*/
//        while ((child = parent * 2 + 1) < end)
//        {
//        if ((child < end - 1) && (arr[child] < arr[child + 1]))
//        ++child;    //右孩子节点
//        if (arr[child] > arr[parent])
//        profile::mySwap(&arr[child], &arr[parent]);
//        else
//        break;
//        parent = child;
//        }
//        }
////将数组构造为最大堆
//        void buildMaxHeap(vector<int> &arr, int bgn, int end)
//        {
//        if (bgn >= end - 1)
//        return;
//
//        int parent = end / 2 - 1;
//        while (parent >= 0)
//        {
//        downToMaxHeap(arr, parent, end);
//        --parent;
//        }
//        }
////堆排序
//        void heapSort(vector<int> &arr, int bgn, int end)
//        {
//        //构造最大堆
//        buildMaxHeap(arr, bgn, end);
//
//        while (end > 1)
//        {
//        profile::mySwap(&arr[0], &arr[--end]);
//        downToMaxHeap(arr, 0, end);
//        }
//        }
//
//        /**
//         * 插入排序 -
//         * 数列前面部分看为有序，
//         * 依次将后面的无序数列元素插入到前面的有序数列中，
//         * 初始状态有序数列仅有一个元素，即首元素。
//         * 在将无序数列元素插入有序数列的过程中，采用了逆序遍历有序数列，
//         * 相较于顺序遍历会稍显繁琐，但当数列本身已近排序状态效率会更高。
//         *
//         * 时间复杂度：O(N^2) 　　
//         * 稳定性：稳定
//         */
//        #include<vector>
//#include "profile.h"
//
//        /*插入排序*/
//        void insertSort(vector<int> &arr, int bgn, int end)
//        {
//        for (int i = bgn + 1; i < end; ++i)
//        {
//        /*
//         * 分为1,2两部分处理，可以囊括j = beg - 1时的情况
//         * 即需要将arr[i]插入到首元素前的位置，若使用一个for
//         * 包括这两部分，则会在发生这种情况时退出
//         */
//        /*1*/
//        int j = i - 1;
//        for (; j >= bgn; --j)
//        if (arr[j] <= arr[i])
//        break;
//        /*2*/
//        if (j != i - 1)
//        {
//        int temp = arr[i];
//        for (int k = i; k > j + 1; --k)
//        {
//        arr[k] = arr[k - 1];
//        }
//        arr[j + 1] = temp;
//        }
//        }
//        }
//
//        /**
//         * 快速排序 -
//         * （类似于选择排序的定位思想）
//         * 选一基准元素，
//         * 依次将剩余元素中小于该基准元素的值放置其左侧，
//         * 大于等于该基准元素的值放置其右侧；
//         *
//         * 然后，取基准元素的前半部分和后半部分分别进行同样的处理；
//         * 以此类推，直至各子序列剩余一个元素时，即排序完成（类比二叉树的思想，from up to down）
//         *
//         * 时间复杂度：O(NlogN) 　　
//         * 稳定性：不稳定
//         */
//
//        #include<vector>
//#include<iostream>
//#include "profile.h"
//
//        /*快排*/
//        void quickSort(vector<int> &arr, int bgn, int end)  //arr must be the reference of real param
//        {
//        //数组arr空or仅有一个元素则退出
//        if (bgn >= end - 1)
//        return;
//
//        int lindex = bgn;
//        int rindex = end - 1;
//        int std = arr[lindex];
//        while (lindex < rindex)
//        {
//        while (lindex < rindex)
//        {
//        if (arr[rindex] < std)
//        {
//        arr[lindex++] = arr[rindex];
//        break;
//        }
//        --rindex;
//        }
//
//        while (lindex < rindex)
//        {
//        if (arr[lindex] >= std)
//        {
//        arr[rindex--] = arr[lindex];
//        break;
//        }
//        ++lindex;
//        }
//        }
//
//        arr[lindex] = std;
//        quickSort(arr, bgn, lindex);
//        quickSort(arr, rindex + 1, end);
//        }
//
////int main() {
////	vector<int> temp = { 1,5,8,2,3,2,5,15,12,44,23 };
////	quickSort(temp, 0, 11);
////	for (int i = 0; i < 11; i++) {
////		cout << temp[i] << " ";
////	}
////	getchar();
////}
//
///**
// * 基数排序 -
// * 桶排序的改进版，桶的大小固定为10，减少了内存空间的开销。
// * 首先，找出待排序列中得最大元素max，并依次按max的低位到高位对所有元素排序；
// * 桶元素10个元素的大小即为待排序数列元素对应数值为相等元素的个数，
// * 即每次遍历待排序数列，桶将其按对应数值位大小分为了10个层级，桶内元素值得和为待排序数列元素个数。
// *
// * 时间复杂度：O(x*N) 　　
// * 稳定性：稳定
// */
//
//        #include<vector>
//#include<iostream>
//#include "profile.h"
//
//        /*基数排序*/
//        //1. 计数排序，按整形数值单位进行排序
//        void countSort(vector<int> &arr, int exp)
//        {
//        int bucket[10] = { 0 };
//        int arrSize = arr.size();
//        int *pTemp = new int[arrSize];
//        memset(pTemp, 0, arrSize * sizeof(int));
//
//        //统计单位exp各数值计数值
//        for (auto const val : arr)
//        ++bucket[(val / exp) % 10];
//
//        //计数分层
//        for (int i = 1; i < 10; ++i)
//        bucket[i] += bucket[i - 1];
//
//        //按exp位大小用数组arr元素填充pTemp
//        for (int i = arrSize - 1; i >= 0; --i)
//        pTemp[--bucket[(arr[i] / exp) % 10]] = arr[i];
//        /*bugs*/
//        #if 0
//        //bug1: bucket各层次的计数值没遍历一次相应自减1
//        for (auto const val : arr)
//        pTemp[bucket[(val / exp) % 10] - 1] = val;
//        //bug2: arr数组元素每次排序时，下标应从大到小遍历，否则无法实现排序
//        for (auto const val : arr)
//        pTemp[--bucket[(val / exp) % 10]] = val;
//        #endif
//
//        //pTemp -> arr
//        for (int i = 0; i < arrSize; ++i)
//        arr[i] = pTemp[i];
//        delete[]pTemp;
//        }
////2. 合并各单位计数排序结果
//        void radixSort(vector<int> &arr)
//        {
//        int max = profile::getMaxValue(arr);
//        for (int exp = 1; max / exp != 0; exp *= 10)
//        countSort(arr, exp);
//        }
//
//        int min() {
//        vector<int> temp = { 1,5,8,2,3,2,5,15,12,44,23 };
//        radixSort(temp);
//        for (int i = 0; i < 11; i++) {
//        cout << temp[i] << " ";
//        }
//        getchar();
//        }
///**
// * 选择排序 -
// * 首先初始化最小元素索引值为首元素，
// * 依次遍历待排序数列，若遇到小于该最小索引位置处的元素则刷新最小索引为该较小元素的位置，直至遇到尾元素，
// * 结束一次遍历，并将最小索引处元素与首元素交换；
// * 然后，初始化最小索引值为第二个待排序数列元素位置，同样的操作，可得到数列第二个元素即为次小元素；以此类推。
// *
// * 时间复杂度：O(N^2) 　　
// * 稳定性：不稳定
// */
//        #include<vector>
//#include "profile.h"
//        /*选择排序*/
//        void selectSort(vector<int> &arr, int bgn, int end)
//        {
//        for (int i = bgn; i < end; ++i)
//        {
//        int minIndex = i;
//        for (int j = i + 1; j < end; ++j)
//        {
//        if (arr[j] < arr[minIndex])
//        minIndex = j;
//        }
//        if (minIndex != i)
//        profile::mySwap(&arr[i], &arr[minIndex]);
//        }
//        }
//
//        /**
//         * 希尔排序 -
//         * 插入排序的改进版。
//         * 为了减少数据的移动次数，在初始序列较大时取较大的步长，通常取序列长度的一半，
//         * 此时只有两个元素比较，交换一次；
//         * 之后步长依次减半直至步长为1，即为插入排序，
//         * 由于此时序列已接近有序，故插入元素时数据移动的次数会相对较少，效率得到了提高。
//         *
//         * 时间复杂度：通常认为是O(N^3/2) ，未验证　　O(n^(1.3—2))[来自百度百科]
//         * 稳定性：不稳定
//         */
//
//        #include<vector>
//#include "profile.h"
//
//        /*希尔排序*/
//        void shellSort(vector<int> &arr, int bgn, int end)
//        {
//        for (int step = (end - bgn) / 2; step > 0; step /= 2)
//        {
//        for (int i = bgn; i < step; ++i)
//        {
//        /*
//         * 以下，insertSort的变异
//         */
//        for (int j = i + step; j < end; j += step)
//        {
//        int k = j - step;
//        for (; k >= i; k -= step)
//        if (arr[k] <= arr[j])
//        break;
//        if (k != j - step)
//        {
//        int tmp = arr[j];
//        for (int m = j; m > k + step; m -= step)
//        arr[m] = arr[m - step];
//        arr[k + step] = tmp;
//        }
//        }
//        }
//        }
//        }

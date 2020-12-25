package summer2019;


import java.util.*;

//300开始
public class LeetCodePraticeIIII {


    //301 删除括号
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        set.add(s);
        while(true){
            for(String item : set){
                if(help301(item))
                    res.add(item);
            }

            //精髓所在
            if(res.size() >0)
                return res;
            Set<String> nextSet = new HashSet<>();
            for(String item : set){
                for(int i = 0 ; i < item.length() ; i ++){
                    if(item.charAt(i) == '(' || item.charAt(i) == ')'){
                        nextSet.add(item.substring(0,i) + item.substring(i+1));
                    }
                }
            }
            set = nextSet;
        }
    }

    private boolean help301(String s){
        char[] chars = s.toCharArray();
        int count = 0;
        for(char item : chars){
            if(item == '(')
                count++;
            else if(item == ')')
                count--;
            if(count < 0)
                return false;
        }
        return count == 0;
    }


    //303
    class NumArray {

        private int[] arrays;
        public NumArray(int[] nums) {
            arrays = new int[nums.length];
            if(nums.length == 0)
                return;
            arrays[0] = nums[0];
            for(int i = 1 ; i < nums.length ; i ++){
                arrays[i] = arrays[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if(i == 0)
                return arrays[j];
            else
                return arrays[j] - arrays[i - 1];
        }
    }

    //304
    class NumMatrix {

        private int[][] matrix;
        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for(int i = row1 ; i <= row2 ; i++){
                for(int j = col1 ; j <= col2 ; j++){
                    sum += matrix[i][j];
                }
            }
            return sum;
        }
    }


    class NumMatrixII {

        private int[][] dp;
        public NumMatrixII(int[][] matrix) {
            if (matrix.length == 0) return;
            dp = new int[matrix.length + 1][matrix[0].length + 1];
            for(int i = 0 ; i < matrix.length ; i++){
                for(int j = 0 ; j < matrix[0].length; j++){
                    dp[i + 1][j + 1] = matrix[i][j] + dp[i + 1][j] + dp[i][j + 1] - dp[i][j];
                }
            }


        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row1][col2 + 1] - dp[row2 + 1][col1];
        }
    }

    //307 线段数组  参考https://blog.csdn.net/Yaokai_AssultMaster/article/details/79492190
    class NumArrayIII {
        int[] nums;
        int[] sums;
        public NumArrayIII(int[] nums) {
            this.nums = nums;
            this.sums = new int[nums.length + 1];
            for(int i = 0 ; i < nums.length ; i++){
                updateTree(i + 1,nums[i]);
            }
        }

        public void update(int i, int val) {
            updateTree(i + 1,val-nums[i]);
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            return query(j + 1) - query(i);
        }

        private void updateTree(int index,int val){
            while(index < sums.length){
                sums[index] += val ;
                index += and(index);
            }

        }

        private int query(int i){
            int res = 0;
            while(i > 0){
                res += sums[i];
                i -= and(i);
            }
            return res;
        }

        private int and(int x){
            return x & (-x);
        }
    }


    //309
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - prices[0]);
        for(int i = 2; i < prices.length ; i++){
            buy[i] = Math.max(sell[i-2] - prices[i],buy[i-1]);
            sell[i] = Math.max(buy[i-1] + prices[i],sell[i-1]);
        }
        return sell[prices.length-1];
     }


     //dp 思路：第i天结束有股票  1 无股票，冷却  2 无股票，无冷却
    public int maxProfitII(int[] prices) {
        int[][] dp = new int[prices.length][3];
        if(prices.length < 2)
            return 0;
        dp[0][0] = -prices[0];
        for(int i = 1 ; i < prices.length ; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
        }
        return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
    }

    public static void main(String[] args) {
        System.out.println("111");
        int[][] edges = new int[5][2];
        edges[0][0] = 3;
        edges[0][1] = 0;
        edges[1][0] = 3;
        edges[1][1] = 1;
        edges[2][0] = 3;
        edges[2][1] = 2;
        edges[3][0] = 3;
        edges[3][1] = 4;
        edges[4][0] = 5;
        edges[4][1] = 4;
        new LeetCodePraticeIIII().findMinHeightTreesII(6,edges).forEach(i -> System.out.println(i));
    }

    //310
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            int height = help310(edges,i,n);
            if(height < min){
                res.clear();
                res.add(i);
                min = height;
            }
            else if(height == min){
                res.add(i);
            }
        }
        return res;
    }

    private int help310(int[][] edges,int root,int n){
        int height = 0;
        Boolean[] visited = new Boolean[n];
        Arrays.fill(visited,false);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                int cur = queue.poll();
                visited[cur] = true;
                List<Integer> candidate = getCandidate(edges, cur,visited);
                for (Integer i : candidate) {
                    queue.offer(i);
                }
                size--;
            }
            height++;
        }
        return height;
    }

    private List<Integer> getCandidate(int[][] edges,int cur,Boolean[] visited){
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ;i < edges.length ; i++){
            if(edges[i][0] == cur && visited[edges[i][1]] == false){
                res.add(edges[i][1]);
            }
            else if(edges[i][1] == cur && visited[edges[i][0]] == false){
                res.add(edges[i][0]);
            }
        }
        return res;
    }



    // 不断去掉子节点 使得最后只剩下<=2个节点
    public List<Integer> findMinHeightTreesII(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        int[] indegrees = new int[n];
        boolean[][] graph = new boolean[n][n];
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < edges.length ; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            indegrees[x]++;
            indegrees[y]++;
            graph[x][y] = true;
            graph[y][x] = true;
        }
        while(n>2){
            List<Integer> candidate = getCandidata(indegrees);
            System.out.println("-----------");
            for(int i = 0 ; i < candidate.size(); i ++){
                int cur = candidate.get(i);
                indegrees[cur]--;
                visited[cur] = true;
                n--;
                for(int j = 0 ; j < graph[cur].length ; j++){
                    if(graph[cur][j]){
                        graph[cur][j] = false;
                        graph[j][cur] = false;
                        indegrees[j]--;
                    }
                }
            }
        }

        for(int i = 0 ; i < visited.length ; i ++){
            if(!visited[i])
                res.add(i);
        }
        return res;
    }

    private List<Integer> getCandidata(int[] indegrees){
        List<Integer> res = new ArrayList<>();
        for(int i  = 0 ; i < indegrees.length ; i++){
            if(indegrees[i] == 1)
                res.add(i);
        }
        return res;
    }




}

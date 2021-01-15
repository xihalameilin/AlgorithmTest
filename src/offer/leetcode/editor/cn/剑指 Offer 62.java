package offer.leetcode.editor.cn;
//0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
// 👍 280 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 class YuanQuanZhongZuiHouShengXiaDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();
    System.out.println(solution.lastRemaining(5, 3));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> circle = new ArrayList<>();
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            circle.add(i);
        }
        int count = 0;
        int index = -1;
        while(count < n -1 ){
            for(int i = 0 ; i < m ; i++){
                index = (index + 1) % n;
                if(visited[index] == 1){
                    i--;
                }
            }
            visited[index] = 1;
            count++;
        //Arrays.stream(visited).forEach(i -> System.out.print(i + " "));
        //System.out.println();
        }
        for(int i = 0 ; i < n ; i++){
            if(visited[i] == 0)
                return circle.get(i);
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
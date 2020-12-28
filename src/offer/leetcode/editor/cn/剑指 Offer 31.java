package offer.leetcode.editor.cn;
//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈
//的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。 
//
// 
//
// 示例 1： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 示例 2： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= pushed.length == popped.length <= 1000 
// 0 <= pushed[i], popped[i] < 1000 
// pushed 是 popped 的排列。 
// 
//
// 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/ 
// 👍 103 👎 0

import javax.management.StringValueExp;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class ZhanDeYaRuDanChuXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new ZhanDeYaRuDanChuXuLieLcof().new Solution();
        solution.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     执行耗时:3 ms,击败了45.96% 的Java用户
     内存消耗:38 MB,击败了86.09% 的Java用户
     */
//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        Stack<Integer> stack = new Stack<>();
//        int popIndex = 0;
//        int pushIndex = 0;
//        while(pushIndex < pushed.length) {
//            boolean flag = false;
//            if(stack.isEmpty()){
//                stack.push(pushed[pushIndex]);
//                pushIndex ++;
//            }
//            while (!stack.isEmpty() && stack.peek() != popped[popIndex]) {
//                stack.push(pushed[pushIndex]);
//                pushIndex++;
//                if(pushIndex == pushed.length){
//                    flag = true;
//                    break;
//                }
//
//            }
//            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
//                stack.pop();
//                popIndex++;
//            }
//            if(flag)
//                break;
//        }
//        return stack.isEmpty();
//    }


    /**
     执行耗时:2 ms,击败了94.61% 的Java用户
     内存消耗:38.3 MB,击败了41.37% 的Java用户
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int index = 0;
        for(int item : pushed){
            stack.push(item);
            while(!stack.isEmpty() && stack.peek() == popped[index]){
                stack.pop();
                index ++;
            }
        }
        return index == popped.length;
    }

//    private boolean help(int[] pushed,int[] popped,boolean[] visited,int index,int step){
//        System.out.println(index);
//        System.out.println(step);
//        if(step == popped.length-1)
//            return true;
//        if(pushed[index] != popped[step])
//            return false;
//        visited[index] = true;
//        int left = index - 1,right = index + 1;
//        while(left >= 0 && visited[left]){
//            left --;
//        }
//        if(left >= 0){
//            boolean flag = help(pushed,popped,visited,left,step+1);
//            if(flag)
//                return true;
//        }
//        while(right < popped.length && visited[right]){
//            right ++;
//        }
//        if(right < popped.length){
//            boolean flag = help(pushed,popped,visited,right,step+1);
//            if(flag)
//                return true;
//        }
//
//        if(left < 0 && right == popped.length)
//            return false;
//        if(pushed[left] != popped[step] && pushed[right] != popped[step])
//            return false;

//        return help(pushed,popped,visited,left,step+1) || help(pushed,popped,visited,right,step+1);

//        return false;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
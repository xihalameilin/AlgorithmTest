package offer.leetcode.editor.cn;
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 79 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
        //Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        //new CongWeiDaoTouDaYinLianBiaoLcof().test();
    }

//    private  void test(){
//        ListNode listNode = new ListNode(2);
//        listNode.next = new ListNode(3);
//        listNode.next.next = new ListNode(1);
//        new Solution().reversePrint(listNode);
//    }

//leetcode submit region begin(Prohibit modification and deletion)
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    /**
     执行耗时:5 ms,击败了6.01% 的Java用户
     内存消耗:38.7 MB,击败了96.85% 的Java用户
     */
//    public int[] reversePrint(ListNode head) {
//        List<Integer> res = new ArrayList<>();
//        while(head != null){
//            res.add(0,head.val);
//            head = head.next;
//        }
//        int[] array = new int[res.size()];
//        for(int i = 0 ; i < res.size() ; i++) {
//            array[i] = res.get(i);
//        }
//        return array;
//    }

    /**
     执行耗时:2 ms,击败了38.04% 的Java用户
     内存消耗:38.6 MB,击败了98.16% 的Java用户
     */
//    public int[] reversePrint(ListNode head) {
//        Stack<Integer> res = new Stack<>();
//        while(head != null){
//            res.push(head.val);
//            head = head.next;
//        }
//        int size = res.size();
//        int[] array = new int[size];
//        for(int i = 0 ; i < size ; i++) {
//            array[i] = res.pop();
//        }
//        return array;
//
//    }


    //翻转链表

    /**
     执行耗时:1 ms,击败了72.21% 的Java用户
     内存消耗:39.1 MB,击败了72.51% 的Java用户
     */
    public int[] reversePrint(ListNode head) {
        ListNode pre = null;
        ListNode mid = head;
        int count = 0;
        while(mid != null){
            count++;
            ListNode next = mid.next;
            mid.next = pre;
            pre = mid;
            mid = next;
        }
        System.out.println(count);
        int[] res = new int[count];
        int index = 0;
        while(pre != null){
            res[index] = pre.val;
            pre = pre.next;
            index ++;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
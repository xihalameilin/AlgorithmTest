package offer.leetcode.editor.cn;
//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
//
// 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-point
//er/ 
//
// 
// Related Topics 链表 
// 👍 129 👎 0

import javax.naming.Name;
import java.util.HashMap;
import java.util.Map;

class FuZaLianBiaoDeFuZhiLcof{
    public static void main(String[] args) {
        Solution solution = new FuZaLianBiaoDeFuZhiLcof().new Solution();
        
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    /**
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:38.3 MB,击败了43.17% 的Java用户
     */
//    public Node copyRandomList(Node head) {
//        if(head == null)
//            return null;
//        Map<Node,Node> map = new HashMap<>();
//        Node cur = head;
//        while(cur != null){
//            map.put(cur,new Node(cur.val));
//            cur = cur.next;
//        }
//
//        cur = head;
//        while(cur != null){
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//        return map.get(head);
//    }


    /**
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:38.1 MB,击败了61.13% 的Java用户
     */
    // 原地修改
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node cur = head;
        // 在每个节点的后面添加一个复制
        while(cur != null){
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        // 安排random指针
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        Node res = head.next;
        Node curCopy = head.next;
        while(cur != null){
            cur.next = cur.next.next;
            cur = cur.next;
            if(curCopy.next != null){
                curCopy.next = curCopy.next.next;
                curCopy = curCopy.next;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
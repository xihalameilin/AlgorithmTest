package summer2019;

import java.util.Stack;


//155
public class MinStack {
    //要求：在常数时间内检索到最小的元素
    private int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack();
    public MinStack() {

    }

    public void push(int x) {
        if(min>=x){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

//    private Node head;
//
//    public void push(int x) {
//        if(head == null)
//            head = new Node(x, x);
//        else
//            head = new Node(x, Math.min(x, head.min), head);
//    }
//
//    public void pop() {
//        head = head.next;
//    }
//
//    public int top() {
//        return head.val;
//    }
//
//    public int getMin() {
//        return head.min;
//    }
//
//    private class Node {
//        int val;
//        int min;
//        Node next;
//
//        private Node(int val, int min) {
//            this(val, min, null);
//        }
//
//        private Node(int val, int min, Node next) {
//            this.val = val;
//            this.min = min;
//            this.next = next;
//        }
//    }
}

package summer2019;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue;
    public MyStack() {
        queue  = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        while(size-->0){
            int temp = queue.poll();
            queue.offer(temp);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }
}

package summer2019;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> temp ;
    private Stack<Integer> out ;
    public MyQueue() {
        temp = new Stack<>();
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        temp.clear();
        while(!out.isEmpty()){
            int t = out.pop();
            temp.push(t);
        }
        temp.push(x);
        out.clear();
        while(!temp.isEmpty()){
            int t = temp.pop();
            out.push(t);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return out.size() == 0;
    }
}

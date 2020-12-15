package summer2019;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)-> {return b-a;});

    }

    public void addNum(int num) {
        if(num < findMedian())
            maxHeap.add(num);
        else
            minHeap.add(num);
        if(minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.add(maxHeap.poll());
        }
    }


    public double findMedian() {
        if(maxHeap.size() == maxHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }
}

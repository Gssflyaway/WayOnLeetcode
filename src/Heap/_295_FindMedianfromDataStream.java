package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _295_FindMedianfromDataStream {

    private Queue<Integer> smallHeapQueue;
    private Queue<Integer> bigHeapQueue;

    public _295_FindMedianfromDataStream(){
        smallHeapQueue = new PriorityQueue<>();
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        bigHeapQueue = new PriorityQueue<>(comparator);
    }

    public void addNum(int num) {
        bigHeapQueue.add(num);
        if (bigHeapQueue.size() - smallHeapQueue.size() >= 2){
            smallHeapQueue.add(bigHeapQueue.poll());
        }
        if (smallHeapQueue.peek() != null && smallHeapQueue.peek() < bigHeapQueue.peek()){
            smallHeapQueue.add(bigHeapQueue.poll());
            if (smallHeapQueue.size() - bigHeapQueue.size() >= 2)
                bigHeapQueue.add(smallHeapQueue.poll());
        }
    }

    public double findMedian() {
        int totalSize = smallHeapQueue.size() + bigHeapQueue.size();
        if (totalSize == 0)
            return 0;
        if (totalSize % 2 == 1){
            if (smallHeapQueue.size() > bigHeapQueue.size())
                return smallHeapQueue.peek();
            else
                return bigHeapQueue.peek();
        }else {
            return (smallHeapQueue.peek() + bigHeapQueue.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        _295_FindMedianfromDataStream main = new _295_FindMedianfromDataStream();
        main.addNum(1);
        main.addNum(2);
        System.out.println(main.findMedian());;
        main.addNum(3);
        System.out.println(main.findMedian());;
    }
}

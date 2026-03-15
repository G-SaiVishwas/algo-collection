package dsalgo.datastructure.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class MinHeap2{
    private ArrayList<Integer> minHeap;

    public MinHeap2() {
        minHeap = new ArrayList<>();
    }

    public void insert(int val){
        minHeap.add(val);
        heapifyUp(minHeap.size()-1);
    }

    public int poll(){
        if(minHeap.isEmpty()) return -1;

        int minvalue = minHeap.getFirst();
        int lastValue = minHeap.removeLast();

        minHeap.set(0,lastValue);
        heapifyDown(0);
        return minvalue;

    }

    public int peek(){
        if(minHeap.isEmpty()) return -1;
        return minHeap.getFirst();
    }

    private void heapifyDown(int index){
        int leftChildIndex = index*2+1;
        int rightChildIndex = index*2+2;
        int smallestIndex = index;

        if(leftChildIndex < minHeap.size() && minHeap.get(leftChildIndex) < minHeap.get(smallestIndex)){
            smallestIndex = leftChildIndex;
        }

        if(rightChildIndex < minHeap.size() && minHeap.get(rightChildIndex) < minHeap.get(smallestIndex)){
            smallestIndex = rightChildIndex;
        }

        if(smallestIndex != index){
            swap(index, smallestIndex);
            heapifyDown(smallestIndex);
        }
    }

    private void heapifyUp(int index){
        if(index < 0) return;
        int parentIndex = (index-1)/2;
        while(minHeap.get(index) < minHeap.get(parentIndex)){
            swap(index,parentIndex);
            index = parentIndex;
            parentIndex = (index-1)/2;
        }
    }

    private void swap(int index1, int index2){
        int temp = minHeap.get(index1);
        minHeap.set(index1, minHeap.get(index2));
        minHeap.set(index2, temp);
    }

    public void print(){
        System.out.println(minHeap);
    }
}

public class MinHeapExample2 {
    public static void main(String[] args) {
        MinHeap2 minHeap = new MinHeap2();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(10);
        minHeap.insert(4);
        minHeap.insert(7);

        minHeap.print();
        System.out.println("peek = " + minHeap.peek());

        System.out.println(minHeap.poll());

        System.out.println("peek = " + minHeap.peek());
        System.out.println(minHeap.poll());

        minHeap.print();
        System.out.println(minHeap.poll());
        minHeap.print();
        System.out.println("peek = " + minHeap.peek());
    }

}

package dsalgo.datastructure.heap;

import java.util.ArrayList;

class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Insert a new value into the heap
    public void insert(int value) {
        heap.add(value); // Add the value at the end
        heapifyUp(heap.size() - 1); // Restore the heap property
    }

    // Get the minimum value (root) without removing it
    public int peek() throws IllegalStateException {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    // Remove and return the minimum value (root)
    public int poll() throws IllegalStateException {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int minValue = heap.get(0);
        int lastValue = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastValue); // Move the last element to the root
            heapifyDown(0); // Restore the heap property
        }
        return minValue;
    }

    // Heapify up to maintain the heap property after insertion
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index) < heap.get(parentIndex)) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    // Heapify down to maintain the heap property after removal
    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;

        // Check if the left child is smaller
        if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(smallest)) {
            smallest = leftChildIndex;
        }

        // Check if the right child is smaller
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(smallest)) {
            smallest = rightChildIndex;
        }

        // If the smallest is not the current index, swap and continue heapifying
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Swap two elements in the heap
    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    // Print the heap
    public void printHeap() {
        System.out.println(heap);
    }
}

public class MinHeapExample {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        // Insert values into the heap
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.insert(7);
        minHeap.insert(3);

        // Print the heap
        System.out.println("Heap elements:");
        minHeap.printHeap();

        // Get the minimum value
        System.out.println("Minimum value (peek): " + minHeap.peek());
        minHeap.printHeap();

        // Remove and print elements in sorted order
        System.out.println("Removing elements:");
        while (true) {
            try {
                System.out.println(minHeap.poll());
            } catch (IllegalStateException e) {
                break;
            }
        }
    }
}

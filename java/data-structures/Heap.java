package data.structures;

import java.util.*;

/**
 * Heap (Priority Queue) Implementation
 *
 * A Heap is a complete binary tree that satisfies the heap property:
 * - Max-Heap: Parent node >= child nodes
 * - Min-Heap: Parent node <= child nodes
 *
 * Key characteristics:
 * - Complete binary tree structure
 * - Efficient insert and extract operations
 * - Time Complexity: O(log n) for insert/delete, O(1) for peek
 * - Space Complexity: O(n) for n elements
 *
 * Operations:
 * - Insert: Add element and maintain heap property
 * - Extract Max/Min: Remove and return root element
 * - Peek: Get root element without removing
 * - Heapify: Maintain heap property after modifications
 */
public class Heap {

    private List<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    /**
     * Returns the parent index of a given index
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Returns the left child index of a given index
     */
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * Returns the right child index of a given index
     */
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    /**
     * Swaps two elements in the heap
     */
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Inserts a new element into the max-heap
     *
     * @param value Element to insert
     */
    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        // Bubble up to maintain heap property
        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    /**
     * Extracts and returns the maximum element (root) from the heap
     *
     * @return Maximum element, or Integer.MIN_VALUE if heap is empty
     */
    public int extractMax() {
        if (heap.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int max = heap.get(0);

        // Move last element to root
        int lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapify(0);
        }

        return max;
    }

    /**
     * Returns the maximum element without removing it
     *
     * @return Maximum element, or Integer.MIN_VALUE if heap is empty
     */
    public int peek() {
        if (heap.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return heap.get(0);
    }

    /**
     * Maintains heap property by heapifying from given index
     */
    private void heapify(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        // Find largest among root, left child, right child
        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    /**
     * Returns the size of the heap
     */
    public int size() {
        return heap.size();
    }

    /**
     * Checks if the heap is empty
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Main method to demonstrate Heap operations
     */
    public static void main(String[] args) {
        Heap maxHeap = new Heap();

        // Insert elements
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(30);
        maxHeap.insert(40);

        System.out.println("Heap elements (not in sorted order): " + maxHeap.heap);

        System.out.println("Extracting maximum elements:");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.extractMax() + " ");
        }
        System.out.println();
    }
}

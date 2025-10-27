/*
 * HeapSort.java
 * 
 * Description:
 * Heap Sort builds a binary heap and repeatedly extracts the maximum element
 * from it to form a sorted array.
 * 
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 * Stable: No
 */

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root (largest) to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // Left child
        int r = 2 * i + 2; // Right child

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}
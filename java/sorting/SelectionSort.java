/*
 * SelectionSort.java
 * 
 * Description:
 * Selection Sort divides the array into a sorted and an unsorted region.
 * It repeatedly selects the smallest element from the unsorted region and
 * moves it to the end of the sorted region.
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * Stable: No
 */

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume the current position has the smallest value
            for (int j = i + 1; j < n; j++) {
                // Find the index of the smallest element in the unsorted part
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            // Swap the found minimum element with the first unsorted element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
public class InsertionSort {
    
    // The algorithm divides the array into a sorted and an unsorted part.
    // It iteratively takes one element from the unsorted part and inserts it into the correct position in the sorted part.
    // Time complexity:
        // Best case: O(n) (already sorted)
        // Worst case: O(n²) (reverse order)
    // Space complexity: O(1) (in-place sorting)
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];       // Element to be inserted in sorted portion
            int j = i - 1;

            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert the key at the correct position
            arr[j + 1] = key;
        }
    }

   
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
  
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6 };
        System.out.println("Original array:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}

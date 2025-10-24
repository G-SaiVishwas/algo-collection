/*
📌 Shell Sort - Java Implementation

Shell Sort is an optimization over Insertion Sort.
It allows the exchange of items that are far apart by using a "gap" which is reduced over time.

Time Complexity:
- Worst Case: O(n^2)
- Average Case: Between O(n) and O(n^2)
- Best Case: O(n log n) depending on gap sequence

Space Complexity: O(1) (in-place sorting)
*/

public class shell_sort {

    // Function to perform Shell Sort
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // Perform a gapped insertion sort
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;

                // Shift earlier gap-sorted elements up until the correct location for arr[i] is found
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // Put temp (the original arr[i]) in its correct location
                arr[j] = temp;
            }
        }
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Driver method to test
    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3};

        System.out.println("Original array:");
        printArray(arr);

        shellSort(arr);

        System.out.println("Sorted array using Shell Sort:");
        printArray(arr);
    }
}

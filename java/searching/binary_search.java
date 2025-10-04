/**
 * Binary Search Algorithm
 * 
 * Description: Binary search is an efficient algorithm for finding an item from a sorted list
 * by repeatedly dividing the search interval in half.
 * 
 * Input: Sorted array and target element
 * Output: Index of target element or -1 if not found
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class binary_search {
    
    /**
     * Performs binary search on a sorted array
     * @param arr The sorted array to search in
     * @param target The element to search for
     * @return The index of target element, or -1 if not found
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // If target is found at mid
            if (arr[mid] == target) {
                return mid;
            }
            
            // If target is smaller, search left half
            if (arr[mid] > target) {
                right = mid - 1;
            }
            // If target is larger, search right half
            else {
                left = mid + 1;
            }
        }
        
        return -1; // Target not found
    }
    
    /**
     * Main method demonstrating binary search usage
     */
    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 45, 56, 67, 78};
        int target = 23;
        
        int result = binarySearch(sortedArray, target);
        
        if (result != -1) {
            System.out.println("Element " + target + " found at index: " + result);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
        
        // Test with element not in array
        int target2 = 25;
        int result2 = binarySearch(sortedArray, target2);
        
        if (result2 != -1) {
            System.out.println("Element " + target2 + " found at index: " + result2);
        } else {
            System.out.println("Element " + target2 + " not found in the array");
        }
    }
}
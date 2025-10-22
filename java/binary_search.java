public class Binary_Search {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60};
        int target = 40;  // number to search for

        int left = 0;
        int right = numbers.length - 1;
        int foundAt = -1; // -1 means not found yet

        while (left <= right) {
            int mid = (left + right) / 2; // middle index

            if (numbers[mid] == target) {
                foundAt = mid; // found!
                break;
            } else if (numbers[mid] < target) {
                left = mid + 1; // search in right half
            } else {
                right = mid - 1; // search in left half
            }
        }

        if (foundAt == -1) {
            System.out.println("Number not found.");
        } else {
            System.out.println("Number found at index " + foundAt);
        }
    }
}

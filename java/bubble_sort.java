/*
 * Algorithm: Bubble Sort
 * Description: Swaps adjacent elements to sort an array; simple O(n^2) example.
 * Usage: Compile with `javac bubble_sort.java` and run `java BubbleSortExample`.
 */
class BubbleSortExample {
    static void bubbleSort(int[] data) {
        boolean swapped = true;
        int n = data.length;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (data[i - 1] > data[i]) {
                    int temp = data[i - 1];
                    data[i - 1] = data[i];
                    data[i] = temp;
                    swapped = true;
                }
            }
            n--; // Last element is in place after each pass.
        }
    }

    public static void main(String[] args) {
        int[] values = {5, 1, 4, 2, 8};
        bubbleSort(values);
        System.out.print("Bubble sorted values: ");
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

public class LinearSearch {
    public static boolean contains(int[] arr, int target) {
        for (int i = 0; i < n; i++) {
            if (a[i] == x)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 15, 16, 23, 42};
        int target = 15;
        System.out.println("Array contains " + target + "? " + contains(arr, target));
    }
}

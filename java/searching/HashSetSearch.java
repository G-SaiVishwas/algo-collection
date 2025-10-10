import java.util.HashSet;

public class HashSetSearch {
    public static boolean contains(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);
        return set.contains(target);
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 15, 16, 23, 42};
        int target = 15;
        System.out.println("Array contains " + target + "? " + contains(arr, target));
    }
}

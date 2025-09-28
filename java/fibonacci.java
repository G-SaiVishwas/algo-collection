/*
 * Algorithm: Fibonacci (Dynamic Programming)
 * Description: Generates Fibonacci sequence up to n using iterative DP; O(n) time.
 * Usage: Compile with `javac fibonacci.java` and run `java FibonacciDp`.
 */
class FibonacciDp {
    static long[] fibonacci(int n) {
        if (n < 2) {
            return new long[]{0, 1};
        }
        long[] sequence = new long[n + 1];
        sequence[0] = 0;
        sequence[1] = 1;
        for (int i = 2; i <= n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        return sequence;
    }

    public static void main(String[] args) {
        int n = 10; // Generate first 10 Fibonacci numbers.
        long[] sequence = fibonacci(n);
        System.out.print("Fibonacci sequence: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(sequence[i] + " ");
        }
        System.out.println();
    }
}

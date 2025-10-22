package dp;

import java.util.*;

/**
 * Longest Common Subsequence (LCS) Algorithm Implementation
 *
 * LCS is a classic dynamic programming problem that finds the longest subsequence
 * present in both given sequences. A subsequence is derived from another sequence
 * by deleting some or no elements without changing the order of the remaining elements.
 *
 * Key characteristics:
 * - Uses dynamic programming with memoization
 * - Time Complexity: O(m*n) where m and n are lengths of input sequences
 * - Space Complexity: O(m*n) for DP table
 *
 * Algorithm Steps:
 * 1. Create a DP table of size (m+1) x (n+1)
 * 2. If characters match, dp[i][j] = dp[i-1][j-1] + 1
 * 3. If characters don't match, dp[i][j] = max(dp[i-1][j], dp[i][j-1])
 * 4. The value at dp[m][n] gives the length of LCS
 */
public class LongestCommonSubsequence {

    /**
     * Computes the length of Longest Common Subsequence using DP
     *
     * @param X First sequence
     * @param Y Second sequence
     * @return Length of LCS
     */
    public static int lcsLength(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        // Create DP table
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * Reconstructs the actual LCS string using the DP table
     *
     * @param X First sequence
     * @param Y Second sequence
     * @param dp DP table computed by lcsLength
     * @return The LCS string
     */
    public static String reconstructLCS(String X, String Y, int[][] dp) {
        int i = X.length();
        int j = Y.length();
        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString();
    }

    /**
     * Computes both length and the actual LCS string
     *
     * @param X First sequence
     * @param Y Second sequence
     * @return Array containing [length, lcs_string]
     */
    public static Object[] getLCS(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        // Fill DP table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        String lcs = reconstructLCS(X, Y, dp);
        return new Object[]{dp[m][n], lcs};
    }

    /**
     * Main method to demonstrate LCS algorithm
     */
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        System.out.println("String X: " + X);
        System.out.println("String Y: " + Y);

        Object[] result = getLCS(X, Y);
        int length = (Integer) result[0];
        String lcs = (String) result[1];

        System.out.println("Length of LCS: " + length);
        System.out.println("LCS: " + lcs);

        // Another example
        String X2 = "ABCBDAB";
        String Y2 = "BDCABA";

        System.out.println("\nString X2: " + X2);
        System.out.println("String Y2: " + Y2);

        Object[] result2 = getLCS(X2, Y2);
        int length2 = (Integer) result2[0];
        String lcs2 = (String) result2[1];

        System.out.println("Length of LCS: " + length2);
        System.out.println("LCS: " + lcs2);
    }
}

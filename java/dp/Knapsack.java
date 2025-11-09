package dp;

import java.util.*;

/**
 * 0/1 Knapsack Problem Implementation
 *
 * The 0/1 Knapsack problem is a classic optimization problem where we have to maximize
 * the value of items we can carry in a knapsack of limited capacity. Each item can be
 * taken (1) or left (0), hence the name 0/1.
 *
 * Key characteristics:
 * - Each item can be used at most once
 * - Uses dynamic programming with memoization
 * - Time Complexity: O(n*W) where n is number of items, W is capacity
 * - Space Complexity: O(n*W) for DP table
 *
 * Algorithm Steps:
 * 1. Create DP table of size (n+1) x (W+1)
 * 2. For each item and capacity:
 *    - If item weight > current capacity: dp[i][w] = dp[i-1][w]
 *    - Else: dp[i][w] = max(dp[i-1][w], dp[i-1][w-weight[i]] + value[i])
 * 3. The value at dp[n][W] gives the maximum value
 */
public class Knapsack {

    static class Item {
        int weight;
        int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    /**
     * Solves 0/1 Knapsack problem using dynamic programming
     *
     * @param items Array of items with weights and values
     * @param W Maximum capacity of knapsack
     * @return Maximum value that can be obtained
     */
    public static int knapsack01(Item[] items, int W) {
        int n = items.length;
        int[][] dp = new int[n + 1][W + 1];

        // Build DP table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (items[i - 1].weight <= w) {
                    dp[i][w] = Math.max(
                        dp[i - 1][w],
                        dp[i - 1][w - items[i - 1].weight] + items[i - 1].value
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    /**
     * Reconstructs the selected items for maximum value
     *
     * @param items Array of items
     * @param dp DP table
     * @return List of selected item indices (0-based)
     */
    public static List<Integer> getSelectedItems(Item[] items, int[][] dp) {
        List<Integer> selected = new ArrayList<>();
        int i = items.length;
        int w = dp[0].length - 1;

        while (i > 0 && w > 0) {
            if (dp[i][w] != dp[i - 1][w]) {
                selected.add(i - 1);
                w -= items[i - 1].weight;
            }
            i--;
        }

        Collections.reverse(selected);
        return selected;
    }

    /**
     * Solves knapsack and returns both maximum value and selected items
     *
     * @param items Array of items
     * @param W Maximum capacity
     * @return Array containing [maxValue, selectedItemsList]
     */
    public static Object[] solveKnapsack(Item[] items, int W) {
        int n = items.length;
        int[][] dp = new int[n + 1][W + 1];

        // Build DP table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (items[i - 1].weight <= w) {
                    dp[i][w] = Math.max(
                        dp[i - 1][w],
                        dp[i - 1][w - items[i - 1].weight] + items[i - 1].value
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        int maxValue = dp[n][W];
        List<Integer> selectedItems = getSelectedItems(items, dp);

        return new Object[]{maxValue, selectedItems};
    }

    /**
     * Main method to demonstrate 0/1 Knapsack algorithm
     */
    public static void main(String[] args) {
        // Example items: {weight, value}
        Item[] items = {
            new Item(2, 12),  // Item 0
            new Item(1, 10),  // Item 1
            new Item(3, 20),  // Item 2
            new Item(2, 15)   // Item 3
        };

        int W = 5; // Knapsack capacity

        System.out.println("Items (weight, value):");
        for (int i = 0; i < items.length; i++) {
            System.out.println("Item " + i + ": (" + items[i].weight + ", " + items[i].value + ")");
        }
        System.out.println("Knapsack capacity: " + W);

        Object[] result = solveKnapsack(items, W);
        int maxValue = (Integer) result[0];
        List<Integer> selectedItems = (List<Integer>) result[1];

        System.out.println("Maximum value: " + maxValue);
        System.out.println("Selected items: " + selectedItems);

        // Another example
        Item[] items2 = {
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        };
        int W2 = 50;

        System.out.println("\nSecond example:");
        System.out.println("Items (weight, value):");
        for (int i = 0; i < items2.length; i++) {
            System.out.println("Item " + i + ": (" + items2[i].weight + ", " + items2[i].value + ")");
        }
        System.out.println("Knapsack capacity: " + W2);

        Object[] result2 = solveKnapsack(items2, W2);
        int maxValue2 = (Integer) result2[0];
        List<Integer> selectedItems2 = (List<Integer>) result2[1];

        System.out.println("Maximum value: " + maxValue2);
        System.out.println("Selected items: " + selectedItems2);
    }
}

package Graphs;

import java.util.*;

/**
 * Prim's Minimum Spanning Tree (MST) Algorithm Implementation
 *
 * Prim's algorithm finds a minimum spanning tree for a weighted undirected graph.
 * It starts with a single vertex and grows the spanning tree by adding the smallest edge
 * that connects a vertex in the tree to a vertex outside the tree.
 *
 * Key characteristics:
 * - Works with weighted undirected graphs
 * - Uses greedy approach
 * - Time Complexity: O(V^2) with adjacency matrix, O((V+E)log V) with priority queue
 * - Space Complexity: O(V) for key array and visited array
 *
 * Algorithm Steps:
 * 1. Initialize key values as infinity, except source as 0
 * 2. Initialize parent array and visited array
 * 3. While there are unvisited vertices:
 *    a. Select vertex with minimum key value
 *    b. Mark it as visited
 *    c. Update key values of adjacent unvisited vertices
 */
public class PrimsMST {

    /**
     * Computes Minimum Spanning Tree using Prim's algorithm
     *
     * @param graph Adjacency matrix representation of the graph
     * @return Array of parent vertices in the MST
     */
    public static int[] primMST(int[][] graph) {
        int V = graph.length;
        int[] parent = new int[V]; // Array to store constructed MST
        int[] key = new int[V];    // Key values used to pick minimum weight edge
        boolean[] visited = new boolean[V]; // To represent set of vertices included in MST

        // Initialize all keys as INFINITE
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        // Always include first 0th vertex in MST
        key[0] = 0; // Make key 0 so that this vertex is picked as first vertex

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum key vertex from the set of vertices not yet included in MST
            int u = minKey(key, visited);

            // Add the picked vertex to the MST Set
            visited[u] = true;

            // Update key value and parent index of the adjacent vertices of the picked vertex
            for (int v = 0; v < V; v++) {
                // graph[u][v] is non zero only for adjacent vertices of u
                // visited[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        return parent;
    }

    /**
     * Utility function to find the vertex with minimum key value
     */
    private static int minKey(int[] key, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < key.length; v++) {
            if (!visited[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    /**
     * Prints the constructed MST
     */
    public static void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    /**
     * Main method to demonstrate Prim's MST algorithm
     */
    public static void main(String[] args) {
        // Example graph represented as adjacency matrix
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        System.out.println("Graph Adjacency Matrix:");
        for (int[] row : graph) {
            System.out.println(Arrays.toString(row));
        }

        int[] parent = primMST(graph);

        System.out.println("\nMinimum Spanning Tree:");
        printMST(parent, graph);
    }
}

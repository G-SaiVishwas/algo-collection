package Graphs;

import java.util.*;

/**
 * Depth-First Search (DFS) Algorithm Implementation
 * 
 * DFS is a graph traversal algorithm that explores vertices in depth-first order,
 * going as deep as possible down each branch before backtracking.
 * 
 * Key characteristics:
 * - Uses recursion (implicit stack) or explicit stack data structure
 * - Explores one path completely before trying another path
 * - Time Complexity: O(V + E) where V is vertices and E is edges
 * - Space Complexity: O(V) for the visited array and recursion stack
 * 
 * Algorithm Steps:
 * 1. Mark the current vertex as visited
 * 2. Process the current vertex
 * 3. For each unvisited adjacent vertex:
 *    a. Recursively call DFS on that vertex
 * 4. Backtrack when no more unvisited adjacent vertices exist
 */
public class DFS {
    
    /**
     * Performs Depth-First Search traversal on a graph using recursion
     * 
     * @param visited Boolean array to track visited vertices
     * @param v       Total number of vertices in the graph
     * @param adj     Adjacency list representation of the graph
     *                adj.get(i) contains all vertices adjacent to vertex i
     * @param source  Current vertex being processed
     * 
     * Approach:
     * - Mark the current vertex as visited
     * - Process/print the current vertex
     * - Recursively visit all unvisited adjacent vertices
     * - The recursion naturally handles the backtracking mechanism
     * - Goes deep into one path before exploring other paths
     */
    public static void dfs(boolean visited[], int v, ArrayList<ArrayList<Integer>> adj, int source) {
        // Mark current vertex as visited
        visited[source] = true;
        System.out.print(source + " --> ");
        
        // Recursively visit all unvisited adjacent vertices
        for (int adjacentVertex : adj.get(source)) {
            if (visited[adjacentVertex] != true) {
                // Recursive call for unvisited adjacent vertex
                dfs(visited, v, adj, adjacentVertex);
            }
        }
    }
    
    /**
     * Wrapper method to initiate DFS traversal from a given source
     * 
     * @param v      Total number of vertices in the graph
     * @param adj    Adjacency list representation of the graph
     * @param source Starting vertex for DFS traversal
     */
    public static void performDFS(int v, ArrayList<ArrayList<Integer>> adj, int source) {
        boolean visited[] = new boolean[v + 1];
        System.out.println("DFS Traversal starting from vertex " + source + ":");
        dfs(visited, v, adj, source);
        System.out.println("END");
    }
    
    /**
     * Main method to demonstrate DFS algorithm
     * Creates a sample graph and performs DFS traversal
     */
    public static void main(String[] args) {
        // Number of vertices in the graph
        int v = 4;
        
        // Create adjacency list representation
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Build the graph by adding edges
        // Graph structure:
        //   0 --- 1
        //   |     |
        //   2 --- 3
        adj.get(0).add(1);  // Edge 0-1
        adj.get(0).add(2);  // Edge 0-2
        adj.get(1).add(3);  // Edge 1-3
        adj.get(1).add(0);  // Edge 1-0 (undirected)
        adj.get(2).add(0);  // Edge 2-0 (undirected)
        adj.get(2).add(3);  // Edge 2-3
        adj.get(3).add(1);  // Edge 3-1 (undirected)
        adj.get(3).add(2);  // Edge 3-2 (undirected)
        
        // Display the adjacency list
        System.out.println("Graph Adjacency List:");
        for (int i = 0; i < v; i++) {
            System.out.println("Vertex " + i + " --> " + adj.get(i));
        }
        System.out.println();
        
        // Perform DFS traversal using the wrapper method
        performDFS(v, adj, 0);
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Comparison with BFS:");
        System.out.println("DFS: Goes deep first (0->1->3->2 or 0->2->3->1)");
        System.out.println("BFS: Goes wide first (0->1,2->3)");
    }
}
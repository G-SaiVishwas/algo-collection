package Graphs;

import java.util.*;

/**
 * Breadth-First Search (BFS) Algorithm Implementation
 * 
 * BFS is a graph traversal algorithm that explores vertices in breadth-first order,
 * visiting all vertices at the current depth level before moving to vertices at the next depth level.
 * 
 * Key characteristics:
 * - Uses a queue data structure (FIFO - First In, First Out)
 * - Guarantees shortest path in unweighted graphs
 * - Time Complexity: O(V + E) where V is vertices and E is edges
 * - Space Complexity: O(V) for the visited array and queue
 * 
 * Algorithm Steps:
 * 1. Mark the source vertex as visited and enqueue it
 * 2. While queue is not empty:
 *    a. Dequeue a vertex from the front of queue
 *    b. Process the current vertex
 *    c. For each unvisited adjacent vertex:
 *       - Mark it as visited
 *       - Enqueue it
 */
public class BFS {
    
    /**
     * Performs Breadth-First Search traversal on a graph
     * 
     * @param v      Total number of vertices in the graph
     * @param adj    Adjacency list representation of the graph
     *               adj.get(i) contains all vertices adjacent to vertex i
     * @param source Starting vertex for BFS traversal
     * 
     * Approach:
     * - Initialize a boolean array to track visited vertices
     * - Use a queue to maintain the order of vertex exploration
     * - Start from the source vertex, mark it visited, and add to queue
     * - Continue until queue is empty:
     *   - Remove vertex from queue front
     *   - Print/process the vertex
     *   - Add all unvisited adjacent vertices to queue and mark them visited
     */
    public static void bfs(int v, ArrayList<ArrayList<Integer>> adj, int source) {
        // Array to keep track of visited vertices
        boolean visited[] = new boolean[v + 1];
        
        // Queue for BFS traversal (FIFO order)
        Queue<Integer> q = new LinkedList<>();
        
        // Start BFS from source vertex
        q.add(source);
        visited[source] = true;
        
        // Process vertices level by level
        while (!q.isEmpty()) {
            // Remove vertex from front of queue
            int vertex = q.poll();
            System.out.print(vertex + " --> ");
            
            // Explore all adjacent vertices
            for (int adjVertex : adj.get(vertex)) {
                // If adjacent vertex is not visited
                if (visited[adjVertex] != true) {
                    visited[adjVertex] = true;  // Mark as visited
                    q.add(adjVertex);           // Add to queue for future processing
                }
            }
        }
        System.out.println("END");
    }
    
    /**
     * Main method to demonstrate BFS algorithm
     * Creates a sample graph and performs BFS traversal
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
        
        System.out.println("\nBFS Traversal starting from vertex 3:");
        bfs(v, adj, 3);
    }
}
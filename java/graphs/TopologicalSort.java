package Graphs;

import java.util.*;

/**
 * Topological Sort Algorithm Implementation
 *
 * Topological sorting is a linear ordering of vertices in a Directed Acyclic Graph (DAG)
 * such that for every directed edge u -> v, vertex u comes before vertex v in the ordering.
 *
 * Key characteristics:
 * - Only works on Directed Acyclic Graphs (DAGs)
 * - Can be used to detect cycles in directed graphs
 * - Time Complexity: O(V + E) where V is vertices and E is edges
 * - Space Complexity: O(V) for visited array and stack
 *
 * Algorithm Steps (using DFS):
 * 1. Create a stack to store the topological order
 * 2. For each unvisited vertex, perform DFS
 * 3. In DFS, mark vertex as visiting, visit all unvisited neighbors, then mark as visited and push to stack
 * 4. After all vertices are visited, pop from stack to get topological order
 */
public class TopologicalSort {

    /**
     * Performs topological sort using DFS
     *
     * @param V      Number of vertices
     * @param adj    Adjacency list representation of the graph
     * @return List containing vertices in topological order, or null if cycle detected
     */
    public static List<Integer> topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V]; // To detect cycles
        Stack<Integer> stack = new Stack<>();

        // Call DFS for all vertices
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack, stack)) {
                    return null; // Cycle detected
                }
            }
        }

        // Create result list from stack
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    /**
     * DFS helper function for topological sort
     */
    private static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
                              boolean[] recStack, Stack<Integer> stack) {
        visited[v] = true;
        recStack[v] = true;

        // Recur for all adjacent vertices
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, recStack, stack)) {
                    return true; // Cycle detected
                }
            } else if (recStack[neighbor]) {
                return true; // Cycle detected
            }
        }

        recStack[v] = false;
        stack.push(v);
        return false;
    }

    /**
     * Main method to demonstrate Topological Sort algorithm
     */
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph (DAG)
        // Course prerequisites example:
        // 5 -> 2 -> 0 -> 1
        // 5 -> 0
        // 4 -> 0
        // 4 -> 1
        // 2 -> 3
        // 3 -> 1
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(0).add(1);

        System.out.println("Graph Adjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " --> " + adj.get(i));
        }

        List<Integer> result = topologicalSort(V, adj);

        if (result != null) {
            System.out.println("\nTopological Sort Order:");
            for (int vertex : result) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        } else {
            System.out.println("\nGraph contains a cycle! Topological sort not possible.");
        }
    }
}

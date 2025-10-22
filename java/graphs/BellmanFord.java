package Graphs;

import java.util.*;

/**
 * Bellman-Ford Algorithm Implementation
 *
 * Bellman-Ford is a single-source shortest path algorithm that can handle graphs with negative edge weights.
 * Unlike Dijkstra's algorithm, it can detect negative weight cycles.
 *
 * Key characteristics:
 * - Can handle negative edge weights
 * - Can detect negative weight cycles
 * - Time Complexity: O(V * E) where V is vertices and E is edges
 * - Space Complexity: O(V) for distance array
 *
 * Algorithm Steps:
 * 1. Initialize distance array with infinity, except source as 0
 * 2. Relax all edges |V|-1 times
 * 3. Check for negative weight cycles by relaxing edges one more time
 */
public class BellmanFord {

    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    /**
     * Computes shortest paths from source to all vertices using Bellman-Ford algorithm
     *
     * @param V      Number of vertices
     * @param edges  List of edges in the graph
     * @param source Source vertex
     * @return Array of shortest distances from source, or null if negative cycle exists
     */
    public static int[] bellmanFord(int V, List<Edge> edges, int source) {
        // Initialize distances
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Relax all edges V-1 times
        for (int i = 1; i < V; i++) {
            for (Edge edge : edges) {
                if (dist[edge.src] != Integer.MAX_VALUE &&
                    dist[edge.src] + edge.weight < dist[edge.dest]) {
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                }
            }
        }

        // Check for negative weight cycles
        for (Edge edge : edges) {
            if (dist[edge.src] != Integer.MAX_VALUE &&
                dist[edge.src] + edge.weight < dist[edge.dest]) {
                System.out.println("Graph contains negative weight cycle");
                return null; // Negative cycle detected
            }
        }

        return dist;
    }

    /**
     * Main method to demonstrate Bellman-Ford algorithm
     */
    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = Arrays.asList(
            new Edge(0, 1, -1),
            new Edge(0, 2, 4),
            new Edge(1, 2, 3),
            new Edge(1, 3, 2),
            new Edge(1, 4, 2),
            new Edge(3, 2, 5),
            new Edge(3, 1, 1),
            new Edge(4, 3, -3)
        );

        System.out.println("Graph Edges:");
        for (Edge edge : edges) {
            System.out.println(edge.src + " -> " + edge.dest + " (weight: " + edge.weight + ")");
        }

        int source = 0;
        int[] distances = bellmanFord(V, edges, source);

        if (distances != null) {
            System.out.println("\nShortest distances from source " + source + ":");
            for (int i = 0; i < V; i++) {
                System.out.println("Vertex " + i + ": " + (distances[i] == Integer.MAX_VALUE ? "INF" : distances[i]));
            }
        }
    }
}

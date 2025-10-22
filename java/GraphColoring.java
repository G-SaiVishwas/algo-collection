/**
 * Java Program to Solve Graph Coloring Problem using Backtracking
 * Hacktoberfest 2025 
 * 
 * Problem:
 * - Assign colors to the vertices of a graph such that no two adjacent vertices have the same color.
 * - Use m colors (given) to color the graph.
 */

import java.util.Scanner;

public class GraphColoring {

    private int vertices;        // Number of vertices in the graph
    private int[][] graph;       // Adjacency matrix representation of the graph
    private int[] colors;        // Colors assigned to vertices
    private int m;               // Number of colors available

    // Constructor to initialize graph
    public GraphColoring(int vertices, int m) {
        this.vertices = vertices;
        this.m = m;
        graph = new int[vertices][vertices];
        colors = new int[vertices];
    }

    // Add an edge between vertex u and vertex v
    public void addEdge(int u, int v) {
        graph[u][v] = 1;
        graph[v][u] = 1; // Since the graph is undirected
    }

    // Check if it is safe to color vertex v with color c
    private boolean isSafe(int v, int c) {
        for (int i = 0; i < vertices; i++) {
            if (graph[v][i] == 1 && colors[i] == c) {
                return false; // Adjacent vertex has same color
            }
        }
        return true;
    }

    // Recursive function to solve coloring problem
    private boolean graphColoringUtil(int v) {
        if (v == vertices) {
            return true; // All vertices are colored
        }

        // Try all colors for vertex v
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, c)) {
                colors[v] = c; // Assign color
                if (graphColoringUtil(v + 1)) {
                    return true;
                }
                colors[v] = 0; // Backtrack
            }
        }
        return false; // No color can be assigned
    }

    // Solve the graph coloring problem
    public boolean solve() {
        if (!graphColoringUtil(0)) {
            System.out.println("No solution exists with " + m + " colors.");
            return false;
        }
        printSolution();
        return true;
    }

    // Print the color assignment
    private void printSolution() {
        System.out.println("Solution exists! Vertex colors:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + " --->  Color " + colors[i]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of vertices in the graph:");
        int n = scanner.nextInt();

        System.out.println("Enter number of colors available:");
        int m = scanner.nextInt();

        GraphColoring gc = new GraphColoring(n, m);

        System.out.println("Enter number of edges in the graph:");
        int edges = scanner.nextInt();

        System.out.println("Enter edges (u v) between vertices (0 to " + (n - 1) + "):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            gc.addEdge(u, v);
        }

        // Solve the graph coloring problem
        gc.solve();
        scanner.close();
    }
}

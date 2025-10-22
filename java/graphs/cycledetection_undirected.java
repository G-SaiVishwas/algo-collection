import java.util.*;

public class DetectCycleUndirected {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    // Constructor
    DetectCycleUndirected(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    // Add an undirected edge
    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    // DFS function to detect cycle
    boolean dfs(int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (int neighbor : adj[node]) {
            // If neighbor is not visited, do DFS on it
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, node))
                    return true;
            }
            // If neighbor is visited and not parent, then a cycle exists
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    // Function to check if graph contains a cycle
    boolean isCyclic() {
        boolean[] visited = new boolean[V];

        // Check for each disconnected component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, -1))
                    return true;
            }
        }
        return false;
    }

    // Main method
    public static void main(String[] args) {
        DetectCycleUndirected graph = new DetectCycleUndirected(5);

        // Creating a graph
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        // Uncomment below to introduce a cycle
        graph.addEdge(4, 1);

        if (graph.isCyclic())
            System.out.println("Graph contains a cycle ⚠️");
        else
            System.out.println("Graph does NOT contain a cycle ✅");
    }
}

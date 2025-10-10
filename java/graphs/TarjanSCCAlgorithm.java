import java.util.*;

/**
 * Tarjan's Algorithm for finding Strongly Connected Components (SCCs)
 * in a Directed Graph.
 *
 * <p>Each SCC is a maximal subset of nodes where every node
 * is reachable from every other node in the subset.</p>
 *
 * <p>Algorithm complexity: O(V + E)</p>
 *
 * <p>Usage Example:
 * <pre>
 *     DirectedGraph graph = new DirectedGraph(5);
 *     graph.addEdge(0, 1);
 *     graph.addEdge(1, 2);
 *     graph.addEdge(2, 0);
 *     graph.addEdge(1, 3);
 *     graph.addEdge(3, 4);
 *
 *     TarjanSCCAlgorithm tarjan = new TarjanSCCAlgorithm(graph);
 *     List<List<Integer>> sccList = tarjan.findStronglyConnectedComponents();
 *     System.out.println(sccList);
 * </pre>
 * </p>
 *
 */
public class TarjanSCCAlgorithm {

    /** Graph representation */
    private final DirectedGraph graph;

    /** Discovery index of each vertex */
    private final int[] discoveryIndex;

    /** Low link value of each vertex */
    private final int[] lowLinkValue;

    /** Track if a vertex is currently on the stack */
    private final boolean[] onStack;

    /** Global index counter */
    private int indexCounter = 0;

    /** Stack to maintain active nodes */
    private final Deque<Integer> stack = new ArrayDeque<>();

    /** List to hold all strongly connected components */
    private final List<List<Integer>> stronglyConnectedComponents = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param graph directed graph on which Tarjan's algorithm will run
     */
    public TarjanSCCAlgorithm(DirectedGraph graph) {
        this.graph = graph;
        int n = graph.getVertexCount();
        this.discoveryIndex = new int[n];
        this.lowLinkValue = new int[n];
        this.onStack = new boolean[n];
        Arrays.fill(discoveryIndex, -1); // mark all vertices as unvisited
    }

    /**
     * Executes Tarjan's algorithm.
     *
     * @return list of SCCs, each SCC is a list of vertices
     */
    public List<List<Integer>> findStronglyConnectedComponents() {
        for (int vertex = 0; vertex < graph.getVertexCount(); vertex++) {
            if (discoveryIndex[vertex] == -1) {
                performDepthFirstSearch(vertex);
            }
        }
        return stronglyConnectedComponents;
    }

    /**
     * Recursive DFS helper for Tarjan's algorithm.
     */
    private void performDepthFirstSearch(int vertex) {
        discoveryIndex[vertex] = indexCounter;
        lowLinkValue[vertex] = indexCounter;
        indexCounter++;

        stack.push(vertex);
        onStack[vertex] = true;

        for (int neighbor : graph.getAdjacencyList(vertex)) {
            if (discoveryIndex[neighbor] == -1) {
                performDepthFirstSearch(neighbor);
                lowLinkValue[vertex] = Math.min(lowLinkValue[vertex], lowLinkValue[neighbor]);
            } else if (onStack[neighbor]) {
                lowLinkValue[vertex] = Math.min(lowLinkValue[vertex], discoveryIndex[neighbor]);
            }
        }

        // Found root of SCC
        if (lowLinkValue[vertex] == discoveryIndex[vertex]) {
            List<Integer> component = new ArrayList<>();
            int node;
            do {
                node = stack.pop();
                onStack[node] = false;
                component.add(node);
            } while (node != vertex);

            stronglyConnectedComponents.add(component);
        }
    }

    /**
     * Simple directed graph class with adjacency list representation.
     */
    public static class DirectedGraph {
        private final int vertexCount;
        private final List<List<Integer>> adjacencyList;

        public DirectedGraph(int vertexCount) {
            this.vertexCount = vertexCount;
            this.adjacencyList = new ArrayList<>(vertexCount);
            for (int i = 0; i < vertexCount; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int from, int to) {
            if (from < 0 || from >= vertexCount || to < 0 || to >= vertexCount) {
                throw new IllegalArgumentException("Invalid vertex index.");
            }
            adjacencyList.get(from).add(to);
        }

        public int getVertexCount() {
            return vertexCount;
        }

        public List<Integer> getAdjacencyList(int vertex) {
            return adjacencyList.get(vertex);
        }
    }

    /**
     * Example usage of Tarjan's Algorithm.
     */
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(8);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(6, 5);
        graph.addEdge(6, 7);
        graph.addEdge(7, 6);

        TarjanSCCAlgorithm tarjan = new TarjanSCCAlgorithm(graph);
        List<List<Integer>> sccList = tarjan.findStronglyConnectedComponents();

        System.out.println("Strongly Connected Components:");
        for (List<Integer> scc : sccList) {
            Collections.sort(scc); // For consistent output
            System.out.println(scc);
        }
    }
}

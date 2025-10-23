def dfs(visited, adj, source):
    visited[source] = True
    print(f"{source} --> ", end="")

    for adjacent_vertex in adj[source]:
        if not visited[adjacent_vertex]:
            dfs(visited, adj, adjacent_vertex)

def perform_dfs(v, adj, source):
    visited = [False] * (v + 1)
    print(f"DFS Traversal starting from vertex {source}:")
    dfs(visited, adj, source)
    print("END")

if __name__ == "__main__":
    v = 4

    # Create adjacency list
    adj = [[] for _ in range(v)]
    adj[0].extend([1, 2])  # Edges 0-1, 0-2
    adj[1].extend([3, 0])  # Edges 1-3, 1-0
    adj[2].extend([0, 3])  # Edges 2-0, 2-3
    adj[3].extend([1, 2])  # Edges 3-1, 3-2

    # Display adjacency list
    print("Graph Adjacency List:")
    for i in range(v):
        print(f"Vertex {i} --> {adj[i]}")
    print()

    # Perform DFS
    perform_dfs(v, adj, 0)

    print("\n" + "=" * 50)
    print("Comparison with BFS:")
    print("DFS: Goes deep first (0->1->3->2 or 0->2->3->1)")
    print("BFS: Goes wide first (0->1,2->3)")

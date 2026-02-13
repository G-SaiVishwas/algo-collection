from collections import deque

def bfs(v, adj, source):
    # Initialize visited array
    visited = [False] * (v + 1)

    # Queue for BFS
    q = deque()
    q.append(source)
    visited[source] = True

    # Process vertices level by level
    while q:
        vertex = q.popleft()
        print(f"{vertex} --> ", end="")

        for adj_vertex in adj[vertex]:
            if not visited[adj_vertex]:
                visited[adj_vertex] = True
                q.append(adj_vertex)
    print("END")

if __name__ == "__main__":
    # Number of vertices
    v = 4

    # Create adjacency list
    adj = [[] for _ in range(v)]

    # Build the graph
    adj[0].extend([1, 2])  # Edges 0-1, 0-2
    adj[1].extend([3, 0])  # Edges 1-3, 1-0
    adj[2].extend([0, 3])  # Edges 2-0, 2-3
    adj[3].extend([1, 2])  # Edges 3-1, 3-2

    # Display adjacency list
    print("Graph Adjacency List:")
    for i in range(v):
        print(f"Vertex {i} --> {adj[i]}")

    print("\nBFS Traversal starting from vertex 3:")
    bfs(v, adj, 3)

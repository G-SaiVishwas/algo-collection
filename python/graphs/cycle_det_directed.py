def is_cyclic(V, edges):
    # Build adjacency list
    adj = [[] for _ in range(V)]
    for u, v in edges:
        adj[u].append(v)

    visited = [False] * V
    path = [False] * V

    for i in range(V):
        if not visited[i] and is_cyc(visited, adj, i, path):
            return True
    return False

def is_cyc(visited, adj, node, path):
    visited[node] = True
    path[node] = True

    for nei in adj[node]:
        if not visited[nei]:
            if is_cyc(visited, adj, nei, path):
                return True
        elif path[nei]:
            return True

    path[node] = False
    return False

# Example usage
if __name__ == "__main__":
    V = 4
    edges = [
        [0, 1],
        [1, 2],
        [2, 3],
        [3, 1]  # This creates a cycle
    ]
    print("Graph has cycle:", is_cyclic(V, edges))

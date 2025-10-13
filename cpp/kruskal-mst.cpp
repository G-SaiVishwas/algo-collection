/*
  Algorithm: Kruskal's Algorithm for Minimum Spanning Tree (MST)
  Problem: Given a connected, undirected and weighted graph, find its minimum spanning tree.

  Input: List of weighted edges (u, v, weight); number of vertices
  Output: Edges in the MST and total minimum cost

  Time Complexity: O(E log V) with union-find
  Space Complexity: O(V)
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Edge {
    int u, v, weight;
    Edge(int u_, int v_, int w_) : u(u_), v(v_), weight(w_) {}
};

bool cmp(const Edge& a, const Edge& b) {
    return a.weight < b.weight;
}

class UnionFind {
    vector<int> parent;
public:
    UnionFind(int n) : parent(n) {
        for(int i=0; i<n; i++) parent[i]=i;
    }
    int find(int x) {
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    bool unite(int x, int y) {
        int px=find(x), py=find(y);
        if(px==py) return false;
        parent[py]=px;
        return true;
    }
};

int kruskalMST(int V, vector<Edge>& edges) {
    sort(edges.begin(), edges.end(), cmp);
    UnionFind uf(V);
    int mst_weight = 0;
    cout << "Edges in MST:\n";
    for(const auto& edge : edges) {
        if(uf.unite(edge.u, edge.v)) {
            cout << edge.u << " - " << edge.v << " (weight: " << edge.weight << ")\n";
            mst_weight += edge.weight;
        }
    }
    return mst_weight;
}

// Minimal usage example
int main() {
    int V = 4;
    vector<Edge> edges = {
        Edge(0, 1, 10),
        Edge(0, 2, 6),
        Edge(0, 3, 5),
        Edge(1, 3, 15),
        Edge(2, 3, 4)
    };
    int total_weight = kruskalMST(V, edges);
    cout << "Total MST cost: " << total_weight << endl;
    return 0;
}

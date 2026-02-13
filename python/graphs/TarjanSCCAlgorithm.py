class DirectedGraph:
    def __init__(self, vertex_count):
        self.vertex_count = vertex_count
        self.adjacency_list = [[] for _ in range(vertex_count)]

    def add_edge(self, from_vertex, to_vertex):
        if from_vertex < 0 or from_vertex >= self.vertex_count or to_vertex < 0 or to_vertex >= self.vertex_count:
            raise ValueError("Invalid vertex index.")
        self.adjacency_list[from_vertex].append(to_vertex)

    def get_vertex_count(self):
        return self.vertex_count

    def get_adjacency_list(self, vertex):
        return self.adjacency_list[vertex]


class TarjanSCCAlgorithm:
    def __init__(self, graph):
        self.graph = graph
        n = graph.get_vertex_count()
        self.discovery_index = [-1] * n
        self.low_link_value = [0] * n
        self.on_stack = [False] * n
        self.index_counter = 0
        self.stack = []
        self.strongly_connected_components = []

    def find_strongly_connected_components(self):
        for vertex in range(self.graph.get_vertex_count()):
            if self.discovery_index[vertex] == -1:
                self._dfs(vertex)
        return self.strongly_connected_components

    def _dfs(self, vertex):
        self.discovery_index[vertex] = self.index_counter
        self.low_link_value[vertex] = self.index_counter
        self.index_counter += 1

        self.stack.append(vertex)
        self.on_stack[vertex] = True

        for neighbor in self.graph.get_adjacency_list(vertex):
            if self.discovery_index[neighbor] == -1:
                self._dfs(neighbor)
                self.low_link_value[vertex] = min(self.low_link_value[vertex], self.low_link_value[neighbor])
            elif self.on_stack[neighbor]:
                self.low_link_value[vertex] = min(self.low_link_value[vertex], self.discovery_index[neighbor])

        if self.low_link_value[vertex] == self.discovery_index[vertex]:
            component = []
            while True:
                node = self.stack.pop()
                self.on_stack[node] = False
                component.append(node)
                if node == vertex:
                    break
            self.strongly_connected_components.append(component)


if __name__ == "__main__":
    graph = DirectedGraph(8)
    graph.add_edge(0, 1)
    graph.add_edge(1, 2)
    graph.add_edge(2, 0)
    graph.add_edge(2, 3)
    graph.add_edge(3, 4)
    graph.add_edge(4, 5)
    graph.add_edge(5, 3)
    graph.add_edge(6, 5)
    graph.add_edge(6, 7)
    graph.add_edge(7, 6)

    tarjan = TarjanSCCAlgorithm(graph)
    scc_list = tarjan.find_strongly_connected_components()

    print("Strongly Connected Components:")
    for scc in scc_list:
        print(sorted(scc))  # Sorted for consistent output

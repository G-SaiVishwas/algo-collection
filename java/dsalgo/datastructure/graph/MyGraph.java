package dsalgo.datastructure.graph;

import java.util.ArrayList;

public class MyGraph {

    int vertex;
    ArrayList<Edge>[] graph;
    public MyGraph(int v){
        this.vertex = v;
        graph = new ArrayList[vertex];
    }

    static class Edge{
        int src;
        int desc;

        public Edge(int s,int d){
            this.src = s;
            this.desc = d;
        }
    }

    public void createGraph(){
//        System.out.println(dsalgo.datastructure.graph.length);
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));
    }

    public int[] neighbour(int src){
        int []neighbour = new int[graph[src].size()];
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
//            System.out.print(e.desc+ " ");
            neighbour[i] = e.desc;
        }

        return neighbour;
    }
}

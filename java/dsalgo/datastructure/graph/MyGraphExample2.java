package dsalgo.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Satish Yadav
 * @purpose :
 */
class MyGraph2 {
    private int V;
    private ArrayList<ArrayList<Integer>> adj;

    public MyGraph2(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i <V; i++) {
            this.adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public ArrayList<Integer> bfs(int index) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        q.add(index);
        visited[index] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            result.add(cur);

            for(int i = 0; i < adj.get(cur).size(); i++){
                if(!visited[adj.get(cur).get(i)]){
                    q.add(adj.get(cur).get(i));
                    visited[adj.get(cur).get(i)] = true;
                }
            }
        }

        return result;
    }

    public ArrayList<Integer> dfs(int index) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        dfsUtil(index,visited,result);
        return result;
    }

    private void dfsUtil(int index , boolean[] visited, ArrayList<Integer> result) {
        visited[index] = true;
        result.add(index);

        for(int i = 0; i < adj.get(index).size(); i++){
            if(!visited[adj.get(index).get(i)]){
                dfsUtil(adj.get(index).get(i),visited,result);
            }
        }
    }
}

public class MyGraphExample2 {
    public static void main(String[] args) {
        MyGraph2 myGraph2 = new MyGraph2(6);
//        myGraph.addEdge(0, 1);
//        myGraph.addEdge(0, 2);
        myGraph2.addEdge(1, 2);
        myGraph2.addEdge(2, 1);
        myGraph2.addEdge(1, 3);
        myGraph2.addEdge(3, 1);
        myGraph2.addEdge(2, 4);
        myGraph2.addEdge(4, 2);
        myGraph2.addEdge(3, 4);
        myGraph2.addEdge(4, 3);
        myGraph2.addEdge(2, 5);
        myGraph2.addEdge(5, 2);
        myGraph2.addEdge(4, 5);
        myGraph2.addEdge(5, 4);

        System.out.println(myGraph2.bfs(4));
        System.out.println(myGraph2.dfs(4));
    }
}


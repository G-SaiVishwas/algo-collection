import java.util.ArrayList;

public class cycle_det_directed {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
        }
        boolean vis[]= new boolean[V];
        boolean path[]= new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i] && isCyc(vis,adj,i,path)){
                return true;
            }
        }
        return false;
    }
    boolean isCyc(boolean vis[],ArrayList<ArrayList<Integer>> adj,int node,boolean path[]){
        vis[node]=true;
        path[node]= true;
        for(int nei:adj.get(node)){
            if(!vis[nei]){
                if(isCyc(vis,adj,nei,path)) return true;
            }
            else if(path[nei]){
                return true;
            }
        }
        path[node]=false;
        return false;
    }
}

import java.util.*;

public class DFSGraph{
  static void dfs(int node, List<List<Integer>>adj, boolean[] visited){
    visited[node] = true;
    System.out.print(node + " ");
    
    for(int nei : adj.get(node)){
      if(!visited[nei]){
        dfs(nei, adj, visited);
      }
    }
  }
  
  public static void main(String[]args){
    int V = 5;
    List<List<Integer>> adj = new ArrayList<>();
    for(int i = 0 ; i < V  ; i++){
      adj.add(new ArrayList<>());
    }
    
    adj.get(0).add(1);
    adj.get(0).add(2);
    adj.get(1).add(3);
    adj.get(2).add(4);
    boolean[] visited = new boolean[V];
    dfs(0, adj, visited);
  }
}

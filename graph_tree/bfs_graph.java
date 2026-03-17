import java.util.*;

public class BFSGraph{
  static void bfs(int start, List<List<Integer>>adj, boolean[] visited){
    Queue<Integer>q = new LinkedList<>();
    q.add(start);
    visited[start] = true;
    
    while(!q.isEmpty()){
      int node = q.poll();
      System.out.print(node + " ");
      for(int nei : adj.get(node)){
        if(!visited[nei]){
          visited[nei] = true;
          q.add(nei);
        }
      }
    }
  }
  public static void main(String[] args) {
        int V = 5;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // graph edges
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(4);

        boolean[] visited = new boolean[V];

        bfs(0, adj, visited);
    }
}

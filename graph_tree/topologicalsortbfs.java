import java.util.*;
public class TopSortBFS{
  static void topoSort(int V, List<List<Integer>>adj){
    int[] indegree = new int[V];
    for(int i = 0 ; i < V ; i++){
      for(int nei : adj.get(i)){
        indegree[nei]++;
      }
    }
    
    Queue<Integer>q = new LinkedList<>();
    for(int i = 0 ; i < V ; i++){
      if(indegree[i] == 0){
        q.add(i);
      }
    }
    while(!q.isEmpty()){
      int node = q.poll();
      System.out.print(node + " ");
      
      for(int nei : adj.get(node)){
        indegree[nei]--;
        if(indegree[nei] == 0){
          q.add(nei);
        }
      }
    }
  }
  public static void main(String[] args) {
        int V = 6;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Directed edges
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(5);
        adj.get(2).add(3);
        adj.get(2).add(5);
        adj.get(3).add(4);
        adj.get(5).add(4);

        topoSort(V, adj);
    }
}

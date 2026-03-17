import java.util.*;

class Pair{
  int node, dist;
  Pair(int n, int d){
    node = n;
    dist = d;
  }
}

public class Dijkstra{
  static void dijkstra(int V, List<List<Pair>>adj, int src){
    int[]dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    
    PriorityQueue<Pair>pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
    dist[src] = 0;
    pq.add(new Pair(src, 0));
    
    while(!pq.isEmpty()){
      Pair p = pq.poll();
      int u = p.node;
      
      for(Pair nei : adj.get(u)){
        int v = nei.node;
        int weight = nei.dist;
        if(dist[u] + weight < dist[v]){
          dist[v] = dist[u] + weight;
          pq.add(new Pair(v, dist[v]));
        }
      }
    }
    for(int d : dist){
      System.out.print(d + " ");
    }
  }
  
  public static void main(String[] args) {
        int V = 5;

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // edges: u -> v (weight)
        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(2, 4));
        adj.get(1).add(new Pair(2, 1));
        adj.get(1).add(new Pair(3, 7));
        adj.get(2).add(new Pair(4, 3));
        adj.get(3).add(new Pair(4, 1));

        dijkstra(V, adj, 0);
    }
}

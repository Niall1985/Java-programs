import java.util.*;

class Edge{
  int u, v, w;
  Edge(int u, int v, int w){
    this.u = u;
    this.v = v;
    this.w = w;
  }
}

public class BellmanFord{
  static void bellmanford(int V, List<Edge>edges, int src){
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    
    dist[src] = 0;
    for(int i = 0 ; i < V-1 ; i++){
      for(Edge e : edges){
        if(dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]){
          dist[e.v] = dist[e.u] + e.w;
        }
      }
    }
    
    for(Edge e : edges){
      if(dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]){
        System.out.println("Negative Cycle detected");
        return;
      }
    }
    
    for(int d : dist){
      System.out.print(d + " ");
    }
  }
  public static void main(String[] args){
    int V = 5;
    List<Edge>edges = new ArrayList<>();
    edges.add(new Edge(0, 1, 2));
    edges.add(new Edge(0, 2, 4));
    edges.add(new Edge(1, 2, 1));
    edges.add(new Edge(1, 3, 7));
    edges.add(new Edge(2, 4, 3));
    edges.add(new Edge(3, 4, 1));
    
    bellmanford(V, edges, 0);
  }
}

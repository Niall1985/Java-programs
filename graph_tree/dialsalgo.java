import java.util.*;

class Pair {
    int node, weight;

    Pair(int n, int w) {
        node = n;
        weight = w;
    }
}

public class DialsAlgorithm {

    static void dials(int V, List<List<Pair>> adj, int src, int W) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // buckets
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i <= W * V; i++)
            bucket.add(new ArrayList<>());

        dist[src] = 0;
        bucket.get(0).add(src);

        int idx = 0;

        while (idx <= W * V) {

            // find next non-empty bucket
            while (idx <= W * V && bucket.get(idx).isEmpty())
                idx++;

            if (idx > W * V) break;

            int u = bucket.get(idx).remove(0);

            // relax edges
            for (Pair p : adj.get(u)) {
                int v = p.node;
                int weight = p.weight;

                if (dist[u] + weight < dist[v]) {
                    if (dist[v] != Integer.MAX_VALUE)
                        bucket.get(dist[v]).remove((Integer) v);

                    dist[v] = dist[u] + weight;
                    bucket.get(dist[v]).add(v);
                }
            }
        }

        // print result
        for (int d : dist)
            System.out.print(d + " ");
    }

    public static void main(String[] args) {
        int V = 5;
        int W = 10; // max edge weight

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

        dials(V, adj, 0, W);
    }
}

package graph.shortestpath;

import java.util.*;

public class DijkstraWithSet {

    public static void main(String[] args) {
        int n = 5;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(2, 4));
        adj.get(1).add(new Pair(2, 1));
        adj.get(1).add(new Pair(3, 7));
        adj.get(2).add(new Pair(4, 3));
        adj.get(3).add(new Pair(4, 1));

        DijkstraWithSet obj = new DijkstraWithSet();
        int[] dist = obj.fun(adj, 0);

        for (int i = 0; i < dist.length; i++) {
            System.out.println("Distance from 0 to " + i + " is " + dist[i]);
        }
    }

    public int[] fun(List<List<Pair>> adj, int src) {
        int n = adj.size();
        int[] dis = new int[n];
        Arrays.fill(dis, (int) 1e9);
        dis[src] = 0;

        // TreeSet sorts pairs by weight, then by node index to avoid equality conflict
        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if (a.w == b.w) return Integer.compare(a.a, b.a);
            return Integer.compare(a.w, b.w);
        });

        set.add(new Pair(src, 0));

        while (!set.isEmpty()) {
            Pair top = set.pollFirst(); // smallest distance node
            int node = top.a;
            int distTillNow = top.w;

            for (Pair edge : adj.get(node)) {
                int adjNode = edge.a;
                int edgeWeight = edge.w;

                if (distTillNow + edgeWeight < dis[adjNode]) {
                    // Remove old pair if present
                    set.remove(new Pair(adjNode, dis[adjNode]));
                    dis[adjNode] = distTillNow + edgeWeight;
                    set.add(new Pair(adjNode, dis[adjNode]));
                }
            }
        }

        return dis;
    }

    static class Pair {
        int a;
        int w;

        public Pair(int a, int w) {
            this.a = a;
            this.w = w;
        }

        // Needed so TreeSet.remove() works correctly
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return a == pair.a && w == pair.w;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, w);
        }
    }
}

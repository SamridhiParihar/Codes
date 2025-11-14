package graph.minimum_spanning_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {
    public static void main(String[] args) {
        int V = 5; // number of vertices

        // adjacency list: List<List<List<Integer>>> adj
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // helper function to add edges
        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 3, 6);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 1, 3, 8);
        addEdge(adj, 1, 4, 5);
        addEdge(adj, 2, 4, 7);
        addEdge(adj, 3, 4, 9);

        int mstWeight = prims(V, adj);
        System.out.println("Weight of MST: " + mstWeight);
    }

    // helper to add undirected edge
    public static void addEdge(List<List<List<Integer>>> adj, int u, int v, int w) {
        List<Integer> edge1 = new ArrayList<>();
        edge1.add(v);
        edge1.add(w);
        adj.get(u).add(edge1);

        List<Integer> edge2 = new ArrayList<>();
        edge2.add(u);
        edge2.add(w);
        adj.get(v).add(edge2);
    }

    public static int prims(int V, List<List<List<Integer>>> adj){
        List<Pair> edges = new ArrayList<>();
        int[] vis = new int[V];
        PriorityQueue<Tri> q = new PriorityQueue<>(
                (a,b)->(a.weight-b.weight)
        );
        q.add(new Tri(0,0,-1));
        int sum =0;
        while (!q.isEmpty()){
            Tri tri = q.poll();
            if(vis[tri.node]==1) continue;
            int node = tri.node;
            int weight = tri.weight;
            int parent = tri.parent;
            vis[node] = 1;
            if(parent!=-1) edges.add(new Pair(parent,node));
            sum+=weight;
            for(List<Integer> list : adj.get(node)){
                int currNode = list.get(0);
                int currWeight = list.get(1);
                if(vis[currNode]!=1){
                    q.add(new Tri(currWeight,currNode,node));
                }
            }
        }
        System.out.println(edges);
        return sum;
    }
    static class Tri{
        int weight;
        int node;
        int parent;
        public Tri(int weight, int node , int parent){
            this.weight = weight;
            this.node = node;
            this.parent = parent;
        }
    }
    static class Pair{
        int a ;
        int b;
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "(" + a + ", " + b + ")";
        }

    }
}

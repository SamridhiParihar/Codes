package graph.minimum_spanning_tree;

import contest.c_1047_div3.E;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static void main(String[] args) {

        int V = 5; // number of vertices

        // Create adjacency list in format: adj.get(u) = [[v, wt], [v2, wt2], ...]
        List<List<List<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph example:
        // 0 --1-- 1
        // 0 --2-- 2
        // 1 --3-- 2
        // 1 --4-- 3
        // 2 --5-- 3
        // 3 --7-- 4

        addEdge(adj, 0, 1, 1);
        addEdge(adj, 0, 2, 2);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 1, 3, 4);
        addEdge(adj, 2, 3, 5);
        addEdge(adj, 3, 4, 7);

        Kruskal k = new Kruskal();
        int result = k.kruskal(V, adj);

        System.out.println("MST Weight = " + result);
    }

    // Helper method to add edges in your adjacency-list structure
    private static void addEdge(List<List<List<Integer>>> adj, int u, int v, int wt) {
        List<Integer> uv = new ArrayList<>();
        uv.add(v);
        uv.add(wt);

        List<Integer> vu = new ArrayList<>();
        vu.add(u);
        vu.add(wt);

        adj.get(u).add(uv);
        adj.get(v).add(vu); // because graph is undirected
    }
    public int kruskal(int V, List<List<List<Integer>>> adj){
        List<Edge> edgesInvolved = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        for(int i=0; i<V; i++){
            for(int j=0; j<adj.get(i).size(); j++){
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                int node = i;
                Edge edge = new Edge(node,adjNode,wt);
                edges.add(edge);
            }
        }
        DisjointSetUnion dsu = new DisjointSetUnion(V);
        // sort the edges first
        Collections.sort(edges);
        int mstWt = 0;

        for(int i=0; i<edges.size(); i++){
            int wt = edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;
            if(dsu.findParent(u)!=dsu.findParent(v)) {
                edgesInvolved.add(edges.get(i));
                dsu.unionByRank(u,v);
                mstWt+=wt;
            }
        }
        System.out.println(edgesInvolved);
        return mstWt;
    }
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;
        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge comparedEdge) {
            return this.weight - comparedEdge.weight;
        }

        @Override
        public String toString(){
            return src+"--->"+dest+"("+weight+")";
        }
    }


}

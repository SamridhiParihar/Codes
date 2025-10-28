package graph.shortestpath;

import java.util.*;

public class ShortestPathInDAG {
    public static void main(String[] args) {
        int n = 6; // number of nodes
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 4, 1);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 4, 2, 2);
        addEdge(adj, 2, 3, 6);
        addEdge(adj, 4, 5, 4);
        addEdge(adj, 5, 3, 1);

        ShortestPathInDAG solver = new ShortestPathInDAG();
        int src = 0;
        int[] dist = solver.fun(adj, src);

        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Node " + i + " -> " + (dist[i] == 1e9 ? "INF" : dist[i]));
        }
    }

    // Add a directed weighted edge
    private static void addEdge(List<List<Pair>> adj, int u, int v, int w) {
        adj.get(u).add(new Pair(v, w));
    }

    public int[] fun(List<List<Pair>> adj , int src){
        int n = adj.size();
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();

        // Get topological order
        for(int i = 0 ; i < n; i++ ){
            if(!vis[i]){
                dfs(i, adj, vis, st);
            }
        }

        int[] dis = new int[n];
        Arrays.fill(dis, (int)1e9);
        dis[src] = 0;

        while(!st.isEmpty()){
            int node = st.pop();
            if(dis[node] != 1e9) {
                for(Pair pair: adj.get(node)){
                    int ele = pair.a;
                    int w = pair.w;
                    if(dis[node] + w < dis[ele]){
                        dis[ele] = dis[node] + w;
                    }
                }
            }
        }
        return dis;
    }

    private void dfs(int node, List<List<Pair>> adj , boolean[] vis, Stack<Integer> st){
        vis[node] = true;
        for(Pair pair: adj.get(node)){
            int ele = pair.a;
            if(!vis[ele]){
                dfs(ele, adj, vis, st);
            }
        }
        st.add(node);
    }

    static class Pair{
        int a;
        int w;
        public Pair(int a, int w){
            this.a = a;
            this.w = w;
        }
    }
}

package graph.traversal;

import java.util.ArrayList;

public class DFS {
    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> dfs = new ArrayList<>();
        int n = adj.size();
        boolean[]vis = new boolean[n];
        dfs(0,adj,vis,dfs);
        return dfs;
    }
    public static void dfs (int node, ArrayList<ArrayList<Integer>> adj,boolean[]vis,ArrayList<Integer> ans ){
        vis[node] = true;
        ans.add(node);
        for(int ele: adj.get(node)){
            if(!vis[ele]){
                dfs(ele,adj,vis,ans);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (undirected graph example)
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(2);

        System.out.println(dfs(adj));
    }
}

package graph.kosaraju;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Kosaraju {
    public static void main(String[] args) {

        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph:
        // 1 -> 0
        // 0 -> 2
        // 2 -> 1
        // 0 -> 3
        // 3 -> 4
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(0).add(3);
        adj.get(3).add(4);

        Kosaraju k = new Kosaraju();
        int scc = k.kosaraju(V, adj);

        System.out.println("Number of Strongly Connected Components = " + scc);
    }

    public void dfs(int node, int[] vis , List<List<Integer>> adj, Stack<Integer> st){
        vis[node] = 1;
        for(int it: adj.get(node)){
            if(vis[it]==0){
                dfs(it,vis,adj,st);
            }
        }
        st.push(node);
    }
    public void dfs3(int node, int[]vis, List<List<Integer>> adj){
        vis[node] = 1;
        for(int it: adj.get(node)){
            if(vis[it]==0){
                dfs3(it,vis,adj);
            }
        }
    }

    public int kosaraju(int V, List<List<Integer>> adj){
        // sorting them inorder of finishing time
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if(vis[i]==0){
                dfs(i,vis,adj,st);
            }
        }

        // reversing the graph
        List<List<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            vis[i]=0;
            for(int it: adj.get(i)){
                adjT.get(it).add(i); // reversed
            }
        }
        int scc = 0;
        while (!st.isEmpty()){
            int node = st.peek();
            st.pop();
            if(vis[node]==0){
                scc++;
                dfs3(node,vis,adjT);
            }
        }
        return scc;
    }
}

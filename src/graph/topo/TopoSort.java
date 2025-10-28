package graph.topo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopoSort {
    public static void main(String[] args) {
        // Example graph:
        // 5 → 0 ← 4
        // ↓         ↑
        // 2 → 3 → 1
        int V = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (directed)
        graph.get(5).add(0);
        graph.get(5).add(2);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        TopoSort obj = new TopoSort();
        List<Integer> order = obj.topoSort(graph);

        System.out.println("Topological Order: " + order);
    }
    public List<Integer> topoSort(List<List<Integer>>list){
        int n = list.size();
        Stack<Integer> st = new Stack<>();
        boolean[]vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!vis[i]) dfs(i,list,vis,st);
        }
        List<Integer>ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    public void dfs(int node ,List<List<Integer>>list,boolean[]vis,Stack<Integer> st){
        vis[node]=true;
        for(int ele: list.get(node)){
            if(!vis[ele])dfs(ele,list,vis,st);
        }
        st.add(node);
    }

}

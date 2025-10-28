package graph.topo;

import java.util.*;

public class KahnAlgo {

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
        List<Integer> ans = new ArrayList<>();
        int[] ind = new int[n];
        for(int i=0; i<n; i++){
            for(int ele: list.get(i)){
                ind[ele]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n;i++){
            if(ind[i]==0) q.add(i);
        }

        while (!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int ele: list.get(node)){
                ind[ele]--;
                if(ind[ele]==0)q.add(ele);
            }

        }
        return ans;
    }
}

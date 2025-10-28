package graph.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int st = 0;
        ArrayList<Integer> bfs = new ArrayList<>();
        int n = adj.size();
        boolean []vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0); vis[0] = true;
        while (!q.isEmpty()){
            int ver = q.poll();
            bfs.add(ver);
            for(int ele: adj.get(ver)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele]=true;
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        // Number of vertices
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

        System.out.println(bfs(adj));
    }
}

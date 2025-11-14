package graph.shortestpath;

// only works with directed graph and if there is some undirected graph we need to convert it to
// directed graph
// algorithm:
/*
    -- relax edges for n-1 times sequence

why N-1 times ?
    -- because in worst case in a graph you will get n-1 edges to reach from src to end which ends
        up taking n-1 iteration to update all (

How do we detect cycle ?
  -- since we know that it will only take n-1 iteration to update all the distance and then if on
    nth iteration also some distance is reducing it means there is cycle
* */

import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    public static void main(String[] args) {
        BellmanFord obj = new BellmanFord();

        // Example graph (V = 5 vertices)
        int V = 5;

        // Each edge: [u, v, w]
        List<List<Integer>> edges = List.of(
                List.of(0, 1, -1),
                List.of(0, 2, 4),
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(1, 4, 2),
                List.of(3, 2, 5),
                List.of(3, 1, 1),
                List.of(4, 3, -3)
        );

        int src = 0;
        int[] result = obj.fun(V, edges, src);

        if (result.length == 1 && result[0] == -1) {
            System.out.println("Graph contains a negative weight cycle.");
        } else {
            System.out.println("Shortest distances from source " + src + ":");
            for (int i = 0; i < V; i++) {
                System.out.println("Node " + i + " → " + result[i]);
            }
        }
    }

    public int[] fun(int V, List<List<Integer>> edges , int src){
        int[] dis = new int[V];
        Arrays.fill(dis, (int) 1e8);
        dis[src] =0;
        for(int i=0; i<V-1; i++){
            for(List<Integer> list : edges){
                int u = list.get(0);
                int v = list.get(1);
                int w = list.get(2);
                if(dis[u]!=(int)1e8 && dis[u]+w<dis[v]){
                    dis[v] = dis[u]+w;
                }
            }
        }

        // if you want to check cycle just do only one more iteration
        for(List<Integer> list : edges){
            int u = list.get(0);
            int v = list.get(1);
            int w = list.get(2);
            if(dis[u]!=(int)1e8 && dis[u]+w<dis[v]){
                return new int[]{-1}; // there is a cycle
            }
        }
        return dis;

    }
}

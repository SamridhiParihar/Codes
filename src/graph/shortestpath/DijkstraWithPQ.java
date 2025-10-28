package graph.shortestpath;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraWithPQ {
    // can't be used with negative weight edge or negative cycles
    public static void main(String[] args) {
        int n = 5;
        List<List<Pair>> adj = new java.util.ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new java.util.ArrayList<>());

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(2, 4));
        adj.get(1).add(new Pair(2, 1));
        adj.get(1).add(new Pair(3, 7));
        adj.get(2).add(new Pair(4, 3));
        adj.get(3).add(new Pair(4, 1));

        DijkstraWithPQ obj = new DijkstraWithPQ();
        int[] dist = obj.fun(adj, 0);

        for(int i=0;i<dist.length;i++){
            System.out.println("Distance from 0 to " + i + " is " + dist[i]);
        }
    }

    public int[] fun(List<List<Pair>> adj , int src){
        int n = adj.size();
        int[] dis = new int[n];
        Arrays.fill(dis, (int)1e9);
        dis[src] =0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->Integer.compare(a.w,b.w));
        q.add(new Pair(src,0));

        while(!q.isEmpty()){
            Pair ele = q.poll();
            int node = ele.a;
            int w = ele.w;
            for(Pair pair : adj.get(node)){
                if(dis[pair.a] > dis[node] + pair.w){
                    dis[pair.a] = dis[node] + pair.w;
                    q.add(new Pair(pair.a, dis[pair.a]));
                }
            }
        }
        return dis;
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

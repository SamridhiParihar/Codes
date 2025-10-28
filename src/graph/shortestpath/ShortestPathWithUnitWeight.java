package graph.shortestpath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathWithUnitWeight {
    public int[] fun(List<List<Integer>> adj){
        int n = adj.size();
        int[] distance = new int[n];
        Arrays.fill(distance,(int)1e9);
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(0,0));

        while(!q.isEmpty()){
            Pair pair = q.poll();
            int a = pair.a;
            int w = pair.w;
            distance[a] = w;
            for(int node: adj.get(a)){
                if(distance[node]>w+1){
                    q.add(new Pair(node,w+1));
                }
            }
        }
        return distance;

    }
    public static void main(String[] args) {

    }
    static class Pair{
         int a ;
         int w ;
        public Pair(int a, int w){
            this.a = a;
            this.w = w;
        }
    }
}

package graph.minimum_spanning_tree;

import java.util.ArrayList;
import java.util.List;


public class DisjointSetUnion {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSetUnion(int n){
        for(int i=0; i<=n; i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findParent(int node){
        if(parent.get(node)==node) return node;
        int ultimateParent = findParent(parent.get(node));
        parent.set(node,ultimateParent);
        return parent.get(node);
    }
    public void unionByRank(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_v==ulp_u) return;
        int rankU = rank.get(ulp_u);
        int rankV = rank.get(ulp_v);
        if(rankU>rankV){
            parent.set(ulp_v,ulp_u);
        }
        else if(rankV>rankU){
            parent.set(ulp_u,ulp_v);
        }
        else {
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }
    public void unionBySize(){

    }
    public static void main(String[] args) {
        DisjointSetUnion dsu = new DisjointSetUnion(7);
        dsu.unionByRank(1,2);
        dsu.unionByRank(2,3);
        dsu.unionByRank(4,5);
        dsu.unionByRank(6,7);
        dsu.unionByRank(5,6);

        // 3 and 6 belongs to same set (component or not ) expected different
        if(dsu.findParent(3)==dsu.findParent(7))
            System.out.println("same");
        else System.out.println("different");

        dsu.unionByRank(3,7);
        //again checking; 3 and 6 belongs to same set (component or not ) expected same
        if(dsu.findParent(3)==dsu.findParent(7))
            System.out.println("same");
        else System.out.println("different");
    }
}

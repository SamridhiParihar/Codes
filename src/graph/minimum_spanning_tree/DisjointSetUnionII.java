package graph.minimum_spanning_tree;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetUnionII{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSetUnionII(int n){
        for(int i=0; i<=n; i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int findParent(int node){
        if(parent.get(node)==node) return node;
        int ultimateParent = findParent(parent.get(node));
        parent.set(node,ultimateParent);
        return parent.get(node);
    }
    public void unionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_v==ulp_u) return;
        int sizeU = size.get(ulp_u);
        int sizeV = size.get(ulp_v);
        if(sizeU>sizeV){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,sizeU+sizeV);
        }
        else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,sizeV+sizeU);
        }

    }
    public void unionBySize(){

    }
    public static void main(String[] args) {
        DisjointSetUnionII dsu = new DisjointSetUnionII(7);
        dsu.unionBySize(1,2);
        dsu.unionBySize(2,3);
        dsu.unionBySize(4,5);
        dsu.unionBySize(6,7);
        dsu.unionBySize(5,6);

        // 3 and 6 belongs to same set (component or not ) expected different
        if(dsu.findParent(3)==dsu.findParent(7))
            System.out.println("same");
        else System.out.println("different");

        dsu.unionBySize(3,7);
        //again checking; 3 and 6 belongs to same set (component or not ) expected same
        if(dsu.findParent(3)==dsu.findParent(7))
            System.out.println("same");
        else System.out.println("different");
    }
}

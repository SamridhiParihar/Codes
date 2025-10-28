package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(node==null) return ans;
        ans.add(node.data);
        Node temp = node;
        List<Integer> left = left(temp);
        temp = node;
        List<Integer> right = right(temp);
        temp = node;
        List<Integer> leaf = new ArrayList<>();
        leaf(temp,leaf);
        for(int i=0; i<left.size(); i++){
            if(i==0) continue;
            ans.add(left.get(i));
        }
        for(int i=0; i<leaf.size(); i++){
            ans.add(leaf.get(i));
        }
        for(int i=0; i<right.size();i++){
            if(i==0) continue;
            ans.add(right.get(i));
        }

        return ans;
    }
    public List<Integer> left(Node node){
        List<Integer> ans = new ArrayList<>();
        while(true){
            if(node.left==null && node.right==null) break;
            ans.add(node.data);
            if(node.left!=null) node = node.left;
            else node = node.right;
        }
        return ans;
    }
    public List<Integer> right(Node node){
        List<Integer> ans = new ArrayList<>();
        while(true){
            if(node.left==null && node.right==null) break;
            ans.add(node.data);
            if(node.right!=null) node = node.right;
            else node = node.left;
        }
        return ans;
    }
    public void leaf(Node node, List<Integer> ans){
        if(node.left==null && node.right==null) {
            ans.add(node.data);
            return;
        }
        leaf(node.left,ans);
        leaf(node.right,ans);
    }

    static class Node
    {
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
       String s = "abBcCdD";
       int[]arr = new int[26];
       StringBuffer ans = new StringBuffer("");
       for(char ch: s.toCharArray()){
           ch = Character.toLowerCase(ch);
           if(arr[ch-'a']==0){
               ans = ans.append(ch);
           }
           arr[ch-'a']++;
       }
        System.out.println(ans.toString());
    }
}
package Trees.traversal.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {
    public void bfs(Node root, List<List<Node>> list){
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            List<Node> curr = new ArrayList<>();
            int n = q.size();
            for(int i=0; i<n; i++){
                Node node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                curr.add(node);
            }
            list.add(curr);
        }
    }

    public static void main(String[] args) {
        // Build the tree
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        Bfs obj = new Bfs();
        List<List<Node>> levels = new ArrayList<>();

        obj.bfs(root, levels);

        // Print BFS traversal (level order)
        System.out.println("BFS Level Order Traversal:");
        int level = 1;
        for (List<Node> l : levels) {
            System.out.print("Level " + level + ": ");
            for (Node n : l) {
                System.out.print(n.data + " ");
            }
            System.out.println();
            level++;
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }
}

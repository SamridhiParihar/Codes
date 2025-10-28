package Trees.traversal.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {
    // Left Root Right
    public  void inorder(Node node , List<Node> in){
        if(node==null) return ;
        inorder(node.left,in);
        in.add(node);
        inorder(node.right,in);
    }

    public void inorderIterative(Node root, List<Node> in){
        Node node = root;
        Stack<Node> st = new Stack<>();
        while (true){
            if(node!=null){
                st.add(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()) break;
                node = st.pop();
                in.add(node);
                node = node.right;
            }
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

        Inorder obj = new Inorder();
        List<Node> result = new ArrayList<>();
        List<Node> result2 = new ArrayList<>();


        obj.inorder(root, result);
        obj.inorderIterative(root,result2);

        // Print preorder traversal
        System.out.println("Preorder Traversal: ");
        System.out.print("Recursive: ");
        for (Node n : result) {
            System.out.print(n.data + " ");
        }
        System.out.println();
        System.out.print("Iterative: ");
        for (Node n : result2) {
            System.out.print(n.data + " ");
        }
    }

    static class Node{
        int data;
        Node left;
        Node right ;
        public Node(int data){
            this.data = data;
        }
    }
}

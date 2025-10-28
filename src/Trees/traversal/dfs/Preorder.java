package Trees.traversal.dfs;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder {
    // Root Left Right
    public void preorder(Node node , List<Node> pre){
        if(node==null) return ;
        pre.add(node);
        preorder(node.left,pre);
        preorder(node.right,pre);
    }
    public void preorderIterative(Node node , List<Node> pre){
        Stack<Node> st = new Stack<>();
        st.add(node);
        while (!st.isEmpty()){
            Node curr = st.pop();
            if(curr.right!=null)st.add(curr.right);
            if(curr.left!=null)st.add(curr.left);
            pre.add(curr);
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

        Preorder obj = new Preorder();
        List<Node> result = new ArrayList<>();
        List<Node> result2 = new ArrayList<>();

        obj.preorder(root, result);
        obj.preorderIterative(root,result2);

        // Print preorder traversal
        System.out.println("Preorder Traversal ");
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

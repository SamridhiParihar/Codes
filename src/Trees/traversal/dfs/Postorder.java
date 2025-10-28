package Trees.traversal.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Postorder {
    // Left Right Root
    public void postorder(Node node, List<Node> post) {
        if (node == null) return;
        postorder(node.left, post);
        postorder(node.right, post);
        post.add(node); // visit root at the end
    }
    // with two stacks
    public void postorderIterativeTwoStacks(Node node, List<Node> post){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.add(node);
        while(!st1.isEmpty()){
            Node curr = st1.pop();
            if(curr.left!=null) st1.add(curr.left);
            if(curr.right!=null)  st1.add(curr.right);
            st2.add(curr);
        }
        while (!st2.isEmpty()) post.add(st2.pop());

    }

    // with one stack
    public void postorderIterativeOneStack(Node node,List<Node> post){
        Node curr = node;
        Stack<Node> st = new Stack<>();
        while (curr!=null || !st.isEmpty()){
            if(curr!=null) {
                st.add(curr);
                curr = curr.left;
            }
            else {
                Node temp = st.peek().right;
                if(temp==null){
                    temp = st.pop();
                    post.add(temp);
                    while(!st.isEmpty() && temp==st.peek().right){
                        temp = st.pop();
                        post.add(temp);
                    }
                }
                else curr = temp;
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

        Postorder obj = new Postorder();
        List<Node> result = new ArrayList<>();
        List<Node> result2 = new ArrayList<>();
        List<Node> result3 = new ArrayList<>();



        obj.postorder(root, result);
        obj.postorder(root,result2);
        obj.postorder(root,result3);
        // Print postorder traversal
        System.out.println("Postorder Traversal: ");

        System.out.print("Recursive : ");
        for (Node n : result) {
            System.out.print(n.data + " ");
        }
        System.out.println();
        System.out.print("Iterative : ");
        for (Node n : result2) {
            System.out.print(n.data + " ");
        }
        System.out.println();
        System.out.print("Iterative II : ");
        for (Node n : result3 ) {
            System.out.print(n.data + " ");
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }
}

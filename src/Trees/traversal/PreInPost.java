package Trees.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreInPost {
    public void allInOne(Node root, List<Node> pre , List<Node> in , List<Node> post){
        Node temp = root;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(temp,1));
        while (!st.isEmpty()){
            int val = st.peek().val;
            if(val==1){
                Pair curr = st.pop();
                curr.val++;
                pre.add(curr.node);
                st.push(curr);
                if(curr.node.left!=null)st.push(new Pair(curr.node.left,1));
            }
            else if(val==2){   // should be else if (important!)
                Pair curr = st.pop();
                curr.val++;
                in.add(curr.node);
                st.push(curr);
                if(curr.node.right!=null) st.push(new Pair(curr.node.right,1));
            }
            else {  // val == 3
                Pair curr = st.pop();
                post.add(curr.node);
            }
        }
    }

    public static void main(String[] args) {
        // Build a sample tree
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

        List<Node> preorder = new ArrayList<>();
        List<Node> inorder = new ArrayList<>();
        List<Node> postorder = new ArrayList<>();

        PreInPost obj = new PreInPost();
        obj.allInOne(root, preorder, inorder, postorder);

        // Print results
        System.out.print("Preorder: ");
        preorder.forEach(n -> System.out.print(n.data + " "));
        System.out.println();

        System.out.print("Inorder: ");
        inorder.forEach(n -> System.out.print(n.data + " "));
        System.out.println();

        System.out.print("Postorder: ");
        postorder.forEach(n -> System.out.print(n.data + " "));
        System.out.println();
    }

    static class Pair{
        Node node;
        int val;
        public Pair (Node node, int val){
            this.node = node;
            this.val = val;
        }
    }
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }
}

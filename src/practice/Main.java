package practice;

import java.util.*;

public class Main {

    static int f(int[][] dp, List<List<Integer>> adj, int curr, int par, int parity, int[] a) {
        if (dp[curr][parity] != -1) return dp[curr][parity];

        // Leaf condition (degree == 1 and not the root)
        if (adj.get(curr).size() == 1 && curr != 1) {
            if (parity == 0) {
                return dp[curr][parity] = 0;
            } else {
                return dp[curr][parity] = a[curr-1];
            }
        }

        int sumTrue = 0, sumFalse = a[curr-1];
        for (int child : adj.get(curr)) {
            if (child != par) {
                sumFalse += f(dp, adj, child, curr, 0, a);
                sumTrue += f(dp, adj, child, curr, 1, a);
            }
        }
        System.out.println(curr+"  "+par+"  "+sumTrue+"  "+sumFalse+" "+a[curr]);
        return dp[curr][parity] = Math.min(sumTrue, sumFalse);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
       // System.out.println("a done");

        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
           // System.out.print("i " + i + " ");
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            //System.out.println(edges[i][0] + " " + edges[i][1] + " ");
        }
       // System.out.println("edges fone " + (n - 1));

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <=n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        // dp[n][2], initialized to -1
        int[][] dp = new int[n+1][2];
        for (int[] row : dp) Arrays.fill(row, -1);

      //  System.out.println("     mmmm   ");
        System.out.println(f(dp, adj, 1, -1, 1, a));
    }
}

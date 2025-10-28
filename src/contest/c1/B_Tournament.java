package contest.c1;

import java.util.Scanner;

public class B_Tournament {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int j = in.nextInt();
            int k = in.nextInt();
            int[]arr = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                max = Math.max(max,arr[i]);
            }
            if(arr[j-1]==max) System.out.println("Yes");
            else {
                if(k>1) System.out.println("Yes");
                else System.out.println("No");
            }

        }
    }
}

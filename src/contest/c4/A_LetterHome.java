package contest.c4;

import java.util.Scanner;

public class A_LetterHome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int s = in.nextInt();
            int[]arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int res =0;
            if(s<=arr[0]) res = arr[n-1]-s;
            else if(s>=arr[n-1]) res = s - arr[0];
            else res = arr[n-1]-arr[0]+Math.min((arr[n-1]-s),(s-arr[0]));
            System.out.println(res);
        }
    }
}

package contest.c7;

import java.util.Arrays;
import java.util.Scanner;

public class A_Lever {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int[] a = new int[n];
            int [] b = new int[n];
            int max_a = -1;
            int max_b = -1;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                max_a = Math.max(max_a,a[i]);
            }
            for (int i = 0; i < n; i++) {
                b[i]= in.nextInt();
                max_b = Math.max(max_b,b[i]);
            }
            long sum =0;
            for (int i = 0; i < n; i++) {
                if(a[i]>b[i]){
                    sum+=(a[i]-b[i]);
                }
            }
            System.out.println(sum+1);

        }
    }
}

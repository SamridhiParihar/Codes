package contest.c_1048_div2;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            long m = in.nextLong();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            long min = Math.min(n,m);
            long ans = 0;
            int ind = n-1;
            long s = m;
            for (int i = 0; i < min; i++) {
                ans += (arr[ind--]*s);
                s--;
            }
            System.out.println(ans);
        }
    }
}

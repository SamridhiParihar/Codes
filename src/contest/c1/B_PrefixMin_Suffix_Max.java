package contest.c1;

import java.util.Scanner;

public class B_PrefixMin_Suffix_Max {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t =in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int[]arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int[] small = new int[n];
            int min = arr[0];
            for (int i = 0; i < n; i++) {
                min = Math.min(min,arr[i]);
                small[i] = min;
            }
            int [] big = new int[n];
            int max = arr[n-1];
            for (int i = n-1; i >=0 ; i--) {
                max = Math.max(max,arr[i]);
                big[i] = max;
            }
            int[]ans = new int[n];
            ans[0]=1;ans[n-1]=1;
            for (int i = 1; i < n-1; i++) {
                if(big[i]==arr[i] || small[i]==arr[i]){
                    ans[i]=1;
                }
                else ans[i]=0;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i]);
            }
            System.out.println();
        }
    }
}

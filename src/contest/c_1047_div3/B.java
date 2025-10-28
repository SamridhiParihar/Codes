package contest.c_1047_div3;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int[]arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int[]ans = new int[n];
            for(int i=0; i<n; i++){

                ans[i] = n- arr[i]+1;
            }
            for(int i=0; i<n ; i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
    }
}

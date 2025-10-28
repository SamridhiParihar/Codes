package contest.c8;

import java.util.Scanner;

public class B_Shrink {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int[]arr = new int[n+1];
            int even = 4;
            int odd = ((n&1)==1)?n:n-1;
            arr[1] = 2;
            arr[n] = 1;
            for (int i = 2; i <=n-1; i++) {
                if((i&1)==1) {
                    arr[i] = even;
                    even+=2;
                }
                else {
                    arr[i] = odd;
                    odd-=2;
                }
            }
            for (int i = 1; i <=n; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}

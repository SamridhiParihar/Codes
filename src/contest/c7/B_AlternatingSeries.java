package contest.c7;

import java.util.Scanner;

public class B_AlternatingSeries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            if(n==2){
                System.out.println(-1+" "+2);
                continue;
            }
            int[]arr = new int[n];
            for (int i = 0; i < n; i++) {
                if(i%2==0)arr[i]=-1;
                else arr[i] = 3;
            }
            if(n%2==0) arr[n-1]=2;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}

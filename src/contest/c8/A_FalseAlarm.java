package contest.c8;

import java.util.Scanner;

public class A_FalseAlarm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int x = in.nextInt();
            int[]arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int firstOne = 0;
            int lastOne = n-1;
            for (int i = 0; i < n; i++) {
                if(arr[i]==1) {
                    firstOne = i;
                    break;
                }
            }
            for (int i = n-1; i >=0 ; i--) {
                if(arr[i]==1){
                    lastOne = i;
                    break;
                }
            }
            if(lastOne-firstOne+1<=x) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}

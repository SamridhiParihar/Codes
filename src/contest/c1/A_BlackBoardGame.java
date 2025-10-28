package contest.c1;

import java.util.Scanner;

public class A_BlackBoardGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[]arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%4==0) System.out.println("Bob");
            else System.out.println("Alice");
        }
    }
}

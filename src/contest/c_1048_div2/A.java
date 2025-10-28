package contest.c_1048_div2;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            long a = in.nextLong();
            long b = in.nextLong();
            if(a==b) System.out.println(0);
            else if(a%b==0 || b%a==0) System.out.println(1);
            else System.out.println(2);
        }
    }
}

package contest.c_1047_div3;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int tt = in.nextInt();
            long x =  in.nextLong();
            for(int i =0; i<tt; i++){
                x*=2;
            }
            System.out.println(x);
        }
    }
}

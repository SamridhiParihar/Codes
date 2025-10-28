package contest.c_1046_div2;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();

            boolean check = true;
            if(Math.max(a,b)>(Math.min(a,b)*2+2)) check = false;
            if(c<a || d<b) check = false;
            int c1 = c-a;
            int d1 = d-b;
            if(Math.max(c1,d1)>(Math.min(c1,d1)*2+2)) check = false;
            if(check) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}

package contest.c_1047_div3;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            long a = in.nextLong();
            long b = in.nextLong();
            // even, odd
            if(a%2==0 && b%2!=0){
                System.out.println(-1);
            }
            // odd, odd
            else if(a%2!=0 && b%2!=0){
                long ans = (a*b) + 1;
                System.out.println(ans);
            }
            else {
                long a1 = a+b;
                long a2 = (a*(b/2))+2;
                if(a1%2!=0 && a2%2!=0) System.out.println(-1);
                else if(a1%2==0 ) System.out.println(Math.max(a1,a2));
                else  System.out.println(a2);

            }

        }
    }
}

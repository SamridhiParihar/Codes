package contest.c3;

import java.util.Scanner;

public class LeftAndDown {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of test cases

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long k = sc.nextLong();

            long g = gcd(a, b);

            if (a / g <= k && b / g <= k) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }

        sc.close();
    }

    // Euclidean algorithm for GCD
    public static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}

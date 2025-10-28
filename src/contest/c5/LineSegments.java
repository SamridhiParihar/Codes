package contest.c5;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class LineSegments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long px = sc.nextLong();
            long py = sc.nextLong();
            long qx = sc.nextLong();
            long qy = sc.nextLong();

            long total = 0;
            for (int i = 0; i < n; i++) {
                total += sc.nextLong();
            }

            long dx = qx - px;
            long dy = qy - py;
            double dist = Math.hypot(dx, dy);

            if (dist > total) {
                System.out.println("No");
            }
            else if (Math.abs(dist) < 1e-9 && n == 1) {
                System.out.println("No");
            }
            else {
                double diff = total - dist;
                if (Math.abs(diff - Math.round(diff)) < 1e-9) {
                    long diffInt = Math.round(diff);

                    if ((diffInt & 1) == 0) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                } else {
                    System.out.println("No");
                }
            }
        }

    }
}

package contest.c_1048_div2;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            long k = in.nextLong();
            long x = in.nextLong();
            long total = 1L << (k + 1);
            long choc = 1L << k;
            long van = 1L << k;
            long target = x;

            if (choc == target) {
                System.out.println(0);
                System.out.println();
                continue;
            }

            List<Integer> moves = new ArrayList<>();
            long diff = Math.abs(choc - target);

            for (int i = (int)k; i >= 0; i--) {
                long step = 1L << i;
                if ((diff & step) != 0) {
                    if (choc > target) {
                        moves.add(1);
                        choc -= step;
                        van += step;
                    } else {
                        moves.add(2);
                        choc += step;
                        van -= step;
                    }
                }
            }

            System.out.println(moves.size());
            for (int i = 0; i < moves.size(); i++) {
                System.out.print(moves.get(i) + (i == moves.size() - 1 ? "\n" : " "));
            }
        }
    }
}

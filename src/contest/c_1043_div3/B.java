package contest.c_1043_div3;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            List<Long> list = new ArrayList<>();

            long p = 10;
            while (p + 1 <= n) {
                long div = p + 1;
                if (n % div == 0) {
                    list.add(n / div);
                }
                if (p > Long.MAX_VALUE / 10) break;
                p *= 10;
            }



            if (list.isEmpty()) {
                System.out.println(0);
            } else {
                Collections.sort(list);
                System.out.println(list.size());
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i));
                    if (i + 1 < list.size()) System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}

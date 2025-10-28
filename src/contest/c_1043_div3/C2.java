package contest.c_1043_div3;
import java.util.*;

public class C2 {
    public static void main(String[] args) {
        List<Long> cost = new ArrayList<>();
        long c = 3;
        long cnt = 1;

        for (int i = 0; i < 21; ++i) {
            cost.add(c);
            c = 3 * c + cnt;
            cnt *= 3;
        }

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();

            List<Long> tr = new ArrayList<>();
            long min_k = 0;

            while (n > 0) {
                tr.add(n % 3);
                min_k += n % 3;
                n /= 3;
            }

            if (min_k > k) {
                System.out.println(-1);
                continue;
            }

            k -= min_k;
            k /= 2;

            for (int i = tr.size() - 1; i >= 1; --i) {
                long val = tr.get(i);

                if (val <= k) {
                    tr.set(i - 1, tr.get(i - 1) + 3 * val);
                    k -= val;
                    tr.set(i, 0L);
                } else {
                    tr.set(i - 1, tr.get(i - 1) + 3 * k);
                    tr.set(i, val - k);
                    break;
                }
            }
//            System.out.println(tr);

            long an = 0;
            for (int i = tr.size() - 1; i >= 0; --i) {
                an += cost.get(i) * tr.get(i);
            }

            System.out.println(an);
        }

        sc.close();
    }
}

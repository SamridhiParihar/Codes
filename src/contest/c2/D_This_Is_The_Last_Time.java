package contest.c2;
import java.util.*;
public class D_This_Is_The_Last_Time {
    static class Casino {
        int l, r, real;
        public Casino(int l, int r, int real) {
            this.l = l;
            this.r = r;
            this.real = real;
        }
    }
// wrong solution
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            List<Casino> casinos = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int real = sc.nextInt();
                casinos.add(new Casino(l, r, real));
            }

            long low = k, high = (long) 1e9, ans = k;

            while (low <= high) {
                long mid = (low + high) / 2;
                if (canReach(mid, k, casinos)) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }

    private static boolean canReach(long target, long start, List<Casino> allCasinos) {
        List<Casino> casinos = new ArrayList<>();
        for (Casino c : allCasinos) {
            if (c.real <= target) {
                casinos.add(c);
            }
        }

        casinos.sort(Comparator.comparingInt(c -> c.l));

        long reach = start;
        boolean changed = true;

        while (changed) {
            changed = false;
            for (Casino c : casinos) {
                if (c.l <= reach && reach <= c.r && c.real > reach) {
                    reach = c.real;
                    changed = true;
                    if (reach >= target) return true;
                }
            }
        }

        return reach >= target;
    }
}

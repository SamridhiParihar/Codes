package itmo.binary_search.bs2;

import java.util.Scanner;

public class D_ChildrenHoliday {

    static class Assistant {
        int t, z, y;
        Assistant(int t, int z, int y) {
            this.t = t;
            this.z = z;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        Assistant[] assistants = new Assistant[n];
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int z = sc.nextInt();
            int y = sc.nextInt();
            assistants[i] = new Assistant(t, z, y);
        }

        int low = -1, high = (int) 1e9;
        while (high > low + 1) {
            int mid = (low + high) / 2;
            if (canInflateAll(assistants, m, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        System.out.println(high);

        int[] count = new int[n];
        int totalInflated = 0;

        for (int i = 0; i < n; i++) {
            count[i] = maxBalloons(assistants[i], high);
        }

        for (int i = 0; i < n; i++) {
            if (totalInflated + count[i] <= m) {
                System.out.print(count[i] + " ");
                totalInflated += count[i];
            } else {
                System.out.print((m - totalInflated) + " ");
                totalInflated = m;
            }
        }
        System.out.println();
    }

    static boolean canInflateAll(Assistant[] assistants, int m, int time) {
        int total = 0;
        for (Assistant a : assistants) {
            total += maxBalloonsInTime(a, time);
            if (total >= m) return true;
        }
        return false;
    }

    static int maxBalloonsInTime(Assistant a, int time) {
        int lo = 0, hi = (int) 1e9;
        while (hi > lo + 1) {
            int mid = (lo + hi) / 2;
            if (isBalloonPossible(a, mid, time)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    static boolean isBalloonPossible(Assistant a, int balloons, int time) {
        int batchTime = a.t * a.z + a.y;
        int fullBatches = balloons / a.z;
        int extra = balloons % a.z;

        int totalTime;
        if (extra == 0 && balloons != 0) {
            // No rest after last batch
            totalTime = (fullBatches - 1) * batchTime + a.z * a.t;
        } else {
            totalTime = fullBatches * batchTime + extra * a.t;
        }

        return totalTime <= time;
    }

    static int maxBalloons(Assistant a, int time) {
        int batchTime = a.t * a.z + a.y;
        int fullBatches = time / batchTime;
        int remTime = time % batchTime;

        int total = fullBatches * a.z;
        total += Math.min(remTime / a.t, a.z);
        return total;
    }
}

package contest.c8;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C_CoolPartition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int []arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int count=1 ;
            Set<Integer> exist = new HashSet<>();
            Set<Integer> curr = new HashSet<>();
            exist.add(arr[0]);
            for (int i = 1; i <n; i++) {
                if(exist.isEmpty()) {
                    count++;
                    exist = new HashSet<>(curr);
                    curr = new HashSet<>();
                }
                if(exist.contains(arr[i])) exist.remove(arr[i]);
                curr.add(arr[i]);
            }
            if(exist.isEmpty()) count++;
            System.out.println(count);

        }
    }
}

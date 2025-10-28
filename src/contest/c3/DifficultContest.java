package contest.c3;

import java.util.Scanner;

public class DifficultContest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            String s = in.next();
            int[] f = new int[26];
            for(char ch : s.toCharArray()){
                f[ch-'A']++;
            }

            StringBuilder res = new StringBuilder("");
            res.append("T".repeat(f['T'-'A']));
            f['T'-'A']=0;
            for (int i = 0; i < 26; i++) {
                res.append(String.valueOf((char)('A'+i)).repeat(f[i]));
            }
            System.out.println(res);

        }
    }
}

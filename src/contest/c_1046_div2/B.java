package contest.c_1046_div2;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();
//            int[] tt = new int[n+1];
            int one = 0;
            boolean check = true;
            int total = 0;
//            int min =Integer.MAX_VALUE,max =Integer.MIN_VALUE;
            int l =0;
            for (int r = 0; r < n; r++) {
                if(s.charAt(r)=='1') {
                    one++;
                    total++;
                }
                while(r-l+1>k) {
                    if(s.charAt(l)=='1') one--;
                    l++;
                }
                if(one>=1 && r-l+1==k) {
                    if(one==k) check = false;
//                    min = Math.min(l + 1, min);
//                    max = Math.max(r+1,max);
                }
            }
            if(total==0){
                System.out.println("YES");
                for (int i = 0; i < n; i++) {
                    System.out.print(i+1+" ");
                }
                System.out.println();
                continue;
            }
            if(!check){
                System.out.println("NO");
                continue;
            }

            int big = n;
            int small = 1;
            int[]ans = new int[n];
            for (int i=0; i<n; i++) {
                char ch  = s.charAt(i);
                if(ch=='0') {
                    ans[i] = big;
                    big--;
                }
                else {
                    ans[i] = small;
                    small++;
                }
            }
            System.out.println("YES");
            for (int i = 0; i < n; i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(ans[i]);
            }
            System.out.println();

        }
    }
}

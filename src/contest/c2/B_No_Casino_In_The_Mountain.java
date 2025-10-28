package contest.c2;

import java.util.Scanner;

public class B_No_Casino_In_The_Mountain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[]arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int count =0;
            int res = 0;
            boolean end = false;
            for (int i = 0; i < n; ) {
                if(arr[i]==0){
                    count++;
                    if(count==k) {
                        res++;
                        i+=2;
                        count =0;
                        continue;
                    }
                    i++;
                }
                else {
                    count =0;
                    i++;
                }

            }
            System.out.println(res);
        }
    }
}

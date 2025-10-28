package contest.c_1047_div3;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            long[] f = new long[n+1];
            int zero = 0;
            for (int i = 0; i <n; i++) {
                arr[i] = in.nextInt();
                f[arr[i]]++;
                if(arr[i]==0) zero++;
            }
            if(zero==n){
                if(k%2==0) System.out.println(0);
                else System.out.println(n);
                continue;
            }
            int min =-1;
            for(int i=0; i<=n; i++){
                if(f[i]==0) {
                    min = i;
                    break;
                }
            }


            int[] ans = new int[n];
            long sum = 0;
            for (int i=0; i<n ;i++){
                if(f[arr[i]]>1) {
                    ans[i] = min;
                    continue;
                }
                if(arr[i]>min){
                    ans[i] = min;
                    continue;
                }
                ans[i] = arr[i];
            }
            for (int ele: ans) {
                sum+=ele;
            }
            System.out.println(sum);
        }
    }
}

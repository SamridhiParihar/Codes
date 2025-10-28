package contest.c_1043_div3;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            long n = in.nextLong();
            long num = ternary_reverse(n);

            long ans = 3*n;
            long i = 0;
            long pans = 0;
            while(num!=0){
                long d = num%10;
                pans+=(d*i*(long)Math.pow(3,i));
                i++;
                num/=10;
            }
            pans = pans/3;
            ans+=pans;
            System.out.println(ans);

        }
    }
    public static long count(long n){
        long cnt = 0;
        while (n!=0){
            n/=3;
            cnt++;
        }
        return cnt;
    }
    public static long ternary_reverse(long n){
        long ans = 0;
        StringBuilder sb = new StringBuilder();
        while (n!=0){
            sb.append(String.valueOf(n%3));
            n/=3;
        }

        int pow  = 0;
        for(char ch: sb.toString().toCharArray()){
            ans += (long) ((ch-'0') * Math.pow(10,pow++));
        }
        return ans;
    }
}

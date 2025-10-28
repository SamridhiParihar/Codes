package contest.c5;

import java.util.Scanner;

public class A_AddOrXor {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            long a = in.nextInt();
            long b = in.nextInt();
            long x = in.nextInt();
            long y = in.nextInt();
            // impossible ones
            long ans = -1;
            if(a>b){
                if((a==b+1) && a%2==1) ans = y;
                else ans =-1;
            }
            else {
                if(x<=y) ans = (b-a)*x;
                else{
                    long diff = b-a;
                    long k = diff/2;
                    if(diff%2==0){
                        ans = k*x + k*y;
                    }
                    else{
                        if(a%2==0) ans = k*x + (k+1)*y;
                        else ans = (k+1)*x+ k*y;
                    }
                }
            }
            System.out.println(ans);

        }
    }
}

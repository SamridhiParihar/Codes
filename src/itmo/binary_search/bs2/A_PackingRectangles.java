package itmo.binary_search.bs2;

import java.util.Scanner;

public class A_PackingRectangles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long w = in.nextLong();
        long h = in.nextLong();
        long n = in.nextLong();

        long l = 0;
        long r = 1;
        while (!good(r,w,h,n))r=2*r;

        while (r>l+1){
            long m = l+(r-l)/2;
            if(good(m,w,h,n))r=m;
            else l=m;
        }
        System.out.println(r);
    }
    public  static boolean good(long x , long w, long h, long n){
        return (x/w)*(x/h)>=n;
    }
}

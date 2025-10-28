package itmo.binary_search.bs2;

import java.util.Scanner;

public class C_VeryEasyTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long x = in.nextLong();
        long y = in.nextLong();

        long l = 0 , r =Math.max(x,y)*n+1;
        while(r>l+1){
            long m = l+(r-l)/2;
            if(good(m,n,x,y)) r=m;
            else l =m;
        }
        System.out.println(r);
    }
    public static boolean good(long m , long n, long x , long y){
        return ((m/Math.min(x,y))+((m-Math.min(x,y))/Math.max(x,y)))>=n;
    }

}

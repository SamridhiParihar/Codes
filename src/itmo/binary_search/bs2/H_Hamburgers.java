package itmo.binary_search.bs2;

import java.util.Scanner;

public class H_Hamburgers {
    static long nB;
    static long nS;
    static long nC;
    static long pB;
    static long pS;
    static long pC;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        nB = in.nextLong();
        nS = in.nextLong();
        nC = in.nextLong();

        pB = in.nextLong();
        pS = in.nextLong();
        pC = in.nextLong();

        long money = in.nextLong();

        long l=0, r= (long)1e14+1;
        while (r>l+1){
            long m = (r+l)/2;
            if(good(m,s,money))l=m;
            else r =m;
        }
        System.out.println(l);
    }
    public static boolean good(long m , String s  , long money){
        long noB =0, noC=0,noS=0;
        for(char ch: s.toCharArray()) {
            if(ch=='B') noB++;
            else if(ch=='C') noC++;
            else if(ch=='S') noS++;
        }
        noC*=m;noB*=m;noS*=m;

        long price = Math.max(noB-nB,0)*pB + Math.max(noC-nC,0)*pC+ Math.max(noS-nS,0)*pS;

        return price<=money;

    }
}

package itmo.binary_search.bs2;

import java.util.Scanner;

public class E_Equation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double c = in.nextDouble();
        double l = 0, r = 1000000000;
        for (int i = 0; i <100; i++) {
            double m = l+(r-l)/2;
            if(good(m,c)) r=m;
            else l =m;
        }
        System.out.println(r);
    }
    public static boolean good(double x , double c){
        return (x*x+Math.sqrt(x)>=c);
    }
}

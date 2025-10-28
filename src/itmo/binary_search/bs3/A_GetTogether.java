package itmo.binary_search.bs3;

import java.util.ArrayList;
import java.util.Scanner;
import  java.util.List;

public class A_GetTogether {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            list.add(new Pair(a,b));
        }
        double l =0,  r = 20e8+1;
        for (int i = 0; i <=100; i++) {
            double m = (l+r)/2;
            if(good(m, list )) r=m;
            else l =m;
        }
        System.out.println(r);
    }
    static class Pair{
        public Pair(int x, int v){
            this.x =x;
            this.v = v;
        }
        int x;
        int v;
    }
    public static boolean good(double t, List<Pair> list){
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        for(Pair pair: list){
            int x = pair.x;
            int v = pair.v;
            max = Math.max(max,x-v*t);
            min = Math.min(min,x+v*t);
        }
        return min-max>=0;
    }
}

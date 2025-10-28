package itmo.binary_search.bs2;

import java.util.Scanner;

public class B_Ropes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[]arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }
        double l =0 ;
        double r = 1e8;
        for (int i = 0; i < 100; i++) {
            double m = l+(r-l)/2;
            if(good(m,arr,k)) l=m;
            else r =m;
        }
        System.out.println(r);
    }
    public static boolean good(double m , int []arr, int k){
        long total =0;
        for(int ele: arr){
            total+=(ele/m);
        }
        return total>=k;
    }
}

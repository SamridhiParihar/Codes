package itmo.binary_search.bs3;

import java.util.Scanner;

public class C_CowsInStall {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong();
        long[]arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        long l =-1, r = arr[n-1]-arr[0]+1;
        while (r>l+1){
            long m = (l+r)/2;
            if(good(m,arr,k))l=m;
            else r =m;
        }
        System.out.println(l);
    }
    public static boolean good(long m, long[]arr, long k){
        long res =1;
        long temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            long diff = arr[i]-temp;
            if(diff>=m){
                res++;
                temp = arr[i];
            }
        }
        return res>=k;
    }
}

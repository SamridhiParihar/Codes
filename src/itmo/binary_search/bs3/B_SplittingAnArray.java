package itmo.binary_search.bs3;

import java.util.Scanner;

public class B_SplittingAnArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong();
        long[]arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        long l=0, r=0;
        for(long ele: arr){
            l = Math.max(l,ele);
            r+=ele;
        }
        l--;
        r++;
        while (r>l+1){
            long m = (l+r)/2;
            if(good(m,arr,k)) r=m;
            else l =m;
        }
        System.out.println(r);
    }
    public static boolean good(long m ,long[]arr, long k ){
        long res =1;
        long total =0;
        for (long l : arr) {
            total += l;
            if (total > m) {
                res++;
                total = l;
            }
        }
        return res<=k;

    }
}

package itmo.binary_search.bs2;

import java.util.Scanner;

public class G_StudentCouncils {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int[]arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }
        long l=0,r=(long)25e10+1;
        while(r>l+1){
            long m = l+(r-l)/2;
            if(good(arr,m,k)) l=m;
            else r =m;
        }
        System.out.println(l);
    }
    public static boolean good(int[]arr, long m , int k){
        long total =0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(arr[i]>m) total+=m;
            else total+=arr[i];
        }
        return ( total/m )>=k;
    }
}

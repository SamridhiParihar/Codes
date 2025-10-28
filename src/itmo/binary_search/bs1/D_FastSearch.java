package itmo.binary_search.bs1;

import java.util.Arrays;
import java.util.Scanner;

public class D_FastSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[]arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }
        Arrays.sort(arr);
        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int temp_a = closestToRight(arr,a);
            int temp_b = closestToLeft(arr,b);
            int ans = temp_b-temp_a+1;
            System.out.println(ans);
        }
    }
    public static int closestToLeft(int[]arr , int target){
        int n = arr.length;
        int l =-1,r = n;
        while (r>l+1){
            int m = l+(r-l)/2;
            if(arr[m]<=target) l=m;
            else r=m;
        }
        return l;
    }
    public static int closestToRight(int[]arr, int target){
        int n = arr.length;
        int l=-1,r = n;
        while (r>l+1){
            int m = l+(r-l)/2;
            if(arr[m]<target)l=m;
            else r=m;
        }
        return r;
    }
}

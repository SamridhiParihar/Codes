package itmo.binary_search.bs1;

import java.util.Scanner;

public class C_ClosestToRight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[]arr = new int[n];
        int[] que = new int[k];
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            que[i]=in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            int temp = (closestToRight(arr,que[i]));
            int ans = (temp!=-1)?temp+1:0;
            System.out.println(ans);
        }
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

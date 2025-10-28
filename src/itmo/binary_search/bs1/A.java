package itmo.binary_search.bs1;

import java.util.Scanner;

public class A {
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
            System.out.println(fun(arr,que[i]));
        }


    }
    public static String fun(int[]arr, int target){
        int n = arr.length;
        int s =0, e = n-1;
        while (e>=s){
            int mid = s+(e-s)/2;
            if(arr[mid]==target){
                return "YES";
            }
            else if(arr[mid]<target){
                s=mid+1;
            }
            else {
                e =mid-1;
            }
        }
        return "NO";
    }
}

package itmo.binary_search.bs2;

import java.util.Arrays;
import java.util.Scanner;

public class F_StringGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String t = in.next();
        String p = in.next();
        int[] arr = new int[t.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

            int l =0,r = 200000+1;
            while (r>l+1){
                int m = l+(r-l)/2;
                if(good(m,arr,t,p)) l=m;
                else r =m;
            }
            System.out.println(l);

//        String  t = "ababcba";
//        String p = "abb";
//        int[]arr = {5,3,4,1,7,6,2};
//        System.out.println(good(4,arr,t,p));


    }
    public static boolean good(int m, int[]arr, String t , String p){
        if(m>t.length()) return false;
        int n = arr.length;
        boolean[] check = new boolean[n];
        Arrays.fill(check,true);
        for (int i = 0; i < m; i++) {
            check[arr[i]-1] = false;
        }
        boolean[] real = new boolean[p.length()];
        Arrays.fill(real,false);
        int ind = n-1;
        for(int j = p.length()-1; j>=0; j--){
            char ch = p.charAt(j);
            for (int i = ind; i >=0 ; i--) {
                if(check[i]&& t.charAt(i)==ch){
                    check[i] = false;
                    real[j] = true;
                    ind = i-1;
                    break;
                }
            }
        }
        for(boolean val: real){
            if(!val) return false;
        }
        return true;
    }
}

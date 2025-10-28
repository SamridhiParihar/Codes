package contest.c8;

import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.Set;

public class D_Retaliation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int[]arr = new int[n+1];
            for (int i = 0; i <n; i++) {
                arr[i] = in.nextInt();
            }
//            System.out.println(arr[0]+" "+arr[1]);
            if(((2*arr[0])-arr[1])%(n+1)!=0) {
                System.out.println("No");
                continue;
            }
            if(((1-n)*arr[0]+arr[1]*n)%(n+1)!=0){
                System.out.println("No");
                continue;
            }
            int k2 = ((2*arr[0])-arr[1])/(n+1);
            int k1 = ((1-n)*arr[0]+arr[1]*n)/(n+1);
            if(k1<0 || k2<0) {
                System.out.println("No");
                continue;
            }
//            System.out.println(k1+" "+k2);
            boolean flag = true;
            for(int i=0; i<n ; i++){
                int val = (i+1)*(k1-k2) + (n+1)*k2;
                if(val!=arr[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println("Yes");
            else System.out.println("No");

        }
    }




}

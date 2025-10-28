package contest.c2;

import java.util.Scanner;

public class A_Only_One_Digit_Number {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int ele = in.nextInt();
                int res = Integer.MAX_VALUE;
                while(ele!=0){
                    res = Math.min(res,ele%10);
                    ele/=10;
                }
            System.out.println(res);
        }
    }
}

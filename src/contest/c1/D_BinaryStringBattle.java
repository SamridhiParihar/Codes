package contest.c1;

import java.util.Scanner;

public class D_BinaryStringBattle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();
            int one =0, zero =0;
            for(char ch: s.toCharArray()){
                if(ch=='0') zero++;
                else one++;
            }
            if(k>=one || k>n/2) System.out.println("Alice");
            else{
                System.out.println("Bob");
            }
        }
    }
}

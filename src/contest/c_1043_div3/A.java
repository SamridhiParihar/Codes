package contest.c_1043_div3;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            StringBuilder a = new StringBuilder(in.next());
            int m = in.nextInt();
            String b = in.next();
            String c = in.next();

            for(int i=0; i<m; i++){
                if(c.charAt(i)=='D') a.append(b.charAt(i));
                else a.insert(0, b.charAt(i));
            }
            System.out.println(a.toString());

        }
    }
}

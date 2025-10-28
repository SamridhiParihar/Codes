package contest.c4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B_AboveTheClouds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            String s = in.next();
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(0));
            set.add(s.charAt(s.length()-1));
            boolean flag = false;
            for(int i=1; i<n-1; i++){
                char ch = s.charAt(i);
                if(set.contains(ch)){
                    flag = true;
                    break;
                }
                else set.add(ch);
            }
            if(flag) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}

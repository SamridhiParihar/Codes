package contest.c2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C_I_Will_Definitely_Make_It {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[]arr = new int[n];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                pq.add(arr[i]);
            }
            int ele = arr[k-1];
            while (pq.peek()!=ele){
                pq.poll();
            }
            int prev = pq.poll();
            boolean flag = true;
            int wl = 1;
            while (!pq.isEmpty()){
                int curr = pq.poll();
                int hd = Math.abs(curr-prev);
                if(hd<=(prev-wl+1)) {
                    prev = curr;
                    wl+=hd;
                    continue;
                }
                else{
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}

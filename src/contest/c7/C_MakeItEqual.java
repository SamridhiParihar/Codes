package contest.c7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C_MakeItEqual {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tt = in.nextInt();
        for (int test = 0; test < tt; test++) {
            int n  = in.nextInt();
            int k = in.nextInt();
            int[]s = new int[n];
            int[]t = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                t[i] = in.nextInt();
            }

            Map<Integer,Integer> mapA= new HashMap<>();
            Map<Integer,Integer> mapB = new HashMap<>();
            for (int i = 0; i < n; i++) {

                t[i] = Math.min((t[i]%k),Math.abs((t[i]%k) - k )%k);
                mapA.put(t[i], mapA.getOrDefault(t[i],0)+1);

                s[i] = Math.min((s[i]%k),Math.abs((s[i]%k) - k )%k);
                mapB.put(s[i],mapB.getOrDefault(s[i],0)+1);
            }

            boolean flag = true;
            for(Map.Entry<Integer,Integer> e: mapA.entrySet()){
                int key = e.getKey();
                int val = e.getValue();
                if(!mapB.containsKey(key) || mapB.get(key)!=val) {
                    flag = false;
                    break;
                }
//                mapA.remove(key);
//                mapB.remove(key);
            }
//            flag = (mapA.isEmpty() && mapB.isEmpty());

            if(flag) System.out.println("Yes");
            else System.out.println("No");


        }
    }
}

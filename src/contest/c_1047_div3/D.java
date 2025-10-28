package contest.c_1047_div3;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            long[]arr = new long[n];
            Map<Long,Long> map = new HashMap<>();
            Map<Long,List<Integer>> map2 = new HashMap<>();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
                map2.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
                map.put(arr[i],map.getOrDefault(arr[i],0L)+1);
            }
            for(Map.Entry<Long,Long> e: map.entrySet()){
                long key = e.getKey();
                long value = e.getValue();
                sum+=((ceilDiv(value,key))*key);
            }
            if(sum!=n) System.out.println(-1);
            else {
                long val = 1;
                int ind =0;
                long [] ans = new long[n];
                for(Map.Entry<Long,Long>e:map.entrySet()){
                    long key = e.getKey();
                    long value = e.getValue();
                    long ceil = ceilDiv(value,key);
                    List<Integer> list = map2.get(key);
                    int cnt =0;
                    for(int ele: list){
                        cnt++;
                        if(cnt>key){
                            val++;
                            cnt = 1;
                        }
                        ans[ele] = val;
                    }
                    val++;
                }
                for (int i = 0; i < ans.length; i++) {
                    System.out.print(ans[i]+" ");
                }
                System.out.println();
            }
        }
    }
    static long ceilDiv(long a, long b) {
        return (a + b - 1) / b;  // works when a >= 0 and b > 0
    }

}

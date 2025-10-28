package contest.c4;

import java.util.*;

public class C_ThoseWhoAreWithUs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int nr =0, nc =0;
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][]arr = new int[n][m];
            int res = 1;
            int total =0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = in.nextInt();
                    res = Math.max(res,arr[i][j]);
                }
            }
            Set<Integer> setr = new HashSet<>();
            Set<Integer> setc = new HashSet<>();
            Map<Integer,Integer> rows = new HashMap<>();
            Map<Integer,Integer> cols = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j]==res){
                        total++;
                        setr.add(i);
                        setc.add(j);
                        rows.put(i,rows.getOrDefault(i,0)+1);
                        cols.put(j,cols.getOrDefault(j,0)+1);
                    }
                }
            }
            boolean flag = false;
            for(int row : setr){
                for(int col : setc){
                    int val = rows.get(row)+cols.get(col);
                    if(arr[row][col]==res) val --;
                    if(val==total){
                        flag = true;
                        break;
                    }
                }
            }
            if(flag) System.out.println(res-1);
            else System.out.println(res);


        }
    }
    public static boolean fun(int[][]check , int res){
        for (int[] booleans : check) {
            for (int j = 0; j < check[0].length; j++) {
                if (booleans[j] == res) return true;
            }
        }
        return false;
    }
}

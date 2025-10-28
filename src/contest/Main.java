package contest;

import java.util.Arrays;

public class Main {
    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==-1 || grid[n-1][m-1]==-1) return 0;
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]!=-1){
                    int left = 0, up  = 0;
                    if(i-1>=0 ) up = dp[i-1][j];
                    if(j-1>=0) left = dp[i][j-1];
                    dp[i][j] = Math.max(left,up)+grid[i][j];
                    grid[i][j]=0;
                }
            }
        }
        if(dp[n-1][m-1]==0) return -1;
        int[][]dp2 = new int[n][m];
        System.out.print(dp[n-1][m-1]);
        dp2[n-1][m-1] = dp[n-1][m-1];
        System.out.print(dp[n-1][m-1]);
        System.out.print(Arrays.deepToString(dp));
        for(int i=n-1; i>=0 ;i--){
            for(int j=m-1; j>=0 ;j--){
                if(i==n-1 && j==m-1)continue;
                if(grid[i][j]!=-1){
                    int right = 0, down = 0;
                    if(i+1<n) down = dp2[i+1][j];
                    if(j+1<m) right = dp2[i][j+1];
                    dp2[i][j] = Math.max(down,right)+grid[i][j];
                }
            }
        }
        System.out.println();
        System.out.println(Arrays.deepToString(dp2));
        return dp2[0][0];
    }

    public static void main(String[] args) {
        int[][]arr = {
                {0,1,-1},
                {1,0,-1},
                {1,1,1}
        };
    }
}

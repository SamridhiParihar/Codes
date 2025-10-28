package graph.shortestpath;
/*
    -- here we will be finding shortest path from every node to every other node
    -- similar to bellmanFord if you have undirected graph just split it and convert it into directed
    -- idea : for every node go via every other node and then cal min
       minimum ( d[i][k]+ d[k][j] )
    -- we will store this in adj matrix
    -- for cycle detection just check if there is any dis[i][i]<0 (For i=0 to n) , if yes then there
       cycle present
* */
public class FloydWarshall {
    public static void main(String[] args) {

    }
    public void fun(int[][]matrix){
        int n = matrix.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==-1) matrix[i][j] = (int)(1e9);
                if(i==j) matrix[i][j]=0;
            }
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][via]+matrix[via][j]);
                }
            }
        }
    }
}
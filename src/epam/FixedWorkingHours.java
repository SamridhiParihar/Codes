package epam;

public class FixedWorkingHours {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int k =4;
        System.out.println(searchMatrix(matrix,k));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int r = 0 , c = m-1;
        while(r<n && c>=0){
            if(matrix[r][c]==target)return true;
            else if(matrix[r][c]< target) r++;
            else c--;
        }
        return false;
    }


}

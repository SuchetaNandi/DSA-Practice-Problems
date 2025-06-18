package DP;

public class UniquePaths2 {
    public static int uniquePaths(int[][] matrix){
        int m= matrix.length;
        int n= matrix[0].length;

        if(matrix[0][0]==1 || matrix[m-1][n-1]==1){
            return 0;
        }
        int dp[][]= new int[m][n];
        dp[0][0]=1;

        for(int j=1; j<n; j++){
            if(matrix[0][j]==1){
                dp[0][j]= 0;
            }
            else{
                dp[0][j]= dp[0][j-1];
            }
        }

        for(int i=1; i<m; i++){
            if(matrix[i][0]==1){
                dp[i][0]= 0;
            }
            else{
                dp[i][0]= dp[i-1][0];
            }
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j]==1){
                    dp[i][j]= 0;
                }
                else{
                    dp[i][j]= dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
    public static void main(String args[]){
        int mat[][]= {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };

        System.out.println(uniquePaths(mat));
    }
}

package DP;

import java.util.*;
public class MaxPathSum {
    //Memoization
    public static int maxSumM(int [][] grid, int [][] mem, int i, int j){
        if(j>=grid[0].length || j<0){
            return Integer.MIN_VALUE;
        }
        if(i==0){
            return grid[i][j];
        }
        if(mem[i][j]!= -1){
            return grid[i][j];
        }
        
        int up= maxSumM(grid, mem, i-1, j);
        int left= maxSumM(grid, mem, i-1, j-1);
        int right= maxSumM(grid, mem, i-1, j+1);

        mem[i][j]= grid[i][j]+ Math.max(up, Math.max(left, right));
        return mem[i][j];
    }

    //Tabulation
    public static int maxSumT(int[][] grid){
        int m= grid.length;
        int n= grid[0].length;
        int dp[][]= new int[m][n];

        for(int i=0; i<n; i++){
            dp[0][i]= grid[0][i];
        }

        for(int i=1; i<m; i++){
            for(int j=0; j< n; j++){
                int left=0, right=0;
                int down= grid[i-1][j];
                if(j>0){
                    left=grid[i-1][j-1];
                }
                if(j<n-1){
                    right= grid[i-1][j+1];
                }
                
                dp[i][j]= grid[i][j]+Math.max(down, Math.max(left, right));
            }
        }

        int maxSum= Integer.MIN_VALUE;
        for(int i=0; i< n; i++){
            int ans= dp[m-1][i];

            if(ans> maxSum){
                maxSum= ans;
            }
        }

        return maxSum;
    }
    public static void main(String args[]){
        int[][] grid= {
            {1, 2, 3},
            {4, 5, 6}
        };

        int mem[][]= new int[grid.length][grid[0].length];
        for(int[] i: mem){
            Arrays.fill(i, -1);
        }
        int maxSum= Integer.MIN_VALUE;
        for(int i= 0; i<grid[0].length; i++){
            int ans= maxSumM(grid, mem, grid.length-1, i);
            if(ans>maxSum){
                maxSum= ans;
            }
        }
        System.out.println(maxSum);

        System.out.println(maxSumT(grid));
    }
}

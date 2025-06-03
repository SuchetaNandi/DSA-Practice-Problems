package DP;

import java.util.*;
public class MinPathSum {
    public static int minPathSumM(int[][] grid, int i, int j, int[][] mem){
        if(i<0||j<0){
            return Integer.MAX_VALUE;
        }
        if (i==0 && j==0) {
            return grid[0][0];
        }
        if(mem[i][j]!=-1){
            return mem[i][j];
        }

        int up= minPathSumM(grid, i-1, j, mem);
        int left= minPathSumM(grid, i, j-1, mem);

        mem[i][j]= grid[i][j] + Math.min(up, left);
        return mem[i][j];
    } 

    /* error
    public static int minPathSumT(int [][]grid, int m, int n){
        int [][] dp= new int[m][n];
        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                if(i==0&& j==0){
                    dp[i][j]= grid[i][j];
                }
                else{
                    int up=0, left=0;
                    if(i>0){
                        up=  dp[i-1][j];
                    }
                    if(j>0){
                        left=dp[i][j-1];
                    }
                    dp[i][j]= Math.min(up, left)+ grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
    */
    public static void main(String args[]){
        int[][] grid= {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        int mem[][]= new int[grid.length][grid[0].length];
        for(int i=0; i< grid.length; i++){
            Arrays.fill(mem[i], -1);
        }
        System.out.println(minPathSumM(grid, grid.length-1, grid[0].length-1, mem));

        //System.out.println(minPathSumT(grid, grid.length-1, grid[0].length-1));
    }
}

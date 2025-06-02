package DP;

import java.util.*;
public class TotalUniquePaths{
    //Memoization
    public static int totalUniquePathsM( int[][] mem, int i, int j){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0||j<0){
            return 0;
        }
        if(mem[i][j]!= -1){
            return mem[i][j];
        }
        int up= totalUniquePathsM( mem, i-1, j);
        int left= totalUniquePathsM( mem, i, j-1);

        mem[i][j]= up+left;
        return mem[i][j];
    }

    //Tabulation
    public static int totalUniquePathsT( int i, int j){
        int[][] dp= new int[i][j];

        for(int a=0; a<i;a++){
            for (int b=0; b<j; b++){
                if(a==0 && b==0){
                    dp[a][b]= 1;
                }
                else{
                    int up=0;
                    int left=0;
                    if(a>0){
                        up= dp[a-1][b];
                    }
                    if(b>0){
                        left= dp[a][b-1];
                    }
                    dp[a][b]= up+left;
                } 
            }
        }

        return dp[i-1][j-1];
    }

    // Space Optimization
    public static int totalUniquePathsSO(int i, int j){
        int[] prev= new int[j];
        for(int a=0;a<i; a++){
            int[] curr= new int[j];
            for(int b=0; b< j; b++){
                if(a==0 && b==0){
                    curr[b]=1;
                }
                else{
                    int up=0;
                    int left= 0;
                    if(a>0){
                        up=prev[b];
                    }
                    if(b>0){
                        left= curr[b-1];
                    }
                    curr[b]= up+left;
                }
            }
            prev= curr;
        }
        return prev[j-1];
    }
    public static void main(String args[]){
        int mem[][]= new int[3][7];
        for(int i=0; i<3;i++){
            Arrays.fill(mem[i], -1);
        }
        System.out.println(totalUniquePathsM(mem, 2, 6));

        System.out.println(totalUniquePathsT(3, 7));

        System.out.println(totalUniquePathsSO(3, 7));
    }
}

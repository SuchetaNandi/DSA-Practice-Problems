package DP;

import java.sql.Array;
import java.util.*;
public class FrogJumpKSteps {
    // Memoization
    public static int minEnergyM(int height[], int k, int n, int[] mem){
        if(n==0){
            return 0;
        }
        if(mem[n] != -1){
            return mem[n];
        }

        int minCost= Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
            if(n-i>=0){
                int jumpCost= minEnergyM(height, k, n-i, mem)+ Math.abs(height[n]- height[n-i]);
                minCost= Math.min(minCost, jumpCost);
            }
        }
        mem[n]= minCost;
        return mem[n];
    }

    //Tabulation
    public static int minEnergyT(int height[], int n, int k){
        int dp[]= new int [n];
        dp[0]= 0;

        for(int i=1; i<n; i++){
            dp[i]= Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                if(i-j>=0){
                    int jumpCost= dp[i-j]+ Math.abs(height[i]- height[i-j]);
                    dp[i]= Math.min(jumpCost, dp[i]);
                }
            }
        }
        return dp[n-1];
    }

    public static void main(String args[]){
        int[] height= {10, 20, 30, 10, 20};
        int k=3;

        int[] mem= new int[height.length];
        Arrays.fill(mem, -1);
        System.out.println(minEnergyM(height, k, height.length-1, mem));

        System.out.println(minEnergyT(height, height.length, k));
    }
}

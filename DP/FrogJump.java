package DP;

import java.util.*;
public class FrogJump {

    // Tabulation
    public static int minEnergy(int height[], int n){
        if(n==0){
            return 0;
        }

        int dp[]= new int[n];
        dp[0]=0;
        dp[1]= Math.abs(height[1]-height[0]);

        for(int i=2; i<n; i++){
            int jump1= dp[i-1] + Math.abs(height[i]- height[i-1]);
            int jump2= dp[i-2] + Math.abs(height[i]- height[i-2]);
            dp[i]= Math.min(jump1, jump2);
        }

        return dp[n-1];
    }

    // Memoization
    public static int minE(int height[], int n, int[] mem){
        if(n==0){
            return 0;
        }
        if(n==1){
            return Math.abs(height[1]- height[0]);
        }

        if(mem[n]!= -1){
            return mem[n];
        }

        int jump1= minE(height, n-1, mem)+ Math.abs(height[n]- height[n-1]);
        int jump2= minE(height, n-2, mem)+ Math.abs(height[n]- height[n-2]);

        mem[n]= Math.min(jump1, jump2);
        return mem[n];
    }

    // Space Optimized
    public static int minEnergyOp(int[] height, int n){
        if(n==0){
            return 0;
        }
        int prev2= 0;
        int prev= Math.abs(height[n]- height[n-1]);

        for(int i=0;i<n; i++){
            int jump1= prev+ Math.abs(height[n]- height[n-1]);
            int jump2= prev2+ Math.abs(height[n]- height[n-2]);
            int curr= Math.min(jump1, jump2);

            prev2= prev;
            prev= curr;
        }

        return prev;
    }

    public static void main(String args[]){
        int height[]= {10, 20, 30, 10};
        System.out.println(minEnergy(height, height.length));

        int mem[]= new int[height.length];
        Arrays.fill(mem, -1);
        System.out.println(minE(height, height.length-1, mem));

        System.out.println(minEnergyOp(height, height.length-1));
    }
}

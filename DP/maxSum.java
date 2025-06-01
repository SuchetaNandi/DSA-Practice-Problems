package DP;

import java.util.*;
// Finding the maximum sum of non adjacent elements in an array
public class maxSum {
    // Memoization
    public static int maxSumM(int arr[], int[] mem, int i){
        if(i==0){
            return arr[i];
        }
        if(i<0){
            return 0;
        }
        if(mem[i]!= -1){
            return mem[i];
        }

        int pick= arr[i]+ maxSumM(arr, mem, i-2);
        int notPick= maxSumM(arr, mem, i-1);
        mem[i]= Math.max(pick, notPick);

        return mem[i];
    }
    //Tabulation
    public static int maxSumT(int arr[]){
        int dp[]= new int[arr.length];

        if(arr.length==0){
            return 0;
        }
        if(arr.length==1){
            return arr[0];
        }
        dp[0]= arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i=2; i<arr.length; i++){
            int pick= arr[i]+ dp[i-2];
            int notPick= dp[i-1];
            dp[i]= Math.max(pick, notPick);
        }

        return dp[arr.length-1];
    }
    public static void main(String args[]){
        int arr[]= {2, 1, 4, 9, 3};
        int[] mem= new int[arr.length];
        Arrays.fill(mem,-1);
        System.out.println(maxSumM(arr, mem, arr.length-1));

        System.out.println(maxSumT(arr));
    }
}

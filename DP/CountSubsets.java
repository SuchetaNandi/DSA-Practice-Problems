package DP;

import java.util.*;
public class CountSubsets {
    //recursion
    public static int countSubsets(int[] arr, int sum, int index){
        if(sum==0){
            return 1;
        }
        if(index==0){
            if(arr[index]==sum){
                return 1;
            }
            else{
                return 0;
            }
        }

        int notPick= countSubsets(arr, sum, index-1);
        int pick= 0;
        if(arr[index]<= sum){
            pick= countSubsets(arr, sum-arr[index], index-1);
        }

        return pick+notPick;
    }

    //memoiaztion
    public static int countSubsetsM(int [] arr, int sum, int index, int[][] mem){
        if(sum==0){
            return 1;
        }
        if(index==0){
            if(arr[index]== sum){
                return 1;
            }
            else{
                return 0;
            }
        }

        if(mem[index][sum]!=-1){
            return mem[index][sum];
        }

        int notPick= countSubsetsM(arr, sum, index-1, mem);
        int pick= 0;
        if(arr[index]<= sum){
            pick= countSubsetsM(arr, sum-arr[index], index-1, mem);
        }

        mem[index][sum]= pick+notPick;

        return mem[index][sum];
    }

    //tabulation
    public static int countSubsetsT(int arr[], int sum, int index){
        int dp[][]= new int[arr.length][sum+1];
        for(int i=0; i< arr.length; i++){
            dp[i][0]= 1;
        }
        if(arr[0]<= sum){
                dp[0][arr[0]]=1;
        }

        for(int i=1; i<arr.length; i++){
            for(int j=0; j<=sum; j++){
                int notPick= dp[i-1][j];
                int pick=0;
                if(arr[i]<= j){
                    pick= dp[i-1][j-arr[i]];
                }
                dp[i][j]= pick+notPick;
            }
        }
        
        return dp[index][sum];
    }
    public static void main(String args[]){
        int []arr={1,2,3,3};
        int k= 6;
        System.out.println(countSubsets(arr, k, arr.length-1));

        int [][] mem= new int[arr.length][k+1];
        for(int i[]: mem){
            Arrays.fill(i, -1);
        }
        System.out.println(countSubsetsM(arr, k, arr.length-1, mem));

        System.out.println(countSubsetsT(arr, k, arr.length-1));
    }
}

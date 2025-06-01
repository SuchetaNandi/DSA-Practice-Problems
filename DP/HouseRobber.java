package DP;

import java.util.Arrays;

// robs from houses not aadjacent to eachother where houses are arranged in circular form
public class HouseRobber {
    public static int maxSum(int arr[]){
        int dp[]= new int[arr.length];
        if(arr.length==0){
            return 0;
        }
        if(arr.length ==1){
            return arr[0];
        }

        dp[0]=arr[0];
        dp[1]= Math.max(arr[0], arr[1]);

        for(int i=2; i< arr.length; i++){
            int pick= arr[i]+ dp[i-2];
            int notpick= dp[i-1];

            dp[i]= Math.max(pick, notpick);
        }

        return dp[arr.length-1];
    }
    public static void main(String args[]){
        int arr[]= {1, 3, 2, 1};
        int first[]= Arrays.copyOfRange(arr, 0,arr.length-1 );
        int last[]= Arrays.copyOfRange(arr, 1, arr.length);

        System.out.println(Math.max(maxSum(first), maxSum(last)));
    }
}

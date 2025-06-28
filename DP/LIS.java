package DP;
// Longest Increasing Subsequence

public class LIS {
    public static int LISlength(int arr[]){
        int dp[]= new int[arr.length];
        if(arr.length==0){
            return 0;
        }
        int maxLen=0;
        for(int i=0; i<arr.length; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    dp[i]= Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen= Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
    public static void main(String args[]){
        int arr[]={5, 8, 3, 7, 9, 1};

        System.out.println(LISlength(arr));
    }
}

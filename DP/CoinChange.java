package DP;

/*You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin. */

import java.util.*;
public class CoinChange {
    public static int cointCount(int coins[], int amount){
        if(amount==0){
            return 0;
        }

        int dp[]= new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=1; i<= amount; i++){
            for(int c:coins){
                if(c<=i && dp[i-c]!= Integer.MAX_VALUE){
                    dp[i]= Math.min(dp[i], dp[i-c]+1);
                }
            }
        }

        if(dp[amount]== Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dp[amount];
        }
    }
    public static void main(String args[]){
        int coins[]= {1, 2, 5};
        int amt= 11;

        System.out.println(cointCount(coins, amt));
    }
}

package DP;

import java.util.*;
public class Fibonacci {
    public static int fiboMemo(int n, int[] mem){
        if(mem[n]!=-1){
            return mem[n];
        }
        if(n<=1){
            return n;
        }
        mem[n]= fiboMemo(n-1, mem)+fiboMemo(n-2, mem);
        return mem[n];
    }

    public static int fiboTabu(int n){
        int[] dp= new int[n+1];
        dp[0]= 0;
        dp[1]= 1;
        for(int i=2; i<=n ; i++){
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String args[]){
        int n=10;
        int[] mem= new int[n+1];
        Arrays.fill(mem, -1);
        System.out.println(fiboMemo(n, mem));
        System.out.println(fiboTabu(n));
    }
}

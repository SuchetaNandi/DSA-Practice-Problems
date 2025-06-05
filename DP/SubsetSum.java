package DP;

import java.util.*;
public class SubsetSum {
    //Recursion
    public static boolean subsetSum(int [] arr, int tar, int i){
        if(tar==0){
            return true;
        }
        if(i==0){
            return (arr[0]==tar);
        }
        boolean notTake= subsetSum(arr, tar, i-1);
        boolean take= false;
        if(arr[i]<= tar){
            take= subsetSum(arr, tar-arr[i], i-1);
        }

        return take||notTake;
    }

    //Memoization
    public static boolean subsetSumM(int [] arr, int tar, int i, boolean mem[][]){
        if(tar==0){
            return true;
        }
        if(i==0){
            return (arr[i]==tar);
        }
        if(mem[i][tar]){
            return mem[i][tar];
        }
        boolean notTake= subsetSumM(arr, tar, i-1, mem);
        boolean take= false;
        if(arr[i]<= tar){
            take= subsetSumM(arr, tar- arr[i], i-1, mem);
        }

        mem[i][tar]= take||notTake;
        return mem[i][tar];
    }
    public static void main(String args[]){
        int [] arr= {3, 34, 4, 12, 5, 2};
        int target= 9;
        System.out.println(subsetSum(arr, target, arr.length-1));

        boolean mem[][]= new boolean[arr.length][target+1];
        for(boolean i[]: mem){
            Arrays.fill(i, false);
        }
        System.out.println(subsetSumM(arr, target, arr.length-1, mem));
    }
}

package Arrays;

import java.util.*;
public class SubarraySumIndexes {
    public static ArrayList<Integer> subarraySum(int[] arr, int target){
        //ArrayList<Integer> result= new ArrayList<>();
        int n= arr.length;
        int dp[][]= new int[n][n];

        for(int i=0; i< n; i++){
            dp[i][i]= arr[i];
        }

        for(int i=0; i< n; i++){
            for(int j=i+1; j<n; j++){
                dp[i][j]= dp[i][j-1]+ arr[j];
            }
        }

        for(int i=0; i< n; i++){
            for(int j= i; j< n; j++){
                if(dp[i][j]== target){
                    return new ArrayList<>(Arrays.asList(i+1, j+1));
                }
            }
        }

        return new ArrayList<>(Arrays.asList(-1));
    }

    // using sliding window
    public static ArrayList<Integer> subarrySumSW(int[] arr, int target){
        int n= arr.length;
        int left= 0;
        int currSum=0;
        
        for(int right=0; right< n; right++){
            currSum+= arr[right];
            
            while(currSum>target && left<= right){
                currSum-= arr[left];
                left++;
            }
            
            if(currSum== target){
                return new ArrayList<>(Arrays.asList(left+1, right+1));
            }
        }
        
        return new ArrayList<>(Arrays.asList(-1));
    }
    public static void main(String args[]){
        int [] arr= {1, 2, 3, 7, 5};
        int target= 12;

        System.out.println(subarraySum(arr, target));
    }
}

package Arrays;

import java.util.*;
public class HeightMinimize {
    public static int minDiff(int arr[], int k){
        int n= arr.length;
        if(n==1){
            return 0;
        }
        Arrays.sort(arr);
        int diff= arr[n-1]- arr[0];

        if(k==0){
            return diff;
        }

        int min= arr[0];
        int max= arr[n-1];

        for(int i=0; i< n-1; i++){
            min= Math.min(arr[0]+k, arr[i+1]-k);
            max= Math.max(arr[i]+k, arr[n-1]-k);
            if(min<0){
                continue;
            }
            diff= Math.min(diff, max-min);
        }

        return diff;
    }
    public static void main(String args[]){
        int arr[]= {3, 9, 12, 16, 20};
        int k=3;

        System.out.println(minDiff(arr, k));
    }
}

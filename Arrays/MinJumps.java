package Arrays;

import java.util.*;
public class MinJumps {
    public static int minJumps(int[]arr){
        if(arr.length<=1){
            return 0;
        }
        if(arr[0]==0){
            return -1;
        }
        int maxReach= arr[0];
        int jumps=1;
        int steps= arr[0];
        for(int i=1; i<arr.length; i++){
            if(i== arr.length-1){
                return jumps;
            }
            maxReach= Math.max(i+arr[i], maxReach);
            steps--;
            if(steps==0){
                jumps++;
                if(i>= maxReach){
                    return -1;
                }
                steps= maxReach-i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int arr[]= {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr));
    }
}

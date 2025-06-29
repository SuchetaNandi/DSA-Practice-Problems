package Arrays;

import java.util.*;
public class JumpGame {
    public static boolean canJump(int arr[]){
        int maxReach=0;
        for(int i=0; i< arr.length; i++){
            if(maxReach<i){
                return false;
            }
            maxReach= Math.max(maxReach, i+arr[i]);
            if(maxReach>= arr.length-1){
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        int arr[]= {2, 3, 1, 1, 4};

        System.out.println(canJump(arr));
    }
}

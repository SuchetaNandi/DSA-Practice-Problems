package Arrays;

import java.util.*;
public class PlatformsNeeded {
    public static int platformsNeeded(int arr[], int dep[]){
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i=1,j=0; 
        int p=1, maxP=1;
        while(i< arr.length && j< dep.length){
            if(arr[i]<=dep[j]){
                i++;
                p++;
                maxP= Math.max(maxP, p);
            }
            else{
                j++;
                p--;
            }
        }

        return maxP;
    }
    public static void main(String args[]){
        int arr[]= {1000, 935, 1100};
        int dep[]= {1200, 1240, 1130};

        System.out.println(platformsNeeded(arr, dep));
    }
}

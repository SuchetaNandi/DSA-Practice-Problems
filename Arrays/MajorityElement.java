package Arrays;

import java.util.*;
public class MajorityElement {
    public static int majorityElement(int arr[]){
        int result= 0;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i:arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(e.getValue()> (arr.length/2)){
                result= e.getKey();
            }
        }

        if(result==0){
            return -1;
        }
        return result;
    }
    public static void main(String arge[]){
        int arr[]= {1, 1, 2, 1, 3, 5, 1};

        System.out.println(majorityElement(arr));
    }
}

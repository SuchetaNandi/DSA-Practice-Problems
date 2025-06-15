package Arrays;

import java.util.*;
public class RotateArray {
    public static void rotate(int []arr, int d){
        List<Integer> list= new ArrayList<>();
        d= d%arr.length;
        for(int i=0; i<d;i++){
            list.add(arr[i]);
        }
        for(int i=d; i< arr.length; i++){
            arr[i-d]= arr[i];
        }
        for(int i= arr.length-d; i<arr.length; i++){
            arr[i]= list.get(i-(arr.length-d));
        }
    }
    public static void main(String args[]){
        int arr[]= {1, 2, 3, 4, 5};
        int d= 2;

        rotate(arr, d);
        System.out.println(Arrays.toString(arr));
    }
}

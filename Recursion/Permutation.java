package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);

        return result;
    }
    public static void backtrack(List<List<Integer>> result, List<Integer> per, int[] nums){
        if(per.size()== nums.length){
            result.add(new ArrayList<>(per));
        }
        for(int i=0; i< nums.length; i++){
            if(!per.contains(nums[i])){
                per.add(nums[i]);
                backtrack(result, per, nums);
                per.remove(per.size()-1);
            }
        }
    }
    public static void main(String args[]){
        int arr[]={1,2,3};

        System.out.println(permute(arr).toString());
    }
}

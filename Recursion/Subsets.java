package Recursion;

import java.util.*;
public class Subsets {
    public static void subsets(String s, String str){
        if(s.isEmpty()){
            System.out.println(str);
            return;
        }
        char c= s.charAt(0);
        subsets(s.substring(1), str+c);
        subsets(s.substring(1), str);
    }
    public static ArrayList<String> subseq(String s, String str){
        if(s.isEmpty()){
            ArrayList<String> list= new ArrayList<>();
            list.add(str);
            return list;   
        }
        char c= s.charAt(0);
        ArrayList<String> left= subseq(s.substring(1), str+c);
        ArrayList<String> right= subseq(s.substring(1), str);

        left.addAll(right);
        return left;
    }

    public static ArrayList<ArrayList<Integer>> subSeqInt(int[] arr, ArrayList<Integer> newArr){
        if(arr.length==0){
            ArrayList<ArrayList<Integer>> res= new ArrayList<>();
            res.add(newArr);
            return res;
        }

        int n= arr[0];

        ArrayList<Integer> newArrEle = new ArrayList<>(newArr);
        newArrEle.add(n);
        ArrayList<ArrayList<Integer>> left= subSeqInt(Arrays.copyOfRange(arr, 1, arr.length), newArrEle);
        ArrayList<ArrayList<Integer>> right= subSeqInt(Arrays.copyOfRange(arr, 1, arr.length), newArr);
        
        left.addAll(right);
        return left;
    }
    public static void main(String args[]){
        subsets("abc", "");

        System.out.println(subseq("abc", ""));

        System.out.println(subSeqInt(new int[]{1,2,3}, new ArrayList<>()));
    }
}

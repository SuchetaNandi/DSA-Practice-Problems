package Recursion;

import java.util.ArrayList;
import java.util.List;

public class ParenthesisAdding {
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result= new ArrayList<>();
        for(int i=0; i< expression.length(); i++){
            char c= expression.charAt(i);
            if(c=='+'|| c=='*'||c=='-'){
                List<Integer> left= diffWaysToCompute(expression.substring(0, i));
                List<Integer> right=diffWaysToCompute(expression.substring(i+1));
                for(int l:left){
                    for(int r:right){
                        if(c=='*'){
                            result.add(l*r);
                        }
                        else if(c=='+'){
                            result.add(l+r);
                        }
                        if(c=='-'){
                            result.add(l-r);
                        }
                    }
                }
            }
        }

        if(result.isEmpty()){
            result.add(Integer.parseInt(expression));
        }

        return result;
    }
    public static void main(String args[]){
        String s= "2*3-4*5";
        System.out.println(diffWaysToCompute(s).toString());
    }
}

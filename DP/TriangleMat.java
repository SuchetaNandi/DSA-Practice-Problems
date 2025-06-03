package DP;

import java.util.*;
public class TriangleMat {
    // Memoization
    public static int minPathM(List<List<Integer>> mat, int [][] mem, int i, int j){
        int n= mat.size();
        if(i== n-1){
            return mat.get(i).get(j);
        }
        if(mem[i][j]!= -1){
            return mem[i][j];
        }

        int down= minPathM(mat, mem, i+1, j);
        int diagonal=  minPathM(mat, mem, i+1, j+1);

        mem[i][j]= Math.min(down, diagonal)+ mat.get(i).get(j) ;
        return mem[i][j];
    }

    //Tabulation
    public static int minPathT(List<List<Integer>> mat){
        int n= mat.size();
        int [][] dp= new int[n][n];

        for(int j=0; j<n-1; j++){
            dp[n-1][j]= mat.get(n-1).get(j);
        }

        for(int i=n-2; i>=0; i--){
            for(int j= i; j>=0; j--){
                int down=dp[i+1][j];
                int diagonal= dp[i+1][j+1];
                dp[i][j]= Math.min(down, diagonal)+ mat.get(i).get(j);
            }
        }

        return dp[0][0];
    }

    public static void main(String args[]){
        List<List<Integer>> mat= Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        );

        int mem[][] = new int[mat.size()][mat.size()];
        for(int []r: mem){
            Arrays.fill(r, -1);
        }

        System.out.println(minPathM(mat, mem, 0, 0));

        System.out.println(minPathT(mat));
    }
}

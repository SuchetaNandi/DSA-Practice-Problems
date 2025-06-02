package DP;

import java.util.*;


public class MazeObstracle {
    public static int mazePath(int [][] maze, int[][] mem, int i, int j){
        if(i>0 && j>0 && maze[i][j]==-1){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        if(i<0||j<0){
            return 0;
        }
        if(mem[i][j]!= -1){
            return mem[i][j];
        }
        int up= mazePath( maze, mem, i-1, j);
        int left= mazePath( maze, mem, i, j-1);

        mem[i][j]= up+left;
        return mem[i][j];
    }
    public static void main(String args[]){
        int maze[][] = {
            {0, 0, 0},
            {0, -1, 0},
            {0, 0, 0}
        };
        int mem[][]= new int[3][3];
        for(int i=0; i<3;i++){
            Arrays.fill(mem[i], -1);
        }
        System.out.println(mazePath(maze, mem, 2,2));
    }
}

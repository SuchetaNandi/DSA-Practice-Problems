package Arrays.Maze;

/*Consider a rat placed at position (0, 0) in an n x n square matrix mat[][]. The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

The matrix contains only two possible values:

0: A blocked cell through which the rat cannot travel.
1: A free cell that the rat can pass through.
Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
If no path exists, return an empty list. */

import java.util.*;
public class RatInMaze {
    public static ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> result= new ArrayList<>();
        if(maze[maze.length-1][maze.length-1]==0 || maze[0][0]==0){
            return result;
        }
        boolean vis[][]= new boolean[maze.length][maze.length];
        traverse(result, "", maze, vis, 0, 0);
        
        return result;
        
    }
    public static void traverse(ArrayList<String> result, String path, int[][] maze, boolean[][] vis, int i, int j){
        int directions[][]= {{1, 0},{0, -1}, {0, 1}, {-1, 0}};
        String dirChar[]= {"D", "L", "R", "U"};
        vis[i][j]= true;
        int n= maze.length;
        if(i==n-1 && j==n-1){
            result.add(path);
            return;
        }
        
        for(int k=0; k<directions.length; k++){
            int nr= directions[k][0]+i;
            int nc= directions[k][1]+j;
            if(nr>=0 && nc>=0 && nr<n &&nc<n && !vis[nr][nc] && maze[nr][nc]!=0){
                traverse(result, path+ dirChar[k], maze, vis, nr, nc);
                vis[nr][nc]= false;
            }
        }
    }
    public static void main(String args[]){
        int[][] maze={
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        System.out.println(ratInMaze(maze).toString());
    }
}

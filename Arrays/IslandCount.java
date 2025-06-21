package Arrays;

import java.util.*;
public class IslandCount {
    public static int numIslands(char[][] grid) {
        if(grid.length==0 || grid== null){
            return 0;
        }
        int island=0;
        int rows= grid.length;
        int cols= grid[0].length;
        boolean vis[][]= new boolean[rows][cols];
        for(int i=0; i< rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1'&&!vis[i][j]){
                    bfs(grid, i, j, vis);
                    island++;
                }
            }
        }

        return island;
    }
    public static void bfs(char[][] grid, int row, int col, boolean vis[][]){
        int rows= grid.length;
        int cols= grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{row, col});
        vis[row][col]= true;

        int[][] direction= {{1,0}, {-1,0}, {0, 1}, {0,-1}};

        while(!q.isEmpty()){
            int []curr= q.poll();
            for(int d[]: direction){
                int newRow= curr[0]+d[0];
                int newCol= curr[1]+d[1];

                if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && grid[newRow][newCol]=='1' && !vis[newRow][newCol]){
                    q.offer(new int[]{newRow, newCol});
                    vis[newRow][newCol]= true;
                }
            }
        }
    }
    public static void main(String args[]){
        char grid[][]= {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            { '0', '0','1', '0', '0'},
            { '0', '0','0', '1', '1'}
        };

        System.out.println(numIslands(grid));
    }
}

package DP;

//A ninja trains for N days, performing one of three tasks each day (Task 0, Task 1, or Task 2). Each task gives points, and the ninja cannot perform the same task on consecutive days. The goal is to find the maximum points achievable over N days.

import java.util.*;
public class NinjaTraining {

    // Memoization
    public static int ninjaTraining(int day, int task, int[][] mem, int[][] points){
        if(day==0){
            return points[0][task];
        }
        if (mem[day][task] !=-1) {
            return mem[day][task];
        }
        int maxPts=0;
        for(int i=0; i<3; i++){
            if(task!=i){
                int currPts= points[day][task]+ ninjaTraining(day-1, i, mem, points);
                maxPts= Math.max(maxPts, currPts);
            }
        }

        mem[day][task] = maxPts;
        return maxPts;
    }

    // Tabulation
    public static int ninjaTrainingT(int [][] points){
        if(points.length==0){
            return 0;
        }

        int [][] dp= new int[points.length][3];

        dp[0][0]= points[0][0];
        dp[0][1]= points[0][1];
        dp[0][2]= points[0][2];

        for(int i=1; i< points.length; i++){
            dp[i][0]= points[i][0]+ Math.max(dp[i-1][1], dp[i-1][2]);
            dp[i][1]= points[i][1]+ Math.max(dp[i-1][0], dp[i-1][2]);
            dp[i][2]= points[i][2]+ Math.max(dp[i-1][0], dp[i-1][1]);
        }
        return Math.max(dp[points.length-1][0], Math.max(dp[points.length-1][1], dp[points.length-1][2]));
    }
    public static void main(String[] args) {
        int[][] points={
            {1,2,5},
            {3,1,1},
            {3,3,3}
        };

        int mem[][]= new int[points.length][3];
        for(int[] row: mem){
            Arrays.fill(row, -1);
        }
        // Maximum of all the 3 tasks
        System.out.println(Math.max(ninjaTraining(points.length-1, 0, mem, points), Math.max(ninjaTraining(points.length-1, 1, mem, points), ninjaTraining(points.length-1, 2, mem, points))));

        System.out.println(ninjaTrainingT(points));
    }
}

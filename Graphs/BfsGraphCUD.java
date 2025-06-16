package Graphs;

import java.util.*;
public class BfsGraphCUD {
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> res= new ArrayList<>();
        if(adj.size()==0){
            return res;
        }

        Queue<Integer> q= new LinkedList<>();
        boolean vis[]= new boolean[adj.size()];

        q.offer(0);
        vis[0]= true;

        while(!q.isEmpty()){
            int curr= q.poll();
            res.add(curr);

            for(int i: adj.get(curr)){
                if(!vis[i]){
                    vis[i]= true;
                    q.offer(i);
                }
            }
        }

        return res;
    }
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> adjList= new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).addAll(Arrays.asList(2, 3, 1));
        adjList.get(1).addAll(Arrays.asList(0));
        adjList.get(2).addAll(Arrays.asList(0, 4));
        adjList.get(3).addAll(Arrays.asList(0));
        adjList.get(4).addAll(Arrays.asList(2));

        ArrayList<Integer> result= new ArrayList<>();
        result= bfs(adjList);

        System.out.println(result.toString());
    }
}

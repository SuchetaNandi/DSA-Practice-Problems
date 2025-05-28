package Graphs;

import java.util.*;

public class GraphUDW {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src= s;
            this.dest= d;
            this.wt= w;
        }
    } 

    // undirected weighted graph
    public static void createGraph(ArrayList<Edge> graph[]){
        // we initialize elements of graph to an empty arraylist as it is null by default which might throw error
        for(int i=0; i<4; i++){
            graph[i]= new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,2,2));

        graph[1].add(new Edge(1,2,10));
        graph[1].add(new Edge(1,3,0));

        graph[2].add(new Edge(2,0,2));
        graph[2].add(new Edge(2,1, 10));
        graph[2].add(new Edge(2,3,-1));

        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,2,-1));
    }

    public static void main(String args[]){
        int V=4;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);

        //printing the neighbours of 2
        for(int i=0; i< graph[2].size(); i++){
            Edge e= graph[2].get(i);
            System.out.println(e.dest+", "+e.wt);
        }
    }
}


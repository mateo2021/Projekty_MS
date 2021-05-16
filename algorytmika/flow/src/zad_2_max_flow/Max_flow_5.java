/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad_2_max_flow;

import java.util.LinkedList;

/**
 *
 * @author Mateusz Stadnicki
 */
public class Max_flow_5 {
     static final int V = 5;

    boolean bfs(int rGraph[][], int s, int t, int parent[]) {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; ++i)
            visited[i] = false;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;
        // Funkcja BFS
        while (queue.size() != 0) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (visited[v] == false && rGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }

            }
        }

        return (visited[t] == true);
    }

    int fordFulkerson(int graph[][], int s, int t) {
        LinkedList<Integer> object = new LinkedList<Integer>();
        int u, v;
        int rGraph[][] = new int[V][V];
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];


        int parent[] = new int[V];

        int max_flow = 0;

        while (bfs(rGraph, s, t, parent)) {

            int path_flow = Integer.MAX_VALUE;

            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
                object.add(path_flow);
            }

            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }
            int zysk = (object.get(0) - path_flow) + (object.get(1) - path_flow)+13;
            object.remove(2);
            max_flow += path_flow;

            System.out.println("modyfikowane kanały" + object);
            System.out.println("Zysk w metrach to : " + zysk);
            System.out.println("Zysk w  zł :" + " " + zysk * 10 * 18);
            
            System.out.println("max_flow : " + max_flow);
        }
        
        return max_flow; 
    
}
    
}
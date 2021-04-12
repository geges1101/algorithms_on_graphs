//package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {
        int[] visited = new int[adj.length];
        int[] previous = new int[adj.length];
        for (int i = 0; i < adj.length; i++) {
            if (visited[i] == 0) {
                if (dfs(adj, i, visited, previous) == 1)
                    return 1;
            }
        }
        return 0;
    }

    private static int dfs(ArrayList<Integer>[] adj, int x, int[] visited, int[] previous) {
        visited[x] = 1;
        previous[x] = 1;
        for (int i = 0; i < adj[x].size(); i++) {
            if (visited[adj[x].get(i)] == 0 && dfs(adj, adj[x].get(i), visited, previous) == 1)
                return 1;
            else if(previous[adj[x].get(i)] == 1)
                return 1;
        }
        previous[x] = 0;
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }
}

package BarkingDog_Cicle2.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1260 {
    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);
        int V = Integer.parseInt(ip[2]);

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            ip = br.readLine().split(" ");
            int u = Integer.parseInt(ip[0]);
            int v = Integer.parseInt(ip[1]);

            lists.get(u).add(v);
            lists.get(v).add(u);
        }

        sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            Collections.sort(lists.get(i));
        }

        visited = new boolean[N+1];
        DFS(V);

        sb.append("\n");

        visited = new boolean[N+1];
        BFS(V);

        System.out.println(sb);
    }
    static void DFS(int x) {
        if (!visited[x]) visited[x] = true;

        sb.append(x + " ");

        for (int i = 0; i < lists.get(x).size(); i++) {
            if (!visited[lists.get(x).get(i)]) {
                DFS(lists.get(x).get(i));
            }
        }
    }

    static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now + " ");
            for (int i = 0; i < lists.get(now).size(); i++) {
                if (!visited[lists.get(now).get(i)]) {
                    visited[lists.get(now).get(i)] = true;
                    queue.offer(lists.get(now).get(i));
                }
            }
        }
    }
}

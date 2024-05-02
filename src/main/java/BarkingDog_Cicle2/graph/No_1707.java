package BarkingDog_Cicle2.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_1707 {
    static List<List<Integer>> lists;
    static boolean[] visited;
    static boolean isEven;
    static int[] group;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        for (int t = 0; t < K; t++) {
            String[] ip = br.readLine().split(" ");

            int V = Integer.parseInt(ip[0]);
            int E = Integer.parseInt(ip[1]);

            lists = new ArrayList<>();

            for (int i = 0; i <= V; i++) {
                lists.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                ip = br.readLine().split(" ");

                int u = Integer.parseInt(ip[0]);
                int v = Integer.parseInt(ip[1]);

                lists.get(u).add(v);
                lists.get(v).add(u);
            }

            visited = new boolean[V+1];
            group = new int[V+1];
            isEven = true;
            for (int i = 1; i <= V; i++) {
                if (!visited[i]) {
                    BFS(i);
                }
            }

            if (isEven) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb);
    }
    static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        visited[x] = true;
        queue.offer(x);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int target : lists.get(now)) {
                if (!visited[target]) {
                    visited[target] = true;
                    group[target] = (group[now] + 1) % 2;
                    queue.offer(target);
                } else if (group[now] == group[target]) {
                    isEven = false;
                    return;
                }
            }
        }
    }
}

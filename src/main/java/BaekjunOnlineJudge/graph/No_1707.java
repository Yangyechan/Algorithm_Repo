package BaekjunOnlineJudge.graph;

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
    static int[] check;
    static boolean isEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < K; t++) {
            String[] input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);

            lists = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                lists.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                String[] input2 = br.readLine().split(" ");
                int u = Integer.parseInt(input2[0]);
                int v = Integer.parseInt(input2[1]);

                lists.get(u).add(v);
                lists.get(v).add(u);
            }

            visited = new boolean[V + 1];
            check = new int[V + 1];
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
        queue.offer(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int target : lists.get(now)) {
                if (!visited[target]) {
                    visited[target] = true;
                    check[target] = (check[now] + 1) % 2;
                    queue.offer(target);
                } else if (check[target] == check[now]) {
                    isEven = false;
                    return;
                }
            }
        }
    }
}

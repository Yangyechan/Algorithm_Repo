package BarkingDog_Cicle2.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_5567 {
    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] visited;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] ip = br.readLine().split(" ");
            int u = Integer.parseInt(ip[0]);
            int v = Integer.parseInt(ip[1]);

            lists.get(u).add(v);
            lists.get(v).add(u);
        }

        visited = new boolean[n+1];
        visited[1] = true;
        BFS(1);
        System.out.println(ans);
    }
    static void BFS(int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < lists.get(now[0]).size(); i++) {
                if (!visited[lists.get(now[0]).get(i)] && now[1] < 2) {
                    visited[lists.get(now[0]).get(i)] = true;
                    ans++;
                    queue.offer(new int[]{lists.get(now[0]).get(i), now[1] + 1});
                }
            }
        }
    }
}

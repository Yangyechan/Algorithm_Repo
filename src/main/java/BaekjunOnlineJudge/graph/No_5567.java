package BaekjunOnlineJudge.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_5567 {
    static List<List<Integer>> lists;
    static boolean[] visited;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lists = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            lists.get(a).add(b);
            lists.get(b).add(a);
        }

        BFS(1);
        System.out.println(cnt);
    }
    static void BFS(int x) {
        visited[x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[1] == 2) continue;

            for (int i = 0; i < lists.get(now[0]).size(); i++) {
                if (!visited[lists.get(now[0]).get(i)]) {
                    visited[lists.get(now[0]).get(i)] = true;
                    cnt++;
                    queue.offer(new int[]{lists.get(now[0]).get(i), now[1] + 1});
                }
            }
        }
    }
}

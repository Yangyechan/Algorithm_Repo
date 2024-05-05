package BarkingDog_Cicle2.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_1240 {
    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] visited;
    static int[][] dir;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        dir = new int[N + 1][N + 1];
        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);

            lists.get(a).add(b);
            lists.get(b).add(a);
            dir[a][b] = d;
            dir[b][a] = d;
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            sb.append(dir[a][b] + "\n");
        }
        System.out.println(sb);
    }
    static void BFS(int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, 0});
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int nxt : lists.get(now[0])) {
                if (!visited[nxt]) {
                    if (now[0] == x) {
                        visited[nxt] = true;
                        queue.offer(new int[]{nxt, dir[now[0]][nxt]});
                        continue;
                    }
                    visited[nxt] = true;
                    dir[x][nxt] = now[1] + dir[now[0]][nxt];
                    dir[nxt][x] = dir[x][nxt];
                    queue.offer(new int[]{nxt, dir[x][nxt]});
                }else {
                    if (now[1] + dir[now[0]][nxt] < dir[x][nxt]) {
                        dir[x][nxt] = now[1] + dir[now[0]][nxt];
                        dir[nxt][x] = now[1] + dir[now[0]][nxt];
                    }
                }
            }
        }
    }
}

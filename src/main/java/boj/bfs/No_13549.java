package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        int[] map = new int[300000];
        boolean[] visited = new boolean[300000];

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int f = now + 1;
            int b = now - 1;
            int db = now * 2;
            if (now == M) {
                System.out.println(map[now]);
                break;
            }
            if (db >= 0 && db < 100001 && !visited[db]) {
                queue.offer(db);
                visited[db] = true;
                map[db] = map[now];
            }
            if (b >= 0 && b < 100001 && !visited[b]) {
                queue.offer(b);
                visited[b] = true;
                map[b] = map[now] + 1;
            }
            if (f >= 0 && f < 100001 && !visited[f]) {
                queue.offer(f);
                visited[f] = true;
                map[f] = map[now] + 1;
            }
            visited[N] = true;
        }
    }
}

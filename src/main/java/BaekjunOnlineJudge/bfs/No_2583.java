package BaekjunOnlineJudge.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class No_2583 {
    static int M, N, K;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);
        K = Integer.parseInt(str[2]);
        map = new int[M][N];
        visited = new boolean[M][N];
        queue = new LinkedList<>();

        int cnt = 0;
        for (int i = 0; i < K; i++) {
            String[] str2 = br.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            int c = Integer.parseInt(str2[2]);
            int d = Integer.parseInt(str2[3]);
            for (int j = b; j < d; j++) {
                for (int k = a; k < c; k++) {
                    map[j][k] = -1;
                    visited[j][k] = true;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    cnt++;
                    queue.offer(new int[]{i, j});
                    BFS(i, j);
                    queue1.offer(size);
                    size = 0;
                }
            }
        }
        System.out.println(cnt);
        int s = queue1.size();
        for (int i = 0; i < s; i++) {
            System.out.print(queue1.poll() + " ");
        }
    }
    static void BFS(int x, int y) {
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            size++;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}

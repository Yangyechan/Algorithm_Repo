package BaekjunOnlineJudge.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_1012 {
    static int M, N, K;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] str = br.readLine().split(" ");
            M = Integer.parseInt(str[0]);
            N = Integer.parseInt(str[1]);
            K = Integer.parseInt(str[2]);
            map = new int[M][N];
            visited = new boolean[M][N];
            queue = new LinkedList<>();
            for (int j = 0; j < K; j++) {
                String[] str2 = br.readLine().split(" ");
                int x = Integer.parseInt(str2[0]);
                int y = Integer.parseInt(str2[1]);
                map[x][y] = 1;
                visited[x][y] = true;
            }
            int cnt = 0;
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (visited[j][k]) {
                        queue.offer(new int[]{j, k});
                        BFS(j, k);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    static void BFS(int x, int y) {
        visited[x][y] = false;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 1 && visited[nx][ny]) {
                        visited[nx][ny] = false;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}

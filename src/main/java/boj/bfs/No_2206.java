package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No_2206 {
    static int N, M;
    static int[][][] dist;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        dist = new int[N][M][2];
        map = new int[N][M];
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                dist[i][j][0] = -1;
                dist[i][j][1] = -1;
                if (str.charAt(j) == '0') {
                    map[i][j] = 0;
                } else if (str.charAt(j) == '1') {
                    map[i][j] = 1;
                }
            }
        }
        dist[0][0][0] = 1;
        queue.offer(new int[]{0, 0, 0});
        System.out.println(BFS());
    }
    static int BFS() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int z = now[2];
            if (x == N -1 && y == M - 1) {
                return dist[x][y][z];
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0 && dist[nx][ny][z] == -1) {
                        dist[nx][ny][z] = dist[x][y][z] + 1;
                        queue.offer(new int[]{nx, ny, z});
                    }
                    if (z == 0 && map[nx][ny] == 1 && dist[nx][ny][1] == -1) {
                        dist[nx][ny][1] = dist[x][y][z] + 1;
                        queue.offer(new int[]{nx, ny, 1});
                    }
                }
            }
        }
        return -1;
    }
}

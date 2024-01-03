package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_2178_2 {
    static int M,N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String str2 = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str2.charAt(j) - '0';
            }
        }
        BFS(0, 0);
        System.out.println(map[N-1][M-1]);
    }
    static void BFS(int x, int y) {
        visited[x][y] = true;
        queue.offer(new int[]{x,y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        map[nx][ny] = map[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}

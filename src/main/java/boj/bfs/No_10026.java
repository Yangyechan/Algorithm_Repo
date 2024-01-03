package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_10026 {
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] visited2;
    static Queue<int[]> queue1;
    static Queue<int[]> queue2;
    static Queue<int[]> queue3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        visited2 = new boolean[N][N];
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        queue3 = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if (str.charAt(j) == 'R') {
                    map[i][j] = 0;
                } else if (str.charAt(j) == 'G') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 2;
                }
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 0) {
                        queue1.offer(new int[]{i, j});
                        BFS1(i, j);
                        cnt1++;
                    }else if (map[i][j] == 1) {
                        queue2.offer(new int[]{i, j});
                        BFS2(i, j);
                        cnt1++;
                    }else if (map[i][j] == 2) {
                        queue3.offer(new int[]{i, j});
                        BFS3(i, j);
                        cnt1++;
                    }
                }
            }
        }
        queue1.clear();
        queue3.clear();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited2[i][j]) {
                    if (map[i][j] == 0 || map[i][j] == 1) {
                        queue1.offer(new int[]{i, j});
                        BFS4(i, j);
                        cnt2++;
                    }else if (map[i][j] == 2) {
                        queue3.offer(new int[]{i, j});
                        BFS5(i, j);
                        cnt2++;
                    }
                }
            }
        }
        System.out.println(cnt1 + " " + cnt2);
    }
    static void BFS1(int x, int y) {
        visited[x][y] = true;
        while (!queue1.isEmpty()) {
            int[] now = queue1.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 0) {
                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            queue1.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
    static void BFS2(int x, int y) {
        visited[x][y] = true;
        while (!queue2.isEmpty()) {
            int[] now = queue2.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 1) {
                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            queue2.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
    static void BFS3(int x, int y) {
        visited[x][y] = true;
        while (!queue3.isEmpty()) {
            int[] now = queue3.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 2) {
                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            queue3.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
    static void BFS4(int x, int y) {
        visited2[x][y] = true;
        while (!queue1.isEmpty()) {
            int[] now = queue1.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 0 || map[nx][ny] == 1) {
                        if (!visited2[nx][ny]) {
                            visited2[nx][ny] = true;
                            queue1.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
    static void BFS5(int x, int y) {
        visited2[x][y] = true;
        while (!queue3.isEmpty()) {
            int[] now = queue3.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 2) {
                        if (!visited2[nx][ny]) {
                            visited2[nx][ny] = true;
                            queue3.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
}

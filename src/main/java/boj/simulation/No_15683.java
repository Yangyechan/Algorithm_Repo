package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_15683 {
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] copyMap;
    static List<int[]> cctv;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][M];
        cctv = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] str2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str2[j]);
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctv.add(new int[]{i, j});
                }
            }
        }

        int totalCase = (int) Math.pow(4, cctv.size());
        for (int tmp = 0; tmp < totalCase; tmp++) {
            copyMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }
            int brute = tmp;
            for (int i = 0; i < cctv.size(); i++) {
                int dir = brute % 4;
                brute /= 4;
                int[] now = cctv.get(i);
                int x = now[0];
                int y = now[1];
                if (copyMap[x][y] == 1) {
                    BFS(x, y, dir);
                } else if (copyMap[x][y] == 2) {
                    BFS(x, y, dir);
                    BFS(x, y, dir + 2);
                } else if (copyMap[x][y] == 3) {
                    BFS(x, y, dir);
                    BFS(x, y, dir + 1);
                } else if (copyMap[x][y] == 4) {
                    BFS(x, y, dir);
                    BFS(x, y, dir + 1);
                    BFS(x, y, dir + 2);
                } else if (copyMap[x][y] == 5) {
                    BFS(x, y, dir);
                    BFS(x, y, dir + 1);
                    BFS(x, y, dir + 2);
                    BFS(x, y, dir + 3);
                }
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyMap[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            ans = Math.min(ans, cnt);
        }
        System.out.println(ans);
    }
    static void BFS(int x, int y, int dir) {
        dir %= 4;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0] + dx[dir];
            int ny = now[1] + dy[dir];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (copyMap[nx][ny] == 6) break;
                if (copyMap[nx][ny] != 0) {
                    queue.offer(new int[]{nx, ny});
                }else {
                    queue.offer(new int[]{nx, ny});
                    copyMap[nx][ny] = 7;
                }
            }
        }
    }
}


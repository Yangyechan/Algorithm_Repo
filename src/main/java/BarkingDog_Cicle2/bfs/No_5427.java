package BarkingDog_Cicle2.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_5427 {
    static int K, W, H;
    static boolean[][][] visited;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {1, 0, -1, 0, 2, 1, -1, -2, -2, -1, 1, 2};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        String[] ip = br.readLine().split(" ");
        W = Integer.parseInt(ip[0]);
        H = Integer.parseInt(ip[1]);

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            ip = br.readLine().split(" ");
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(ip[j]);
            }
        }

        if (W == 1 && H == 1) {
            if (map[0][0] == 1) {
                System.out.println(-1);
            }else {
                System.out.println(0);
            }
            return;
        }

        visited = new boolean[H][W][K+1];
        BFS(0, 0);
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
    }

    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y][0] = true;
        queue.offer(new int[]{x, y, 0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 12; i++) {
                if (i < 4) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if (!check(nx, ny)) continue;
                    if (map[nx][ny] == 1) continue;
                    if (visited[nx][ny][now[2]]) continue;

                    if (nx == H-1 && ny == W-1) {
                        if (now[3] + 1 < ans) {
                            ans = now[3] + 1;
                        }
                    }
                    visited[nx][ny][now[2]] = true;
                    queue.offer(new int[]{nx, ny, now[2], now[3] + 1});
                }else {
                    if (now[2] == K) continue;
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if (!check(nx, ny)) continue;
                    if (map[nx][ny] == 1) continue;
                    if (visited[nx][ny][now[2]+1]) continue;

                    if (nx == H-1 && ny == W-1) {
                        if (now[3] + 1 < ans) {
                            ans = now[3] + 1;
                        }
                    }
                    visited[nx][ny][now[2]+1] = true;
                    queue.offer(new int[]{nx, ny, now[2] + 1, now[3] + 1});
                }
            }
        }
    }
    static boolean check(int nx, int ny) {
        if (nx >= 0 && nx < H && ny >= 0 && ny < W) return true;
        return false;
    }
}





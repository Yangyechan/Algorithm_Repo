package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_14500 {
    static int N, M;
    static int[][][] map;
    static long max = -1;
    static int[] dx1 = {0, 0, 0};
    static int[] dy1 = {1, 1, 1};
    static int[] dx2 = {1, 1, 0};
    static int[] dy2 = {0, 0, 1};
    static int[] dx3 = {1, 0, 1};
    static int[] dy3 = {0, 1, 0};
    static int[] dx4 = {1, 0, -1};
    static int[] dy4 = {0, 1, 0};
    static int[] dx5 = {0, 0, 1};
    static int[] dy5 = {1, 1, -1};
    static int[] dx6 = {1, 1, 0};
    static int[] dy6 = {0, 0, -1};
    static int[] dx7 = {1, 0, 1};
    static int[] dy7 = {0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        N = Integer.parseInt(ip[0]);
        M = Integer.parseInt(ip[1]);

        map = new int[4][501][501];
        for (int i = 0; i < N; i++) {
            ip = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[0][i][j] = Integer.parseInt(ip[j]);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[1][i][j] = map[0][N-1-j][i];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[2][i][j] = map[1][M-1-j][i];
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[3][i][j] = map[2][N-1-j][i];
            }
        }

        for (int d = 0; d < 4; d++) {
            for (int s = 1; s <= 7; s++) {
                if (d % 2 == 0) {
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            DFS(i, j, s, d, 0, 0);
                        }
                    }
                }else {
                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < N; j++) {
                            DFS(i, j, s, d, 0, 0);
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
    static void DFS(int x, int y, int shape, int dir, int depth, long sum) {
        if (shape == 1) {
            sum += map[dir][x][y];

            if (depth == 3) {
                if (sum > max) max = sum;
                return;
            }

            int nx = x + dx1[depth];
            int ny = y + dy1[depth];

            if (dir % 2 == 0) {
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
            }else {
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) return;
            }

            DFS(nx, ny, shape, dir, depth+1, sum);
        } else if (shape == 2) {
            sum += map[dir][x][y];

            if (depth == 3) {
                if (sum > max) max = sum;
                return;
            }

            int nx = x + dx2[depth];
            int ny = y + dy2[depth];

            if (dir % 2 == 0) {
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
            }else {
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) return;
            }

            DFS(nx, ny, shape, dir, depth+1, sum);
        } else if (shape == 3) {
            sum += map[dir][x][y];

            if (depth == 3) {
                if (sum > max) max = sum;
                return;
            }

            int nx = x + dx3[depth];
            int ny = y + dy3[depth];

            if (dir % 2 == 0) {
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
            }else {
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) return;
            }

            DFS(nx, ny, shape, dir, depth+1, sum);
        } else if (shape == 4) {
            sum += map[dir][x][y];

            if (depth == 3) {
                if (sum > max) max = sum;
                return;
            }

            int nx = x + dx4[depth];
            int ny = y + dy4[depth];

            if (dir % 2 == 0) {
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
            }else {
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) return;
            }

            DFS(nx, ny, shape, dir, depth+1, sum);
        } else if (shape == 5){
            sum += map[dir][x][y];

            if (depth == 3) {
                if (sum > max) max = sum;
                return;
            }

            int nx = x + dx5[depth];
            int ny = y + dy5[depth];

            if (dir % 2 == 0) {
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
            }else {
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) return;
            }

            DFS(nx, ny, shape, dir, depth+1, sum);
        } else if (shape == 6){
            sum += map[dir][x][y];

            if (depth == 3) {
                if (sum > max) max = sum;
                return;
            }

            int nx = x + dx6[depth];
            int ny = y + dy6[depth];

            if (dir % 2 == 0) {
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
            }else {
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) return;
            }

            DFS(nx, ny, shape, dir, depth+1, sum);
        } else {
            sum += map[dir][x][y];

            if (depth == 3) {
                if (sum > max) max = sum;
                return;
            }

            int nx = x + dx7[depth];
            int ny = y + dy7[depth];

            if (dir % 2 == 0) {
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
            }else {
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) return;
            }

            DFS(nx, ny, shape, dir, depth+1, sum);
        }
    }
}

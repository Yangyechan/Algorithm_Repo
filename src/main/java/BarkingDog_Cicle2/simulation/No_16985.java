package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class No_16985 {
    static int[][][][] map;
    static int[][][] copyMap;
    static int[][][] copyMap2;
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] arr = new int[5];
    static boolean[] check = new boolean[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[4][5][5][5];
        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < 5; i++) {
                String[] ip = br.readLine().split(" ");
                for (int j = 0; j < 5; j++) {
                    map[0][k][i][j] = Integer.parseInt(ip[j]);
                }
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    map[1][k][i][j] = map[0][k][4-j][i];
                }
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    map[2][k][i][j] = map[1][k][4-j][i];
                }
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    map[3][k][i][j] = map[2][k][4-j][i];
                }
            }
        }

        int T = (int) Math.pow(4, 5);
        for (int t = 0; t < T; t++) {
            int tmp = t;
            copyMap = new int[5][5][5];
            for (int i = 0; i < 5; i++) {
                int x = tmp % 4;
                tmp /= 4;
                copy(x, i);
            }

            backTracking(0);
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(ans);

    }
    static void copy(int dir, int floor) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                copyMap[floor][i][j] = map[dir][floor][i][j];
            }
        }
    }

    static void backTracking(int depth) {
        if (depth == 5) {
            if (copyMap[arr[0]][0][0] == 0 || copyMap[arr[4]][4][4] == 0) return;

            copyMap2 = new int[5][5][5];
            for (int k = 0; k < 5; k++) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        copyMap2[k][i][j] = copyMap[arr[k]][i][j];
                    }
                }
            }
            BFS();
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[depth] = i;
                backTracking(depth+1);
                check[i] = false;
            }
        }
    }

    static void BFS() {
        boolean[][][] visited = new boolean[5][5][5];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 1});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int nz = now[2] + dz[i];

                if (nx == 4 && ny == 4 && nz == 4) {
                    if (now[3] < ans) ans = now[3];
                }

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5) continue;
                if (visited[nx][ny][nz]) continue;
                if (copyMap2[nx][ny][nz] != 1) continue;

                visited[nx][ny][nz] = true;
                queue.offer(new int[]{nx, ny, nz, now[3]+1});
            }
        }
    }
}

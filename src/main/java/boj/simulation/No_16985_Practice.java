package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_16985_Practice {
    static int[][][][] map = new int[4][5][5][5];
    static int[][][] maze = new int[5][5][5];
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String[] str = br.readLine().split(" ");
                for (int k = 0; k < 5; k++) {
                    map[0][i][j][k] = Integer.parseInt(str[k]);
                }
            }
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    map[1][i][j][k] = map[0][i][4 - k][j];
                }
            }
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    map[2][i][j][k] = map[1][i][4 - k][j];
                }
            }
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    map[3][i][j][k] = map[2][i][4 - k][j];
                }
            }
        }
        int[] order = {0, 1, 2, 3, 4};
        int ans = 9999;
        do {
            for (int tc = 0; tc < 1024; tc++) {
                int tmp = tc;
                for (int i = 0; i < 5; i++) {
                    int dir = tmp % 4;
                    tmp /= 4;
                    for (int j = 0; j < 5; j++) {
                        for (int k = 0; k < 5; k++) {
                            maze[i][j][k] = map[dir][order[i]][j][k];
                        }
                    }
                }
                ans = Math.min(ans, BFS());
            }
        }while (nextPermutation(order));

        if (ans == 9999) ans = -1;
        System.out.println(ans);
    }
    static int BFS() {
        if (maze[0][0][0] == 0 || maze[4][4][4] == 0) return 9999;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        int[][][] dir = new int[5][5][5];
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == 4 && now[1] == 4 && now[2] == 4) {
                return dir[now[0]][now[1]][now[2]];
            }
            for (int i = 0; i < 6; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int nz = now[2] + dz[i];
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && nz >= 0 && nz < 5) {
                    if (maze[nx][ny][nz] == 0 || dir[nx][ny][nz] != 0) continue;
                    dir[nx][ny][nz] = dir[now[0]][now[1]][now[2]] + 1;
                    queue.offer(new int[]{nx, ny, nz});
                }
            }
        }
        return 9999;
    }
    static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;

        while (i > 0 && arr[i - 1] >= arr[i]) i--;

        if (i <= 0) return false;

        int j = arr.length - 1;

        while (arr[j] <= arr[i - 1]) j--;

        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;
    }
    /*
    1234
    1243
    1324
    1342
     */
}

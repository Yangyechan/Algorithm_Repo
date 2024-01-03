package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_6593 {
    static int L, R, C;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[][][] map;
    static boolean[][][] visited;
    static Queue<int[]> queue;
    static boolean escape;
    static int minuite;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] str = br.readLine().split(" ");
            L = Integer.parseInt(str[0]);
            R = Integer.parseInt(str[1]);
            C = Integer.parseInt(str[2]);
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            map = new int[R][C][L];
            visited = new boolean[R][C][L];
            queue = new LinkedList<>();
            escape = false;
            minuite = 0;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str2 = br.readLine();
                    for (int k = 0; k < C; k++) {
                        if (str2.charAt(k) == 'S') {
                            visited[j][k][i] = true;
                            map[j][k][i] = 0;
                        } else if (str2.charAt(k) == '.') {
                            map[j][k][i] = -2;
                        } else if (str2.charAt(k) == '#') {
                            visited[j][k][i] = true;
                            map[j][k][i] = -3;
                        } else if (str2.charAt(k) == 'E') {
                            map[j][k][i] = -1;
                        }
                    }
                }
                br.readLine();
            }
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        if (map[j][k][i] == 0) {
                            queue.offer(new int[]{j, k, i});
                            BFS();
                        }
                    }
                }
            }
            if (escape) {
                System.out.println("Escaped in " + minuite + " minute(s).");
            }else {
                System.out.println("Trapped!");
            }
        }
    }
    static void BFS() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int nz = now[2] + dz[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && nz >= 0 && nz < L) {
                    if (map[nx][ny][nz] == -1 && !visited[nx][ny][nz]) {
                        escape = true;
                        minuite = map[now[0]][now[1]][now[2]] + 1;
                        return;
                    } else if (map[nx][ny][nz] == -2 && !visited[nx][ny][nz]) {
                        visited[nx][ny][nz] = true;
                        map[nx][ny][nz] = map[now[0]][now[1]][now[2]] + 1;
                        queue.offer(new int[]{nx, ny, nz});
                    }
                }
            }
        }
    }
}

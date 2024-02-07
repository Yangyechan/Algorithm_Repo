package BaekjunOnlineJudge.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_7569 {
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int N, M, H;
    static int[][][] box;
    static boolean[][][] visited;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);
        H = Integer.parseInt(str[2]);
        queue = new LinkedList<>();
        box = new int[N][M][H];
        visited = new boolean[N][M][H];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                String[] str2 = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    box[j][k][i] = Integer.parseInt(str2[k]);
                    if (box[j][k][i] == 1) {
                        visited[j][k][i] = true;
                        queue.add(new int[]{j, k, i});
                    }
                }
            }
        }
        BFS();
        boolean isZero = false;
        int max = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[j][k][i] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    if (max < box[j][k][i]) {
                        max = box[j][k][i];
                    }
                }
            }
        }
        System.out.println(max - 1);
    }
    static void BFS() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int nz = now[2] + dz[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
                    if (box[nx][ny][nz] == 0 && !visited[nx][ny][nz]) {
                        visited[nx][ny][nz] = true;
                        box[nx][ny][nz] = box[now[0]][now[1]][now[2]] + 1;
                        queue.offer(new int[]{nx, ny, nz});
                    }
                }
            }
        }
    }
}

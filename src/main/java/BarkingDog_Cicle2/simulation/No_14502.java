package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_14502 {
    static int N, M;
    static int[][] map;
    static int[][] copyMap;
    static int[] arr = new int[3];
    static boolean[] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<int[]> virus = new ArrayList<>();
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");

        N = Integer.parseInt(ip[0]);
        M = Integer.parseInt(ip[1]);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            ip = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(ip[j]);

                if (map[i][j] == 2) virus.add(new int[]{i, j});
            }
        }

        visited = new boolean[N*M];
        backTracking(0, 0);

        System.out.println(max);
    }
    static void backTracking(int depth, int st) {
        if (depth == 3) {

            boolean pos = true;
            copyMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < 3; i++) {
                int t = arr[i];
                int x = t / M;
                int y = t % M;

                if (copyMap[x][y] != 0) {
                    pos = false;
                    break;
                }
                copyMap[x][y] = 1;
            }

            if (pos) BFS();
            return;
        }

        for (int i = st; i < N * M; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                backTracking(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < virus.size(); i++) {
            queue.offer(virus.get(i));
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (copyMap[nx][ny] != 0) continue;

                copyMap[nx][ny] = 2;
                queue.offer(new int[]{nx, ny});
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) cnt++;
            }
        }

        if (cnt > max) max = cnt;
    }
}

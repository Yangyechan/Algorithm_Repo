package BaekjunOnlineJudge.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_1941_Practice {
    static char[][] map = new char[5][5];
    static boolean[] visited;
    static int[] check = new int[7];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }
        comb(0, 0, 0);
        System.out.println(cnt);
    }
    static void comb(int depth, int start, int dasom) {
        if (depth - dasom > 3) {
            return;
        }
        if (depth == 7) {
            visited = new boolean[7];
            BFS(check[0] / 5, check[0] % 5);
            return;
        }
        for (int i = start; i < 25; i++) {
            int nx = i / 5;
            int ny = i % 5;
            check[depth] = i;
            comb(depth + 1, i + 1, (map[nx][ny] == 'S') ? dasom + 1 : dasom);
        }
    }

    static void BFS(int x, int y) {
        int num = 1;
        visited[0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                    int nxt = 5 * nx + ny;
                    for (int j = 0; j < 7; j++) {
                        if (!visited[j] && check[j] == nxt) {
                            num++;
                            visited[j] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        if (num == 7) {
            cnt++;
        }
    }
}

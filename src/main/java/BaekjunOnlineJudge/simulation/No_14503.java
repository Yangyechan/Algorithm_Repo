package BaekjunOnlineJudge.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_14503 {// 문제 포기
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        String[] str2 = br.readLine().split(" ");
        int r = Integer.parseInt(str2[0]);
        int c = Integer.parseInt(str2[1]);
        int d = Integer.parseInt(str2[2]);
        for (int i = 0; i < N; i++) {
            String[] str3 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str3[j]);
            }
        }
        dfs(r, c, d);
        System.out.println(ans);
    }

    static void dfs(int x, int y, int dir) {
        // 현재 위치를 청소한다.
        if (map[x][y] == 0 && !visited[x][y]) {
            visited[x][y] = true;
            ans++;
        }

        // 네 방향 모두 청소되어 있거나 벽인 경우
        boolean allCleaned = true;
        for (int i = 0; i < 4; i++) {
            int nextDir = (dir + 3 - i) % 4;
            int nx = x + dx[nextDir];
            int ny = y + dy[nextDir];
            if (map[nx][ny] == 0 && !visited[nx][ny]) {
                allCleaned = false;
                dfs(nx, ny, nextDir);
                return; // 청소를 했으면 바로 종료하여 후진하지 않도록 수정
            }
        }

        // 네 방향 모두 청소되어 있거나 벽인 경우 후진
        if (allCleaned) {
            int backDir = (dir + 2) % 4;
            int nx = x + dx[backDir];
            int ny = y + dy[backDir];
            if (map[nx][ny] != 1) {
                dfs(nx, ny, dir);
            }
        }
    }
}



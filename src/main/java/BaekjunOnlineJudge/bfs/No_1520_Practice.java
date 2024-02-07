package BaekjunOnlineJudge.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1520_Practice {
    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        M = Integer.parseInt(strings[0]);
        N = Integer.parseInt(strings[1]);
        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            String[] strings1 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(strings1[j]);
                dp[i][j] = -1;
            }
        }
        int result = dfs(0, 0);
        System.out.println(result);
    }
    private static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > M - 1 || ny < 0 || ny > N - 1) {
                continue;
            }
            if (map[x][y] > map[nx][ny]) {
                dp[x][y] += dfs(nx, ny);
            }
        }
        return dp[x][y];
    }
}

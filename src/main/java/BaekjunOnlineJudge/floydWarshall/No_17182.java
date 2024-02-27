package BaekjunOnlineJudge.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_17182 {
    static final int INF = (int) Math.pow(10, 9);
    static int[][] d;
    static int[][] nxt;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        N = Integer.parseInt(ip[0]);
        int K = Integer.parseInt(ip[1]);

        d = new int[N+1][N+1];
        nxt = new int[N+1][N+1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(d[i], INF);
        }

        for (int i = 0; i < N; i++) {
            d[i][i] = 0;
        }

        for (int i = 0; i < N; i++) {
            ip = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int nx = Integer.parseInt(ip[j]);
                d[i][j] = Math.min(d[i][j], nx);
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        visited = new boolean[N];
        visited[K] = true;
        backTracking(K, 0, 0);

        System.out.println(min);
    }
    static void backTracking(int x, int size, int time) {

        if (size == N-1) {
            if (posCheck()) {
                min = Math.min(min, time);
            }
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                time += d[x][i];
                backTracking(i, size+1, time);
                time -= d[x][i];
                visited[i] = false;
            }
        }
    }

    static boolean posCheck() {
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}

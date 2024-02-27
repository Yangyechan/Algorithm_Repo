package BaekjunOnlineJudge.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class No_11562 {
    static final int INF = (int) Math.pow(10, 9);
    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int n = Integer.parseInt(ip[0]);
        int m = Integer.parseInt(ip[1]);

        d = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(d[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            d[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            ip = br.readLine().split(" ");
            int u = Integer.parseInt(ip[0]);
            int v = Integer.parseInt(ip[1]);
            int b = Integer.parseInt(ip[2]);
            d[u][v] = 0;
            if (b == 1) {
                d[v][u] = 0;
            }else {
                d[v][u] = 1;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            ip = br.readLine().split(" ");
            int s = Integer.parseInt(ip[0]);
            int e = Integer.parseInt(ip[1]);
            sb.append(d[s][e] + "\n");
        }

        System.out.println(sb);
    }
}

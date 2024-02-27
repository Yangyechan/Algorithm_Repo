package BaekjunOnlineJudge.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_1956 {
    static final int INF = (int) Math.pow(10, 9);
    static int[][] d;
    static int[][] nxt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int v = Integer.parseInt(ip[0]);
        int e = Integer.parseInt(ip[1]);

        d = new int[v+1][v+1];
        nxt = new int[v+1][v+1];

        for (int i = 1; i <= v; i++) {
            Arrays.fill(d[i], INF);
        }

        for (int i = 1; i <= v; i++) {
            d[i][i] = 0;
        }

        for (int i = 0; i < e; i++) {
            ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int c = Integer.parseInt(ip[2]);
            d[a][b] = c;
            nxt[a][b] = b;
        }

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                        nxt[i][j] = nxt[i][k];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
//                if (d[i][j] == 0 || (d[i][j] == INF && d[j][i] == INF)) {
//                    continue;
//                }
//
//                min = Math.min(min, d[i][j] + d[j][i]);
                if (i == j) {
                    continue;
                }

                // 자기 자신을 제외한 두 정점이
                // 서로에게 가는 경로가 있다면, 사이클이 존재한다는 뜻.
                if (d[i][j] != INF && d[j][i] != INF) {
                    min = Math.min(min, d[i][j] + d[j][i]);
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }
}

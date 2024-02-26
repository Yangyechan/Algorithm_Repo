package BaekjunOnlineJudge.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_14938 {
    static final int INF = (int) Math.pow(10, 9);
    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int n = Integer.parseInt(ip[0]);
        int m = Integer.parseInt(ip[1]);
        int r = Integer.parseInt(ip[2]);

        d = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(d[i], INF);
        }

        int[] item = new int[n+1];
        ip = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(ip[i]);
            item[i+1] = num;
        }

        for (int i = 0; i < r; i++) {
            ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int l = Integer.parseInt(ip[2]);
            d[a][b] = l;
            d[b][a] = l;
        }

        for (int i = 1; i <= n; i++) {
            d[i][i] = 0;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                        d[j][i] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = 0;
            for (int j = 1; j <= n; j++) {
                if (d[i][j] <= m) {
                    tmp += item[j];
                }
            }
            if (tmp > max) max = tmp;
        }

        System.out.println(max);
    }
}

package BaekjunOnlineJudge.floydWarshall;

import java.util.*;
import java.io.*;

public class No_11404 {
    static final int INF = (int)Math.pow(10, 9);
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for(int i = 0; i < m; i++) {
            String[] ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int c = Integer.parseInt(ip[2]);
            graph[a][b] = Math.min(graph[a][b], c);
        }

        for(int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] == INF) {
                    sb.append("0 ");
                } else {
                    sb.append(graph[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}


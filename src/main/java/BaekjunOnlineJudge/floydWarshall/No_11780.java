package BaekjunOnlineJudge.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_11780 {
    static final int INF = (int) Math.pow(10, 9);
    static int[][] nxt;
    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        d = new int[n+1][n+1];
        nxt = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(d[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            d[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            String[] ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int c = Integer.parseInt(ip[2]);
            d[a][b] = Math.min(d[a][b], c);
            nxt[a][b] = b;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                        nxt[i][j] = nxt[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (d[i][j] == INF) {
                    sb.append(0 + " ");
                }else {
                    sb.append(d[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (d[i][j] == INF || d[i][j] == 0) {
                    sb.append(0 + " \n");
                    continue;
                }

                List<Integer> list = new ArrayList<>();
                int st = i;
                while (st != j) {
                    list.add(st);
                    st = nxt[st][j];
                }
                list.add(j);
                sb.append(list.size() + " ");
                for (int x : list) {
                    sb.append(x + " ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}

//import java.util.*;
//import java.io.*;
//
//public class No_11780 {
//    static final int INF = 0x3f3f3f3f;
//    static int[][] d;
//    static int[][] nxt;
//    static int n, m;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        n = Integer.parseInt(br.readLine());
//        m = Integer.parseInt(br.readLine());
//        d = new int[n+1][n+1];
//        nxt = new int[n+1][n+1];
//
//        for(int i = 1; i <= n; i++)
//            Arrays.fill(d[i], INF);
//        while(m-- > 0){
//            String[] ip = br.readLine().split(" ");
//            int a = Integer.parseInt(ip[0]);
//            int b = Integer.parseInt(ip[1]);
//            int c = Integer.parseInt(ip[2]);
//            d[a][b] = Math.min(d[a][b], c);
//            nxt[a][b] = b;
//        }
//        for(int i = 1; i <= n; i++) d[i][i] = 0;
//
//        for(int k = 1; k <= n; k++)
//            for(int i = 1; i <= n; i++)
//                for(int j = 1; j <= n; j++)
//                    if(d[i][k] + d[k][j] < d[i][j]){
//                        d[i][j] = Math.min(d[i][j], d[i][k]+d[k][j]);
//                        nxt[i][j] = nxt[i][k];
//                    }
//
//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= n; j++){
//                if(d[i][j] == INF) System.out.print("0 ");
//                else System.out.print(d[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= n; j++){
//                if(d[i][j] == 0 || d[i][j] == INF){
//                    System.out.println("0");
//                    continue;
//                }
//                List<Integer> path = new ArrayList<>();
//                int nx = i;
//                while(nx != j){
//                    path.add(nx);
//                    nx = nxt[nx][j];
//                }
//                path.add(j);
//                System.out.print(path.size() + " ");
//                for(int x : path) System.out.print(x + " ");
//                System.out.println();
//            }
//        }
//    }
//}


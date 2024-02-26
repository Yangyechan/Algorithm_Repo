package BaekjunOnlineJudge.floydWarshall;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class No_21940 {
//    static final int INF = (int) Math.pow(10, 9);
//    static int[][] d;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] ip = br.readLine().split(" ");
//        int N = Integer.parseInt(ip[0]);
//        int M = Integer.parseInt(ip[1]);
//
//        d = new int[N+1][N+1];
//        for (int i = 1; i <= N; i++) {
//            Arrays.fill(d[i], INF);
//        }
//
//        for (int i = 1; i <= N; i++) {
//            d[i][i] = 0;
//        }
//
//        for (int i = 0; i < M; i++) {
//            ip = br.readLine().split(" ");
//            int a = Integer.parseInt(ip[0]);
//            int b = Integer.parseInt(ip[1]);
//            int t = Integer.parseInt(ip[2]);
//            d[a][b] = Math.min(d[a][b], t);
//        }
//
//        for (int k = 1; k <= N; k++) {
//            for (int i = 1; i <= N; i++) {
//                for (int j = 1; j <= N; j++) {
//                    if (d[i][k] + d[k][j] < d[i][j]) {
//                        d[i][j] = Math.min(d[i][k] + d[k][j], d[i][j]);
//                    }
//                }
//            }
//        }
//
//        int memberNum = Integer.parseInt(br.readLine());
//        ip = br.readLine().split(" ");
//        List<Integer> member = new ArrayList<>();
//        for (int i = 0; i < memberNum; i++) {
//            int n = Integer.parseInt(ip[i]);
//            member.add(n);
//        }
//
//        int min = Integer.MAX_VALUE;
//        for (int i = 1; i <= N; i++) {
//            int tmp = 0;
//            for (int j = 0; j < member.size(); j++) {
//                int n = member.get(j);
//                tmp += d[n][i] + d[i][n];
//            }
//            if (tmp < min) {
//                min = tmp;
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i <= N; i++) {
//            int tmp = 0;
//            for (int j = 0; j < member.size(); j++) {
//                int n = member.get(j);
//                tmp += d[n][i] + d[i][n];
//            }
//            if (tmp == min) {
//                sb.append(i + " ");
//            }
//        }
//        System.out.println(sb);
//    }
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class No_21940 {
    static final int INF = 987987987;
    static int n, m, f;
    static int[] c;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        c = new int[n + 2];
        d = new int[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) d[i][j] = 0;
                else d[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            d[x][y] = Math.min(d[x][y], cost);
        }

        f = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int ci = 1; ci <= f; ci++) {
            int x = Integer.parseInt(st.nextToken());
            c[ci] = x;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = Math.min(d[i][k] + d[k][j], d[i][j]);
                }
            }
        }

        ArrayList<Pair> v = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int mx = 0;
            for (int ci = 1; ci <= f; ci++) {
                mx = Math.max(mx, d[i][c[ci]] + d[c[ci]][i]);
            }
            v.add(new Pair(mx, i));
        }

        Collections.sort(v);

        int mn = v.get(0).first;
        for (Pair cur : v) {
            if (mn < cur.first) break;
            System.out.print(cur.second + " ");
        }
    }

    static class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.first == o.first) {
                return this.second - o.second;
            } else {
                return this.first - o.first;
            }
        }
    }
}

package BarkingDog_Cicle2.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class No_1261 {
    static class Node implements Comparable<Node> {
        int a, b, cnt;

        Node(int a, int b, int cnt) {
            this.a = a;
            this.b = b;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return cnt - o.cnt;
        }
    }
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int[][] d;
    static int[][] map;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);

        d = new int[M+1][N+1];
        for (int i = 1; i <= M; i++) {
            Arrays.fill(d[i], INF);
        }

        map = new int[M+1][N+1];
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                int num = str.charAt(j) - '0';
                map[i+1][j+1] = num;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 1, 0));
        d[1][1] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            int a = now.a;
            int b = now.b;
            int cnt = now.cnt;

            if (cnt != d[a][b]) continue;

            for (int i = 0; i < 4; i++) {
                int nxa = a + dx[i];
                int nxb = b + dy[i];

                if (nxa < 1 || nxa > M || nxb < 1 || nxb > N) continue;

                int nxc = cnt;
                if (map[nxa][nxb] == 1) nxc++;

                if (d[nxa][nxb] <= nxc) continue;

                d[nxa][nxb] = nxc;
                pq.offer(new Node(nxa, nxb, d[nxa][nxb]));
            }
        }

        System.out.println(d[M][N]);
    }
}

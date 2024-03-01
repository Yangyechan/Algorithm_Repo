package BaekjunOnlineJudge.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class No_1261 {
    static int N, M;
    static class Node implements Comparable<Node> {
        int a, b, broke;

        Node(int a, int b, int broke) {
            this.a = a;
            this.b = b;
            this.broke = broke;
        }

        @Override
        public int compareTo(Node o) {
            return broke - o.broke;
        }
    }
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        M = Integer.parseInt(ip[0]);
        N = Integer.parseInt(ip[1]);

        int[][] d = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(d[i], INF);
        }
        d[0][0] = 0;

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, d[0][0]));
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (d[now.a][now.b] != now.broke) continue;

            for (int i = 0; i < 4; i++) {
                int nx = now.a + dx[i];
                int ny = now.b + dy[i];
                int nbk = now.broke;
                if (check(nx, ny)) {
                    if (map[nx][ny] == 1) {
                        nbk = nbk + 1;
                    }

                    if (nbk < d[nx][ny]) {
                        d[nx][ny] = nbk;
                    }else continue;

                    pq.offer(new Node(nx, ny, nbk));
                }
            }
        }

        System.out.println(d[N-1][M-1]);
    }
    static boolean check(int a, int b) {
        if (a >= 0 && a < N && b >= 0 && b < M) return true;
        else return false;
    }
}

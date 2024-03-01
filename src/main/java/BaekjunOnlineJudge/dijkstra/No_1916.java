package BaekjunOnlineJudge.dijkstra;

import javax.swing.plaf.nimbus.NimbusStyle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class No_1916 {
    static int N;
    static class Node implements Comparable<Node> {
        int dis, idx;

        Node(int dis, int idx) {
            this.dis = dis;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return dis - o.dis;
        }
    }
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> lists = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        int[] d = new int[N+1];
        Arrays.fill(d, INF);

        for (int i = 0; i < M; i++) {
            String[] ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int c = Integer.parseInt(ip[2]);
            lists.get(a).add(new Node(c, b));
        }

        String[] ip = br.readLine().split(" ");
        int st = Integer.parseInt(ip[0]);
        int ed = Integer.parseInt(ip[1]);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[st] = 0;
        pq.offer(new Node(d[st], st));
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (d[now.idx] != now.dis) continue;

            for (Node nxt : lists.get(now.idx)) {
                if (d[nxt.idx] <= d[now.idx] + nxt.dis) continue;

                d[nxt.idx] = d[now.idx] + nxt.dis;
                pq.offer(new Node(d[nxt.idx], nxt.idx));
            }
        }

        System.out.println(d[ed]);
    }
}

package BaekjunOnlineJudge.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class No_1238 {
    static int N;
    static final int INF = Integer.MAX_VALUE;
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
    static List<List<Node>> lists = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);
        int X = Integer.parseInt(ip[2]);

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            ip = br.readLine().split(" ");
            int s = Integer.parseInt(ip[0]);
            int e = Integer.parseInt(ip[1]);
            int t = Integer.parseInt(ip[2]);
            lists.get(s).add(new Node(t, e));
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, func(i, X) + func(X, i));
        }

        System.out.println(ans);
    }
    static int func(int st, int ed) {
        int[] d = new int[N+1];
        Arrays.fill(d, INF);

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
        return d[ed];
    }
}

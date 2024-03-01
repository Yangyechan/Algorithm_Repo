package BaekjunOnlineJudge.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class No_1504 {
    static final int INF = (int) Math.pow(10, 9);
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
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        N = Integer.parseInt(ip[0]);
        int E = Integer.parseInt(ip[1]);

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int c = Integer.parseInt(ip[2]);
            lists.get(a).add(new Node(c, b));
            lists.get(b).add(new Node(c, a));
        }

        ip = br.readLine().split(" ");
        int st = Integer.parseInt(ip[0]);
        int ed = Integer.parseInt(ip[1]);

        int[][] arr = new int[2][2];
        arr[0][0] = st;
        arr[0][1] = ed;
        arr[1][0] = ed;
        arr[1][1] = st;


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

        for (int i = 1; i <= N; i++) {
            if (d[i] == INF) {
                System.out.println(-1);
                return;
            }
        }

        long ans1 = 0;
        int tmp = func(1, ed);
        if (tmp != INF) {
            ans1 += tmp;
        }

        tmp = func(ed , st);
        if (tmp != INF) {
            ans1 += tmp;
        }

        tmp = func(st, N);
        if (tmp != INF) {
            ans1 += tmp;
        }

        long ans2 = 0;
        tmp = func(1, st);
        if (tmp != INF) {
            ans2 += tmp;
        }

        tmp = func(st , ed);
        if (tmp != INF) {
            ans2 += tmp;
        }

        tmp = func(ed, N);
        if (tmp != INF) {
            ans2 += tmp;
        }
        if (ans1 >= INF && ans2 >= INF) {
            System.out.println(-1);
            return;
        }
        long ans = 0;
        ans = Math.min(ans1, ans2);

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

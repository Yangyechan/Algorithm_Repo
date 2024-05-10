package BarkingDog_Cicle2.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class No_1916 {
    static class Node implements Comparable<Node> {
        int idx, dis;

        Node(int idx, int dis) {
            this.idx = idx;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return dis - o.dis;
        }
    }
    static final int INF = Integer.MAX_VALUE;
    static int[] d;
    static List<List<Node>> lists = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int c = Integer.parseInt(ip[2]);

            lists.get(a).add(new Node(b, c));
        }

        String[] ip = br.readLine().split(" ");
        int st = Integer.parseInt(ip[0]);
        int ed = Integer.parseInt(ip[1]);

        d = new int[N+1];
        Arrays.fill(d, INF);
        d[st] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(st, d[st]));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.dis != d[now.idx]) continue;

            for (Node nxt : lists.get(now.idx)) {

                if (d[nxt.idx] <= nxt.dis + d[now.idx]) continue;

                d[nxt.idx] = nxt.dis + d[now.idx];
                pq.offer(new Node(nxt.idx, d[nxt.idx]));
            }
        }

        System.out.println(d[ed]);
    }
}

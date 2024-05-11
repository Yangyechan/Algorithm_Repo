package BarkingDog_Cicle2.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_17853 {
    static int N, K;
    static final int INF = Integer.MAX_VALUE;
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
    static int[] company;
    static Set<Integer> companySet = new HashSet<>();
    static List<List<Node>> lists = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);
        K = Integer.parseInt(ip[2]);

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            ip = br.readLine().split(" ");

            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int dis = Integer.parseInt(ip[2]);

            lists.get(a).add(new Node(b, dis));
        }

        company = new int[N];
        ip = br.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(ip[i]);
            company[i] = num;
            companySet.add(num);
        }

        int[][] d = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            d[i][0] = INF;
            d[i][1] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (companySet.contains(i)) continue;

            d[i][0] = 0;
            pq.offer(new Node(i, d[i][0]));
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.dis != d[now.idx][0]) continue;

            for (Node nxt : lists.get(now.idx)) {

                if (d[nxt.idx][0] <= nxt.dis + d[now.idx][0]) continue;

                d[nxt.idx][0] = nxt.dis + d[now.idx][0];
                d[nxt.idx][1] = d[now.idx][1];
                pq.offer(new Node(nxt.idx, d[nxt.idx][0]));
            }
        }

        int idx = 0;
        int min = 0;
        for (int i = 1; i <= N; i++) {
            if (companySet.contains(i)) continue;

            if (min > d[i][0]) {
                idx = d[i][1];
                min = d[i][0];
            }
        }
        

        System.out.println(idx);
        System.out.println(min);
    }
}

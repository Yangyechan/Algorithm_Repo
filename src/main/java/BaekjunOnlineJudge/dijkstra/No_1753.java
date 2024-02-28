package BaekjunOnlineJudge.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1753 {
    static int[] d;
    static List<List<Node>> lists = new ArrayList<>();
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int V = Integer.parseInt(ip[0]);
        int E = Integer.parseInt(ip[1]);
        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            ip = br.readLine().split(" ");
            int u = Integer.parseInt(ip[0]);
            int v = Integer.parseInt(ip[1]);
            int w = Integer.parseInt(ip[2]);
            lists.get(u).add(new Node(w, v));
        }

        d = new int[V+1];
        Arrays.fill(d, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Node(d[start], start));
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (d[now.idx] != now.dis) continue;

            for (Node nxt : lists.get(now.idx)) {
                if (d[nxt.idx] <= d[now.idx] + nxt.dis) continue;

                d[nxt.idx] = d[now.idx] + nxt.dis;
                pq.offer(new Node(d[nxt.idx], nxt.idx));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (d[i] == INF) {
                sb.append("INF\n");
            }else {
                sb.append(d[i] + "\n");
            }
        }

        System.out.println(sb);
    }
}

//import java.util.*;
//
//public class No_1753 {
//    static int V, E, start;
//    static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
//    static final int INF = Integer.MAX_VALUE;
//    static int[] d;
//
//    static class Pair implements Comparable<Pair> {
//        int cost, vertex;
//
//        Pair(int cost, int vertex) {
//            this.cost = cost;
//            this.vertex = vertex;
//        }
//
//        public int compareTo(Pair o) {
//            return this.cost - o.cost;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        V = scanner.nextInt();
//        E = scanner.nextInt();
//        start = scanner.nextInt();
//
//        d = new int[V + 1];
//        Arrays.fill(d, INF);
//
//        for (int i = 0; i <= V; i++) {
//            adj.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < E; i++) {
//            int u = scanner.nextInt();
//            int v = scanner.nextInt();
//            int w = scanner.nextInt();
//            adj.get(u).add(new Pair(w, v));
//        }
//
//        PriorityQueue<Pair> pq = new PriorityQueue<>();
//        d[start] = 0;
//        pq.offer(new Pair(d[start], start));
//
//        while (!pq.isEmpty()) {
//            Pair cur = pq.poll();
//
//            if (d[cur.vertex] != cur.cost) continue;
//
//            for (Pair next : adj.get(cur.vertex)) {
//                if (d[next.vertex] <= d[cur.vertex] + next.cost) continue;
//
//                d[next.vertex] = d[cur.vertex] + next.cost;
//                pq.offer(new Pair(d[next.vertex], next.vertex));
//            }
//        }
//
//        for (int i = 1; i <= V; i++) {
//            if (d[i] == INF) {
//                System.out.println("INF");
//            } else {
//                System.out.println(d[i]);
//            }
//        }
//    }
//}

package BarkingDog_Cicle2.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class No_1753 {
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
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");

        int V = Integer.parseInt(ip[0]);
        int E = Integer.parseInt(ip[1]);

        d = new int[V+1];
        int st = Integer.parseInt(br.readLine());

        Arrays.fill(d, INF);
        d[st] = 0;

        List<List<Node>> lists = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            ip = br.readLine().split(" ");

            int u = Integer.parseInt(ip[0]);
            int v = Integer.parseInt(ip[1]);
            int w = Integer.parseInt(ip[2]);

            lists.get(u).add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(st, d[st]));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (d[now.idx] != now.dis) continue;

            for (Node nxt : lists.get(now.idx)) {

                if (d[nxt.idx] <= d[now.idx] + nxt.dis) continue;

                d[nxt.idx] = d[now.idx] + nxt.dis;
                pq.offer(new Node(nxt.idx, d[nxt.idx]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (d[i] == INF) sb.append("INF\n");
            else sb.append(d[i] + "\n");
        }

        System.out.println(sb);
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class No_1753 {
//    static int[] d;
//    static List<List<Node>> lists = new ArrayList<>();
//    static class Node implements Comparable<Node> {
//        int dis, idx;
//
//        Node(int dis, int idx) {
//            this.dis = dis;
//            this.idx = idx;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            return dis - o.dis;
//        }
//    }
//    static final int INF = Integer.MAX_VALUE;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] ip = br.readLine().split(" ");
//        int V = Integer.parseInt(ip[0]);
//        int E = Integer.parseInt(ip[1]);
//        int start = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i <= V; i++) {
//            lists.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < E; i++) {
//            ip = br.readLine().split(" ");
//            int u = Integer.parseInt(ip[0]);
//            int v = Integer.parseInt(ip[1]);
//            int w = Integer.parseInt(ip[2]);
//            lists.get(u).add(new Node(w, v));
//        }
//
//        d = new int[V+1];
//        Arrays.fill(d, INF);
//
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//        d[start] = 0;
//        pq.offer(new Node(d[start], start));
//        while (!pq.isEmpty()) {
//            Node now = pq.poll();
//
//            if (d[now.idx] != now.dis) continue;
//
//            for (Node nxt : lists.get(now.idx)) {
//                if (d[nxt.idx] <= d[now.idx] + nxt.dis) continue;
//
//                d[nxt.idx] = d[now.idx] + nxt.dis;
//                pq.offer(new Node(d[nxt.idx], nxt.idx));
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i <= V; i++) {
//            if (d[i] == INF) {
//                sb.append("INF\n");
//            }else {
//                sb.append(d[i] + "\n");
//            }
//        }
//
//        System.out.println(sb);
//    }
//}
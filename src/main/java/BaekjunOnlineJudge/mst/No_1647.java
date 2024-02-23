package BaekjunOnlineJudge.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class No_1647 {
    //static int[] parent;
    static class node2 implements Comparable<node2> {
        int a, b, c;

        node2(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(node2 o) {
            return c - o.c;
        }
    }

    static boolean[] visited;
    static List<List<node2>> lists = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        PriorityQueue<node2> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int c = Integer.parseInt(ip[2]);
            lists.get(a).add(new node2(a, b, c));
            lists.get(b).add(new node2(b, a, c));
        }

        visited = new boolean[N + 1];
        visited[1] = true;
        for (node2 nxt : lists.get(1)) {
            pq.offer(nxt);
        }
        long ans = 0;
        long cnt = 0;
        int mc = 0;
        while (!pq.isEmpty()) {
            node2 now = pq.poll();

            if (visited[now.b]) continue;

            visited[now.b] = true;
            ans += now.c;
            mc = Math.max(mc, now.c);
            cnt++;
            if (cnt == N-1) break;

            for (node2 nxt : lists.get(now.b)) {
                pq.offer(nxt);
            }
        }

        System.out.println(ans - mc);
    }
}

//import java.util.*;
//
//public class No_1647 {
//    static class Edge implements Comparable<Edge> {
//        int cost, a, b;
//        Edge(int cost, int a, int b) {
//            this.cost = cost;
//            this.a = a;
//            this.b = b;
//        }
//        public int compareTo(Edge o) {
//            return this.cost - o.cost;
//        }
//    }
//
//    static ArrayList<Edge>[] adj;
//    static boolean[] vis;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//
//        adj = new ArrayList[n + 1];
//        for (int i = 1; i <= n; i++) {
//            adj[i] = new ArrayList<>();
//        }
//        vis = new boolean[n + 1];
//
//        for (int i = 0; i < m; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            int c = sc.nextInt();
//            adj[a].add(new Edge(c, a, b));
//            adj[b].add(new Edge(c, b, a));
//        }
//
//        PriorityQueue<Edge> pq = new PriorityQueue<>();
//        vis[1] = true;
//        for (Edge nxt : adj[1]) {
//            pq.add(nxt);
//        }
//
//        int cnt = 0, ans = 0, mc = 0;
//        while (cnt < n - 1) {
//            Edge top = pq.poll();
//            if (vis[top.b]) continue;
//
//            vis[top.b] = true;
//            ans += top.cost;
//            mc = Math.max(mc, top.cost);
//            cnt++;
//
//            for (Edge nxt : adj[top.b]) {
//                if (!vis[nxt.b]) {
//                    pq.add(nxt);
//                }
//            }
//        }
//        System.out.println(ans - mc);
//    }
//}

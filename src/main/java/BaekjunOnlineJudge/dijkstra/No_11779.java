package BaekjunOnlineJudge.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_11779 {
    static int[] d;
    static int[] pre;
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
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }

        d = new int[n+1];
        Arrays.fill(d, INF);

        pre = new int[n+1];

        for (int i = 0; i < m; i++) {
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

            for (Node next : lists.get(now.idx)) {
                if (d[next.idx] <= d[now.idx] + next.dis) continue;

                d[next.idx] = d[now.idx] + next.dis;
                pre[next.idx] = now.idx;
                pq.offer(new Node(d[next.idx], next.idx));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(d[ed] + "\n");

        List<Integer> list = new ArrayList<>();
        while (st != ed) {
            list.add(ed);
            ed = pre[ed];
        }
        list.add(st);
        Collections.reverse(list);

        sb.append(list.size() + "\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + " ");
        }

        System.out.println(sb);
    }
}

//import java.util.*;
//
//public class No_11779 {
//    static int V, E, start, end;
//    static ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
//    static final int INF = Integer.MAX_VALUE;
//    static int[] d, pre;
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
//
//        d = new int[V + 1];
//        pre = new int[V + 1];
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
//        start = scanner.nextInt();
//        end = scanner.nextInt();
//
//        PriorityQueue<Pair> pq = new PriorityQueue<>();
//        d[start] = 0;
//        pq.offer(new Pair(d[start], start));
//        while (!pq.isEmpty()) {
//            Pair now = pq.poll();
//
//            if (d[now.vertex] != now.cost) continue;
//
//            for (Pair nxt : adj.get(now.vertex)) {
//                if (d[nxt.vertex] <= d[now.vertex] + nxt.cost) continue;
//
//                d[nxt.vertex] = d[now.vertex] + nxt.cost;
//                pq.offer(new Pair(d[nxt.vertex], nxt.vertex));
//                pre[nxt.vertex] = now.vertex;
//            }
//        }
//
//        ArrayList<Integer> path = new ArrayList<>();
//        for (int v = end; v != start; v = pre[v]) {
//            path.add(v);
//        }
//        path.add(start);
//        Collections.reverse(path);
//
//        System.out.println(d[end]);
//        System.out.println(path.size());
//        for (int v : path) {
//            System.out.print(v + " ");
//        }
//    }
//}

package BaekjunOnlineJudge.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int a, b, c;

    Node(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Node o) {
        return c - o.c;
    }
}
public class No_1197 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);

        parent = new int[N + 1];
        Arrays.fill(parent, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int c = Integer.parseInt(ip[2]);
            pq.offer(new Node(a, b, c));
        }

        int ans = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int a = now.a;
            int b = now.b;
            int c = now.c;

            if (!union(a, b)) continue;
            ans += c;
            cnt++;
            if (cnt == N - 1) break;
        }

        System.out.println(ans);
    }
    static int find(int x) {
        return parent[x] < 0 ? x : find(parent[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;

        if (a < b) {
            parent[b] = a;
        }else {
            parent[a] = b;
        }
        return true;
    }
}


//import java.util.*;
//
//public class No_1197 {
//    static int[] p = new int[10005];
//
//    static {
//        Arrays.fill(p, -1);
//    }
//
//    static int find(int x) {
//        if (p[x] < 0) return x;
//        return p[x] = find(p[x]);
//    }
//
//    static boolean is_diff_group(int u, int v) {
//        u = find(u);
//        v = find(v);
//        if (u == v) return false;
//        if (p[u] == p[v]) p[u]--;
//        if (p[u] < p[v]) p[v] = u;
//        else p[u] = v;
//        return true;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int v = sc.nextInt();
//        int e = sc.nextInt();
//        Tuple[] edge = new Tuple[e];
//        for (int i = 0; i < e; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            int cost = sc.nextInt();
//            edge[i] = new Tuple(cost, a, b);
//        }
//        Arrays.sort(edge);
//        int cnt = 0;
//        int ans = 0;
//        for (int i = 0; i < e; i++) {
//            int a = edge[i].b;
//            int b = edge[i].c;
//            int cost = edge[i].a;
//            if (!is_diff_group(a, b)) continue;
//            ans += cost;
//            cnt++;
//            if (cnt == v - 1) break;
//        }
//        System.out.println(ans);
//    }
//
//    static class Tuple implements Comparable<Tuple> {
//        int a, b, c;
//
//        public Tuple(int a, int b, int c) {
//            this.a = a;
//            this.b = b;
//            this.c = c;
//        }
//
//        @Override
//        public int compareTo(Tuple o) {
//            return this.a - o.a;
//        }
//    }
//}


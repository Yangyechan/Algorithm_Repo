package BaekjunOnlineJudge.mst;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class No_13418 {
//    static List<List<node>> lists = new ArrayList<>();
//    static class node implements Comparable<node> {
//        int a, b, c;
//
//        node(int a, int b, int c) {
//            this.a = a;
//            this.b = b;
//            this.c = c;
//        }
//
//        @Override
//        public int compareTo(node o) {
//            return c - o.c;
//        }
//    }
//    static boolean[] visited;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] ip = br.readLine().split(" ");
//        int N = Integer.parseInt(ip[0]);
//        int M = Integer.parseInt(ip[1]);
//
//        for (int i = 0; i <= N; i++) {
//            lists.add(new ArrayList<>());
//        }
//
//        ip = br.readLine().split(" ");
//        int zero = Integer.parseInt(ip[0]);
//        int one = Integer.parseInt(ip[1]);
//        int clim = Integer.parseInt(ip[2]);
//        if (clim == 0) clim = 1;
//        else clim = 0;
//        node st = new node(zero, one, clim);
//
//        for (int i = 0; i < M; i++) {
//            ip = br.readLine().split(" ");
//            int a = Integer.parseInt(ip[0]);
//            int b = Integer.parseInt(ip[1]);
//            int c = Integer.parseInt(ip[2]);
//            if (c == 0) {
//                lists.get(a).add(new node(a, b, 1));
//                lists.get(b).add(new node(b, a, 1));
//            }
//            else {
//                lists.get(a).add(new node(a, b, 0));
//                lists.get(b).add(new node(b, a, 0));
//            }
//        }
//
//        visited = new boolean[N + 1];
//        visited[0] = true;
//        PriorityQueue<node> pq1 = new PriorityQueue<>();
//        pq1.offer(st);
//
//        int ans1 = 0;
//        if (st.c == 1) ans1++;
//        int cnt = 0;
//        while (!pq1.isEmpty()) {
//            node now = pq1.poll();
//
//            if (visited[now.b]) continue;
//            visited[now.b] = true;
//            ans1 += now.c;
//            cnt++;
//            if (cnt == N) break;
//
//            for (node nxt : lists.get(now.b)) {
//                pq1.offer(nxt);
//            }
//        }
//
//        visited = new boolean[N + 1];
//        visited[0] = true;
//        PriorityQueue<node> pq2 = new PriorityQueue<>(Collections.reverseOrder());
//        pq2.offer(st);
//
//        int ans2 = 0;
//        if (st.c == 1) ans2++;
//        cnt = 0;
//        while (!pq2.isEmpty()) {
//            node now = pq2.poll();
//
//            if (visited[now.b]) continue;
//            visited[now.b] = true;
//            ans2 += now.c;
//            cnt++;
//            if (cnt == N) break;
//
//            for (node nxt : lists.get(now.b)) {
//                pq2.offer(nxt);
//            }
//        }
//
//        int min = (int) Math.pow(ans1, 2);
//        int max = (int) Math.pow(ans2, 2);
//
//        System.out.println(max - min);
//    }
//}

import java.io.*;
import java.util.*;

public class No_13418 {

    static class Edge implements Comparable<Edge> {
        int u, v, cost;

        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] p;
    static int ans;
    static int n, m;
    static ArrayList<Edge> e;

    static int find(int x) {
        if (p[x] < 0) return x;
        return p[x] = find(p[x]);
    }

    static boolean isDiffGroup(int u, int v) {
        u = find(u); v = find(v);
        if (u == v) return false;
        if (p[u] > p[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        p[u] += p[v];
        p[v] = u;
        return true;
    }

    static void solve(boolean isMaxCalc) {
        int sum = 0, cnt = 0;
        Arrays.fill(p, -1);
        for (Edge edge : e) {
            if (!isDiffGroup(edge.u, edge.v)) continue;
            cnt++;
            sum += edge.cost;
            if (cnt == n) break;
        }
        if (isMaxCalc) ans += sum * sum;
        else ans -= sum * sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        p = new int[n + 2];
        e = new ArrayList<>();

        m++;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken()) == 0 ? 1 : 0;
            e.add(new Edge(u, v, cost));
        }

        Collections.sort(e);
        solve(false);

        Collections.sort(e, Collections.reverseOrder());
        solve(true);

        System.out.println(ans);
    }
}

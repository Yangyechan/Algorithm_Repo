package BaekjunOnlineJudge.dijkstra;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class No_17835 {
//    static int N, M;
//    static class City implements Comparable<City> {
//        int dis, idx;
//
//        City(int dis, int idx) {
//            this.dis = dis;
//            this.idx = idx;
//        }
//
//        @Override
//        public int compareTo(City o) {
//            return dis - o.dis;
//        }
//    }
//    static class dist implements Comparable<dist> {
//        int num, dis;
//
//        dist(int num, int dis) {
//            this.num = num;
//            this.dis = dis;
//        }
//
//        @Override
//        public int compareTo(dist o) {
//            if (dis == o.dis) {
//                return num - o.num;
//            }
//            return o.dis - dis;
//        }
//    }
//    static List<List<City>> lists = new ArrayList<>();
//    static final int INF = Integer.MAX_VALUE;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] ip = br.readLine().split(" ");
//        N = Integer.parseInt(ip[0]);
//        M = Integer.parseInt(ip[1]);
//        int K = Integer.parseInt(ip[2]);
//
//        for (int i = 0; i <= N; i++) {
//            lists.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < M; i++) {
//            ip = br.readLine().split(" ");
//            int u = Integer.parseInt(ip[0]);
//            int v = Integer.parseInt(ip[1]);
//            int c = Integer.parseInt(ip[2]);
//            lists.get(u).add(new City(c, v));
//        }
//
//        Set<Integer> corp = new HashSet<>();
//        ip = br.readLine().split(" ");
//        for (int i = 0; i < K; i++) {
//            corp.add(Integer.parseInt(ip[i]));
//        }
//
//        PriorityQueue<dist> pq = new PriorityQueue<>();
//        for (int ed : corp) {
//            for (int i = 1; i <= N; i++) {
//                if (!corp.contains(i)) {
//                    int dis = func(i, ed);
//                    pq.offer(new dist(i, dis));
//                }
//            }
//        }
//
//        System.out.println(func(9, 1));
//        System.out.println(pq.peek().num);
//        System.out.println(pq.peek().dis);
//    }
//    static int func(int st, int ed) {
//        int[] d = new int[N+1];
//        Arrays.fill(d, INF);
//
//        PriorityQueue<City> pq = new PriorityQueue<>();
//        d[st] = 0;
//        pq.offer(new City(d[st], st));
//        while (!pq.isEmpty()) {
//            City now = pq.poll();
//
//            if (d[now.idx] != now.dis) continue;
//
//            for (City nxt : lists.get(now.idx)) {
//                if (d[nxt.idx] <= d[now.idx] + nxt.dis) continue;
//
//                d[nxt.idx] = d[now.idx] + nxt.dis;
//                pq.offer(new City(d[nxt.idx], nxt.idx));
//            }
//        }
//
//        return d[ed];
//    }
//}

import java.util.*;

public class No_17835 {
    private static final int MX = 100002;
    private static final long INF = Long.MAX_VALUE;

    private static int n, m, k;
    private static long[] d = new long[MX];
    private static List<Pair>[] adj = new ArrayList[MX];
    private static PriorityQueue<Pair> pq = new PriorityQueue<>();

    static class Pair implements Comparable<Pair> {
        long w;
        int v;

        Pair(long w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Pair o) {
            return Long.compare(this.w, o.w);
        }
    }

    public static void solve() {
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            long w = pair.w;
            int u = pair.v;

            if (d[u] != w) continue;
            for (Pair nxt : adj[u]) {
                long dw = nxt.w;
                int v = nxt.v;
                dw += w;
                if (dw >= d[v]) continue;
                d[v] = dw;
                pq.offer(new Pair(dw, v));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        Arrays.fill(d, INF);

        for (int i = 0; i < n + 1; i++)
            adj[i] = new ArrayList<>();

        while (m-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();
            adj[v].add(new Pair(w, u));
        }

        while (k-- > 0) {
            int ct = sc.nextInt();
            d[ct] = 0;
            pq.offer(new Pair(0, ct));
        }

        solve();

        int cidx = 1;
        for (int i = 2; i <= n; i++)
            if (d[i] > d[cidx])
                cidx = i;

        System.out.println(cidx + "\n" + d[cidx]);
    }
}

package BaekjunOnlineJudge.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class No_10423 {
    static int[] parent;
    static class node implements Comparable<node> {
        int a, b, c;

        node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(node o) {
            return c - o.c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);
        int K = Integer.parseInt(ip[2]);

        parent = new int[N + 1];
        Arrays.fill(parent, -1);

        ip = br.readLine().split(" ");
        int st = Integer.parseInt(ip[0]);
        for (int i = 1; i < K; i++) {
            int tmp = Integer.parseInt(ip[i]);
            union(st, tmp);
        }

        PriorityQueue<node> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int c = Integer.parseInt(ip[2]);
            pq.offer(new node(a, b, c));
        }
        long ans = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            node now = pq.poll();

            if (!union(now.a, now.b)) continue;
            ans += now.c;
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

        parent[b] = a;
        return true;
    }
}

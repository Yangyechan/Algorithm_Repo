package BarkingDog_Cicle2.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class No_10423 {
    static int[] parent;
    static class Node implements Comparable<Node> {
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);
        int K = Integer.parseInt(ip[2]);

        parent = new int[N+1];
        Arrays.fill(parent, -1);
        ip = br.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(ip[i]);
            union(0, num);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int c = Integer.parseInt(ip[2]);

            pq.offer(new Node(a, b, c));
        }

        int cnt = 0;
        long ans = 0;
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

        if (a < b) parent[b] = a;
        else parent[a] = b;

        return true;
    }
}

package BarkingDog_Cicle2.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentMap;

public class No_1368 {
    static class Node implements Comparable<Node> {
        int a, b, c;

        Node (int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return c - o.c;
        }
    }
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.offer(new Node(N, i, num));
        }

        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(ip[j]);

                if (num == 0) continue;

                pq.offer(new Node(i, j, num));
            }
        }

        parent = new int[N+1];
        Arrays.fill(parent, -1);

        long ans = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            int a = now.a;
            int b = now.b;
            int c = now.c;

            if (!union(a, b)) continue;

            ans += c;
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

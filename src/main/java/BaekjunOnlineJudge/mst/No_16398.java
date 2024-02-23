package BaekjunOnlineJudge.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class No_16398 {
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
        int N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        Arrays.fill(parent, -1);

        PriorityQueue<node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");
            for (int j = i; j < N; j++) {
                int num = Integer.parseInt(ip[j]);
                if (num == 0) continue;

                pq.offer(new node(i+1, j+1, num));
            }
        }

        long ans = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            node now = pq.poll();
            int a = now.a;
            int b = now.b;
            int c = now.c;

            if (!union(a, b)) continue;

            ans += c;
            cnt++;
            if (cnt == N-1) break;
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


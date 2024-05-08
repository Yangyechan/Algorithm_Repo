package BarkingDog_Cicle2.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class No_13418 {
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
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);

        PriorityQueue<Node> pq1 = new PriorityQueue<>();
        PriorityQueue<Node> pq2 = new PriorityQueue<>(Collections.reverseOrder());


        int ans1 = 0;
        int ans2 = 0;

        for (int i = 0; i <= M; i++) {
            ip = br.readLine().split(" ");

            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            int c = Integer.parseInt(ip[2]);
            int tmp = (c + 1) % 2;

            if (i == 0) {
                ans1 += tmp;
                ans2 += tmp;
                continue;
            }

            pq1.offer(new Node(a, b, tmp));
            pq2.offer(new Node(a, b, tmp));
        }

        parent = new int[N+1];
        Arrays.fill(parent, -1);
        parent[1] = 0;

        int cnt = 0;
        while (!pq1.isEmpty()) {
            Node now = pq1.poll();

            int a = now.a;
            int b = now.b;
            int c = now.c;

            if (!union(a, b)) continue;

            ans1 += c;
            cnt++;
            if (cnt == N-1) break;
        }

        Arrays.fill(parent, -1);
        parent[1] = 0;

        cnt = 0;
        while (!pq2.isEmpty()) {
            Node now = pq2.poll();

            int a = now.a;
            int b = now.b;
            int c = now.c;

            if (!union(a, b)) continue;

            ans2 += c;
            cnt++;
            if (cnt == N-1) break;
        }

        int sum2 = (int) Math.pow(ans2, 2);
        int sum1 = (int) Math.pow(ans1, 2);

        System.out.println(sum2 - sum1);
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

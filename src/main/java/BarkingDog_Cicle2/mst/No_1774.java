package BarkingDog_Cicle2.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class No_1774 {
    static class Node implements Comparable<Node> {
        int a, b;
        double c;

        Node(int a, int b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            if (c > o.c){
                return 1;
            } else if (c == o.c) {
                return 0;
            }else {
                return -1;
            }
        }
    }
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});

        for (int i = 0; i < N; i++) {
            ip = br.readLine().split(" ");

            int x = Integer.parseInt(ip[0]);
            int y = Integer.parseInt(ip[1]);

            list.add(new int[]{x, y});
        }

        parent = new int[N+1];
        Arrays.fill(parent, -1);

        for (int i = 0; i < M; i++) {
            ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);

            union(a, b);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            int ax = list.get(i)[0];
            int ay = list.get(i)[1];
            for (int j = i+1; j <= N; j++) {
                int bx = list.get(j)[0];
                int by = list.get(j)[1];

                double tmp1 = Math.pow((ax - bx), 2);
                double tmp2 = Math.pow((ay - by), 2);
                double dis = Math.sqrt(tmp1 + tmp2);

                pq.offer(new Node(i, j, dis));
            }
        }

        double ans = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            int a = now.a;
            int b = now.b;
            double c = now.c;

            if (!union(a, b)) continue;

            ans += c;
            cnt++;
            if (cnt == N-1) break;
        }

        System.out.printf("%.2f", ans);
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

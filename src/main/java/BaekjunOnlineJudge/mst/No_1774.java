package BaekjunOnlineJudge.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class No_1774 {
    static int[] parent;
    static class node {
        int a, b;

        node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static class nodeDis implements Comparable<nodeDis> {
        int num1, num2;
        double dis;

        nodeDis(int num1, int num2, double dis) {
            this.num1 = num1;
            this.num2 = num2;
            this.dis = dis;
        }

        @Override
        public int compareTo(nodeDis o) {
            if (dis < o.dis) return -1;
            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);

        List<node> nodeList = new ArrayList<>();
        nodeList.add(new node(0, 0));
        for (int i = 1; i <= N; i++) {
            ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            nodeList.add(new node(a, b));
        }

        parent = new int[N + 1];
        Arrays.fill(parent, -1);

        PriorityQueue<nodeDis> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            union(a, b);
            pq.offer(new nodeDis(a, b, 0));
        }


        for (int i = 1; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {
                pq.offer(new nodeDis(i, j, distance(nodeList.get(i), nodeList.get(j))));
            }
        }

        double ans = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            nodeDis now = pq.poll();

            if (!union(now.num1, now.num2)) continue;

            ans += now.dis;
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

    static double distance(node a, node b) {
        return Math.sqrt(Math.pow((a.a - b.a), 2) + Math.pow((a.b - b.b), 2));
    }
}

package BaekjunOnlineJudge.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class node1 implements Comparable<node1> {
    int a, b, c;

    node1(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(node1 o) {
        return c - o.c;
    }
}
public class No_1368 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<node1> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.offer(new node1(N+1, i+1, num));
        }

        parent = new int[N + 2];
        Arrays.fill(parent, -1);
        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(ip[j]);
                if (num == 0) continue;
                pq.offer(new node1(i+1, j+1, num));
            }
        }

        int ans = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            node1 now = pq.poll();
            int a = now.a;
            int b = now.b;
            int c = now.c;
            if (!union(a, b)) continue;
            ans += c;
            cnt++;
            if (cnt == N+1) break;
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

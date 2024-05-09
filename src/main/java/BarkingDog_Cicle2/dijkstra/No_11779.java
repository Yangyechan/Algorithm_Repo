package BarkingDog_Cicle2.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class No_11779 {
    static final int INF = Integer.MAX_VALUE;
    static class Node implements Comparable<Node> {
        int idx, dis;

        Node(int idx, int dis) {
            this.idx = idx;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return dis - o.dis;
        }
    }
    static int[] d;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Node>> lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] ip = br.readLine().split(" ");
            int st = Integer.parseInt(ip[0]);
            int ed = Integer.parseInt(ip[1]);
            int dis = Integer.parseInt(ip[2]);

            lists.get(st).add(new Node(ed, dis));
        }

        String[] ip = br.readLine().split(" ");
        int st = Integer.parseInt(ip[0]);
        int ed = Integer.parseInt(ip[1]);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        d = new int[n+1];
        Arrays.fill(d, INF);
        d[st] = 0;

        parent = new int[n+1];

        pq.offer(new Node(st, d[st]));
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.dis != d[now.idx]) continue;

            for (Node nxt : lists.get(now.idx)) {

                if (d[nxt.idx] <= nxt.dis + d[now.idx]) continue;

                d[nxt.idx] = nxt.dis + d[now.idx];
                parent[nxt.idx] = now.idx;
                pq.offer(new Node(nxt.idx, d[nxt.idx]));
            }
        }

        int tmp = ed;
        List<Integer> list = new ArrayList<>();
        while (tmp != st) {
            list.add(tmp);
            tmp = parent[tmp];
        }
        list.add(st);

        System.out.println(d[ed]);
        System.out.println(list.size());
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}

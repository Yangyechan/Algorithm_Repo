package BaekjunOnlineJudge.topologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1766 {
    static List<List<Integer>> lists = new ArrayList<>();
    static int[] deg;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        deg = new int[N + 1];
        for (int i = 0; i < M; i++) {
            ip = br.readLine().split(" ");
            int a = Integer.parseInt(ip[0]);
            int b = Integer.parseInt(ip[1]);
            deg[b]++;
            lists.get(a).add(b);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(lists.get(i));
        }

        pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (deg[i] == 0) {
                pq.offer(i);
            }
        }

        BFS();
        System.out.println(sb);
    }
    static void BFS() {
        while (!pq.isEmpty()) {
            int now = pq.poll();
            sb.append(now + " ");
            for (int nxt : lists.get(now)) {
                deg[nxt]--;
                if (deg[nxt] == 0) {
                    pq.offer(nxt);
                }
            }
        }
    }
}

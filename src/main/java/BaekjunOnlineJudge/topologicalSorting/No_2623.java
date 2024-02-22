package BaekjunOnlineJudge.topologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_2623 {
    static int[] deg;
    static List<List<Integer>> lists = new ArrayList<>();
    static Queue<Integer> queue;
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
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
            int s = Integer.parseInt(ip[0]);
            for (int j = 1; j < s; j++) {
                int a = Integer.parseInt(ip[j]);
                int b = Integer.parseInt(ip[j+1]);
                lists.get(a).add(b);
                deg[b]++;
            }
        }

        queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (deg[i] == 0) {
                queue.offer(i);
                cnt++;
                sb.append(i + "\n");
            }
        }
        if (queue.isEmpty()) {
            System.out.println(0);
            return;
        }

        BFS();

        if (cnt != N) {
            System.out.println(0);
            return;
        }

        System.out.println(sb);
    }
    static void BFS() {
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int nxt : lists.get(now)) {
                deg[nxt]--;
                if (deg[nxt] == 0) {
                    queue.offer(nxt);
                    cnt++;
                    sb.append(nxt + "\n");
                }
            }
        }
    }
}

package BaekjunOnlineJudge.topologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_2252 {
    static List<List<Integer>> lists;
    static int[] deg;
    static StringBuilder sb;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        lists = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        sb = new StringBuilder();
        queue = new LinkedList<>();
        deg = new int[N + 1];
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            deg[b]++;
            lists.get(a).add(b);
        }

        for (int i = 1; i <= N; i++) {
            if (deg[i] == 0) {
                queue.offer(i);
                sb.append(i + " ");
            }
        }
        BFS();
        System.out.println(sb);
    }
    static void BFS() {
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int nxt : lists.get(now)) {
                deg[nxt]--;
                if (deg[nxt] == 0) {
                    sb.append(nxt + " ");
                    queue.offer(nxt);
                }
            }
        }
    }
}

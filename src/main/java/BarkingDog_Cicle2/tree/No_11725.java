package BarkingDog_Cicle2.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_11725 {
    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            String[] ip = br.readLine().split(" ");

            int u = Integer.parseInt(ip[0]);
            int v = Integer.parseInt(ip[1]);

            lists.get(u).add(v);
            lists.get(v).add(u);
        }

        visited = new boolean[N+1];
        parent = new int[N+1];
        BFS();

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
    static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int nxt : lists.get(now)) {
                if (visited[nxt]) continue;

                visited[nxt] = true;
                parent[nxt] = now;
                queue.offer(nxt);
            }
        }
    }
}

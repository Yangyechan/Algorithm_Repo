package BaekjunOnlineJudge.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1068 {
    static List<List<Integer>> lists = new ArrayList<>();
    static int root;
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            lists.add(new ArrayList<>());
        }

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(input[i]);

            if (n == -1) {
                root = i;
                continue;
            }

            lists.get(n).add(i);
        }

        visited = new boolean[N];
        int del = Integer.parseInt(br.readLine());
        if (del == root) {
            System.out.println(0);
            return;
        }
        BFS(del);
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                set.add(i);
            }
        }

        visited = new boolean[N];
        LeafCheck(root);
        System.out.println(ans);
    }
    static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int target : lists.get(now)) {
                if (!visited[target]) {
                    visited[target] = true;
                    queue.offer(target);
                }
            }
        }
    }
    static void LeafCheck(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            boolean isLeaf = true;
            for (int nxt : lists.get(now)) {
                if (set.contains(nxt)) continue;
                if (!visited[nxt]) {
                    isLeaf = false;
                    visited[nxt] = true;
                    queue.offer(nxt);
                }
            }
            if (isLeaf) ans++;
        }
    }
}

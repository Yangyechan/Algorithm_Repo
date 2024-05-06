package BarkingDog_Cicle2.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1068 {
    static List<List<Integer>> lists = new ArrayList<>();
    static Set<Integer> removeSet;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            lists.add(new ArrayList<>());
        }

        int root = 0;
        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(ip[i]);

            if (num == -1) {
                root = i;
                continue;
            }

            lists.get(num).add(i);
        }

        removeSet = new HashSet<>();

        int st = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        parent = new int[N];
        Arrays.fill(parent, -1);
        BFS(st);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (parent[i] == st) continue;

            if (lists.get(i).size() == 1 && lists.get(i).get(0) == st) ans++;
            else if (lists.get(i).isEmpty()) ans++;
        }

        System.out.println(ans);
    }
    static void BFS(int st) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(st);
        visited[st] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            parent[now] = st;

            for (int nxt : lists.get(now)) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    queue.offer(nxt);
                }
            }
        }
    }
}

/*
4
3 2 -1 2
0
 */
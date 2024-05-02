package BarkingDog_Cicle2.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_2660 {
    static List<List<Integer>> lists = new ArrayList<>();
    static int[] score;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        while (true) {
            String[] ip = br.readLine().split(" ");
            int u = Integer.parseInt(ip[0]);
            int v = Integer.parseInt(ip[1]);

            if (u == -1 && v == -1) break;

            lists.get(u).add(v);
            lists.get(v).add(u);
        }

        score = new int[N+1];

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            Collections.sort(lists.get(i));
            BFS(i, i);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            if (min > score[i]) min = score[i];
        }

        List<Integer> candidate = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (score[i] == min) candidate.add(i);
        }

        System.out.println(min + " " + candidate.size());
        for (int i = 0; i < candidate.size(); i++) {
            System.out.print(candidate.get(i) + " ");
        }
    }
    static void BFS(int num, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, 0});
        visited[num] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (score[num] < now[1]) score[num] = now[1];

            for (int i = 0; i < lists.get(now[0]).size(); i++) {
                if (!visited[lists.get(now[0]).get(i)]) {
                    visited[lists.get(now[0]).get(i)] = true;
                    queue.offer(new int[] {lists.get(now[0]).get(i), now[1] + 1});
                }
            }
        }
    }
}

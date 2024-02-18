package BaekjunOnlineJudge.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_11403 {
    static int N;
    static List<List<Integer>> lists;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        lists = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(input[j-1]);
                if (num == 1) {
                    lists.get(i).add(j);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
            check();
        }

        System.out.println(sb);
    }
    static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < lists.get(now).size(); i++) {
                if (!visited[lists.get(now).get(i)]) {
                    visited[lists.get(now).get(i)] = true;
                    queue.offer(lists.get(now).get(i));
                }
            }
        }
    }

    static void check() {
        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                sb.append(1 + " ");
            }else {
                sb.append(0 + " ");
            }
        }
        sb.append("\n");
    }
}

package BaekjunOnlineJudge.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_6118 {
    static List<List<Integer>> lists;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        lists = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            lists.get(a).add(b);
            lists.get(b).add(a);
        }

        int[] count = new int[N + 1];
        int max = 0;
        visited = new boolean[N + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int j = 0; j < lists.get(now[0]).size(); j++) {
                if (!visited[lists.get(now[0]).get(j)]) {
                    visited[lists.get(now[0]).get(j)] = true;
                    max = Math.max(max, now[1] + 1);
                    count[lists.get(now[0]).get(j)] = now[1] + 1;
                    queue.offer(new int[]{lists.get(now[0]).get(j), now[1] + 1});
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (max == count[i]) {
                cnt++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (max == count[i]) {
                System.out.println(i + " " + max + " " + cnt);
                break;
            }
        }
    }
}

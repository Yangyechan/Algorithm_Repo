package BaekjunOnlineJudge.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_2606 {
    static List<List<Integer>> lists;
    static boolean[] visited;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        lists = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            lists.get(x).add(y);
            lists.get(y).add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(lists.get(i));
        }

        visited[1] = true;
        DFS(1);
        System.out.println(cnt);
    }
    static void DFS(int x) {
        visited[x] = true;
        for (int i = 0; i < lists.get(x).size(); i++) {
            if (!visited[lists.get(x).get(i)]) {
                cnt++;
                DFS(lists.get(x).get(i));
            }
        }
    }
}

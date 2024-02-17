package BaekjunOnlineJudge.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_11724 {
    static int N, M;
    static boolean[] visited;
    static List<List<Integer>> lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        lists = new ArrayList<>();
        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] input2 = br.readLine().split(" ");
            int x = Integer.parseInt(input2[0]);
            int y = Integer.parseInt(input2[1]);
            lists.get(x).add(y);
            lists.get(y).add(x);
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                cnt++;
                DFS(i);
            }
        }
        System.out.println(cnt);
    }
    static void DFS(int x) {
        if (!visited[x]) visited[x] = true;

        for (int i = 0; i < lists.get(x).size(); i++) {
            if (!visited[lists.get(x).get(i)]) {
                DFS(lists.get(x).get(i));
            }
        }
    }
}

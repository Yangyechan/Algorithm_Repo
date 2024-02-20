package BaekjunOnlineJudge.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            lists.get(a).add(b);
            lists.get(b).add(a);
        }

        visited = new boolean[N + 1];
        parent = new int[N + 1];
        DFS(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
    static void DFS(int x) {

        for (int nxt : lists.get(x)) {
            if (!visited[nxt]) {
                visited[nxt] = true;
                parent[nxt] = x;
                DFS(nxt);
            }
        }
    }
}

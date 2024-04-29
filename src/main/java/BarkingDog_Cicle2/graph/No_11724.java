package BarkingDog_Cicle2.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_11724 {
    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);

        visited = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            ip = br.readLine().split(" ");
            int u = Integer.parseInt(ip[0]);
            int v = Integer.parseInt(ip[1]);

            lists.get(u).add(v);
            lists.get(v).add(u);
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

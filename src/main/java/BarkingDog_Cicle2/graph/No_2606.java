package BarkingDog_Cicle2.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_2606 {
    static List<List<Integer>> lists = new ArrayList<>();
    static boolean[] visited;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] ip = br.readLine().split(" ");
            int u = Integer.parseInt(ip[0]);
            int v = Integer.parseInt(ip[1]);

            lists.get(u).add(v);
            lists.get(v).add(u);
        }

        visited = new boolean[N+1];
        visited[1] = true;
        DFS(1);

        System.out.println(ans);
    }
    static void DFS(int x) {
        for (int i = 0; i < lists.get(x).size(); i++) {
            if (!visited[lists.get(x).get(i)]) {
                visited[lists.get(x).get(i)] = true;
                ans++;
                DFS(lists.get(x).get(i));
            }
        }
    }
}

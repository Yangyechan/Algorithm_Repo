package BarkingDog_Cicle2.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_4803 {
    static List<List<Integer>> lists;
    static boolean[] visited;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 0;

        while (true) {
            tc++;
            String[] ip = br.readLine().split(" ");

            int n = Integer.parseInt(ip[0]);
            int m = Integer.parseInt(ip[1]);

            if (n == 0 && m == 0) break;

            lists = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                lists.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                ip = br.readLine().split(" ");

                int u = Integer.parseInt(ip[0]);
                int v = Integer.parseInt(ip[1]);

                lists.get(u).add(v);
                lists.get(v).add(u);
            }

            visited = new boolean[n+1];
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                visited[i] = true;
                check = true;
                DFS(i, -1);
                if (check) ans++;
            }

            if (ans > 1) {
                sb.append("Case " + tc + ": A forest of " + ans + " trees.\n");
            } else if (ans == 1) {
                sb.append("Case " + tc + ": There is one tree.\n");
            }else {
                sb.append("Case " + tc + ": No trees.\n");
            }
        }

        System.out.println(sb);
    }
    static void DFS(int x, int prev) {
        for (int nxt : lists.get(x)) {
            if (nxt == prev) continue;

            if (visited[nxt]) {
                check = false;
                continue;
            }

            visited[nxt] = true;
            DFS(nxt, x);
        }
    }
}

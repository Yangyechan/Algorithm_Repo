package BaekjunOnlineJudge.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_4803 {
    static List<List<Integer>> lists;
    static boolean[] visited;
    static boolean isTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        while (true) {
            cnt++;
            String[] input = br.readLine().split(" ");
            if (input[0].equals("0") && input[1].equals("0")) break;

            lists = new ArrayList<>();
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            for (int i = 0; i <= n; i++) {
                lists.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                String[] input2 = br.readLine().split(" ");
                int a = Integer.parseInt(input2[0]);
                int b = Integer.parseInt(input2[1]);

                lists.get(a).add(b);
                lists.get(b).add(a);
            }

            int ans = 0;
            visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                visited[i] = true;
                isTree = true;
                DFS(i, -1);
                if (isTree) ans++;
            }

            if (ans == 0) {
                sb.append("Case " + cnt + ": No trees.\n");
            } else if (ans == 1) {
                sb.append("Case " + cnt + ": There is one tree.\n");
            }else {
                sb.append("Case " + cnt + ": A forest of " + ans + " trees.\n");
            }
        }
        System.out.println(sb);
    }
    static void DFS(int x, int prev) {
        for (int nxt : lists.get(x)) {
            if (nxt == prev) continue;

            if (visited[nxt]) {
                isTree = false;
                continue;
            }

            visited[nxt] = true;
            DFS(nxt, x);
        }
    }
}

//import java.util.*;
//
//public class Main {
//    static final int MXN = 510;
//    static ArrayList<Integer>[] adj = new ArrayList[MXN];
//    static boolean[] vis = new boolean[MXN];
//    static boolean isTree;
//    static int n, m, u, v, tc, trees;
//
//    public static void dfs(int cur, int prev) {
//        for (int nxt : adj[cur]) {
//            if (nxt == prev) // next가 부모(prev)일 경우 건너뜀
//                continue;
//            if (vis[nxt]) { // 트리일 경우 자식은 반드시 이전에 방문한 적이 없었어야 하고, 이전에 방문을 했다면 현재 보고 있는 connected component가 트리가 아님을 의미
//                isTree = false;
//                continue;
//            }
//            vis[nxt] = true;
//            dfs(nxt, cur);
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        for (int i = 0; i < MXN; i++) {
//            adj[i] = new ArrayList<>();
//        }
//
//        while (true) {
//            n = sc.nextInt();
//            m = sc.nextInt();
//            if (n == 0 && m == 0) break;
//
//            Arrays.fill(vis, false);
//            for (int i = 1; i <= n; i++)
//                adj[i].clear();
//            trees = 0;
//
//            while (m-- > 0) {
//                u = sc.nextInt();
//                v = sc.nextInt();
//                adj[u].add(v);
//                adj[v].add(u);
//            }
//            for (int i = 1; i <= n; i++) {
//                if (vis[i]) continue;
//                vis[i] = true;
//                isTree = true;
//                dfs(i, -1);
//                trees += (isTree? 1 : 0);
//            }
//            System.out.printf("Case %d: ", ++tc);
//            if (trees == 0)
//                System.out.println("No trees.");
//            else if (trees == 1)
//                System.out.println("There is one tree.");
//            else
//                System.out.printf("A forest of %d trees.\n", trees);
//        }
//        sc.close();
//    }
//}


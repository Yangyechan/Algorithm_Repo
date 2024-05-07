package BarkingDog_Cicle2.tree;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//public class No_20955 {
//    static List<List<Integer>> lists = new ArrayList<>();
//    static boolean[] visited;
//    static boolean pos;
//    static int ans = 0;
//    static int[][] check;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] ip = br.readLine().split(" ");
//        int N = Integer.parseInt(ip[0]);
//        int M = Integer.parseInt(ip[1]);
//
//        for (int i = 0; i <= N; i++) {
//            lists.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < M; i++) {
//            ip = br.readLine().split(" ");
//            int u = Integer.parseInt(ip[0]);
//            int v = Integer.parseInt(ip[1]);
//
//            lists.get(u).add(v);
//            lists.get(v).add(u);
//        }
//
//        int cnt = 0;
//        visited = new boolean[N+1];
//        check = new int[N+1][N+1];
//        for (int i = 1; i <= N; i++) {
//            if (!visited[i]) {
//                cnt++;
//                visited[i] = true;
//                DFS(i, -1);
//            }
//        }
//
//        ans += (cnt - 1);
//        System.out.println(ans);
//    }
//    static void DFS(int x, int pre) {
//        for (int nxt : lists.get(x)) {
//            if (nxt == pre) continue;
//
//            if (!visited[nxt]) {
//                visited[nxt] = true;
//                DFS(nxt, x);
//            }else {
//                if (check[x][nxt] == 0) {
//                    ans++;
//                    check[x][nxt] = 1;
//                    check[nxt][x] = 1;
//                }
//            }
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_20955 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);

        parent = new int[N+1];
        Arrays.fill(parent, -1);

        int ans = 0;
        for (int i = 0; i < M; i++) {
            ip = br.readLine().split(" ");
            int u = Integer.parseInt(ip[0]);
            int v = Integer.parseInt(ip[1]);

            if (!union(u, v)) ans++;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(find(i));
        }

        ans += set.size()-1;

        System.out.println(ans);
    }
    static int find(int x) {
        return parent[x] < 0 ? x : (parent[x] = find(parent[x]));
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
            return true;
        } else if (a > b) {
            parent[a] = b;
            return true;
        }

        return false;
    }
}


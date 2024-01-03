package boj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_9466 {
    static boolean[] visited;
    static boolean[] finished;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            arr = new int[n + 1];
            cnt = 0;
            String[] str = br.readLine().split(" ");
            for (int i = 1; i <= str.length; i++) {
                arr[i] = Integer.parseInt(str[i - 1]);
            }
            for (int i = 1; i <= n; i++) {
                DFS(i);
            }
            System.out.println(n - cnt);
        }
    }
    static void DFS(int now) {
        if (visited[now]) {
            return;
        }
        visited[now] = true;
        int next = arr[now];
        if (!visited[next]) {
            DFS(next);
        }else {
            if (!finished[next]) {
                //finished[now] = true;
                cnt++;
                for (int i = next; i != now ; i = arr[i]) {
                    cnt++;
                    //finished[i] = true;
                }
            }
        }
        finished[now] = true;
    }
}

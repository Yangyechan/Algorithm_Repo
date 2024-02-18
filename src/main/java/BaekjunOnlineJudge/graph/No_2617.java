package BaekjunOnlineJudge.graph;

import java.util.*;
import java.io.*;

public class No_2617 {
    static int n, m;
    static ArrayList<Integer>[] hv, li;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        hv = new ArrayList[n + 1];
        li = new ArrayList[n + 1];
        vis = new boolean[n + 1];

        for(int i = 0; i <= n; i++) {
            hv[i] = new ArrayList<>();
            li[i] = new ArrayList<>();
        }

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            hv[u].add(v);
            li[v].add(u);
        }

        int ans = 0;
        for(int i = 1; i <= n; i++)
            ans += (solve(i, hv) || solve(i, li)) ? 1 : 0;
        System.out.println(ans);
    }

    static boolean solve(int st, ArrayList<Integer>[] adj) {
        Arrays.fill(vis, false);
        Queue<Integer> q = new LinkedList<>();

        q.offer(st);
        vis[st] = true;

        int cnt = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int nxt : adj[cur]) {
                if(vis[nxt]) continue;
                q.offer(nxt);
                vis[nxt] = true;
                cnt++;
            }
        }
        return cnt >= (n + 1) / 2;
    }
}


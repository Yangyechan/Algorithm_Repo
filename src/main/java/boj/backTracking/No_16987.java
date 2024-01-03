package boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_16987 {
    static int n;
    static int[] s, w;
    static int mx = 0;
    static int cnt = 0; // 깨져있는 계란의 수

    static void solve(int a) { // a번째 계란으로 다른걸 깰 차례
        if (a == n) {
            mx = Math.max(mx, cnt);
            return;
        }
        if (s[a] <= 0 || cnt == n - 1) {
            solve(a + 1);
            return;
        } // a번째 계란이 깨져있거나 다른 모든 계란이 깨져있으면 넘어감
        for (int t = 0; t < n; t++) { // t번째 계란을 내려치고 싶다
            if (t == a || s[t] <= 0) continue;
            s[a] -= w[t];
            s[t] -= w[a];
            if (s[a] <= 0) cnt++;
            if (s[t] <= 0) cnt++;
            solve(a + 1);
            if (s[a] <= 0) cnt--;
            if (s[t] <= 0) cnt--;
            s[a] += w[t];
            s[t] += w[a];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        w = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }
        solve(0);
        System.out.println(mx);
    }
}

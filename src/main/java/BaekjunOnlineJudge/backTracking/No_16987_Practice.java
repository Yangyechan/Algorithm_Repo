package BaekjunOnlineJudge.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_16987_Practice {
    static int N;
    static int[] s, w;
    static int cnt = 0;
    static int mx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        s = new int[N];
        w = new int[N];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            s[i] = Integer.parseInt(str[0]);
            w[i] = Integer.parseInt(str[1]);
        }
        egg(0);
        System.out.println(mx);
    }
    static void egg(int idx) {
        if (idx == N) {
            mx = Math.max(mx, cnt);
            return;
        }
        if (s[idx] <= 0 || cnt == N - 1) {
            egg(idx + 1);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (s[i] <= 0 || i == idx) continue;
            s[idx] -= w[i];
            s[i] -= w[idx];
            if (s[idx] <= 0) cnt++;
            if (s[i] <= 0) cnt++;
            egg(idx + 1);
            if (s[idx] <= 0) cnt--;
            if (s[i] <= 0) cnt--;
            s[idx] += w[i];
            s[i] += w[idx];
        }
    }
}

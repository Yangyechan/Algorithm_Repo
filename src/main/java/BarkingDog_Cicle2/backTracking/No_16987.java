package BarkingDog_Cicle2.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_16987 {
    static int N;
    static int[] S, W;
    static int max = 0;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N];
        W = new int[N];

        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");
            int s = Integer.parseInt(ip[0]);
            int w = Integer.parseInt(ip[1]);

            S[i] = s;
            W[i] = w;
        }

        backTracking(0);
        System.out.println(max);
    }
    static void backTracking(int depth) {
        if (depth == N) {
            max = Math.max(max, cnt);
            return;
        }

        if (S[depth] <= 0 || cnt == N-1) {
            backTracking(depth+1);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == depth || S[i] <= 0) continue;

            S[depth] -= W[i];
            S[i] -= W[depth];

            if (S[depth] <= 0) cnt++;
            if (S[i] <= 0) cnt++;
            backTracking(depth+1);

            if (S[depth] <= 0) cnt--;
            if (S[i] <= 0) cnt--;

            S[depth] += W[i];
            S[i] += W[depth];
        }
    }
}

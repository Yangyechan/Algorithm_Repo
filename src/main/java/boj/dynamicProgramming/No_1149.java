package boj.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] house = new long[N][3];
        long[] R = new long[N];
        long[] G = new long[N];
        long[] B = new long[N];
        for (int t = 0; t < N; t++) {
            String[] str = br.readLine().split(" ");
            long r = Long.parseLong(str[0]);
            long g = Long.parseLong(str[1]);
            long b = Long.parseLong(str[2]);
            R[t] = r;
            G[t] = g;
            B[t] = b;
        }
        house[0][0] = R[0];
        house[0][1] = G[0];
        house[0][2] = B[0];

        for (int i = 1; i < N; i++) {
            house[i][0] = Math.min(house[i-1][1], house[i-1][2]) + R[i];
            house[i][1] = Math.min(house[i-1][0], house[i-1][2]) + G[i];
            house[i][2] = Math.min(house[i-1][0], house[i-1][1]) + B[i];
        }
        long min = Math.min(house[N-1][0], house[N-1][1]);
        min = Math.min(min, house[N-1][2]);
        System.out.println(min);
    }
}

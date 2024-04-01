package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] R = new long[N];
        long[] G = new long[N];
        long[] B = new long[N];

        long[][] d = new long[N][3];
        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");
            R[i] = Long.parseLong(ip[0]);
            G[i] = Long.parseLong(ip[1]);
            B[i] = Long.parseLong(ip[2]);
        }

        d[0][0] = R[0];
        d[0][1] = G[0];
        d[0][2] = B[0];

        for (int i = 1; i < N; i++) {
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + R[i];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + G[i];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + B[i];
        }

        long min = Math.min(d[N-1][0], d[N-1][1]);
        min = Math.min(min, d[N-1][2]);
        System.out.println(min);
    }
}

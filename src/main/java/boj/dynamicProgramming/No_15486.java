package boj.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] t = new int[N+2];
        long[] p = new long[N+2];
        long[] d = new long[N+2];
        for (int i = 1; i <= N; i++) {
            String[] str = br.readLine().split(" ");
            int nt = Integer.parseInt(str[0]);
            long np = Long.parseLong(str[1]);
            t[i] = nt;
            p[i] = np;
        }

        for (int i = N; i >= 1; i--) {
            if (i + t[i] <= N + 1) {
                d[i] = Math.max(d[i + t[i]] + p[i], d[i+1]);
            }else {
                d[i] = d[i+1];
            }
        }

        Arrays.sort(d);
        System.out.println(d[N+1]);
    }
}

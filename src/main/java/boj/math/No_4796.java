package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        while (true) {
            String[] input = br.readLine().split(" ");
            int l = Integer.parseInt(input[0]);
            int p = Integer.parseInt(input[1]);
            int v = Integer.parseInt(input[2]);
            if (l == 0 && p == 0 && v == 0) {
                System.out.println(sb);
                return;
            }

            long ans = (v / p * l) + Math.min(v % p, l);
            sb.append("Case " + tc + ": " + ans + "\n");
            tc++;
        }
    }
}

package BaekjunOnlineJudge.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] isPrime = new boolean[246913];
        for (int i = 2; i <= 246912; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i*i <= 246912; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= 246912; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int start = n;
            int end = 2 * n;
            int cnt = 0;
            for (int i = start + 1; i <= end; i++) {
                if (isPrime[i]) cnt++;
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}

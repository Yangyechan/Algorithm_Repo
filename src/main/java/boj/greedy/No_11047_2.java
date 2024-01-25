package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11047_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }

        int idx = N - 1;
        int cnt = 0;
        while (idx >= 0) {
            if (coins[idx] <= K) {
                K = K - coins[idx];
                cnt++;
            }else {
                idx--;
            }
        }
        System.out.println(cnt);
    }
}

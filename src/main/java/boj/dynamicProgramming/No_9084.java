package boj.dynamicProgramming;

import java.util.Scanner;

public class No_9084 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int[] coins = new int[N];

            for (int i = 0; i < N; i++) {
                coins[i] = sc.nextInt();
            }

            int M = sc.nextInt();
            int[] dp = new int[M + 1];
            dp[0] = 1;

            for (int i = 0; i < N; i++) {
                for (int j = coins[i]; j <= M; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }

            System.out.println(dp[M]);
        }
    }
}

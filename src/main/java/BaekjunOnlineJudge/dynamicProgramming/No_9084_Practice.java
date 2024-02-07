package BaekjunOnlineJudge.dynamicProgramming;

import java.util.Scanner;

public class No_9084_Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int q = 0; q < T; q++) {
            int N = sc.nextInt();
            int[] coins = new int[N];
            for (int i = 0; i < N; i++) {
                coins[i] = sc.nextInt();
            }

            int M = sc.nextInt();
            int[] dp = new int[M+1];
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (j - coins[i] > 0) {
                        dp[j] += dp[j - coins[i]];
                    } else if (j - coins[i] == 0) {
                        dp[j]++;
                    }
                }
            }
            System.out.println(dp[M]);
        }
    }
}

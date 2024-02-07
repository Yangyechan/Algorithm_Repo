package BaekjunOnlineJudge.dynamicProgramming;

import java.util.Scanner;

public class No_10844 {
    static final long MOD = 1000000000;
    static long[][] d = new long[101][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 초기값 설정: 1의 자리수는 모두 계단 수입니다.
        for (int i = 1; i <= 9; ++i) {
            d[1][i] = 1;
        }

        // 2의 자리수부터 N의 자리수까지 계단 수의 개수를 구합니다.
        for (int i = 2; i <= n; ++i) {
            for (int k = 0; k <= 9; ++k) {
                if (k != 0) {
                    d[i][k] += d[i - 1][k - 1];
                }
                if (k != 9) {
                    d[i][k] += d[i - 1][k + 1];
                }
                d[i][k] %= MOD; // 모듈러 연산을 통해 오버플로우 방지
            }
        }

        long ans = 0;
        // N의 자리수로 끝나는 계단 수의 개수를 모두 더합니다.
        for (int i = 0; i <= 9; ++i) {
            ans += d[n][i];
        }
        ans %= MOD; // 최종 결과에 대해 모듈러 연산

        System.out.println(ans);
        sc.close();
    }
}


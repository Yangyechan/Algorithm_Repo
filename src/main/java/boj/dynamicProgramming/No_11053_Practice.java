package boj.dynamicProgramming;

import java.util.Scanner;

public class No_11053_Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[1] = 1;
        int size = arr.length;
        int max = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        String list = "ssss";
        
    }
}

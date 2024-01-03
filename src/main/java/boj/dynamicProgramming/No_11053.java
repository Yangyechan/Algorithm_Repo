package boj.dynamicProgramming;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;  // 자기 자신을 기준으로 길이 1로 초기화
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.println(maxLen);
    }
}

//public class No_11053 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] A = new int[N];
//        A[0] = sc.nextInt();
//        int cnt = 1;
//        for (int i = 1; i < N; i++) {
//            A[i] = sc.nextInt();
//            if (A[i] > A[i-1]) {
//                cnt++;
//            }
//        }
//        System.out.println(cnt);
//    }
//}

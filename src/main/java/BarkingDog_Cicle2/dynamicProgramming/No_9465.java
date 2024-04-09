package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N];
            int[][] d = new int[2][N];

            String[] ip1 = br.readLine().split(" ");
            String[] ip2 = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr[0][i] = Integer.parseInt(ip1[i]);
                arr[1][i] = Integer.parseInt(ip2[i]);
            }

            d[0][0] = arr[0][0];
            d[1][0] = arr[1][0];
            for (int i = 1; i < N; i++) {
                if (i == 1) {
                    d[0][1] = d[1][0] + arr[0][1];
                    d[1][1] = d[0][0] + arr[1][1];
                    continue;
                }
                d[0][i] = Math.max(d[1][i-2], d[1][i-1]) + arr[0][i];
                d[1][i] = Math.max(d[0][i-2], d[0][i-1]) + arr[1][i];
            }
            int max = Math.max(d[0][N-1], d[1][N-1]);

            System.out.println(max);
        }
    }
}


//import java.util.*;
//import java.io.*;
//public class No_9465 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int t = Integer.parseInt(br.readLine());
//        for (int q = 0; q < t; q++) {
//            int n = Integer.parseInt(br.readLine());
//            int[][] cost = new int[2][n];
//            int[][] dp = new int[2][n];
//            StringTokenizer st1 = new StringTokenizer(br.readLine());
//            StringTokenizer st2 = new StringTokenizer(br.readLine());
//            for (int i = 0; i < n; i++) {
//                cost[0][i] = Integer.parseInt(st1.nextToken());
//                cost[1][i] = Integer.parseInt(st2.nextToken());
//            }
//            dp[0][0] = cost[0][0];
//            dp[1][0] = cost[1][0];
//            int max = Math.max(dp[0][0], dp[1][0]);
//            for (int i = 1; i < n; i++) {
//                if (i == 1) {
//                    dp[0][i] = dp[1][0] + cost[0][1];
//                    dp[1][i] = dp[0][0] + cost[1][1];
//                    max = Math.max(dp[0][i], dp[1][i]);
//                    continue;
//                }
//                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + cost[0][i];
//                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + cost[1][i];
//                max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
//            }
//            sb.append(max + "\n");
//        }
//        System.out.print(sb);
//    }
//}

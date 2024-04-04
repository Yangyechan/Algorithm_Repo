package BarkingDog_Cicle2.dynamicProgramming;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class No_14501 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        boolean[] visited = new boolean[N];
//
//        int[][] arr = new int[N][2];
//        for (int i = 0; i < N; i++) {
//            String[] ip = br.readLine().split(" ");
//            int t = Integer.parseInt(ip[0]);
//            int p = Integer.parseInt(ip[1]);
//            arr[i][0] = t;
//            arr[i][1] = p;
//        }
//
//        int[] d = new int[N];
//        for (int i = 0; i < N; i++) {
//
//            for (int j = 0; j < i; j++) {
//                if (d[j] > d[i]) {
//                    d[i] = d[j];
//                }
//            }
//
//            int nx = i + arr[i][0] - 1;
//            if (nx < N) {
//                if (d[nx] < d[i] + arr[i][1]) {
//                    d[nx] = d[i] + arr[i][1];
//                    visited[nx] = true;
//                }
//            }
//        }
//
//        System.out.println(d[N-1]);
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(ip[0]); // 상담을 완료하는 데 걸리는 기간
            arr[i][1] = Integer.parseInt(ip[1]); // 상담을 했을 때 받을 수 있는 금액
        }

        int[] dp = new int[N + 1]; // dp[i]는 i일까지 얻을 수 있는 최대 수익을 저장합니다.
        for (int i = 0; i < N; i++) {
            if (i + arr[i][0] <= N) { // i일에 상담을 시작했을 때, N일 안에 상담을 마칠 수 있는 경우
                dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], dp[i] + arr[i][1]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]); // i일에 상담을 하지 않는 경우, 이전까지의 최대 수익을 다음 날로 이월
        }

        System.out.println(dp[N]); // N일까지 얻을 수 있는 최대 수익 출력
    }
}

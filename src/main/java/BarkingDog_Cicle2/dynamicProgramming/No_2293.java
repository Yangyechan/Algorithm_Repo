package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int n = Integer.parseInt(ip[0]);
        int k = Integer.parseInt(ip[1]);

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.println(dp[k]);
    }
}


//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n, k;
//        n = scanner.nextInt();
//        k = scanner.nextInt();
//        int[] a = new int[10005];
//        int[] d = new int[10005];
//
//        for (int i = 0; i < n; i++) {
//            a[i] = scanner.nextInt(); // 1, 2, 5
//        }
//
//        d[0] = 1; // dp[i] = j, i == 금액, j == i원을 만드는데 가능한 경우의 수
//        for (int i = 0; i < n; i++) {
//            for (int j = a[i]; j <= k; j++) {
//                d[j] += d[j - a[i]];
//            }   // 예를 들어 d[4]를 구하는 경우, d[4] += d[4 - a[0]] 인데,
//                // a[0] == 1 일때 d[3]의 경우를 더 해준다.
//                // d[3] 이란 1원으로 만들수 있는 3의 경우의 수이기 때문에
//        }
//
//        System.out.println(d[k]);
//    }
//}

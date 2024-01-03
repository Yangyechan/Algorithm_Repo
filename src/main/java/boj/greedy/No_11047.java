package boj.greedy;

import java.util.Scanner;

public class No_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        int count = 0;

//        for (int i = N-1; i >= 0; i--){
//            if ((K / coins[i]) >= 1) {
//                int c = K / coins[i];
//                K = K - (coins[i] * c);
//                count += c;
//            }
//        }
        for (int i = N-1; i >= 0; i--) {
            if (K == 0){
                break;
            }
            if (K >= coins[i]) {
                count += K/coins[i];
                K = K % coins[i];
            }

        }
        System.out.println(count);
    }
}

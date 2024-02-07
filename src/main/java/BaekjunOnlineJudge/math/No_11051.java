package BaekjunOnlineJudge.math;

import java.util.Scanner;

public class No_11051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[1001][1001];
        for (int i = 1; i <= 1000; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
            for (int j = 1; j < i; j++) {
                arr[i][j] = (arr[i - 1][j] + arr[i - 1][j - 1]) % 10007;
            }
        }

        System.out.println(arr[n][k]);
    }
}

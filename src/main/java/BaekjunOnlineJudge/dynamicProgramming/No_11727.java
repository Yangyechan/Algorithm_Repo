package BaekjunOnlineJudge.dynamicProgramming;

import java.util.Scanner;

public class No_11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        long[] arr = new long[n+1];
        arr[1] = 1;
        arr[2] = 3;

        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i-2] * 2 + arr[i-1]) % 10007;
        }

        System.out.println(arr[n] % 10007);
    }
}

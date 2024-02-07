package BaekjunOnlineJudge.twoPointer;

import java.util.Scanner;

public class No_1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }

        int start_idx = 0;
        int end_idx = 1;
        int cnt = 0;
        int sum = 0;

        while (start_idx != N-1) {
            sum = list[start_idx] + list[end_idx];
            if (sum == M) {
                cnt++;
                if (end_idx == N-1) {
                    start_idx++;
                    end_idx = start_idx + 1;
                }else {
                    end_idx++;
                }
            } else {
                if (end_idx == N-1) {
                    start_idx++;
                    end_idx = start_idx + 1;
                }else {
                    end_idx++;
                }
            }
        }
        System.out.println(cnt);
    }
}

package BaekjunOnlineJudge.backTracking;

import java.util.Scanner;

public class No_9663_Practice {
    static int N;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        backTracking(0);
        System.out.println(cnt);
    }
    private static void backTracking(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (Possibility(depth)) {
                backTracking(depth + 1);
            }
        }
    }
    private static boolean Possibility (int c) {
        for (int i = 0; i < c; i++) {
            if (arr[c] == arr[i]) {
                return false;
            }
            else if (Math.abs(c - i) == Math.abs(arr[c] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}

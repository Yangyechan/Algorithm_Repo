package BaekjunOnlineJudge.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_15652 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[M];
        sb = new StringBuilder();
        func(0, 1);
        System.out.println(sb);
    }
    static void func(int depth, int s) {
        if (depth == M) {
            for (int x : arr) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = s; i <= N; i++) {
            arr[depth] = i;
            func(depth + 1, i);
        }
    }
}

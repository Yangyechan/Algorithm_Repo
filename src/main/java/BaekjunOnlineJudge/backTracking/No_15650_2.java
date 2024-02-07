package BaekjunOnlineJudge.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_15650_2 {
    static int N, M;
    static StringBuilder sb;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        sb = new StringBuilder();
        arr = new int[M];
        visited = new boolean[N + 1];
        func(0);
        System.out.println(sb);
    }
    static void func(int depth) {
        if (depth == M) {
            for (int x : arr) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            func(depth + 1);
        }
    }
}

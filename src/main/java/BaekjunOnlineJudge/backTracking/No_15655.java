package BaekjunOnlineJudge.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_15655 {
    static int N, M;
    static int[] arr;
    static int[] list;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        sb = new StringBuilder();
        arr = new int[N];
        list = new int[M];
        visited = new boolean[N];
        String[] str2 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str2[i]);
        }
        Arrays.sort(arr);
        func(0, 0);
        System.out.println(sb);
    }
    static void func(int depth, int s) {
        if (depth == M) {
            for (int t : list) {
                sb.append(t + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = s; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list[depth] = arr[i];
                func(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}

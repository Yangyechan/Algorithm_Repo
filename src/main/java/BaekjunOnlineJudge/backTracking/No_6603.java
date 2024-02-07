package BaekjunOnlineJudge.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_6603 {
    static int k;
    static int[] S;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                return;
            }
            String[] str = input.split(" ");
            k = Integer.parseInt(str[0]);
            S = new int[k];
            arr = new int[6];
            visited = new boolean[k];
            sb = new StringBuilder();
            for (int i = 1; i <= k; i++) {
                S[i - 1] = Integer.parseInt(str[i]);
            }
            func(0, 0);
            System.out.println(sb);
        }
    }
    static void func(int depth, int s) {
        if (depth == 6) {
            for (int t : arr) {
                sb.append(t + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = s; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = S[i];
                func(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}

package BarkingDog_Cicle2.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_15649 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        N = Integer.parseInt(ip[0]);
        M = Integer.parseInt(ip[1]);

        visited = new boolean[N+1];
        arr = new int[M];

        backTracking(0);
        System.out.println(sb);
    }
    static void backTracking(int cnt) {
        if (cnt == M) {
            for (int x : arr) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                backTracking(cnt+1);
                visited[i] = false;
            }
        }
    }
}

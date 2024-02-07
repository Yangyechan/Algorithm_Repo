package BaekjunOnlineJudge.backTracking;

import java.util.Scanner;

public class No_15649_Practice {
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        visited = new boolean[N];
        arr = new int[M];
        dfs(N, M, 0);
    }
    public static void dfs(int N, int M, int depth) {
        if (M == depth) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
}

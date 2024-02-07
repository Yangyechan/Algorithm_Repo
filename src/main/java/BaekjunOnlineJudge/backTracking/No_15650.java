package BaekjunOnlineJudge.backTracking;

import java.util.Scanner;

public class No_15650 {
    static boolean[] visited;
    public static int N, M;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N];
        arr = new int[M];
        dfs(1, 0);
    }
    public static void dfs(int at, int depth) {
        if (M == depth) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
//    public static void dfs(int at, int depth) {
//        if (M == depth) {
//            for (int a : arr) {
//                System.out.print(a + " ");
//            }
//            System.out.println();
//            return;
//        }
//        for (int i = at; i <= N; i++) {
//            arr[depth] = i;
//            dfs(i + 1, depth + 1);
//        }
//    }
}

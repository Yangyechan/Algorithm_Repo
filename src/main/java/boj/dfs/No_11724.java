package boj.dfs;

import java.util.ArrayList;
import java.util.Scanner;
public class No_11724 {
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        visited = new boolean[N+1];

        list = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int v = sc.nextInt();
            int u = sc.nextInt();
            list[v].add(u);
            list[u].add(v);
        }

        int count = 0;
        for (int i = 1; i < N+1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    private static void DFS(int i) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;

        for (int j : list[i]) {
            if (!visited[j]) {
                DFS(j);
            }
        }
    }
}
//public class No_11724 {
//    static boolean visited[];
//    static ArrayList<Integer>[] list;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//
//        visited = new boolean[N + 1];
//        list = new ArrayList[N + 1];
//        for (int i = 1; i < N+1; i++) {
//            list[i] = new ArrayList<Integer>();
//        }
//        for (int i = 0; i < M; i++) {
//            int u = sc.nextInt();
//            int v = sc.nextInt();
//            list[u].add(v);
//            list[v].add(u);
//        }
//
//        int count = 0;
//        for (int i = 1; i < N+1; i++) {
//            if (!visited[i]) {
//                count++;
//                DFS(i);
//            }
//        }
//        System.out.println(count);
//    }
//    private static void DFS(int i) {
//        if (visited[i]) return;
//
//        visited[i] = true;
//        for (int j : list[i]) {
//            if (!visited[j]) {
//                DFS(j);
//            }
//        }
//    }
//}

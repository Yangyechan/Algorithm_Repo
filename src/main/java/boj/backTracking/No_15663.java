package boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_15663 {
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
        String[] str2 = br.readLine().split(" ");
        arr = new int[N];
        list = new int[M];
        visited = new boolean[N];
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str2[i]);
        }
        Arrays.sort(arr);
        func(0);
        System.out.println(sb);
    }
    static void func(int depth) {
        if (depth == M) {
            for (int t : list) {
                sb.append(t + " ");
            }
            sb.append("\n");
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (!visited[i] && !set.contains(arr[i])) {
                visited[i] = true;
                list[depth] = arr[i];
                set.add(arr[i]);
                func(depth + 1);
                visited[i] = false;
            }
        }
    }
}

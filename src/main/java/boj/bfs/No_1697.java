package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_1697 {
    static int N, K;
    static int[] list;
    static boolean[] visited;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);
        queue = new LinkedList<>();
        list = new int[200001];
        visited = new boolean[200001];
        queue.offer(N);
        visited[N] = true;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (n == K) {
                System.out.println(list[n]);
                return;
            }
            int front = n + 1;
            int back = n - 1;
            int max = n * 2;
            if (front <= 200000 && !visited[front]) {
                list[front] = list[n] + 1;
                visited[front] = true;
                queue.offer(front);
            }
            if (back >= 0 && !visited[back]) {
                list[back] = list[n] + 1;
                visited[back] = true;
                queue.offer(back);
            }
            if (max <= 200000 && !visited[max]) {
                list[max] = list[n] + 1;
                visited[max] = true;
                queue.offer(max);
            }
        }
    }
}


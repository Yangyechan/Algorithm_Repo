package BarkingDog_Cicle2.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_13549 {
    static int N, K;
    static boolean[] visited = new boolean[200001];
    static int[] time = new int[200001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        N = Integer.parseInt(ip[0]);
        K = Integer.parseInt(ip[1]);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            int back = now-1;
            int front = now+1;
            int flash = 2*now;

            if (flash >= 0 && flash <= 200000 && !visited[flash]) {
                visited[flash] = true;
                time[flash] = time[now];
                if (flash == K) break;
                queue.offer(flash);
            }

            if (back >= 0 && !visited[back]) {
                visited[back] = true;
                time[back] = time[now] + 1;
                if (back == K) break;
                queue.offer(back);
            }

            if (front >= 0 && front <= 200000 && !visited[front]) {
                visited[front] = true;
                time[front] = time[now] + 1;
                if (front == K) break;
                queue.offer(front);
            }
        }

        System.out.println(time[K]);
    }
}

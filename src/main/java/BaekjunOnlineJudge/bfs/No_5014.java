package BaekjunOnlineJudge.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int F = Integer.parseInt(str[0]);
        int S = Integer.parseInt(str[1]);
        int G = Integer.parseInt(str[2]);
        int U = Integer.parseInt(str[3]);
        int D = Integer.parseInt(str[4]);
        int[] ele = new int[F + 1];
        boolean[] visited = new boolean[F + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        visited[S] = true;
        while (!queue.isEmpty()) {
            int s = queue.poll();
            int u = s + U;
            int d = s - D;
            if (u > 0 && u <= F && !visited[u]) {
                ele[u] = ele[s] + 1;
                visited[u] = true;
                queue.offer(u);
            }
            if (d > 0 && d <= F && !visited[d]) {
                ele[d] = ele[s] + 1;
                visited[d] = true;
                queue.offer(d);
            }
        }
        if (!visited[G]) {
            System.out.println("use the stairs");
        }else {
            System.out.println(ele[G]);
        }
    }
}

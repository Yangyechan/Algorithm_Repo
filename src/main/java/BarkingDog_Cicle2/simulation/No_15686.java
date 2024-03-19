package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class No_15686 {
    static int N, M;
    static List<int[]> list1 = new ArrayList<>();
    static List<int[]> list2 = new ArrayList<>();
    static boolean[] visited;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        N = Integer.parseInt(ip[0]);
        M = Integer.parseInt(ip[1]);

        for (int i = 0; i < N; i++) {
            ip = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(ip[j]);
                if (num == 1) list1.add(new int[]{i, j});
                else if (num == 2) list2.add(new int[]{i, j});
            }
        }

        visited = new boolean[list2.size()];
        arr = new int[M];

        backTracking(0, 0);
        System.out.println(min);
    }
    static void backTracking(int depth, int st) {
        if (depth == M) {
            int d = 0;
            for (int i = 0; i < list1.size(); i++) {
                int[] now = list1.get(i);
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for (int j = 0; j < M; j++) {
                    int[] chicken = list2.get(arr[j]);
                    int dir = 0;
                    dir += Math.abs(now[0] - chicken[0]);
                    dir += Math.abs(now[1] - chicken[1]);

                    pq.offer(dir);
                    if (dir == 1) break;
                }
                d += pq.poll();
            }

            if (d < min) min = d;
            return;
        }

        for (int i = st; i < list2.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                backTracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}

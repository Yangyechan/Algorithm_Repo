package BarkingDog_Cicle2.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class No_1941 {
    static int[][] student = new int[5][5];
    static boolean[] visited;
    static int[] arr = new int[7];
    static int ans = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String ip = br.readLine();
            for (int j = 0; j < 5; j++) {
                if (ip.charAt(j) == 'S') student[i][j] = 1;
            }
        }

        backTracking(0, 0, 0);
        System.out.println(ans);
    }
    static void backTracking(int depth, int st, int dasom) {
        if (depth - dasom > 3) return;
        if (depth == 7) {
            visited = new boolean[7];
            BFS(arr[0]);
            return;
        }

        for (int i = st; i < 25; i++) {
            arr[depth] = i;
            int x = i / 5;
            int y = i % 5;
            backTracking(depth+1, i+1, (student[x][y] == 1 ? dasom+1 : dasom));
        }
    }

    static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.offer(x);
        int num = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int nowX = now / 5;
            int nowY = now % 5;
            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                    int nxt = nx * 5 + ny;
                    for (int j = 0; j < 7; j++) {
                        if (!visited[j] && arr[j] == nxt) {
                            num++;
                            visited[j] = true;
                            queue.offer(nxt);
                        }
                    }
                }
            }
        }
        if (num == 7) ans++;
    }
}

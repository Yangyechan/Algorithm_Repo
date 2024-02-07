package BaekjunOnlineJudge.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_2468 {
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int cntMax = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }
        int num = 0;
        while (num < max) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > num) {
                        queue.offer(new int[]{i, j});
                        BFS(num, i, j);
                        cnt++;
                    }
                }
            }
            visited = new boolean[N][N];
            list.add(cnt);
            num++;
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
    }
    static void BFS(int s, int x, int y) {
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] > s && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}

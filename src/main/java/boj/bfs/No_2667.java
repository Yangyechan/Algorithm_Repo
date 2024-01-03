package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class No_2667 {
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if (str.charAt(j) == '0') {
                    visited[i][j] = true;
                    map[i][j] = 0;
                }else {
                    map[i][j] = 1;
                }
            }
        }
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    BFS(i, j);
                    queue1.offer(size);
                    size = 0;
                }
            }
        }
        int s = queue1.size();
        System.out.println(s);
        for (int i = 0; i < s; i++) {
            System.out.println(queue1.poll());
        }
    }
    static void BFS(int x, int y) {
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            size++;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}

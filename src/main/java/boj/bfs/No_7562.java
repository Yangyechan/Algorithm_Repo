package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_7562 {
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int I;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int fx, fy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visited = new boolean[I][I];
            queue = new LinkedList<>();
            String[] str = br.readLine().split(" ");
            String[] str2 = br.readLine().split(" ");
            int sx = Integer.parseInt(str[0]);
            int sy = Integer.parseInt(str[1]);
            fx = Integer.parseInt(str2[0]);
            fy = Integer.parseInt(str2[1]);
            queue.offer(new int[]{sx, sy});
            visited[sx][sy] = true;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                if (now[0] == fx && now[1] == fy) {
                    System.out.println(map[now[0]][now[1]]);
                    break;
                }
                for (int j = 0; j < 8; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if (nx >= 0 && nx < I && ny >= 0 && ny < I) {
                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            map[nx][ny] = map[now[0]][now[1]] + 1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
}

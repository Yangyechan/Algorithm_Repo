package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_1926 {
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][]map;
    static boolean[][] check;
    static Queue<int[]> queue;
    static int cnt = 0;
    static int max = 0;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][m];
        check = new boolean[n][m];
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] str2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str2[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !check[i][j]) {
                    BFS(i, j);
                    cnt++;
                }
                if (sum >= max) {
                    max = sum;
                    sum = 0;
                }else {
                    sum = 0;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }
    static void BFS(int x, int y) {
        sum++;
        if (!check[x][y]) {
            queue.add(new int[]{x,y});
            check[x][y] = true;
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {

                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 1 && !check[nx][ny]) {
                        BFS(nx, ny);
                    }
                }
            }
        }else {
            return;
        }

    }
}

package BaekjunOnlineJudge.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_1600 {
    static int K, W, H;
    static int[] dx = {-1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {0, 0, -1, 1, -2, -1, 1, 2, -2, -1, 1, 2};
    static int[][][] map;
    static boolean[][][] visited;
    static Queue<int[]> queue;
    static int result = Integer.MAX_VALUE;
    static boolean pos = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");
        W = Integer.parseInt(strings[0]);
        H = Integer.parseInt(strings[1]);
        map = new int[H][W][K + 1];
        visited = new boolean[H][W][K + 1];
        queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < W; j++) {
                for (int k = 0; k <= K; k++) {
                    map[i][j][k] = Integer.parseInt(str[j]);
                    if (map[i][j][k] == 1) {
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        if (W == 1 && H == 1) {
            if (map[H-1][W-1][0] == 0) {
                System.out.println(0);
                return;
            }else {
                System.out.println(-1);
                return;
            }
        }
        visited[0][0][0] = true;
        queue.offer(new int[]{0, 0, 0});
        BFS();

        if (pos) {
            System.out.println(result);
        }else {
            System.out.println(-1);
        }
    }
    static void BFS() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 12; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int cnt = now[2];
                if (i < 4) {
                    if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                        if (nx == H-1 && ny == W-1 && !visited[nx][ny][cnt]) {
                            visited[H-1][W-1][cnt] = true;
                            pos = true;
                            result = Integer.min(map[now[0]][now[1]][cnt] + 1, result);
                            break;
                        }
                        if (map[nx][ny][cnt] == 0 && !visited[nx][ny][cnt]) {
                            map[nx][ny][cnt] = map[now[0]][now[1]][cnt] + 1;
                            visited[nx][ny][cnt] = true;
                            queue.offer(new int[]{nx, ny, cnt});
                        }
                    }
                }else {
                    if (nx >= 0 && nx < H && ny >= 0 && ny < W  && cnt < K) {
                        if (nx == H-1 && ny == W-1 && !visited[nx][ny][cnt + 1]) {
                            visited[H-1][W-1][cnt + 1] = true;
                            pos = true;
                            result = Integer.min(map[now[0]][now[1]][cnt] + 1, result);
                            break;
                        }
                        if (map[nx][ny][cnt + 1] == 0 && !visited[nx][ny][cnt + 1]) {
                            map[nx][ny][cnt + 1] = map[now[0]][now[1]][cnt] + 1;
                            visited[nx][ny][cnt + 1] = true;
                            queue.offer(new int[]{nx, ny, cnt + 1});
                        }
                    }
                }
            }
        }
    }
}
/*
2
10 2
0 0 1 0 0 1 0 0 1 0
0 0 1 1 0 0 0 0 1 0

결과 : 10
 */

/*
1
4 4
0 0 0 0
0 0 0 0
0 0 1 1
0 0 1 0

결과 : 4
 */

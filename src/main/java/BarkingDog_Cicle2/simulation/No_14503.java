package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_14503 {
    static int N, M, cnt;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        N = Integer.parseInt(str1[0]);
        M = Integer.parseInt(str1[1]);
        map = new int[N][M];
        String[] str2 = br.readLine().split(" ");
        int r = Integer.parseInt(str2[0]);
        int c = Integer.parseInt(str2[1]);
        int nd = Integer.parseInt(str2[2]);
        for (int i = 0; i < N; i++) {
            String[] str3 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str3[j]);
            }
        }
        cnt = 1;
        clean(r, c, nd);
        System.out.println(cnt);
    }
    private static void clean(int x, int y, int d) {
        map[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx > 0 && nx < N && ny > 0 && ny < M && map[nx][ny] == 0) {
                cnt++;
                clean(nx, ny, d);
                return;
            }
        }
        int back = (d + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];
        if (bx > 0 && bx < N && by > 0 && by < M && map[bx][by] == -1) {
            clean(bx, by, d);
        }
    }
}
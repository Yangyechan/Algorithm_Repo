package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_14499 {
    static int[][] map;
    static int N, M;
    static int x, y;
    static int[] dice = new int[6]; // 윗면, 아랫면, 앞면, 뒷면, 좌측면, 우측면
                                    //   0,    1,   2,   3,    4,    5
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        x = Integer.parseInt(str[2]);
        y = Integer.parseInt(str[3]);
        int K = Integer.parseInt(str[4]);
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] str2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str2[j]);
            }
        }
        dice[2] = map[x][y];
        String[] str3 = br.readLine().split(" ");
        for (int t = 0; t < K; t++) {
            int dir = Integer.parseInt(str3[t]);
            x += dx[dir-1];
            y += dy[dir-1];
            if (x >= N || x < 0) {
                x-=dx[dir-1];
                y-=dy[dir-1];
                continue;
            } else if (y >= M || y < 0){
                x-=dx[dir-1];
                y-=dy[dir-1];
                continue;
            }
            rotate(dir);
            if (map[x][y] == 0) {
                map[x][y] = dice[1];
            } else  {
                dice[1] = map[x][y];
                map[x][y] = 0;
            }
            System.out.println(dice[0]);
        }
    }
    static void rotate(int dir) {
        int tmp = dice[0];
        if (dir == 1) {
            dice[0] = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[5];
            dice[5] = tmp;
        } else if (dir == 2) {
            dice[0] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[4];
            dice[4] = tmp;
        } else if (dir == 3) {
            dice[0] = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[2];
            dice[2] = tmp;
        }else {
            dice[0] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[3];
            dice[3] = tmp;
        }
    }
}

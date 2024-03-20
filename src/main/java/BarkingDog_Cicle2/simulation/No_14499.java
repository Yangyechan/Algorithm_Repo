package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_14499 {
    static int N, M;
    static int[] dice = new int[6]; // 윗 0, 앞 1, 아래 2, 뒤 3, 왼 4, 오 5
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");

        N = Integer.parseInt(ip[0]);
        M = Integer.parseInt(ip[1]);
        int x = Integer.parseInt(ip[2]);
        int y = Integer.parseInt(ip[3]);
        int k = Integer.parseInt(ip[4]);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            ip = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(ip[j]);
            }
        }

        StringBuilder sb = new StringBuilder();

        ip = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(ip[i]);

            x = x + dx[dir-1];
            y = y + dy[dir-1];

            if (x < 0 || x >= N || y < 0 || y >= M) {
                x = x - dx[dir-1];
                y = y - dy[dir-1];
                continue;
            }

            rotate(dir);

            if (map[x][y] > 0) {
                dice[2] = map[x][y];
                map[x][y] = 0;
            }else {
                map[x][y] = dice[2];
            }
            sb.append(dice[0] + "\n");
        }

        System.out.println(sb);
    }
    static void rotate(int dir) {
        if (dir == 1) { // 동
            int tmp = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[2];
            dice[2] = dice[5];
            dice[5] = tmp;
        } else if (dir == 2) { // 서
            int tmp = dice[0];
            dice[0] = dice[5];
            dice[5] = dice[2];
            dice[2] = dice[4];
            dice[4] = tmp;
        } else if (dir == 3) { // 북
            int tmp = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[3];
            dice[3] = tmp;
        }else { // 남
            int tmp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[2];
            dice[2] = dice[1];
            dice[1] = tmp;
        }
    }
}

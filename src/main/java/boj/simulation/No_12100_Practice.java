package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_12100_Practice {
    static int N;
    static int[][] board1 = new int[20][20];
    static int[][] board2 = new int[20][20];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board1[i][j] = Integer.parseInt(str[j]);
            }
        }
        int mx = 0;
        for (int tc = 0; tc < 1024; tc++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board2[i][j] = board1[i][j];
                }
            }
            int tmp = tc;
            for (int i = 0; i < 5; i++) {
                int dir = tmp % 4;
                tmp /= 4;
                func(dir);
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    mx = Math.max(mx, board2[i][j]);
                }
            }
        }
        System.out.print(mx);
    }
    static void func(int dir) {
        while (dir-- > 0) {
            rotate();
        }

        for (int i = 0; i < N; i++) {
            int idx = 0;
            int[] tmp = new int[20];
            for (int j = 0; j < N; j++) {
                if (board2[i][j] == 0) continue;
                if (tmp[idx] == 0) {
                    tmp[idx] = board2[i][j];
                }else if (tmp[idx] == board2[i][j]) {
                    tmp[idx] *= 2;
                    idx++;
                }else {
                    tmp[++idx] = board2[i][j];
                }
            }
            for (int j = 0; j < N; j++) {
                board2[i][j] = tmp[j];
            }
        }
    }
    static void rotate() {
        int[][] tmp = new int[20][20];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = board2[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board2[i][j] = tmp[N - 1 - j][i];
            }
        }
    }
}

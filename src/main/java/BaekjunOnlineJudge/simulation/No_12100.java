package BaekjunOnlineJudge.simulation;

import java.util.Scanner;

public class No_12100 {
    static int[][] board1 = new int[21][21];
    static int[][] board2 = new int[21][21];
    static int n;

    public static void rotate() {
        int[][] tmp = new int[21][21];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tmp[i][j] = board2[i][j];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board2[i][j] = tmp[n - 1 - j][i];
    }

    public static void tilt(int dir) {
        while (dir-- > 0) rotate();
        for (int i = 0; i < n; i++) {
            int[] tilted = new int[21];
            // 자바에서는 배열을 자동으로 0으로 초기화한다.
            int idx = 0;
            for (int j = 0; j < n; j++) {
                if (board2[i][j] == 0) continue;
                if (tilted[idx] == 0)
                    tilted[idx] = board2[i][j];
                else if (tilted[idx] == board2[i][j])
                    tilted[idx++] *= 2;
                else
                    tilted[++idx] = board2[i][j];
            }
            for (int j = 0; j < n; j++) board2[i][j] = tilted[j];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board1[i][j] = sc.nextInt();

        int mx = 0;
        for (int tmp = 0; tmp < 1024; tmp++) {
            for (int i = 0; i < n; i++)
                System.arraycopy(board1[i], 0, board2[i], 0, n);
            int brute = tmp;
            for (int i = 0; i < 5; i++) {
                int dir = brute % 4;
                brute /= 4;
                tilt(dir);
            }
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    mx = Math.max(mx, board2[i][j]);
        }
        System.out.println(mx);
        sc.close();
    }
}

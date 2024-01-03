package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class No_14503 {
    static boolean[][] clean;
    static int direction;
    static int cnt;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] start = br.readLine().split(" ");
        N = Integer.parseInt(start[0]);
        M = Integer.parseInt(start[1]);
        int[][] map = new int[N][M];
        /*
        (0, 0) (0, 1) (0, 2)
        (1, 0) (1, 1) (1, 2)
        (2, 0) (2, 1) (2, 2)
         */
        String[] position = br.readLine().split(" ");
        int nowI = Integer.parseInt(position[0]);
        int nowJ = Integer.parseInt(position[1]);
        direction = Integer.parseInt(position[2]);
        clean = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] mapStr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(mapStr[j]);
                if (map[i][j] == 1) {
                    clean[i][j] = true;
                }
            }
        }
        move(nowI, nowJ, direction);
        System.out.println(cnt);


    }
    private static void move(int i, int j, int direction) {
        if ((clean[i-1][j] && clean[i+1][j] && clean[i][j-1] && clean[i][j+1])) {
            cnt++;
            return;
        }
        if (clean[i][j]) {
            if (direction == 0) {
                direction = 1;
                i--;
                move(i, j, direction);
            } else if (direction == 1) {
                direction = 2;
                j++;
                move(i, j, direction);
            } else if (direction == 2) {
                direction = 3;
                i++;
                move(i, j, direction);
            }else {
                direction = 0;
                j--;
                move(i, j, direction);
            }
        } else {
            cnt++;
            clean[i][j] = true;
            if (direction == 0) {
                j--;
                move(i, j, direction);
            } else if (direction == 1) {
                i--;
                move(i, j, direction);
            } else if (direction == 2) {
                j++;
                move(i, j, direction);
            }else {
                i++;
                move(i, j, direction);
            }
        }

    }
}

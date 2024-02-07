package BaekjunOnlineJudge.divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2630 {
    static int[][] map;
    static int white;
    static int blue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        partition(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
    private static void partition(int x, int y, int N) {
        if (check(x, y, N)) {
            if (map[x][y] == 0) {
                white++;
            }else {
                blue++;
            }
            return;
        }
        int now = N / 2;
        partition(x, y, now);
        partition(x, y+now, now);
        partition(x+now, y, now);
        partition(x+now, y+now, now);
    }

    private static boolean check (int x, int y, int size) {
        int color = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}

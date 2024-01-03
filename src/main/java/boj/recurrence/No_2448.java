package boj.recurrence;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class No_2448 {
    static char[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], ' ');
        }
        star(0, N - 1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void star(int x, int y, int size) {
        if (size == 3) {
            map[x][y] = '*';
            map[x + 1][y - 1] = map[x + 1][y + 1] = '*';
            map[x + 2][y - 2] = map[x + 2][y - 1] = map[x + 2][y] = map[x + 2][y + 1] = map[x + 2][y + 2] = '*';
            return;
        }
        int newSize = size / 2;
        star(x, y, newSize);
        star(x + newSize, y - newSize, newSize);
        star(x + newSize, y + newSize, newSize);
    }
}

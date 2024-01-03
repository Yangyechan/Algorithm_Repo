package boj.recurrence;

import java.util.Scanner;

public class No_2447 {
    static char[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        map = new char[N][N];
        func(N, 0, 0, false);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void func(int size, int x, int y, boolean blank) {
        if (blank) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    map[i][j] = ' ';
                }
            }
            return;
        }
        if (size == 1) {
            map[x][y] = '*';
            return;
        }

        int newSize = size / 3;
        int cnt = 0;
        for (int i = x; i < x + size; i+=newSize) {
            for (int j = y; j < y + size; j+=newSize) {
                cnt++;
                if (cnt == 5) {
                    func(newSize, i, j, true);
                }else {
                    func(newSize, i, j, false);
                }
            }
        }
    }
}

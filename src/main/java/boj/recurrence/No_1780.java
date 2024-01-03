package boj.recurrence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1780 {
    static int[][] paper;
    static int R, G, B = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(str[j]);
            }
        }
        func(N, 0, 0);
        System.out.println(R);
        System.out.println(G);
        System.out.println(B);
    }
    static void func(int size, int x, int y) {
        if (check(size, x, y)) {
            if (paper[x][y] == -1) {
                R++;
            } else if (paper[x][y] == 0) {
                G++;
            }else {
                B++;
            }
            return;
        }
        int nowSize = size / 3;
        func(nowSize, x, y);
        func(nowSize, x, y + nowSize);
        func(nowSize, x, y + nowSize * 2);
        func(nowSize, x + nowSize, y);
        func(nowSize, x + nowSize, y + nowSize);
        func(nowSize, x + nowSize, y + nowSize * 2);
        func(nowSize, x + nowSize * 2, y);
        func(nowSize, x + nowSize * 2, y + nowSize);
        func(nowSize, x + nowSize * 2, y + nowSize * 2);
    }
    static boolean check(int size, int x, int y) {
        int color = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (color != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

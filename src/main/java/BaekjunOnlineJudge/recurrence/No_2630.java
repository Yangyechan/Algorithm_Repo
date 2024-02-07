package BaekjunOnlineJudge.recurrence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2630 {
    static int[][] paper;
    static int zero, one = 0;
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
        func(N,0, 0);
        System.out.println(zero);
        System.out.println(one);
    }
    static void func(int size, int x, int y) {
        if (check(size, x, y)) {
            int color = paper[x][y];
            if (color == 0) {
                zero++;
            }else {
                one++;
            }
            return;
        }
        int nowSize = size / 2;
        func(nowSize, x, y);
        func(nowSize, x, y + nowSize);
        func(nowSize, x + nowSize, y);
        func(nowSize, x + nowSize, y + nowSize);
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

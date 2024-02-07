package BaekjunOnlineJudge.recurrence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1992 {
    static int[][] map;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        func(N, 0, 0);
        System.out.println(sb);
    }
    static void func(int size, int x, int y) {
        if (check(size, x, y)) {

            int color = map[x][y];
            if (color == 0) {
                sb.append("0");
            }else {
                sb.append("1");
            }
            return;
        }
        sb.append("(");
        int nowSize = size / 2;
        func(nowSize, x, y);
        func(nowSize, x, y + nowSize);
        func(nowSize, x + nowSize, y);
        func(nowSize, x + nowSize, y + nowSize);
        sb.append(")");
    }

    static boolean check(int size, int x, int y) {
        int color = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (color != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

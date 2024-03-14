package BarkingDog_Cicle2.recurrence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1992 {
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String ip = br.readLine();
            for (int j = 0; j < N; j++) {
                if (ip.charAt(j) == '1') map[i][j] = 1;
            }
        }

        rec(N, 0, 0);
        System.out.println(sb);
    }
    static void rec(int size, int x, int y) {
        if (check(size, x, y)) {
            sb.append(map[x][y]);
        }else {
            sb.append("(");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    rec(size/2, x + (size/2)*i, y + (size/2)*j);
                }
            }
            sb.append(")");
        }
    }

    static boolean check(int size ,int x, int y) {
        int target = map[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != target) return false;
            }
        }

        return true;
    }
}

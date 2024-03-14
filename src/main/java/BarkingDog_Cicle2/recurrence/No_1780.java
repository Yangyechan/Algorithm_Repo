package BarkingDog_Cicle2.recurrence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1780 {
    static int[][] map;
    static int[] cnt = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(ip[j]);
            }
        }

        rec(N, 0, 0);
        for (int i = 0; i < 3; i++) {
            System.out.println(cnt[i]);
        }
    }
    static void rec(int size, int x, int y) {
        if (check(size, x, y)) {
            if (map[x][y] == -1) cnt[0]++;
            else if (map[x][y] == 0) cnt[1]++;
            else cnt[2]++;
        }else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    rec(size/3, x + (size/3)*i, y + (size/3)*j);
                }
            }
        }
    }

    static boolean check(int size, int x, int y) {
        int target = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size ; j++) {
                if (map[i][j] != target) {
                    return false;
                }
            }
        }
        return true;
    }
}

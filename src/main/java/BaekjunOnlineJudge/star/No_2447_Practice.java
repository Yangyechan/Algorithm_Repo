package BaekjunOnlineJudge.star;

import java.util.Scanner;

public class No_2447_Practice {
    static char[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new char[N][N];
        star(0, 0, N, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void star(int x, int y, int N, boolean blank) {
        // 공백
        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        // N = 1 일때
        if (N == 1) {
            arr[x][y] = '*';
            return;
        }


        int size = N / 3;
        int count = 0;
        for (int i = x; i < x + N; i+=size) {
            for (int j = y; j < y + N; j+=size) {
                count++;
                if (count == 5) {
                    star(i, j, size, true);
                }else {
                    star(i, j, size, false);
                }
            }
        }
    }
}

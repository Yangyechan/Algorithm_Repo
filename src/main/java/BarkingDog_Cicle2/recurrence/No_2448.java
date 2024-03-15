package BarkingDog_Cicle2.recurrence;

import java.util.Arrays;
import java.util.Scanner;

public class No_2448 {
    static char[][] star;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        star = new char[N][2*N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(star[i], ' ');
        }

        StringBuilder sb = new StringBuilder();

        rec(N, 0, N-1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2*N; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void rec(int size, int x, int y) {
        if (size == 3) {
            mark(x, y);
            return;
        }

        rec(size/2, x, y);
        rec(size/2, x + (size/2), y - (size/2));
        rec(size/2, x + (size/2), y + (size/2));
    }

    static void mark(int x, int y) {
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                star[x][y] = '*';
            } else if (i == 2) {
                star[x+1][y-1] = '*';
                star[x+1][y+1] = '*';
            }else {
                for (int j = y-2; j < y+3; j++) {
                    star[x+2][j] = '*';
                }
            }
        }
    }
}

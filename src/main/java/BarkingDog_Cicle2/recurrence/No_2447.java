package BarkingDog_Cicle2.recurrence;

import java.util.Scanner;

public class No_2447 {
    static StringBuilder sb = new StringBuilder();
    static char[][] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ch = new char[N][N];
        rec(N, 0, 0, false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ch[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    static void rec(int size, int x, int y, boolean blank) {
        if (size == 3) {
            if (blank) blankMark(x, y);
            else mark(x, y);
            return;
        }

        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cnt++;
                if (cnt == 5 || blank) {
                    rec(size/3, x + (size/3)*i, y + (size/3)*j, true);
                }else{
                    rec(size/3, x + (size/3)*i, y + (size/3)*j, false);
                }
            }
        }

    }

    static void mark(int x, int y) {
        int cnt = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                cnt++;
                if (cnt == 5) ch[i][j] = ' ';
                else ch[i][j] = '*';
            }
        }
    }

    static void blankMark(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                ch[i][j] = ' ';
            }
        }
    }
}

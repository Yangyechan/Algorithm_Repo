package workbook.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_20125 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1};
    static int[] dy = {-1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        boolean headCheck = false;
        int heartX = 0;
        int heartY = 0;
        for (int i = 0; i < N; i++) {
            String ip = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = ip.charAt(j);

                if (ch == '*') {
                    map[i][j] = 1;

                    if (!headCheck) {
                        headCheck = true;
                        heartX = i + 1;
                        heartY = j;
                    }
                }
            }
        }


    }
}

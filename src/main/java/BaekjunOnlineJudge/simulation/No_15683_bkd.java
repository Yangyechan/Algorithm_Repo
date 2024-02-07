package BaekjunOnlineJudge.simulation;

import java.util.*;
import java.io.*;

public class No_15683_bkd {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] board1 = new int[10][10];
    static int[][] board2 = new int[10][10];
    static List<Pair> cctv = new ArrayList<>();

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static boolean OOB(int a, int b) {
        return a < 0 || a >= n || b < 0 || b >= m;
    }

    static void upd(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (OOB(x, y) || board2[x][y] == 6) return;
            if (board2[x][y] != 0) continue;
            board2[x][y] = 7;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int mn = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board1[i][j] = Integer.parseInt(st.nextToken());
                if (board1[i][j] != 0 && board1[i][j] != 6)
                    cctv.add(new Pair(i, j));
                if (board1[i][j] == 0) mn++;
            }
        }
        int totalCases = (int) Math.pow(4, cctv.size()); // 모든 방향 조합의 수 계산

        for (int tmp = 0; tmp < totalCases; tmp++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board2[i][j] = board1[i][j];
                }
            }

            int brute = tmp;
            for (int i = 0; i < cctv.size(); i++) {
                int dir = brute % 4;
                brute /= 4;
                int x = cctv.get(i).first;
                int y = cctv.get(i).second;

                switch (board1[x][y]) {
                    case 1:
                        upd(x, y, dir);
                        break;
                    case 2:
                        upd(x, y, dir);
                        upd(x, y, dir + 2);
                        break;
                    case 3:
                        upd(x, y, dir);
                        upd(x, y, dir + 1);
                        break;
                    case 4:
                        upd(x, y, dir);
                        upd(x, y, dir + 1);
                        upd(x, y, dir + 2);
                        break;
                    case 5:
                        upd(x, y, dir);
                        upd(x, y, dir + 1);
                        upd(x, y, dir + 2);
                        upd(x, y, dir + 3);
                        break;
                }
            }

            int val = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (board2[i][j] == 0) val++;

            mn = Math.min(mn, val);
        }

        System.out.println(mn);
    }
}


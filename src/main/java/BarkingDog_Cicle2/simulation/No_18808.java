package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_18808 {
    static int N, M, R, C;
    static int[][] notebook;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        N = Integer.parseInt(ip[0]);
        M = Integer.parseInt(ip[1]);
        int K = Integer.parseInt(ip[2]);

        notebook = new int[N][M];

        for (int t = 0; t < K; t++) {
            ip = br.readLine().split(" ");
            R = Integer.parseInt(ip[0]);
            C = Integer.parseInt(ip[1]);

            paper = new int[R][C];

            for (int i = 0; i < R; i++) {
                ip = br.readLine().split(" ");
                for (int j = 0; j < C; j++) {
                    paper[i][j] = Integer.parseInt(ip[j]);
                }
            }

            for (int rot = 0; rot < 4; rot++) {
                boolean pos = false;
                for (int i = 0; i <= N - R; i++) {
                    if (pos) break;
                    for (int j = 0; j <= M - C; j++) {
                        if (posCheck(i, j)) {
                            pos = true;
                            break;
                        }
                    }
                }
                if (pos) break;
                rotate();
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (notebook[i][j] == 1) ans++;
            }
        }

        System.out.println(ans);
    }
    static boolean posCheck(int x, int y) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (paper[i][j] == 1 && notebook[x + i][y + j] == 1) {
                    return false;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (paper[i][j] == 1) notebook[x + i][y + j] = 1;
            }
        }
        return true;
    }

    static void rotate() {
        int[][] temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp[i][j] = paper[i][j];
            }
        }

        paper = new int[C][R];
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                paper[i][j] = temp[R-1-j][i];
            }
        }

        int tmp = R;
        R = C;
        C = tmp;
    }
}

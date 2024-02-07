package BaekjunOnlineJudge.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_18808_Practice {
    static int N, M;
    static int[][] notebook = new int[40][40];
    static int[][] paper = new int[10][10];
    static int R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        int K = Integer.parseInt(str[2]);
        for (int t = 0; t < K; t++) {
            String[] str2 = br.readLine().split(" ");
            R = Integer.parseInt(str2[0]);
            C = Integer.parseInt(str2[1]);
            for (int i = 0; i < R; i++) {
                String[] str3 = br.readLine().split(" ");
                for (int j = 0; j < C; j++) {
                    paper[i][j] = Integer.parseInt(str3[j]);
                }
            }
            for (int rot = 0; rot < 4; rot++) {
                boolean pos = false;
                for (int x = 0; x <= N - R; x++) {
                    if (pos) break;
                    for (int y = 0; y <= M - C; y++) {
                        if (postPossible(x, y)) {
                            pos = true;
                            break;
                        }
                    }
                }
                if (pos) break;
                rotate();
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (notebook[i][j] == 1) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    static boolean postPossible(int x, int y) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (paper[i][j] == 1 && notebook[x + i][y + j] == 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (paper[i][j] == 1) {
                    notebook[x + i][y + j] = 1;
                }
            }
        }
        return true;
    }

    static void rotate() {
        int[][] temp = new int[10][10];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp[i][j] = paper[i][j];
            }
        }

        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                paper[i][j] = temp[R - 1 - j][i];
            }
        }
        int tmp = R;
        R = C;
        C = tmp;
    }
}

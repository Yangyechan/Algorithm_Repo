package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_12100 {
    static int N;
    static int[][] map;
    static int[][] copyMap;
    static int[] dir = new int[5];
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(ip[j]);
            }
        }
        backTracking(0);

        System.out.println(max);
    }
    static void backTracking(int depth) {
        if (depth == 5) {
            copyMap = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < 5; i++) {
                if (dir[i] == 0) {
                    plus();
                } else if (dir[i] == 1) {
                    rotate();
                    plus();
                } else if (dir[i] == 2) {
                    rotate();
                    rotate();
                    plus();
                }else {
                    rotate();
                    rotate();
                    rotate();
                    plus();
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (copyMap[i][j] > max) max = copyMap[i][j];
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            dir[depth] = i;
            backTracking(depth + 1);
        }
    }

    static void plus() {
        for (int i = 0; i < N; i++) {
            int[] arr = new int[N];
            boolean[] couple = new boolean[N];
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (copyMap[i][j] > 0) arr[cnt++] = copyMap[i][j];
                copyMap[i][j] = 0;
            }

            for (int j = 0; j < N; j++) {
                if (j != 0 && arr[j-1] == arr[j] && !couple[j-1]) {
                    arr[j-1] += arr[j];
                    arr[j] = 0;
                    couple[j-1] = couple[j] = true;
                }
            }

            cnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j] > 0) copyMap[i][cnt++] = arr[j];
            }
        }
    }

    static void rotate() {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = copyMap[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyMap[i][j] = temp[N - 1 - j][i];
            }
        }
    }
}

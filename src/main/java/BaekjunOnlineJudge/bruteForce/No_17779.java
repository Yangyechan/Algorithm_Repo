package BaekjunOnlineJudge.bruteForce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_17779 {
    static int N;
    static int[][] population;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                        if (x + d1 + d2 <= N && y - d1 >= 1 && y + d2 <= N) {
                            int[][] boundaries = calculateBoundaries(x, y, d1, d2);
                            int diff = calculatePopulationDifference(boundaries);
                            answer = Math.min(answer, diff);
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static int[][] calculateBoundaries(int x, int y, int d1, int d2) {
        int[][] boundaries = new int[N + 1][N + 1];

        // 경계선 1
        for (int i = 0; i <= d1; i++) {
            boundaries[x + i][y - i] = 5;
            boundaries[x + d2 + i][y + d2 - i] = 5;
        }

        // 경계선 2
        for (int i = 0; i <= d2; i++) {
            boundaries[x + i][y + i] = 5;
            boundaries[x + d1 + i][y - d1 + i] = 5;
        }

        // 경계선 3
        for (int r = 1; r <= N; r++) {
            boolean isBoundary = false;
            for (int c = 1; c <= N; c++) {
                if (boundaries[r][c] == 5) {
                    isBoundary = !isBoundary;
                }
                if (isBoundary) {
                    boundaries[r][c] = 5;
                }
            }
        }

        return boundaries;
    }

    private static int calculatePopulationDifference(int[][] boundaries) {
        int[] populationSum = new int[6];

        // 각 구역의 인구 합 계산
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                int section = boundaries[r][c];
                populationSum[section] += population[r][c];
            }
        }

        // 가장 인구가 많은 선거구와 가장 인구가 적은 선거구 차이 계산
        int maxDiff = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i <= 5; i++) {
            maxDiff = Math.max(maxDiff, populationSum[i]);
            minDiff = Math.min(minDiff, populationSum[i]);
        }

        return maxDiff - minDiff;
    }
}


package BarkingDog_Cicle2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_14889 {
    static int N;
    static int[][] member;
    static int[] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        member = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                member[i][j] = Integer.parseInt(ip[j]);
            }
        }

        arr = new int[N/2];
        visited = new boolean[N];
        backTracking(0, 0);

        System.out.println(min);
    }
    static void backTracking(int depth, int st) {
        if (depth == N/2) {

            int sumA = 0;
            int sumB = 0;

            for (int i = 0; i < N/2; i++) {
                for (int j = i+1; j < N/2; j++) {
                    sumA += member[arr[i]][arr[j]] + member[arr[j]][arr[i]];
                }
            }

            int[] teamB = new int[N/2];
            int idx = 0;
            for (int i = 0; i < N; i++) {
                if (!visited[i]) teamB[idx++] = i;
            }

            for (int i = 0; i < N/2; i++) {
                for (int j = i+1; j < N/2; j++) {
                    sumB += member[teamB[i]][teamB[j]] + member[teamB[j]][teamB[i]];
                }
            }

            int ans = Math.abs(sumA - sumB);
            if (min > ans) min = ans;

            return;
        }

        for (int i = st; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                backTracking(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}

package boj.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(str[j-1]);
            }
        }
        int[][] max = new int[n+1][n+1];
        max[1][1] = triangle[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                max[i][j] = Math.max(max[i-1][j], max[i-1][j-1]) + triangle[i][j];
            }
        }
        int mx = 0;
        for (int i = 1; i <= n; i++) {
            if (max[n][i] > mx) mx = max[n][i];
        }
        System.out.println(mx);
    }
}

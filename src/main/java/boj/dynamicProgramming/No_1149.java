package boj.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N + 1][3];
        for (int t = 0; t < N; t++) {
            String[] str = br.readLine().split(" ");
            int r = Integer.parseInt(str[0]);
            int g = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);
        }
    }
}

package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n+1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        }

        int[][] d = new int[n+1][3];

        d[1][1] = stairs[1];
        d[1][2] = 0;
        d[2][1] = stairs[2];
        d[2][2] = stairs[1] + stairs[2];

        for (int i = 3; i <= n; i++) {
            d[i][1] = Math.max(d[i-2][1], d[i-2][2]) + stairs[i];
            d[i][2] = d[i-1][1] + stairs[i];
        }

        System.out.println(Math.max(d[n][1], d[n][2]));
    }
}

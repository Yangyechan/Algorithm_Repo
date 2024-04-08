package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] drink = new int[n+2];
        for (int i = 0; i < n; i++) {
            drink[i] = Integer.parseInt(br.readLine());
        }


        long[][] d = new long[n+2][3];
        d[0][1] = drink[0];
        d[0][2] = 0;

        for (int i = 1; i <= n; i++) {
            d[i][0] = Math.max(Math.max(d[i-1][0], d[i-1][1]), d[i-1][2]);
            d[i][1] = d[i-1][0] + drink[i];
            d[i][2] = d[i-1][1] + drink[i];
        }

        long max = Math.max(Math.max(d[n][0], d[n][1]), d[n][2]);

        System.out.println(max);
    }
}

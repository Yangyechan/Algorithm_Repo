package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int T = Integer.parseInt(ip[0]);
        int W = Integer.parseInt(ip[1]);

        int[] fruit = new int[T+1];
        for (int i = 1; i <= T; i++) {
            fruit[i] = Integer.parseInt(br.readLine());
        }

        int[][][] d = new int[T+1][W+1][3];
        for (int i = 1; i <= T; i++) {
            d[i][0][1] = d[i-1][0][1] + (fruit[i] == 1 ? 1 : 0);

            for (int j = 1; j <= W; j++) {
                if (i < j) break;
                if (fruit[i] == 1) {
                    d[i][j][1] = Math.max(d[i-1][j-1][2], d[i-1][j][1]) + 1;
                    d[i][j][2] = Math.max(d[i-1][j-1][1], d[i-1][j][2]);
                }else {
                    d[i][j][1] = Math.max(d[i-1][j-1][2], d[i-1][j][1]);
                    d[i][j][2] = Math.max(d[i-1][j-1][1], d[i-1][j][2]) + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= W; i++) {
            int tmp = Math.max(d[T][i][1], d[T][i][2]);
            if (tmp > ans) ans = tmp;
        }

        System.out.println(ans);
    }
}

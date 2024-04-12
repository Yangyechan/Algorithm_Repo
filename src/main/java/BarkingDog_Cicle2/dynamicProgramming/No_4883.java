package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_4883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            tc++;
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int[][] map = new int[N][3];
            for (int i = 0; i < N; i++) {
                String[] ip = br.readLine().split(" ");
                map[i][0] = Integer.parseInt(ip[0]);
                map[i][1] = Integer.parseInt(ip[1]);
                map[i][2] = Integer.parseInt(ip[2]);
            }

            int[][] d = new int[N][3];
            d[0][0] = 1001;
            d[0][1] = map[0][1];
            d[0][2] = map[0][1] + map[0][2];

            for (int i = 1; i < N; i++) {
                d[i][0] = Math.min(d[i - 1][0], d[i - 1][1]) + map[i][0];
                d[i][1] = Math.min(Math.min(d[i - 1][0], d[i - 1][1]), Math.min(d[i - 1][2], d[i][0])) + map[i][1];
                d[i][2] = Math.min(d[i - 1][1], Math.min(d[i - 1][2], d[i][1])) + map[i][2];
            }

            sb.append(tc + ". " +  d[N-1][1] + "\n");
        }

        System.out.println(sb);
    }
}

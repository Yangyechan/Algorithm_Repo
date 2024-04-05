package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] ip = br.readLine().split(" ");
            int t = Integer.parseInt(ip[0]);
            int p = Integer.parseInt(ip[1]);
            arr[i][0] = t;
            arr[i][1] = p;
        }

        long[] d = new long[N+1];
        for (int i = 0; i < N; i++) {
            if (arr[i][0] + i <= N) {
                d[arr[i][0] + i] = Math.max(d[arr[i][0] + i], d[i] + arr[i][1]);
            }
            d[i+1] = Math.max(d[i+1], d[i]);
        }

        System.out.println(d[N]);
    }
}

package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] d = new int[N+1];
        String[] ip = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            d[i] = Integer.parseInt(ip[i-1]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                d[i] = Math.max(d[i], d[i-j] + d[j]);
            }
        }

        System.out.println(d[N]);
    }
}

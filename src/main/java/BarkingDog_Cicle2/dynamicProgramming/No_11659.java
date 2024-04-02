package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");

        int N = Integer.parseInt(ip[0]);
        int M = Integer.parseInt(ip[1]);

        int[] sum = new int[N+1];

        ip = br.readLine().split(" ");
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            tmp += Integer.parseInt(ip[i]);
            sum[i+1] = tmp;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            ip = br.readLine().split(" ");
            int I = Integer.parseInt(ip[0]);
            int J = Integer.parseInt(ip[1]);

            sb.append(sum[J] - sum[I-1] + "\n");
        }

        System.out.println(sb);
    }
}

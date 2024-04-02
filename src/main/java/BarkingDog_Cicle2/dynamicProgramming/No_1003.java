package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1003 {
    static int zero = 0;
    static int one = 0;
    static long[][] fib = new long[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        fib[0][0] = 1;
        fib[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            fib[i][0] = fib[i-1][0] + fib[i-2][0];
            fib[i][1] = fib[i-1][1] + fib[i-2][1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            sb.append(fib[N][0] + " " + fib[N][1] + "\n");
        }

        System.out.println(sb);
    }
}

package boj.dynamicProgramming;

import java.util.Scanner;

public class No_1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] fibo = new int[41][2];
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
            fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
        }

        for (int i = 0; i < T; i++) {
            int num = sc.nextInt();
            System.out.println(fibo[num][0] + " " + fibo[num][1]);
        }
    }
}

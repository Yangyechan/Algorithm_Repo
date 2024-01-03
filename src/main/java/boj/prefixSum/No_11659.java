package boj.prefixSum;

import java.util.Scanner;

public class No_11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] list = new int[N];
        int[] sumList = new int[N+1];
        int[] result = new int[M+1];

        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }

        sumList[1] = list[0];
        for (int i = 2; i <= N; i++) {
            sumList[i] = sumList[i-1] + list[i-1];
        }

        // sumlist = {0,5,9,12,14,15}
        result[0] = 0;
        for (int i = 1; i <= M; i++) {
            int I = sc.nextInt();
            int J = sc.nextInt();
            result[i] = sumList[J] - sumList[I-1];
        }
        // sumList[2] - 0

        for (int i = 1; i <= M; i++) {
            System.out.println(result[i]);
        }
    }
}

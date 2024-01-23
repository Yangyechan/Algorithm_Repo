package boj.dynamicProgramming;

import java.util.Scanner;

public class No_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }else if (n == 2) {
            System.out.println(1);
            return;
        }
        int[][] arr = new int[n+1][2];
        arr[1][1] = 1;
        arr[2][0] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i][0] = arr[i-1][0] + arr[i-1][1];
            arr[i][1] = arr[i-1][0];
        }
        System.out.println(arr[n][0] + arr[n][1]);
    }
}

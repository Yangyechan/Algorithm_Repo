package boj.math;

import java.util.Scanner;

public class No_11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int par = 1;
        for (int i = 1; i <= n; i++) {
            par *= i;
        }

        for (int i = 1; i <= n-k; i++) {
            par /= i;
        }

        for (int i = 1; i <= k; i++) {
            par /= i;
        }
        System.out.println(par);
    }
}

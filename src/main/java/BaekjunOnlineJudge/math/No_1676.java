package BaekjunOnlineJudge.math;

import java.util.Scanner;

public class No_1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] fac = new int[501];

        int cnt5 = 0;
        for (int i = 1; i <= 500; i++) {
            int tmp = i;
            if (tmp % 5 == 0) {
                while (tmp % 5 == 0) {
                    cnt5++;
                    tmp /= 5;
                }
            }
            fac[i] = cnt5;
        }
        System.out.println(fac[n]);
    }
}

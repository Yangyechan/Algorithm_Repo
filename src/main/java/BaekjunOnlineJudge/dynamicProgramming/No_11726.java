package BaekjunOnlineJudge.dynamicProgramming;

import java.util.Scanner;

public class No_11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] D = new int[n+1];
        if (n == 1) {
            System.out.println(1 % 10007);
        }else {
            D[1] = 1;
            D[2] = 2;
            for (int i = 3; i <= n; i++) {
                D[i] = (D[i-1] + D[i-2]) % 10007;
            }
            System.out.println(D[n]);
        }
    }
}

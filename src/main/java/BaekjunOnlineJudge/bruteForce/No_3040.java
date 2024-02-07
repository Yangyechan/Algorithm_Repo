package BaekjunOnlineJudge.bruteForce;

import java.util.Scanner;

public class No_3040 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] list = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int n = sc.nextInt();
            list[i] = n;
            sum += n;
        }

        int x = sum - 100;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (list[i] + list[j] == x) {
                    list[i] = 100;
                    list[j] = 100;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (list[i] == 100) {
                continue;
            }
            System.out.println(list[i]);
        }
    }
}

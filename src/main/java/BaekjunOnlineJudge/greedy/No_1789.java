package BaekjunOnlineJudge.greedy;

import java.util.Scanner;

public class No_1789 {
    public static void main(String[] args) {
        // 1 2 3 4 5 6 7 8 9 10
        // 11 12 13 14 15 16 17 18 19 = 135 + 55 = 190
        // - / %
        Scanner sc = new Scanner(System.in);
        Long S = sc.nextLong();
        Long sum = 0L;
        Long a = 0L;
        Long cnt = -1L;
        while (sum <= S) {
            a++;
            sum += a;
            cnt++;
        }
        System.out.println(cnt);
    }
}

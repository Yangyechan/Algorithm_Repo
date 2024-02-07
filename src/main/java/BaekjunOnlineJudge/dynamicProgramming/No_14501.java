package BaekjunOnlineJudge.dynamicProgramming;

import java.util.Scanner;
import java.util.Arrays;

public class No_14501 {
    static int[] t;
    static int[] p;
    static int[] d; // i번째 날에 상담을 시작했을 때 얻을 수 있는 최대 수익

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        t = new int[n + 2];
        p = new int[n + 2];
        d = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i = n; i >= 1; i--) {
            if (i + t[i] <= n + 1) {
                d[i] = Math.max(d[i + t[i]] + p[i], d[i + 1]);
            } else {
                d[i] = d[i + 1];
            }
        }


        sc.close(); // Scanner 사용을 마쳤으므로 리소스를 해제합니다.

        // 배열 d에서 최대값을 찾아 출력합니다.
        System.out.println(Arrays.stream(d).max().getAsInt());
    }
}


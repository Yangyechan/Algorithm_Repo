package BaekjunOnlineJudge.adHoc;

import java.util.Scanner;

public class No_4307 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int l = sc.nextInt();
            int n = sc.nextInt();
            int min = 0;
            int max = 0;
            int mid = l / 2;
            for (int j = 0; j < n; j++) {
                int ant = sc.nextInt();
                if (ant > mid) {
                    min = Math.max(min, l - ant);
                    max = Math.max(max, ant);
                }else {
                    min = Math.max(min, ant);
                    max = Math.max(max, l - ant);
                }
            }
            System.out.print(min + " " + max);
            System.out.println();
        }
    }
}

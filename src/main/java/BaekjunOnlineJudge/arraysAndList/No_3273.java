package BaekjunOnlineJudge.arraysAndList;

import java.util.Scanner;

public class No_3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        boolean[] check = new boolean[2000001];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
            check[list[i]] = true;
        }
        int x = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int minus = x - list[i];
            if (minus < 0) continue;
            if (check[minus]) {
                cnt++;
            }
        }
        System.out.println(cnt / 2);
    }
}

package BaekjunOnlineJudge.implementation;

import java.util.Scanner;

public class No_1094 {
    static int X;
    static int distance;
    static int cnt;
    static int[] list = {32, 16, 8, 4, 2, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        int now = 64;
        while (X > 0) {
            if (now > X) {
                now = now/2;
            }else {
                X -= now;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

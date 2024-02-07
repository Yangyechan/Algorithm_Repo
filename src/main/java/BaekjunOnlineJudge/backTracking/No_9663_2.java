package BaekjunOnlineJudge.backTracking;

import java.io.IOException;
import java.util.Scanner;

public class No_9663_2 {
    static int N;
    static int cnt = 0;
    static int[] map;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N];
        func(0);
        System.out.println(cnt);
    }
    static void func(int size) {
        if (size == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            map[size] = i;
            if (pos(size)) {
                func(size + 1);
            }
        }

    }
    static boolean pos(int f) {
        for (int i = 0; i < f; i++) {
            if (map[f] == map[i]) {
                return false;
            } else if (Math.abs(f - i) == Math.abs(map[f] - map[i])) {
                return false;
            }
        }
        return true;
    }
}

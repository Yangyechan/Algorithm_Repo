package BaekjunOnlineJudge.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_16401 {
    static int M, N;
    static int[] snack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        snack = new int[N];

        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(snack);

        int st = 0;
        int ed = snack[N-1];
        while (st < ed) {
            int mid = (st + ed + 1) / 2;
            if (check(mid)) {
                st = mid;
            } else {
                ed = mid - 1;
            }
        }
        System.out.println(st);
    }
    static boolean check(int mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += snack[i] / mid;
        }
        return sum >= M;
    }
}


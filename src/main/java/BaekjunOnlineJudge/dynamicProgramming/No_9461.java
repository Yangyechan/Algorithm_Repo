package BaekjunOnlineJudge.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= 100; i++) {
            arr[i] = arr[i - 3] + arr[i - 2];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(arr[num] + "\n");
        }
        System.out.println(sb);
    }
}

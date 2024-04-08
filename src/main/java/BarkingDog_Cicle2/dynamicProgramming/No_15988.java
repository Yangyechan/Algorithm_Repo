package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] arr = new long[1000001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i <= 1000000; i++) {
            arr[i] = (arr[i-1] + arr[i-2] + arr[i-3]) % 1000000009;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(arr[num] + "\n");
        }

        System.out.println(sb);
    }
}

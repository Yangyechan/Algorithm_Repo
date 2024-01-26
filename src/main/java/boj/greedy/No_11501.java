package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            int max = arr[n-1];
            long sum = 0;
            for (int i = n-2; i >= 0; i--) {
                if (max < arr[i]) {
                    max = arr[i];
                    continue;
                }
                sum += max - arr[i];
            }

            sb.append(sum+ "\n");
        }
        System.out.println(sb);
    }
}

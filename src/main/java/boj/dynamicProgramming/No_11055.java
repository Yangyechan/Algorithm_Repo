package boj.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class No_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] d = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(str[i]);
            d[i] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    d[i] = Math.max(d[i], d[j] + arr[i]);
                }
            }
        }
        Arrays.sort(d);
        System.out.println(d[n-1]);
    }
}

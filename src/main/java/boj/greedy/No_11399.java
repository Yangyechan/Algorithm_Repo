package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(p);

        int tmp = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            tmp += p[i];
            ans += tmp;
        }
        System.out.println(ans);
    }
}

package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];

        String[] str = br.readLine().split(" ");
        String[] str2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(str[i]);
            b[i] = Integer.parseInt(str2[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);

        int idx = n-1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += a[i] * b[idx--];
        }

        System.out.println(ans);
    }
}

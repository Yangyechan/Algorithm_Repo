package boj.math;

import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);

            long sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int a = Integer.parseInt(input[i+1]);
                    int b = Integer.parseInt(input[j+1]);
                    sum += gcd(a, b);
                }
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }
    static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b%a, a);
    }
}

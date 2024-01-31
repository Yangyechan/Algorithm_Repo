package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                isPrime[i] = false;
                cnt++;
                if (cnt == k) {
                    System.out.println(i);
                    return;
                }
                for (int j = i * i ; j <= n; j+=i) {
                    if (isPrime[j]) {
                        cnt++;
                        isPrime[j] = false;
                    }
                    if (cnt == k) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }

    }
}

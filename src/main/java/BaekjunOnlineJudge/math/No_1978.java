package BaekjunOnlineJudge.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input[i]);
            ans += isPrime(num);
        }

        System.out.println(ans);
    }
    static int isPrime(int n) {
        if (n == 1) return 0;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return 0;
        }
        return 1;
    }
}

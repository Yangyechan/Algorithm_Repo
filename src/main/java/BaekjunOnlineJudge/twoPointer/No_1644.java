package BaekjunOnlineJudge.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }
        boolean[] isPrime = new boolean[N+1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) prime.add(i);
        }

        int st = 0;
        int ed = 1;
        int ans = 0;
        int sum = prime.get(0);
        while (true) {
            if (sum >= N) {
                if (sum == N) ans++;
                sum -= prime.get(st++);
            } else if (ed == prime.size()) {
                break;
            }else {
                sum += prime.get(ed++);
            }
        }
        System.out.println(ans);
    }
}

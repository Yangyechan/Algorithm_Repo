package BarkingDog_Cicle2.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[N+1];

        Arrays.fill(prime, true);
        prime[1] = false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (prime[i]) {
                for (int j = i*i; j <= N; j+=i) {
                    prime[j] = false;
                }
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = 1; i < N+1; i++) {
            if (prime[i]) primeList.add(i);
        }

        int ed = 0;
        int tmp = 0;
        int ans = 0;
        for (int st = 0; st < primeList.size(); st++) {

            while (ed < primeList.size() && tmp < N) {
                tmp += primeList.get(ed++);
            }

            if (tmp == N) {
                ans++;
            }

            tmp -= primeList.get(st);
        }

        System.out.println(ans);
    }
}

package BarkingDog_Cicle2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");

        int N = Integer.parseInt(ip[0]);
        int K = Integer.parseInt(ip[1]);

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        int idx = N-1;
        while (K != 0) {
            int now = coins[idx];

            if (K - now >= 0) {
                K -= now;
                ans++;
            }else {
                idx--;
            }
        }

        System.out.println(ans);
    }
}

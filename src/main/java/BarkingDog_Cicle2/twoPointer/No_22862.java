package BarkingDog_Cicle2.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int K = Integer.parseInt(ip[1]);

        int[] S = new int[N];
        ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(ip[i]);
        }


        int ed = 0;
        int cnt = 0;
        int ans = 0;
        int tmp = 0;
        for (int st = 0; st < N; st++) {
            while (ed < N && cnt <= K) {
                if (S[ed] % 2 == 0) {
                    tmp++;
                }else {
                    cnt++;
                }

                ed++;

                if (cnt > K) break;
            }

            if (tmp > ans) ans = tmp;

            if (S[st] % 2 == 1) cnt--;
            else tmp--;
        }

        System.out.println(ans);
    }
}

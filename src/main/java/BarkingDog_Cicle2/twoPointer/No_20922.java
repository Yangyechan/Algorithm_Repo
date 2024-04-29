package BarkingDog_Cicle2.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_20922 { // 테케 이상한 문제, 화병 날것 같다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int K = Integer.parseInt(ip[1]);

        int[] arr = new int[N];
        ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ip[i]);
        }


        int[] check = new int[N+1];
        int ed = 0;
        int cnt = 0;
        int tmp = 0;
        int ans = 0;
        for (int st = 0; st < N; st++) {
            while (ed < N && cnt < K) {
                check[arr[ed]]++;

                if (check[arr[ed]] >= 2) {
                    cnt++;
                }

                tmp++;
                ed++;
            }

            if (ans < tmp) ans = tmp;

            check[st]--;

            if (check[st] == 1) cnt--;

            tmp--;
        }

        System.out.println(ans);
    }
}

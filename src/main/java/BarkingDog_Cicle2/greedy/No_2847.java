package BarkingDog_Cicle2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = arr[N-1];
        long ans = 0;
        for (int i = N-2; i >= 0; i--) {
            if (max <= arr[i]) {
                int tmp = (arr[i] - max) + 1;
                arr[i] -= tmp;
                ans += tmp;
            }
            max = arr[i];
        }

        System.out.println(ans);
    }
}

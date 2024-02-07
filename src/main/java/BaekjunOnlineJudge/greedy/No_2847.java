package BaekjunOnlineJudge.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;

        for (int i = n-2; i >= 0; i--) {
            while (arr[i+1] <= arr[i]) {
                ans++;
                arr[i]--;
            }
        }

        System.out.println(ans);
    }
}

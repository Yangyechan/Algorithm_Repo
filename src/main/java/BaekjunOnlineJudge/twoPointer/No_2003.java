package BaekjunOnlineJudge.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        int st = 0;
        int ed = 1;
        int sum = arr[0];
        int ans = 0;
        while (true) {
            if (sum >= m) {
                if (sum == m) ans++;
                sum -= arr[st++];
            } else if (ed == n) {
                break;
            }else {
                sum += arr[ed++];
            }
        }
        System.out.println(ans);
    }
}

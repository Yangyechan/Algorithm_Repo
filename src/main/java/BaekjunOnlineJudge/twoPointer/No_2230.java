package BaekjunOnlineJudge.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long m = Long.parseLong(input[1]);
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;

        int ed = 0;
        for (int st = 0; st < n; st++) {
            while (ed < n && arr[ed] - arr[st] < m) ed++;
            if (ed == n) break;
            min = Math.min(min, arr[ed] - arr[st]);
        }
        System.out.println(min);
    }
}

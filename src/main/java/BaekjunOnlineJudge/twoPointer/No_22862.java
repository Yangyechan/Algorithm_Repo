package BaekjunOnlineJudge.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        long[] arr = new long[s];
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < s; i++) {
            long num = Long.parseLong(input2[i]);
            arr[i] = num;
        }


        long ans = 0;

        long tmp = 0;
        int idx = 0;
        while (idx < s) {
            if (arr[idx] % 2 == 1) {
                tmp = 0;
            }else {
                tmp++;
                ans = Math.max(ans, tmp);
            }
            idx++;
        }

        int st = 0;
        int ed = 1;
        long cnt = arr[0] % 2;

        while (ed < s) {
            if (cnt + arr[ed] % 2 <= k) {
                cnt += arr[ed] % 2;
                ans = Math.max(ans, ed - st + 1 - cnt);
                ed++;
            }else {
                cnt -= arr[st++] % 2;
            }
        }
        System.out.println(ans);
    }
}
/*
14 2
4 7 4 4 7 4 7 7 7 4 4 4 4 4
*/

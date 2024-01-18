package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        long target = arr[0];
        int cnt = 0;
        int max = 0;
        long idx = -((long) Math.pow(2, 62) + 1);
        for (int i = 0; i < N; i++) {
            if (arr[i] == target) {
                cnt++;
                if (max < cnt) {
                    max = cnt;
                    idx = arr[i];
                }
            }else {
                cnt = 1;
                target = arr[i];
            }
        }
        System.out.println(idx);
    }
}

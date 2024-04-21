package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");

        int N = Integer.parseInt(ip[0]);
        long M = Long.parseLong(ip[1]);

        long[] arr = new long[N];
        ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ip[i]);
        }
        Arrays.sort(arr);

        long st = 0;
        long ed = arr[N-1];
        while (st < ed) {
            long mid = (st + ed) / 2;
            long n = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] - mid >= 0) {
                    n += arr[i] - mid;
                }
            }

            if (n < M) {
                ed = mid;
            }else {
                st = mid + 1;
            }
        }

        System.out.println(st-1);
    }
}

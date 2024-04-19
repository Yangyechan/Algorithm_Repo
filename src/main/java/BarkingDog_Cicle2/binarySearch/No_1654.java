package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");

        int K = Integer.parseInt(ip[0]);
        int N = Integer.parseInt(ip[1]);

        long[] arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long min = 0;
        long max = arr[K-1] + 1;
        while (min < max) {
            long mid = (min + max) / 2;
            long n = 0;

            for (int i = 0; i < K; i++) {
                n += arr[i] / mid;
            }

            if (n < N) {
                max = mid;
            }else {
                min = mid + 1;
            }
        }

        System.out.println(min-1);
    }
}

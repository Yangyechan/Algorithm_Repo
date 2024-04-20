package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");

        int M = Integer.parseInt(ip[0]);
        int N = Integer.parseInt(ip[1]);

        ip = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ip[i]);
        }
        Arrays.sort(arr);

        long min = 0;
        long max = arr[N-1] + 1;
        while (min < max) {
            long mid = (min + max) / 2;

            if (mid == 0) {
                System.out.println(0);
                return;
            }

            long n = 0;
            for (int i = 0; i < N; i++) {
                n += (arr[i] / mid);
            }

            if (n < M) {
                max = mid;
            }else {
                min = mid + 1;
            }
        }


        System.out.println(min - 1);
    }
}

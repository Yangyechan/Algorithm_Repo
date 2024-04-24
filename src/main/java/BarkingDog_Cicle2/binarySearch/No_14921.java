package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ip[i]);
        }
        Arrays.sort(arr);

        long min = Integer.MAX_VALUE;
        long ans = 0;
        for (int i = 0; i < N-1; i++) {
            int left = i+1;
            int right = N;

            while (left < right) {
                int mid = (left + right) / 2;
                long sum = arr[i] + arr[mid];

                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    ans = sum;
                }

                if (-arr[i] <= arr[mid]) {
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }

        }

        System.out.println(ans);
    }
}

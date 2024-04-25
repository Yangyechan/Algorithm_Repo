package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(ip[i]);
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        long[] ansArr = new long[3];
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int left = j+1;
                int right = N;
                long target = arr[i] + arr[j];

                while (left < right) {
                    int mid = (left + right) / 2;
                    long sum = target + arr[mid];

                    if (Math.abs(sum) < min) {
                        min = Math.abs(sum);
                        ansArr[0] = arr[i];
                        ansArr[1] = arr[j];
                        ansArr[2] = arr[mid];
                    }

                    if (-target <= arr[mid]) {
                        right = mid;
                    }else {
                        left = mid + 1;
                    }
                }
            }
        }

//        Arrays.sort(ansArr);
        System.out.println(ansArr[0] + " " + ansArr[1] + " " + ansArr[2]);
    }
}

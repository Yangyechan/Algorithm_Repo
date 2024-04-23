package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ip[i]);
        }

        int min = Integer.MAX_VALUE;
        int ml = 0;
        int mr = 0;
        for (int i = 0; i < N-1; i++) {
            int l = i+1;
            int r = N;

            while (l < r) {
                int mid = (l + r) / 2;
                int sum = Math.abs(arr[mid] + arr[i]);

                if (min > sum) {
                    ml = i;
                    mr = mid;
                    min = sum;
                }

                if (-arr[i] <= arr[mid]) {
                    r = mid;
                }else {
                    l = mid + 1;
                }
            }
        }

        System.out.println(arr[ml] + " " + arr[mr]);
    }
}

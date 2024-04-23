package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_3151 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ip[i]);
        }
        Arrays.sort(arr);

        long ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int s = lowerBound(j+1, N, -(arr[i] + arr[j]));
                int e = upperBound(j+1, N, -(arr[i] + arr[j]));
                ans += e - s;
            }
        }

        System.out.println(ans);
    }

    static int lowerBound(int st, int ed, int target) {
        while (st < ed) {
            int mid = (st + ed) / 2;

            if (target <= arr[mid]) {
                ed = mid;
            } else {
                st = mid + 1;
            }
        }

        return st;
    }

    static int upperBound(int st, int ed, int target) {
        while (st < ed) {
            int mid = (st + ed) / 2;

            if (target < arr[mid]) {
                ed = mid;
            }else {
                st = mid + 1;
            }
        }

        return st;
    }
}

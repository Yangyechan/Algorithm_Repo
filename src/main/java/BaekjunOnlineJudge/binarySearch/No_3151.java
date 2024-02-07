package BaekjunOnlineJudge.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class No_3151 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);


        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int start = lowerBound(j+1, n, -(arr[i] + arr[j]));
                int end = upperBound(j+1, n, -(arr[i] + arr[j]));
                ans += end-start;
            }
        }
        System.out.println(ans);
    }
    static int lowerBound(int st, int ed, int target) {
        while (st < ed) {
            int mid = (st + ed) / 2;
            if (target <= arr[mid]) {
                ed = mid;
            }else {
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

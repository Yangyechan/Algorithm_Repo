package BaekjunOnlineJudge.binarySearch;

import java.io.*;

public class No_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int min = Integer.MAX_VALUE;
        int ml = 0;
        int mr = 0;
        for (int i = 0; i < n-1; i++) {
            int left = i+1;
            int right = n-1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int sum = Math.abs(arr[mid] + arr[i]);

                if (min > sum) {
                    ml = i;
                    mr = mid;
                    min = sum;
                }

                if (arr[mid] >= -arr[i]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        System.out.println(arr[ml] + " " + arr[mr]);
    }
}

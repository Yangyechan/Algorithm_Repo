package BaekjunOnlineJudge.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            int st = i+1;
            int ed = n-1;
            while (st <= ed) {
                int mid = (st + ed) / 2;
                int sum = arr[mid] + arr[i];
                int tmp = Math.abs(sum);

                if (min > tmp) {
                    min = tmp;
                    ans = sum;
                }

                if (sum >= 0) {
                    ed = mid - 1;
                }else {
                    st = mid + 1;
                }
            }
        }
        System.out.println(ans);
    }
}

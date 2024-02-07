package BaekjunOnlineJudge.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_1920_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(input2[i]);
            int st = 0;
            int end = arr.length - 1;
            int mid = (st + end) / 2;
            int midVal = arr[mid];
            boolean pos = false;

            while (st <= end) {
                if (midVal < num) {
                    st = mid + 1;
                    mid = (st + end) / 2;
                    midVal = arr[mid];
                } else if (midVal > num) {
                    end = mid - 1;
                    mid = (st + end) / 2;
                    midVal = arr[mid];
                }else {
                    pos = true;
                    break;
                }
            }
            if (pos) sb.append(1 + "\n");
            else sb.append(0 + "\n");
        }
        System.out.println(sb);
    }
}

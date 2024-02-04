package boj.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(input2[i]);
            int st = 0;
            int ed = arr.length-1;
            int mid = (st+ed) / 2;
            int midVal = arr[mid];
            boolean pos = false;

            while (st <= ed) {
                if (target < midVal) {
                    ed = mid-1;
                    mid = (st+ed) / 2;
                    midVal = arr[mid];
                } else if (target > midVal) {
                    st = mid+1;
                    mid = (st + ed) / 2;
                    midVal = arr[mid];
                }else {
                    pos = true;
                    break;
                }
            }
            if (pos) sb.append(1 + " ");
            else sb.append(0 + " ");
        }
        System.out.println(sb);
    }
}

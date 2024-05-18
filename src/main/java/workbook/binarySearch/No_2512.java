package workbook.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ip[i]);
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        int tmp = 0;
        for (int i = 0; i < N; i++) {
            tmp += arr[i];
        }

        if (tmp <= M) {
            System.out.println(arr[N-1]);
            return;
        }

        int st = 0;
        int ed = M;
        while (st < ed) {
            int mid = (st + ed) / 2;

            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (mid <= arr[i]) {
                    sum += mid;
                }else {
                    sum += arr[i];
                }
            }

            if (M < sum) {
                ed = mid;
            }else {
                st = mid + 1;
            }
        }

        System.out.println(st-1);
    }
}

package workbook.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int X = Integer.parseInt(ip[1]);

        int[] arr = new int[N];

        ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ip[i]);
        }

        int ed = 0;
        int sum = 0;
        int max = 0;
        for (int st = 0; st < N; st++) {
            while (ed - st < X && ed < N) {
                sum += arr[ed++];
            }

            if (max < sum) max = sum;

            sum -= arr[st];
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);

        ed = 0;
        int cnt = 0;
        for (int st = 0; st < N; st++) {
            while (ed - st < X && ed < N) {
                sum += arr[ed++];
            }

            if (sum == max) cnt++;

            sum -= arr[st];
        }

        System.out.println(cnt);
    }
}

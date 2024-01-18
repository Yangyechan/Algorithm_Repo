package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_15688 { // 카운팅 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[2000001];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num + 1000000]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 2000000; i++) {
            while (arr[i]-- > 0) {
                sb.append(i - 1000000 + "\n");
            }
        }
        System.out.println(sb);
    }
}

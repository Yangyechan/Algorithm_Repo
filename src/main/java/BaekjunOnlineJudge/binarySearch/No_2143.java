package BaekjunOnlineJudge.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2143 { // 보류
    static int T;
    static int[] a;
    static int[] b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        a = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        int m = Integer.parseInt(br.readLine());
        b = new int[m];
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(input2[i]);
        }
    }
}

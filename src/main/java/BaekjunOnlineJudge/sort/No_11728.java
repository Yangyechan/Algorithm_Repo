package BaekjunOnlineJudge.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int[] A = new int[N];
        int[] B = new int[M];
        int[] sum = new int[N + M];

        String[] a = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(a[i]);
        }

        String[] b = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(b[i]);
        }

        int idx1 = 0;
        int idx2 = 0;
        StringBuilder sb = new StringBuilder();
        while (idx1 < N || idx2 < M) {
            if (idx2 == M || (idx1 < N && A[idx1] <= B[idx2])) {
                sb.append(A[idx1++]).append(" ");
            } else {
                sb.append(B[idx2++]).append(" ");
            }
        }
        System.out.println(sb);
    }
}

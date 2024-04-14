package BarkingDog_Cicle2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(ip[i]);
        }

        ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(ip[i]);
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int ans = 0;
        int idx = N-1;
        for (int i = 0; i < N; i++) {
            ans += A[i] * B[idx-i];
        }

        System.out.println(ans);
    }
}

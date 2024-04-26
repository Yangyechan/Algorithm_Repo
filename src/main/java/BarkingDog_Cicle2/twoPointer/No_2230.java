package BarkingDog_Cicle2.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");

        int N = Integer.parseInt(ip[0]);
        long M = Long.parseLong(ip[1]);

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long ans = Long.MAX_VALUE;
        int ed = 0;
        for (int st = 0; st < N; st++) {
            while (ed < N && arr[ed] - arr[st] < M) ed++;

            if (ed == N) break;

            if (ans > arr[ed] - arr[st]) ans = arr[ed] - arr[st];
        }

        System.out.println(ans);
    }
}

package BarkingDog_Cicle2.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ip[i]);
        }

        Arrays.sort(arr);

        int ans = 0;
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            tmp += arr[i];
            ans += tmp;
        }

        System.out.println(ans);
    }
}

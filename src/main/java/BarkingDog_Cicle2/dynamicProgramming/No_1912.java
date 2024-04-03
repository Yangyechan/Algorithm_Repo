package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        String[] ip = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(ip[i-1]);
        }

        int[] d = new int[n+1];
        for (int i = 1; i <= n; i++) {
            d[i] = Math.max(0, d[i-1]) + arr[i];
        }

        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = d[i+1];
        }

        Arrays.sort(tmp);

        System.out.println(tmp[n-1]);
    }
}

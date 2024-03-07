package BarkingDog_Cicle2.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[] check = new boolean[2000001];

        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(ip[i]);
            arr[i] = num;
            check[num] = true;
        }

        int ans = 0;
        int x = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int d = x - arr[i];

            if (d < 0) continue;

            if (check[d]) {
                ans++;
            }
        }
        System.out.println(ans/2);
    }
}

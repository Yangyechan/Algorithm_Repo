package BarkingDog_Cicle3.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        boolean[] flag = new boolean[2000001];

        String[] str = br.readLine().split(" ");

        int x = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int tar = Integer.parseInt(str[i]);
            flag[tar] = true;
            arr[i] = tar;
        }

        int check = 0;
        for (int i = 0; i < n; i++) {
            int tar = x - arr[i];

            if (tar < 1) continue;

            if (flag[tar]) check++;
        }

        System.out.println(check / 2);
    }
}

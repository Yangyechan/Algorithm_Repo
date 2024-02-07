package BaekjunOnlineJudge.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1541_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            String[] split = str[i].split("\\+");
            int sum = 0;
            for (int j = 0; j < split.length; j++) {
                int num = Integer.parseInt(split[j]);
                sum += num;
            }
            arr[i] = sum;
        }
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            ans = ans - arr[i];
        }
        System.out.println(ans);
    }
}

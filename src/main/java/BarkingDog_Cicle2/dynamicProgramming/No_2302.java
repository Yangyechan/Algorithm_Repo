package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[41];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= 40; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        List<Integer> list = new ArrayList<>();
        int M = Integer.parseInt(br.readLine());
        int st = 0;
        for (int i = 0; i < M; i++) {
            st++;
            int num = Integer.parseInt(br.readLine());
            list.add(num - st);
            st = num;
        }
        list.add(N-st);

        long ans = 1;
        for (int i = 0; i < list.size(); i++) {
            ans *= arr[list.get(i)];
        }

        System.out.println(ans);
    }
}

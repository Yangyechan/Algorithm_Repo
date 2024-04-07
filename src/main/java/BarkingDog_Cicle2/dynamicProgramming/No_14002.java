package BarkingDog_Cicle2.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] d = new int[N];
        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ip[i]);
            d[i] = 1;
        }

        int[] pre = new int[N];
        Arrays.fill(pre, -1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (d[i] < d[j] + 1) {
                        d[i] = d[j] + 1;
                        pre[i] = j;
                    }
                }
            }
        }

        int idx = 0;
        int max = d[0];
        for (int i = 1; i < N; i++) {
            if (max < d[i]) {
                max = d[i];
                idx = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        int tidx = idx;
        while (tidx != -1) {
            list.add(arr[tidx]);
            tidx = pre[tidx];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(d[idx] + "\n");
        for (int i = list.size()-1; i >= 0; i--) {
            sb.append(list.get(i) + " ");
        }

        System.out.println(sb);
    }
}

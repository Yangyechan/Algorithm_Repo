package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(ip[i]);
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        ip = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(ip[i]);
            int st = 0;
            int ed = N;
            boolean pos = false;

            while (st < ed) {
                int mid = (st + ed) / 2;
                int midVal = arr[mid];

                if (midVal < target) {
                    st = mid + 1;
                } else if (midVal > target) {
                    ed = mid;
                } else {
                    pos = true;
                    break;
                }
            }

            if (pos) {
                sb.append(1 + "\n");
            }else {
                sb.append(0 + "\n");
            }
        }

        System.out.println(sb);
    }
}

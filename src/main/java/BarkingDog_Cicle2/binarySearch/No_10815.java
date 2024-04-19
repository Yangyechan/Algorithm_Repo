package BarkingDog_Cicle2.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];

        String[] ip = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(ip[i]);
        }
        Arrays.sort(card);

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        ip = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(ip[i]);
            int st = 0;
            int ed = card.length;
            boolean pos = false;

            while (st < ed) {
                int mid = (st + ed) / 2;

                if (target < card[mid]) {
                    ed = mid;
                } else if (target > card[mid]) {
                    st = mid + 1;
                }else {
                    pos = true;
                    break;
                }
            }

            if (pos) sb.append(1 + " ");
            else sb.append(0 + " ");
        }

        System.out.println(sb);
    }
}
